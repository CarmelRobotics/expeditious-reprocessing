package org.usfirst.frc.team2035.robot.commands;

import edu.wpi.first.wpilibj.Solenoid;

public class TestSolenoidOff extends CommandBase {
	
	private Solenoid sol1;

	public TestSolenoidOff() {
		super("Test Solenoid Off");
		sol1 = new Solenoid(1,0);
		
	}

	@Override
	protected void initialize() {
	

	}

	@Override
	protected void execute() {
		sol1.set(false);
		System.out.println("Solenoid is turned off");
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
