/*----------------------------------------------------------------------------*/
/* Copyright (c) 2014 FIRST Team 2035. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc.team2035.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.DriveTrain;

/**
 *
 * @author Team 2035
 */
public class StandardDrive extends CommandBase {

    private final Joystick JOYSTICK;
    private final RobotDrive DRIVE;
    private final DriveTrain THE_DRIVE_TRAIN;

    /**
     *
     * @param d
     * @param j
     */
    public StandardDrive(RobotDrive d, Joystick j) {
        super("StandardDrive");
        THE_DRIVE_TRAIN = Robot.getDriveTrain();
        requires(THE_DRIVE_TRAIN);
        JOYSTICK = j;
        DRIVE = d;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //DriveTrain.getCommandLog().setCommand(this.getName());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //DriveTrain.getCommandLog().setInputs("" + gyroball.getAngle());
        //DriveTrain.setMetaCommandOutputs();

        THE_DRIVE_TRAIN.arcadeDrive();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        DRIVE.stopMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}