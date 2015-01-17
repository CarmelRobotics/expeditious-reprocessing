package org.usfirst.frc.team2035.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	public static final int F_LEFT_MOTOR_PWM = 0; // Front Left drive motor is wired to PWM out 0
    public static final int B_LEFT_MOTOR_PWM = 1; // Rear Left drive motor is wired to PWM out 1
    public static final int F_RIGHT_MOTOR_PWM = 2; // Front Right drive motor is wired to PWM out 2
    public static final int B_RIGHT_MOTOR_PWM = 3; // Rear Right drive motor is wired to PWM out 3 
    public static final int CHAIN_MOTOR_PWM = 4; //chain motor is wired to PWM out 4
    public static final int RIGHT_ROLLER_MOTOR = 5;
    public static final int LEFT_ROLLER_MOTOR = 6;
    
    public static final int LEFT_ROLLER_PISTON = 0;
    public static final int RIGHT_ROLLER_PISTON = 1;
    
    public static final boolean ROLLER_PISTON_VALUE = true;
    
    /*
     * DRIVETRAIN SUBSYSTEM CONSTANTS
     */
    public static final double AutonomousSpeed = 0.40; //Autonomous speed set to 40%
    public static final double ROLLER_SPEED = 1.0;
    
    public static final int JOYSTICK1 = 0; // First joystick is wired to USB 0
    
    
    // Organize this later
    /*
     * FORKLIFT SUBSYSTEM CONSTANTS
     */
    public static final Joystick DriverJoystick = new Joystick(1);
    
    public static final double FORKLIFT_MOTOR_SPEED = 0.5; //chain motor lift speed is set to lift at half speed 50%
    public static final double FORKLIFT_OFF_MOTOR_SPEED = 0.0; //chain motor stationary is set to 0%
    public static final double FORKLIFT_REVERSE_MOTOR_SPEED = -0.5; //chain motor reverses at half speed -50%
    
    public static final JoystickButton ButtonRollerExtend = new JoystickButton(DriverJoystick, 2);
    public static final JoystickButton ButtonRollerRetract = new JoystickButton(DriverJoystick, 3);
    public static final JoystickButton ButtonRollerMotorSpin = new JoystickButton(DriverJoystick, 4);
    public static final JoystickButton ButtonRollerMotorSpit = new JoystickButton(DriverJoystick, 5);
}
