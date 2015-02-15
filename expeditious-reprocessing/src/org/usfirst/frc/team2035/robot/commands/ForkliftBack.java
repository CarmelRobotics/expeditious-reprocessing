
package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.Robot; 
import org.usfirst.frc.team2035.robot.subsystems.Forklift;

public class ForkliftBack extends CommandBase {
	
	private Forklift tilter;

	public ForkliftBack() {
		super("Tilt Out");
		tilter = Robot.getForklift();
		requires(tilter);
	}

	@Override
	protected void initialize() {
		tilter.extendForklift();
	}

	@Override
	protected void execute() {
		tilter.extendForklift();

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
