package org.usfirst.frc.team2035.robot;

import edu.wpi.first.wpilibj.buttons.Button; 
import org.usfirst.frc.team2035.robot.RobotMap;
import org.usfirst.frc.team2035.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	private static Button rollerIn;
	private static Button rollerOut;
	private static Button rollerMotorIn;
	private static Button rollerMotorOut;
	private static Button shiftGear;
	private static Button lift;
	private static Button lower;
	private static Button forkliftBack;
	private static Button forkliftForward;
	
	public static void initialize()
	{
		/*
		 * Initializes buttons
		 */
		shiftGear = RobotMap.BUTTON_SHIFT_GEAR;
		rollerIn = RobotMap.BUTTON_ROLLER_OUT;
	    rollerOut = RobotMap.BUTTON_ROLLER_IN;
	    rollerMotorIn = RobotMap.BUTTON_ROLLER_MOTOR_IN;
	    rollerMotorOut = RobotMap.BUTTON_ROLLER_MOTOR_OUT;
	    lift = RobotMap.BUTTON_FORKLIFT_UP;
	    lower = RobotMap.BUTTON_FORKLIFT_DOWN;
	    forkliftBack = RobotMap.BUTTON_FORKLIFT_BACK;
	    forkliftForward = RobotMap.BUTTON_FORKLIFT_FORWARD;
	    
	    /*
	     * All button functions
	     */
	    rollerIn.whenPressed(new RollerIn());
	    rollerOut.whenPressed(new RollerOut());
	    rollerMotorIn.whileHeld(new RollerMotorOut());
	    rollerMotorOut.whileHeld(new RollerMotorIn());
	    lift.whileHeld(new LiftForklift());
	    lower.whileHeld(new LowerForklift());
	    forkliftBack.whenPressed(new ForkliftBack());
	    forkliftForward.whenPressed(new ForkliftForward());
		shiftGear.whileHeld(new ShiftLowGear());
	    
	}
}

