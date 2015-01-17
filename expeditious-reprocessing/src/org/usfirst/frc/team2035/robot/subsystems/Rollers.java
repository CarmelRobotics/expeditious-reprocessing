package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import org.usfirst.frc.team2035.robot.RobotMap;

public class Rollers extends Subsystem {

	private final Solenoid 	LEFT_PISTON;
	private final Solenoid RIGHT_PISTON;
	private final Victor RIGHT_MOTOR;
	private final Victor LEFT_MOTOR;
	
	public Rollers()
	{
		RIGHT_MOTOR = new Victor(RobotMap.RIGHT_ROLLER_MOTOR);
		LEFT_MOTOR = new Victor(RobotMap.LEFT_ROLLER_MOTOR);
		LEFT_PISTON = new Solenoid(RobotMap.LEFT_ROLLER_PISTON);
		RIGHT_PISTON = new Solenoid(RobotMap.RIGHT_ROLLER_PISTON);
	}
	
	 public void initDefaultCommand() {
	        // Set the default command for a subsystem here.
	        //setDefaultCommand(new MySpecialCommand());
	    }
	 
	 public void rollerOut()
	 {
		LEFT_PISTON.set(RobotMap.ROLLER_PISTON_VALUE);
		RIGHT_PISTON.set(RobotMap.ROLLER_PISTON_VALUE);
	 }
	 
	 public void rollerIn()
	 {
		LEFT_PISTON.set(!RobotMap.ROLLER_PISTON_VALUE);
		RIGHT_PISTON.set(!RobotMap.ROLLER_PISTON_VALUE);
	 }
	 
	 public void spinIn()
	 {
		 RIGHT_MOTOR.set(RobotMap.ROLLER_SPEED);
		 LEFT_MOTOR.set(RobotMap.ROLLER_SPEED);
	 }
	 
	 public void spinOut()
	 {
		 RIGHT_MOTOR.set(-RobotMap.ROLLER_SPEED);
		 LEFT_MOTOR.set(-RobotMap.ROLLER_SPEED);
	 }
	 
	 public void motorOff()
	 {
		 RIGHT_MOTOR.set(0.0);
		 LEFT_MOTOR.set(0.0);
	 }
	
}
