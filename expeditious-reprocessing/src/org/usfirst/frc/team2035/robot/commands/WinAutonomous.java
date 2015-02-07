
package org.usfirst.frc.team2035.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team2035.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2035.robot.*;
import org.usfirst.frc.team2035.robot.subsystems.Forklift;
import org.usfirst.frc.team2035.robot.commands.Vision;
import org.usfirst.frc.team2035.robot.commands.ProcessImage;


public class WinAutonomous extends CommandBase {
	
	//IMPORTANT! CODE IS NOT FULLY DEVELOPED! UPDATE PERIODICALLY
	
	
	private final DriveTrain DRIVE;
	private final Forklift LIFT;
	private Timer autonomousTimer;
	private final double MOTOR_ON_SPEED = RobotMap.AUTONOMOUS_SPEED; //add AutonomousSpeed on Robot Map (recommended speed 40)
	private final double MOTOR_OFF_SPEED = 0.0;
	private double storedTime;
	private Vision vision;
	private ProcessImage process;
	private double lowTime = .1;
	private double highTime = 1.1;
	
	public WinAutonomous() {
		super("drive");
		DRIVE = Robot.getDriveTrain();
		LIFT = Robot.getForklift();
		vision = new Vision();
		process = new ProcessImage();
	}
	
	
	public void initialize() {
		autonomousTimer = new Timer();
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
			DRIVE.drive(RobotMap.AUTONOMOUS_SPEED);
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
