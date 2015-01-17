package org.usfirst.frc.team2035.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import org.usfirst.frc.team2035.robot.RobotMap;
import org.usfirst.frc.team2035.robot.commands.RollerIn;
import org.usfirst.frc.team2035.robot.commands.RollerOut;
import org.usfirst.frc.team2035.robot.commands.RollerMotorIn;
import org.usfirst.frc.team2035.robot.commands.RollerMotorOut;
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
	
	public static void initialize()
	{
		rollerIn = RobotMap.ButtonRollerExtend;
	    rollerOut = RobotMap.ButtonRollerRetract;
	    rollerMotorIn = RobotMap.ButtonRollerMotorSpin;
	    rollerMotorOut = RobotMap.ButtonRollerMotorSpit;
	    
	    rollerIn.whenPressed(new RollerIn());
	    rollerOut.whenPressed(new RollerOut());
	    rollerMotorIn.whenPressed(new RollerMotorOut());
	    rollerMotorOut.whenPressed(new RollerMotorIn());
	    
	}
}

