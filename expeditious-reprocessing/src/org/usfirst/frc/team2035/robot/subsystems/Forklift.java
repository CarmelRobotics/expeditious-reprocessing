package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon; 
import org.usfirst.frc.team2035.robot.RobotMap;


public class Forklift extends Subsystem {

	private final Talon chainmotor;
	
	public Forklift() {
		chainmotor = new Talon(RobotMap.ChainMotor_PWM); // make sure to make this in robot map
	}
	 public void initDefaultCommand() {
		 
	        // Set the default command for a subsystem here.
	        //setDefaultCommand(new MySpecialCommand());
	 }
	
	public void setliftforklift() {
		chainmotor.set(RobotMap.ForkliftMotorSpeed); // make sure to make this in robot map
	}

	public void setstopforklift() {
		chainmotor.set(RobotMap.ForkliftOffMotorSpeed); // make this in robot map
	}

	public void setreverseforklift() {
		chainmotor.set(RobotMap.ForkliftReverseMotorSpeed);// make this in robot map
	}
	
	
	
}
