package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.Rollers;

public class RollerMotorOut extends CommandBase {

	private final Rollers roller;
	
	public RollerMotorOut()
	{
		super("rollermotorout");
		roller = Robot.getRollers();
		requires(roller);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	protected void execute() {
		roller.spinOut();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		roller.motorOff();
	}

	protected void interrupted() {
		roller.motorOff();
	}

}
