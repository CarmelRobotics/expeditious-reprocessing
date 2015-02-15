package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.Robot; 
import org.usfirst.frc.team2035.robot.subsystems.Rollers;

public class RollerIn extends CommandBase {

	private final Rollers roller;
	
	public RollerIn()
	{
		super("Roller In");
		roller = Robot.getRollers();
		requires(roller);
	}
	
	@Override
	protected void initialize() {
	   // TODO Auto-generated method stub
		roller.rollerIn();

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		roller.rollerIn();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
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
