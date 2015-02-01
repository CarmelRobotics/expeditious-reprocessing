package org.usfirst.frc.team2035.robot.commands;

import edu.wpi.first.wpilibj.Solenoid;

public class TestSolenoidOn extends CommandBase {
	
	private Solenoid sol;

	public TestSolenoidOn() {
		super("Solenoid On");
		sol = new Solenoid(1,0);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		sol.set(true);
		System.out.println("Solenoid On");

	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		sol.set(false);
		System.out.println("Solenoid Off");

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
