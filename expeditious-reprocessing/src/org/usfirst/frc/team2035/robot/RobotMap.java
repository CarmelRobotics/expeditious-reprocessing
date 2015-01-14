package org.usfirst.frc.team2035.robot;
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
    public static final int ChainMotor_PWM = 4; //chain motor is wired to PWM out 4
    
    public static final int JOYSTICK1 = 0; // First joystick is wired to USB 0
    
    
    // Organize this later
    /*
     * FORKLIFT SUBSYSTEM CONSTANTS
     */
    public static final double ForkliftMotorSpeed = 0.5; //chain motor lift speed is set to lift at half speed 50%
    public static final double ForkliftOffMotorSpeed = 0.0; //chain motor stationary is set to 0%
    public static final double ForkliftReverseMotorSpeed = -0.5; //chain motor reverses at half speed -50%
}
