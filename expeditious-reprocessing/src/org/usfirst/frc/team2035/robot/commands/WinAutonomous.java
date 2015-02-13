package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.RobotMap;
import org.usfirst.frc.team2035.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2035.robot.subsystems.Forklift;
import org.usfirst.frc.team2035.robot.subsystems.Rollers;

import edu.wpi.first.wpilibj.Timer;


public class WinAutonomous extends CommandBase {
	
	private final DriveTrain DRIVE;
	private final Forklift LIFTER;
	private final Rollers ROLLER;
	private Timer autonomousTimer;
	private Timer driveTimer;
	private double storedTime;
	private Vision vision;
	private ImageProcess process;
	private double lowTime = .1;
	private double highTime = 1.1;
	
	public WinAutonomous() {
		super("drive");
		DRIVE = Robot.getDriveTrain();
		LIFTER = Robot.getForklift();
		ROLLER = Robot.getRollers();
		vision = new Vision();
		process = new ImageProcess();
	}
	
	
	public void initialize() {
		autonomousTimer = new Timer();
		driveTimer = new Timer();
		autonomousTimer.start();
		vision.visionInit();
		process.initProcessImage();
		process.setTote(false);
	}
	
	public void execute() {
		/*
		double currentTime = autonomousTimer.get();
		if(currentTime > 0.0 && currentTime < .5){ //Change time that is needed 
			DRIVE.drive(MOTOR_ON_SPEED);
		} else if (currentTime >.5 && currentTime < 5.0){
			//LIFT.lift(); //change that is needed
		}
		*/
		storedTime = autonomousTimer.get();
		if(autonomousTimer.get() < 15)
		{
			if(storedTime > lowTime && storedTime < highTime)
			{
				vision.saveImage();
				process.processImage();
			}
			System.out.println("Tote: " + process.foundTote());
			System.out.println("Time: " + storedTime);
			System.out.println("Low: " + lowTime);
			System.out.println("High: " + highTime);
			if(process.foundTote())
			{
				driveTimer.start();
				if(driveTimer.get() < 3)
				{
					if(!ROLLER.getOut())
					{
						ROLLER.rollerOutIn();
					}
					DRIVE.drive(RobotMap.AUTONOMOUS_SPEED);
					ROLLER.spinIn();
				}
				DRIVE.drive(0.0);
				
			}
			else
			{
				DRIVE.rotate(.2);
				if(storedTime > lowTime)
				{
					lowTime += 3.0;
					highTime += 3.0;
				}	
			}
		}
	}
	
	public boolean isFinished() {
		if (autonomousTimer.get() > 15.0) {
            return true;
        }
        return false;
	}
	
	public void interrupted() 
	{
		
	}
	public void end()
	{
		DRIVE.drive(0);
	}	
}
