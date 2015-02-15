package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.Forklift;

public class ForkliftForward extends CommandBase {
	
	private Forklift tilter;

	public ForkliftForward() {
		super("Tilt In");
		tilter = Robot.getForklift();
		requires(tilter);
	}

	@Override
	protected void initialize() {
		tilter.retractForklift();
	}

	@Override
	protected void execute() {
		tilter.retractForklift();

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
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
