package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem; 
import edu.wpi.first.wpilibj.Talon; 
import org.usfirst.frc.team2035.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;

//why is this "Subsystem" underlined?
public class Forklift extends Subsystem {

	private final Talon chainmotor;
	DigitalInput highLimit;
	DigitalInput lowLimit;
	private Timer liftTime;
	private boolean oneThrough = false;
	
	public Forklift() {
		chainmotor = new Talon(RobotMap.CHAIN_MOTOR_PWM); // make sure to make this in robot map
		highLimit = new DigitalInput(RobotMap.HIGH_LIMIT_SWITCH);
		lowLimit = new DigitalInput(RobotMap.LOW_LIMIT_SWITCH);
		liftTime = new Timer();
	}
	public void initDefaultCommand() {
		 
	        // Set the default command for a subsystem here.
	        //setDefaultCommand(new MySpecialCommand());
	}
	
	public void setliftforklift() {
		
		while ( highLimit.get() == false)
		{
		chainmotor.set(RobotMap.FORKLIFT_MOTOR_SPEED); // make sure to make this in robot map
		}
		if(oneThrough == false)
		{
		liftTime.start();
		}
		while(oneThrough == false)
		{
			chainmotor.set(RobotMap.FORKLIFT_MOTOR_SPEED);
		}
		if (liftTime.get() >= 5.0 )
		{
			oneThrough = true;
			liftTime.stop();
			liftTime.reset();
		}
		
	}

	public void setstopforklift() {
		chainmotor.set(RobotMap.FORKLIFT_OFF_MOTOR_SPEED); // make this in robot map
	}

	public void setreverseforklift() {
		while (lowLimit.get() == false)
		{
		chainmotor.set(RobotMap.FORKLIFT_REVERSE_MOTOR_SPEED);// make this in robot map
		}
	}
	
	public void setOneThrough(boolean b)
	{
		oneThrough = b;
	}
	
	
	
}
