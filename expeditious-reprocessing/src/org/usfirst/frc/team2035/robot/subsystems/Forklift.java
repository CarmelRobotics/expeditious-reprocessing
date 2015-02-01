package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon; 
import org.usfirst.frc.team2035.robot.RobotMap;

//why is this "Subsystem" underlined?
public class Forklift extends ExpeditiousSubsystem {

	private final Talon chainmotor;
	
	public Forklift() {
		super("Fork Lift");
		chainmotor = new Talon(RobotMap.CHAIN_MOTOR_PWM); // make sure to make this in robot map
	}
	
	
	public void init() {
		
	}
	
	public void initDefaultCommand() {
		 
	        // Set the default command for a subsystem here.
	        //setDefaultCommand(new MySpecialCommand());
	}
	
	public void setliftforklift() {
		chainmotor.set(RobotMap.FORKLIFT_MOTOR_SPEED); // make sure to make this in robot map
	}

	public void setstopforklift() {
		chainmotor.set(RobotMap.FORKLIFT_OFF_MOTOR_SPEED); // make this in robot map
	}

	public void setreverseforklift() {
		chainmotor.set(RobotMap.FORKLIFT_REVERSE_MOTOR_SPEED);// make this in robot map
	}
	
	public void end() {
		
	}
	
	
	
}
