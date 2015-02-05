package org.usfirst.frc.team2035.robot.commands;
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2014 FIRST Team 2035. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

import org.usfirst.frc.team2035.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2035.robot.Robot;

/**
 *
 * @author Team 2035
 */
public abstract class ShiftLowGear extends CommandBase {


    private final DriveTrain train;

    public ShiftLowGear() {
    	super("ShiftLowGear");
    	train = Robot.getDriveTrain();
    	requires(train);
    }
    
    protected void initialize() {
    	train.shiftLowGear();
    }
    
    protected void execute() {
    	train.shiftLowGear();
    }
    
    protected boolean isFinished() {
    	return false;
    }
    protected void end() {
    	train.shiftHighGear();
    }
    
    protected void interrupted() {
    	train.shiftHighGear();
    }

}