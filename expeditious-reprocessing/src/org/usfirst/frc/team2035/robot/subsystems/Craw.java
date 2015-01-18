package org.usfirst.frc.team2035.robot.subsystems;

import org.usfirst.frc.team2035.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Craw extends Subsystem{
	private final Solenoid 	CrawLeftPiston;
	private final Solenoid  CrawRightPiston;

	public Craw()
	{
		CrawLeftPiston = new Solenoid(RobotMap.CRAW_LEFT_PISTON);//create in robot map
		CrawRightPiston = new Solenoid(RobotMap.CRAW_RIGHT_PISTON);//create in robot map
	}
	
	public void CrawClose()
	{
		CrawLeftPiston.set(!RobotMap.CRAW_PISTON_VALUE);
		CrawRightPiston.set(!RobotMap.CRAW_PISTON_VALUE);
	}
	
	public void CrawOpen()
	{
		CrawLeftPiston.set(!RobotMap.CRAW_PISTON_VALUE);
		CrawRightPiston.set(!RobotMap.CRAW_PISTON_VALUE);
	}
		

}
