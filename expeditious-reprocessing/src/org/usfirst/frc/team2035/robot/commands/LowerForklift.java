package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.*;
import org.usfirst.frc.team2035.robot.*;  
import org.usfirst.frc.team2035.robot.subsystems.Forklift;
import org.usfirst.frc.team2035.robot.subsystems.Rollers;
import org.usfirst.frc.team2035.robot.Robot;

public class LowerForklift extends CommandBase {
	
	private final Forklift forklift;
	//private final Rollers roller;
	
	public LowerForklift(){
		super("lowerforklift");
		forklift = Robot.getForklift();
		//roller = Robot.getRollers();
		//requires(roller);
		requires(forklift);
	}
	
	 // Called just before this Command runs the first time
    protected void initialize() {
    	//forklift.retractForklift();
    	//roller.rollerOut();

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        forklift.setreverseforklift();
    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {

        return false;
    }

    // Called once after isFinished returns true
    protected void end() {

        forklift.setstopforklift();
    }    
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        forklift.setstopforklift();
    }
}
