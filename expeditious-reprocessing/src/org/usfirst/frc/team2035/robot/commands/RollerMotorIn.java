package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.Rollers;

public class RollerMotorIn extends CommandBase {

	private final Rollers roller;
	
	public RollerMotorIn()
	{
		super("rollermotorin");
		roller = Robot.getRollers();
		requires(roller);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	protected void execute() {
		roller.spinIn();
	}

	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		roller.motorOff();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		roller.motorOff();
	}

}
