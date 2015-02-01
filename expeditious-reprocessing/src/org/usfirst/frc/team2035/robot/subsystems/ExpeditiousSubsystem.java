package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

public abstract class ExpeditiousSubsystem extends Subsystem {
	
	private String name;
	
	public ExpeditiousSubsystem()
	{
		super();
		name = "";
	}
	
	public ExpeditiousSubsystem(String n)
	{
		super();
		name = n;
	}
	
	public abstract void init();
	
	public abstract void end();


}
