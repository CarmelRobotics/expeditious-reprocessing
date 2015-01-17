package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import org.usfirst.frc.team2035.robot.RobotMap;

public class Rollers extends Subsystem {

	private final Solenoid 	leftPiston;
	private final Solenoid rightPiston;
	private final Victor rightMotor;
	private final Victor leftMotor;
	
	public Rollers()
	{
		rightMotor = new Victor(RobotMap.RIGHT_ROLLER_MOTOR);
		leftMotor = new Victor(RobotMap.LEFT_ROLLER_MOTOR);
		leftPiston = new Solenoid(RobotMap.LEFT_ROLLER_PISTON);
		rightPiston = new Solenoid(RobotMap.RIGHT_ROLLER_PISTON);
	}
	
	 public void initDefaultCommand() {
	        // Set the default command for a subsystem here.
	        //setDefaultCommand(new MySpecialCommand());
	    }
	 
	 public void rollerOut()
	 {
		leftPiston.set(RobotMap.ROLLER_PISTON_VALUE);
		rightPiston.set(RobotMap.ROLLER_PISTON_VALUE);
	 }
	 
	 public void rollerIn()
	 {
		leftPiston.set(!RobotMap.ROLLER_PISTON_VALUE);
		rightPiston.set(!RobotMap.ROLLER_PISTON_VALUE);
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
	
}
