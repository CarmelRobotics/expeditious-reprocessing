package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick; 
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import org.usfirst.frc.team2035.robot.RobotMap;
import org.usfirst.frc.team2035.robot.commands.StandardDrive;

public class DriveTrain extends ExpeditiousSubsystem{
	
	private static Joystick stick;
    private SpeedController motorFrontLeft;
    private SpeedController motorBackLeft;
    private SpeedController motorFrontRight;
    private SpeedController motorBackRight;
    //private Solenoid GearShiftSolUp;
    //private Solenoid GearShiftSolDown;
    private DoubleSolenoid gearShifter;
    
    private RobotDrive drive;    

    public DriveTrain() {
    	super("Drive Train");
    	
        motorFrontLeft = new Talon(RobotMap.F_LEFT_MOTOR_PWM); // initialize the motor as a Talon on channel 0
        motorBackLeft = new Talon(RobotMap.B_LEFT_MOTOR_PWM);
        motorFrontRight = new Talon(RobotMap.F_RIGHT_MOTOR_PWM);
        motorBackRight = new Talon(RobotMap.B_RIGHT_MOTOR_PWM);
        stick = new Joystick(RobotMap.JOYSTICK_R_USB_NUMBER);	// initialize the joystick on USB 0
        drive = new RobotDrive(motorFrontLeft,motorBackLeft,motorFrontRight,motorBackRight);
        //GearShiftSolUp = new Solenoid(RobotMap.DRIVE_TRAIN_HIGH_GEAR);
        //GearShiftSolDown = new Solenoid(RobotMap.DRIVE_TRAIN_LOW_GEAR);
        gearShifter = new DoubleSolenoid(RobotMap.PCM_ID, RobotMap.DRIVE_TRAIN_AIR_IN, RobotMap.DRIVE_TRAIN_AIR_OUT);
    }
    
    public void init()
    {
    	
    }
    
    protected void initDefaultCommand()
    {
    	super.setDefaultCommand(new StandardDrive(drive, RobotMap.DRIVER_JOYSTICK_R));
    }
    
    public void arcadeDrive() {
        drive.arcadeDrive(stick.getY(), stick.getX());
    }
    
    public void drive(double speed) {
        drive.drive(speed, 0.0);
    }
   
    public void shiftLowGear()
    {
    	//GearShiftSolUp.set(!RobotMap.LOW_GEAR_SOLENOID_VALUE);
    	//GearShiftSolDown.set(RobotMap.LOW_GEAR_SOLENOID_VALUE);
    	//GearShiftSolUp.set(false);
    	//GearShiftSolDown.set(true);
    	System.out.println("Gotta Go LOW");
    	gearShifter.set(DoubleSolenoid.Value.kForward);
    }
    
    public void shiftHighGear()
    {
    	//GearShiftSolUp.set(!RobotMap.LOW_GEAR_SOLENOID_VALUE);
    	//GearShiftSolDown.set(RobotMap.LOW_GEAR_SOLENOID_VALUE);
    	//GearShiftSolUp.set(true);
    	//GearShiftSolDown.set(false);
    	System.out.println("Gotta Go HIGH");
    	gearShifter.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void rotate(double rot) {
    	drive.drive(0, rot);
    }
    
    public void end()
    {
    }
    
}
