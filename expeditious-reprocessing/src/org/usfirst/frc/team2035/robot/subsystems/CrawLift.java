package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import org.usfirst.frc.team2035.robot.RobotMap;
import edu.wpi.first.wpilibj.Talon;

public class CrawLift extends ExpeditiousSubsystem {

	
	private DigitalInput limitSwitchBottom;
	private DigitalInput limitSwitchTop;
	private Talon crawMotor;
	
	public CrawLift() {
		super("Craw Lift");
		limitSwitchBottom = new DigitalInput(RobotMap.DIG_IN_CHANNEL1);
		limitSwitchTop = new DigitalInput(RobotMap.DIG_IN_CHANNEL2);
		crawMotor = new Talon(RobotMap.CRAW_MOTOR);
	}
	
	public void init() 
	{
		
	}
	
	protected void initDefaultCommand()
	{
		
	}
	
	
	public void liftUp() 
	{
		if(limitSwitchTop.get() == true)
		{
			crawMotor.set(-RobotMap.CRAW_SPEED_UP);
		}
		else if(limitSwitchTop.get() == false)
		{
			crawMotor.set(0.00);
		}
		
	}
	
	public void liftDown()
	{
		if(limitSwitchBottom.get() == true)
		{
			crawMotor.set(-RobotMap.CRAW_SPEED_DOWN);
		}
		else if(limitSwitchBottom.get() == false)
		{
			crawMotor.set(0.00);
		}
	}
	
	public void end()
	{
		
	}
}
