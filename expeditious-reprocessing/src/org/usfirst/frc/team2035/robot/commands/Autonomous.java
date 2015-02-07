
package org.usfirst.frc.team2035.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team2035.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2035.robot.*;
import org.usfirst.frc.team2035.robot.subsystems.Forklift;
import org.usfirst.frc.team2035.robot.commands.Vision;
import org.usfirst.frc.team2035.robot.commands.ProcessImage;


public class Autonomous extends CommandBase {
	
	//IMPORTANT! CODE IS NOT FULLY DEVELOPED! UPDATE PERIODICALLY
	
	
	private final DriveTrain DRIVE;
	private final Forklift LIFT;
	private Timer autonomousTimer;
	private final double MOTOR_ON_SPEED = RobotMap.AUTONOMOUS_SPEED; //add AutonomousSpeed on Robot Map (recommended speed 40)
	private final double MOTOR_OFF_SPEED = 0.0;
	private double storedTime;
	private Vision vision;
	private ProcessImage process;
	
	public Autonomous() {
		super("drive");
		DRIVE = Robot.getDriveTrain();
		LIFT = Robot.getForklift();
		vision = new Vision();
		process = new ProcessImage();
	}
	
	
	protected void initialize() {
		autonomousTimer = new Timer();
		autonomousTimer.start();
		vision.visionInit();
		process.initProcessImage();
	}
	
	protected void execute() {
		/*
		double currentTime = autonomousTimer.get();
		if(currentTime > 0.0 && currentTime < .5){ //Change time that is needed 
			DRIVE.drive(MOTOR_ON_SPEED);
		} else if (currentTime >.5 && currentTime < 5.0){
			//LIFT.lift(); //change that is needed
		}
		*/
		storedTime = autonomousTimer.get();
		if(storedTime > .01 && storedTime < 1.2)
		{
			vision.saveImage();
			process.processImage();
		}
		if(process.foundTote())
		{
			DRIVE.drive(RobotMap.AUTONOMOUS_SPEED);
		}
		else
		{
			DRIVE.rotate(.2);
		}		
	}
	
	protected boolean isFinished() {
		if (autonomousTimer.get() > 15.0) {
            return true;
        }
        return false;
	}
	
	protected void interrupted() 
	{
		
	}
	protected void end()
	{
		DRIVE.drive(0);
	}	
}
