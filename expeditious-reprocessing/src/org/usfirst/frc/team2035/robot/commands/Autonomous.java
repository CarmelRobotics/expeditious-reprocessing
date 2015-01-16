package org.usfirst.frc.team2035.robot.commands;
//package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team2035.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2035.robot.*;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.RobotMap;
import org.usfirst.frc.team2035.robot.subsystems.Forklift;


public class Autonomous extends CommandBase {
	
	//IMPORTANT! CODE IS NOT FULLY DEVELOPED! UPDATE PERIODICALLY
	
	
	private final DriveTrain drive;
	private final Forklift lift;
	private Timer autonomousTimer;
	private final double MotorOnSpeed = RobotMap.AutonomousSpeed; //add AutonomousSpeed on Robot Map (recommended speed 40)
	private final double Motoroffspeed = 0.0;
	private double sotredTime;
	
	public Autonomous() {
		super("drive");
		drive = Robot.getDriveTrain();
		lift = Robot.getForklift();
	}
	
	
	protected void initialize() {
		autonomousTimer = new Timer();
		autonomousTimer.start();
	}
	
	protected void execute() {
		double currentTime = autonomousTimer.get();
		if(currentTime > 0.0 && currentTime < .5){ //Change time that is needed 
			drive.arcadeDrive(MotorsOnSpeed, MotorsOnSpeed);
		} else if (currentTime >.5 && currentTime < 5.0){
			lift.lift(); //change that is needed
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
