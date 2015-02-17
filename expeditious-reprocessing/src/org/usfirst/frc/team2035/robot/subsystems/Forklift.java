package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem; 
import edu.wpi.first.wpilibj.Talon; 

import org.usfirst.frc.team2035.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Forklift extends ExpeditiousSubsystem {

	private final Talon rightChainMotor;
	private final Talon leftChainMotor;
	private DigitalInput highLimit;
	//private DigitalInput lowLimit;
	private Timer liftTime;
	private boolean oneThrough = false;
	private Solenoid airInSol;
	private Solenoid airOutSol;
	private boolean out;
	private DoubleSolenoid tilter;
	
	public Forklift() {
		super("Fork Lift");
		rightChainMotor = new Talon(RobotMap.R_CHAIN_MOTOR_PWM); // make sure to make this in robot map
		leftChainMotor = new Talon(RobotMap.L_CHAIN_MOTOR_PWM); // make sure to make this in robot map
		highLimit = new DigitalInput(RobotMap.HIGH_LIMIT_SWITCH);
		//lowLimit = new DigitalInput(RobotMap.LOW_LIMIT_SWITCH);
		liftTime = new Timer();
		out = false;
		//airInSol = new Solenoid(1, RobotMap.BACK_SOLENOID_PCM);
		//airOutSol = new Solenoid(1, RobotMap.FORWARD_SOLENOID_PCM);
		tilter = new DoubleSolenoid(RobotMap.PCM_ID, RobotMap.FORWARD_SOLENOID_PCM, RobotMap.BACK_SOLENOID_PCM);
	}
	
	
	public void init() {
		//leftPiston = new Solenoid(1, RobotMap.EXTEND_SOLENOID_PCM); //I believe this should be in the constructor Dom
		//rightPiston = new Solenoid(1, RobotMap.RETRACT_SOLENOID_PCM); //I believe this should be in the constructor Dom
	}
	
	public void initDefaultCommand() {
		 
	        // Set the default command for a subsystem here.
	        //setDefaultCommand(new MySpecialCommand());
	}
	
	public void setliftforklift() {
		
		//if(highLimit.get())
			//System.out.println("pressed");
		
			rightChainMotor.set(RobotMap.FORKLIFT_MOTOR_SPEED); // make sure to make this in robot map
			leftChainMotor.set(RobotMap.FORKLIFT_MOTOR_SPEED);
		//if(oneThrough == false)
		//{
		//liftTime.start();
		//}
		//while(oneThrough == false)
		//{
		//	rightChainMotor.set(RobotMap.FORKLIFT_MOTOR_SPEED);
		//	leftChainMotor.set(RobotMap.FORKLIFT_MOTOR_SPEED);
		//}
		//if (liftTime.get() >= 5.0)
		//{
		//	oneThrough = true;
		//	liftTime.stop();
		//	liftTime.reset();
		//}
		
	}

	public void setstopforklift() {
		rightChainMotor.set(RobotMap.FORKLIFT_OFF_MOTOR_SPEED); // make this in robot map
		leftChainMotor.set(RobotMap.FORKLIFT_OFF_MOTOR_SPEED);
	}

	public void setreverseforklift() {
		//while (lowLimit.get() == false)
		//{
			rightChainMotor.set(RobotMap.FORKLIFT_REVERSE_MOTOR_SPEED);// make this in robot map
			leftChainMotor.set(RobotMap.FORKLIFT_REVERSE_MOTOR_SPEED);
		//}
	}
	
	//added by Abby: tilts the whole forklift system out
	public void extendForklift()
	{
		//airInSol.set(RobotMap.FORKLIFT_SOLENOID_VALUE);
		//airOutSol.set(!RobotMap.FORKLIFT_SOLENOID_VALUE);
		tilter.set(DoubleSolenoid.Value.kReverse);
		System.out.println("Pistons are out"); 

	}
	
	public void retractForklift()
	{
		//airInSol.set(!RobotMap.FORKLIFT_SOLENOID_VALUE);
        //airOutSol.set(RobotMap.FORKLIFT_SOLENOID_VALUE);
		tilter.set(DoubleSolenoid.Value.kReverse);
        System.out.println("Pistons are in");
	}
	
	
	public void setOneThrough(boolean b)
	{
		oneThrough = b;
	}
	
	public void end() {
		
	}
	
	public DigitalInput getLimit()
	{
		return highLimit;
	}
	
}
