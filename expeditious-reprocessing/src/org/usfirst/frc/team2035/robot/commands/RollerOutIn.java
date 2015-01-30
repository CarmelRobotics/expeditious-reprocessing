package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.Robot; 
import org.usfirst.frc.team2035.robot.subsystems.Rollers;

public class RollerOutIn extends CommandBase {

	private final Rollers roller;
	
	public RollerOutIn()
	{
		super("rolleroutin");
		roller = Robot.getRollers();
		requires(roller);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	protected void execute() {
		roller.rollerOutIn();
	}

	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
	}

}
