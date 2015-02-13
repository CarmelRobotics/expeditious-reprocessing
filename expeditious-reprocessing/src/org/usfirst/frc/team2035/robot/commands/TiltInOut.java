package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.Forklift;

public class TiltInOut extends CommandBase{ 
	
	private Forklift tilter;

	public TiltInOut() {
		super("Tilt InOut");
		tilter = Robot.getForklift();
	}

	@Override
	protected void initialize() {
		tilter.extendForklift();
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
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
