package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.*;  
import org.usfirst.frc.team2035.robot.subsystems.Forklift;
import org.usfirst.frc.team2035.robot.subsystems.Rollers;
import org.usfirst.frc.team2035.robot.Robot;
import edu.wpi.first.wpilibj.Timer;


public class LiftForklift extends CommandBase {
	private final Forklift forklift;
	private final Rollers roller;
	private boolean limSwitch;
	int i = 0;
	private Timer time;
	
	public LiftForklift(){
		super("liftforklift");
		forklift = Robot.getForklift();
		roller = Robot.getRollers();
		limSwitch = false;	
		requires(roller);
		requires(forklift);
		time = new Timer();
	}
	
	 // Called just before this Command runs the first time
    protected void initialize() {
    	//i = 0;
    	forklift.retractForklift();
    	//roller.rollerOut();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//forklift.setOneThrough(false);
    	//System.out.println(forklift.getLimit().get());
    	//i++;
        forklift.setliftforklift();
        
    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {

    	//i++;
    	//if(i <= 50)
    	//{
    	//return false;
    	//}
        if(forklift.getLimit().get() == true)
    	{
    		return true;
    	}
    	else
    	{
            return false;
    	}
    	//if(forklift.getLimit().get() == true)
    	//{
    	// return true;
    	//}
    	/*
    	if(forklift.getLimit().get() == true)
        {	
    		limSwitch = true;
        }
    	if(limSwitch == true)
    	{
    		i++;
    	}
    	if(i >= 20)
    		return true;
    	else
    	*/

        
    }

    // Called once after isFinished returns true
    protected void end() {

    	time.delay(.25);
        forklift.setstopforklift();
    }    
 // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        forklift.setstopforklift();
    }
}
