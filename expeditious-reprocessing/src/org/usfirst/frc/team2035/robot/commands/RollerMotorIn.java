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
		//System.out.println("roller motor in init");
		roller.spinIn();
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		//roller.spinIn();
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		//System.out.println("roller motor in end");
		roller.motorOff();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		roller.motorOff();
	}

}
