package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.RobotMap;
import org.usfirst.frc.team2035.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2035.robot.subsystems.Forklift;
import org.usfirst.frc.team2035.robot.subsystems.Rollers;
import org.usfirst.frc.team2035.robot.subsystems.MaxbotixUltrasonic;

import edu.wpi.first.wpilibj.Timer;


public class WinAutonomous extends CommandBase {
	
	private final DriveTrain DRIVE;
	private final Forklift LIFTER;
	private final Rollers ROLLER;
	private MaxbotixUltrasonic sonar;
	private Timer autonomousTimer;
	private Timer runningTimer;
	private Timer driveTimer;
	private double drivenTime;
	private double storedTime;
	private Vision2 vision;
	private ImageProcess process;
	private double lowTime = .0;
	private double highTime = 1.0;
	//private int forkCounter = 0;
	
	public WinAutonomous() {
		super("drive");
		DRIVE = Robot.getDriveTrain();
		LIFTER = Robot.getForklift();
		ROLLER = Robot.getRollers();
		sonar = Robot.getMaxbotixUltrasonic();
		vision = new Vision2();
		process = new ImageProcess();
	}
	
	
	public void initialize() {
		autonomousTimer = new Timer();
		driveTimer = new Timer();
		runningTimer = new Timer();
		vision.visionInit();
		process.initProcessImage();
		process.setTote(false);
	}
	
	public void execute() 
	{
		/*
		double currentTime = autonomousTimer.get();
		if(currentTime > 0.0 && currentTime < .5){ //Change time that is needed 
			DRIVE.drive(MOTOR_ON_SPEED);
		} else if (currentTime >.541 && currentTime < 5.0){
			//LIFT.lift(); //change that is needed
		}
		*/
		autonomousTimer.start();
		storedTime = autonomousTimer.get();
		ROLLER.rollerOut();
		//while(storedTime < 15)
		//{
			//grabs and processes an image every 3 seconds
			if(storedTime >= lowTime && storedTime <= highTime)
			{
				vision.saveImage();
				process.processImage();
			}
			//Debugging here
			System.out.println("Tote: " + process.foundTote());
			System.out.println("Time: " + storedTime);
			System.out.println("Low: " + lowTime);
			System.out.println("High: " + highTime);
			System.out.println("Distance: " + sonar.getRangeInInches());
			//If a tote is found
			if(process.foundTote())
			{
				//drive for 3 seconds, ultrasonic does not work with open rollers
				driveTimer.start();
				runningTimer.start();
				LIFTER.retractForklift();
				while(driveTimer.get() < 2.0)//sonar.getRangeInInches() > 12
				{
					DRIVE.drive(-RobotMap.AUTONOMOUS_SPEED);
				}
				DRIVE.drive(0.0);
				//when a tote is in range, stop driving, retract rollers, lean the forklift forward and spin inward				
				driveTimer.stop();
				drivenTime = driveTimer.get();
				//if the running time is between 3 and 4 seconds, grab a tote
				while(runningTimer.get() > 2.0 && runningTimer.get() < 3.0)
				{
					ROLLER.rollerIn();
					ROLLER.spinIn();
					LIFTER.setreverseforklift();
				}
				ROLLER.motorOff();
				//lift the tote for 2.5 seconds
				while(runningTimer.get() > 3.0 && runningTimer.get() < 4.5)
					LIFTER.setreverseforklift();
				//release the rollers, stop lifting
				ROLLER.rollerOut();
				LIFTER.setstopforklift();
				//drive in reverse with the same power for a little longer than it was to grab a tote 
				driveTimer.reset();
				driveTimer.start();
				while(driveTimer.get() < drivenTime + 2.0)
				{
					DRIVE.drive(RobotMap.AUTONOMOUS_SPEED);
				}
				DRIVE.drive(0.0);
			}
			//if a tote is not found then, turn looking for a tote and repeat process
			else
			{
				DRIVE.rotate(10.0);
				if(storedTime > lowTime)
				{
					lowTime += 3.0;
					highTime += 3.0;
				}	
			}
		
		storedTime = autonomousTimer.get();
	}
	
	public boolean isFinished() {
		if (autonomousTimer.get() > 15.0) {
            return true;
        }
        return false;
	}
	
	public void interrupted() 
	{
		DRIVE.drive(0.0);
	}
	public void end()
	{
		DRIVE.drive(0.0);
	}	
}
