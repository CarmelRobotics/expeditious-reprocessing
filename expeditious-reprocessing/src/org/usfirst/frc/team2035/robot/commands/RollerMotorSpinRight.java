package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.Rollers;


public class RollerMotorSpinRight extends CommandBase {
	
	private final Rollers roller;

	public RollerMotorSpinRight() {
		super("rollermotorright");
		roller = Robot.getRollers();
		requires(roller);
	}

	@Override
	protected void initialize() {
		roller.spinRight();

		
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
		roller.motorOff();
		
	}

	@Override
	protected void interrupted() {
		roller.motorOff();
		
	}

}
