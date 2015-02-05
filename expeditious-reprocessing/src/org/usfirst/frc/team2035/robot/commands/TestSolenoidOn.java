package org.usfirst.frc.team2035.robot.commands;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;

public class TestSolenoidOn extends CommandBase {
	
	private Solenoid sol1;

	private Timer time;

	public TestSolenoidOn() {
		super("Solenoid On");
		sol1 = new Solenoid(1,0);
	}

	@Override
	protected void initialize() {
		time = new Timer();
		time.start();

	}

	@Override
	protected void execute() {
		sol1.set(true);
		System.out.println("Solenoid On");

	}

	@Override
	protected boolean isFinished() {
		if (time.get() > .5) {
            return true;
        }
		return false;
	}

	@Override
	protected void end() {
		sol1.set(false);
		System.out.println("Solenoid Off");

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		sol1.set(false);
		System.out.println("Solenoid Off");

	}

}
