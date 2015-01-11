package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.RobotDrive;
import org.usfirst.frc.team2035.robot.RobotMap;

public class DriveTrain {
	
	private static Joystick stick;
    private SpeedController motorFrontLeft;
    private SpeedController motorBackLeft;
    private SpeedController motorFrontRight;
    private SpeedController motorBackRight;
    private RobotDrive drive;


    public DriveTrain() {
        motorFrontLeft = new Talon(RobotMap.F_LEFT_MOTOR_PWM); // initialize the motor as a Talon on channel 0
        motorBackLeft = new Talon(RobotMap.B_LEFT_MOTOR_PWM);
        motorFrontRight = new Talon(RobotMap.F_RIGHT_MOTOR_PWM);
        motorBackRight = new Talon(RobotMap.B_RIGHT_MOTOR_PWM);
        stick = new Joystick(RobotMap.JOYSTICK1);	// initialize the joystick on USB 0
        drive = new RobotDrive(motorFrontLeft,motorBackLeft,motorFrontRight,motorBackRight);
    }
    
    public void arcadeDrive() {
        drive.arcadeDrive(stick.getY(), stick.getX());
    }
    
}
