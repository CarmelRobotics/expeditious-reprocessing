package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem; 
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Talon;
import org.usfirst.frc.team2035.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Rollers extends ExpeditiousSubsystem {

	//private final Solenoid 	leftAirInSol;
	//private final Solenoid leftAirOutSol;
	//private final Solenoid 	rightAirInSol;
	//private final Solenoid rightAirOutSol;
	private final Talon rightMotor;
	private final Talon leftMotor;
	private final DoubleSolenoid leftArmSol;
	private final DoubleSolenoid rightArmSol;
	private boolean out;
	
	public Rollers()
	{
		super("Rollers");
		rightMotor = new Talon(RobotMap.R_ROLLER_MOTOR_PWM);
		leftMotor = new Talon(RobotMap.L_ROLLER_MOTOR_PWM);
		//leftAirInSol = new Solenoid(RobotMap.L_ROLLER_AIR_IN_PCM);
		//leftAirOutSol = new Solenoid(RobotMap.L_ROLLER_AIR_OUT_PCM);
		//rightAirInSol = new Solenoid(RobotMap.R_ROLLER_AIR_IN_PCM);
		//rightAirOutSol = new Solenoid(RobotMap.R_ROLLER_AIR_OUT_PCM);
		leftArmSol = new DoubleSolenoid(RobotMap.PCM_ID, RobotMap.L_ROLLER_AIR_IN_PCM, RobotMap.L_ROLLER_AIR_OUT_PCM);
		rightArmSol = new DoubleSolenoid(RobotMap.PCM_ID, RobotMap.R_ROLLER_AIR_IN_PCM, RobotMap.R_ROLLER_AIR_OUT_PCM);
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
		
		leftArmSol.set(DoubleSolenoid.Value.kForward);
		rightArmSol.set(DoubleSolenoid.Value.kForward);
		//leftAirInSol.set(RobotMap.ROLLER_PISTON_VALUE);
		//leftAirOutSol.set(!RobotMap.ROLLER_PISTON_VALUE);
		//rightAirInSol.set(RobotMap.ROLLER_PISTON_VALUE);
		//rightAirOutSol.set(!RobotMap.ROLLER_PISTON_VALUE);
	 }
	
	public void rollerOut()
	{
		leftArmSol.set(DoubleSolenoid.Value.kReverse);
		rightArmSol.set(DoubleSolenoid.Value.kReverse);
		//leftAirInSol.set(!RobotMap.ROLLER_PISTON_VALUE);
		//leftAirOutSol.set(RobotMap.ROLLER_PISTON_VALUE);
		//rightAirInSol.set(!RobotMap.ROLLER_PISTON_VALUE);
		//rightAirOutSol.set(RobotMap.ROLLER_PISTON_VALUE);
	}
	
	
	 public void spinIn()
	 {
		 rightMotor.set(RobotMap.ROLLER_SPEED);
		 leftMotor.set(-RobotMap.ROLLER_SPEED);
	 }
	 
	 public void spinOut()
	 {
		 rightMotor.set(-RobotMap.ROLLER_SPEED);
		 leftMotor.set(RobotMap.ROLLER_SPEED);
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
