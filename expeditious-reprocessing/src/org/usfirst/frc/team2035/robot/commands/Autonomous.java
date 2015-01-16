package org.usfirst.frc.team2035.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team2035.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2035.robot.*;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.RobotMap;
import org.usfirst.frc.team2035.robot.subsystems.Forklift;


public class Autonomous extends CommandBase {
	
	//IMPORTANT! CODE IS NOT FULLY DEVELOPED! UPDATE PERIODICALLY
	
	
	private final DriveTrain DRIVE;
	private final Forklift LIFT;
	private Timer autonomousTimer;
	private final double MOTOR_ON_SPEED = RobotMap.AutonomousSpeed; //add AutonomousSpeed on Robot Map (recommended speed 40)
	private final double MOTOR_OFF_SPEED = 0.0;
	private double storedTime;
	
	public Autonomous() {
		super("drive");
		DRIVE = Robot.getDriveTrain();
		LIFT = Robot.getForklift();
	}
	
	
	protected void initialize() {
		autonomousTimer = new Timer();
		autonomousTimer.start();
	}
	
	protected void execute() {
		double currentTime = autonomousTimer.get();
		if(currentTime > 0.0 && currentTime < .5){ //Change time that is needed 
			DRIVE.arcadeDrive();
		} else if (currentTime >.5 && currentTime < 5.0){
			//LIFT.lift(); //change that is needed
		}
	}
	
	

	protected boolean isFinished() {
		if (autonomousTimer.get() > 15.0) {
            return true;
        }
        return false;
	}
	
	protected void interrupted() {
		
	}
	
	protected void end()
	{
		
	}
	
}
