
package org.usfirst.frc.team2035.robot;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

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
	
	/*
	 *  Motor PWMS
	 */
	public static final int F_LEFT_MOTOR_PWM = 0; // Front Left drive motor is wired to PWM out 0
    public static final int B_LEFT_MOTOR_PWM = 1; // Rear Left drive motor is wired to PWM out 1
    public static final int F_RIGHT_MOTOR_PWM = 2; // Front Right drive motor is wired to PWM out 2
    public static final int B_RIGHT_MOTOR_PWM = 3; // Rear Right drive motor is wired to PWM out 3 
    public static final int R_CHAIN_MOTOR_PWM = 4; //Right chain motor is wired to PWM out 4
    public static final int L_CHAIN_MOTOR_PWM = 5;
    public static final int RIGHT_ROLLER_MOTOR = 6;//6
    public static final int LEFT_ROLLER_MOTOR = 7;//7
    
    public static final int LEFT_ROLLER_PISTON = 0;
    public static final int RIGHT_ROLLER_PISTON = 1;
    
    public static final boolean ROLLER_PISTON_VALUE = true;
    
    /*
     * DIGITAL SIDECAR DIGITAL INPUTS NUMBERING (can be 1-14)
     */
    public static final int PCM_ID = 1;
    public static final int HIGH_LIMIT_SWITCH = 1;
    public static final int LOW_LIMIT_SWITCH = 2;
    
    /*
    
    /*
     * DRIVETRAIN SUBSYSTEM CONSTANTS
     */
    public static final double AUTONOMOUS_SPEED= 0.40; //Autonomous speed set to 40%
    public static final double ROLLER_SPEED = 1.0;
    
    public static final int JOYSTICK1 = 0; // First joystick is wired to USB 0
    
    public static final int JOYSTICK_USB_NUMBER = 0;
    public static final Joystick DRIVER_JOYSTICK = new Joystick(JOYSTICK_USB_NUMBER);
    
    public static final boolean LowGearSolenoidValue = false;
    /*
     * SOLENOID RELAY CARTRIDGE NUMBERING
     */
    public static final int DriveTrainHighGear = 1; //Drive Train High Gear Solenoid set to Relay cartridge 1
    public static final int DriveTrainLowGear = 2; //Drive Train Low Gear Solenoid set to Relay cartridge 2
    
    /*
     * Forklift varialbles, this will be overwritten
     */
    
    public static final int FORWARD_SOLENOID_PCM = 3;
    public static final int BACK_SOLENOID_PCM = 2;
    public static final boolean FORKLIFT_SOLENOID_VALUE = true;
    
    public static final int DIG_IN_CHANNEL1 = 1;
    public static final int DIG_IN_CHANNEL2 = 2;
    /*
     * DIGITAL SIDECAR RELAYS NUMBERING (can be 1-8)
     */
    public static final int COMPRESSOR_RELAY = 5;

    
    /*
     * FORKLIFT SUBSYSTEM CONSTANTS
     */
    
    public static final double FORKLIFT_MOTOR_SPEED = 0.5; //chain motor lift speed is set to lift at half speed 50%
    public static final double FORKLIFT_OFF_MOTOR_SPEED = 0.0; //chain motor stationary is set to 0%
    public static final double FORKLIFT_REVERSE_MOTOR_SPEED = -0.5; //chain motor reverses at half speed -50%

    
    public static final JoystickButton BUTTON_SHIFT_GEAR = new JoystickButton(DRIVER_JOYSTICK, 1);
    public static final JoystickButton BUTTON_ROLLER_EXTEND = new JoystickButton(DRIVER_JOYSTICK, 2);
    public static final JoystickButton BUTTON_ROLLER_RETRACT = new JoystickButton(DRIVER_JOYSTICK, 3);
    public static final JoystickButton BUTTON_ROLLER_MOTOR_SPIN = new JoystickButton(DRIVER_JOYSTICK, 2);
    public static final JoystickButton BUTTON_ROLLER_MOTOR_SPIT = new JoystickButton(DRIVER_JOYSTICK, 5);
    public static final JoystickButton BUTTON_SOLENOID = new JoystickButton(DRIVER_JOYSTICK, 6);
    public static final JoystickButton BUTTON_SOLENOID2 = new JoystickButton(DRIVER_JOYSTICK, 7);
    
    /*
     * Camera
     */
    
    public static final int cameraSession = NIVision.IMAQdxOpenCamera("cam1", NIVision.IMAQdxCameraControlMode.CameraControlModeController); 
    //this may need to change to "cam1" depending if using test board or multiple cameras

    public static final Image frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
    public static int camCounter = 0;
    public static final int IMAGE_QUALITY = 100;
    public static final int SAVE_IMAGE_QUALITY = 100;
    
    public static final String IMAGE_PATH = "/images/test.jpg";
}



