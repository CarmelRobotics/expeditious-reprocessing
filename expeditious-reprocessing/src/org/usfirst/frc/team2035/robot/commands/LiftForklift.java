package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.*;
import org.usfirst.frc.team2035.robot.subsystems.Forklift;
import org.usfirst.frc.team2035.robot.Robot;

public class LiftForklift extends CommandBase {
	private final Forklift forklift;
	
	public LiftForklift(){
		super("liftforklift");
		forklift = Robot.getForklift();
		requires(forklift);
	}
	
	 // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	forklift.setOneThrough(false);
        forklift.setliftforklift();
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
