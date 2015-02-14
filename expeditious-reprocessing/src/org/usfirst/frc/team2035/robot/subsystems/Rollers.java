package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import org.usfirst.frc.team2035.robot.RobotMap;

public class Rollers extends ExpeditiousSubsystem {

	private final Solenoid 	airInSol;
	private final Solenoid airOutSol;
	private final Victor rightMotor;
	private final Victor leftMotor;
	private boolean out;
	
	public Rollers()
	{
		super("Rollers");
		rightMotor = new Victor(RobotMap.R_ROLLER_MOTOR_PWM);
		leftMotor = new Victor(RobotMap.L_ROLLER_MOTOR_PWM);
		airInSol = new Solenoid(RobotMap.ROLLER_AIR_IN_PCM);
		airOutSol = new Solenoid(RobotMap.ROLLER_AIR_OUT_PCM);
		out = false;
	}
	
	public void init()
	{
		
	}
	
	public void initDefaultCommand() {
	        // Set the default command for a subsystem here.
	        //setDefaultCommand(new MySpecialCommand());
	    }
	 
	public void rollerIn()
	{
		airInSol.set(RobotMap.ROLLER_PISTON_VALUE);
		airOutSol.set(!RobotMap.ROLLER_PISTON_VALUE);
	 }
	
	public void rollerOut()
	{
		airInSol.set(!RobotMap.ROLLER_PISTON_VALUE);
		airOutSol.set(RobotMap.ROLLER_PISTON_VALUE);
	}
	
	
	 public void spinIn()
	 {
		 rightMotor.set(RobotMap.ROLLER_SPEED);
		 leftMotor.set(RobotMap.ROLLER_SPEED);
	 }
	 
	 public void spinOut()
	 {
		 rightMotor.set(-RobotMap.ROLLER_SPEED);
		 leftMotor.set(-RobotMap.ROLLER_SPEED);
	 }
	 
	 public void motorOff()
	 {
		 rightMotor.set(0.0);
		 leftMotor.set(0.0);
	 }
	 
	 public void end()
	 {
		 
	 }
	
}
