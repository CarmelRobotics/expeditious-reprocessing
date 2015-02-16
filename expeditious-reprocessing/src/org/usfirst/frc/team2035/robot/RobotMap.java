package org.usfirst.frc.team2035.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;
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
	 * Motor PWMs
	 */
	public static final int F_LEFT_MOTOR_PWM = 0; // Front Left drive motor is wired to PWM out 0
    public static final int B_LEFT_MOTOR_PWM = 1; // Rear Left drive motor is wired to PWM out 1
    public static final int F_RIGHT_MOTOR_PWM = 2; // Front Right drive motor is wired to PWM out 2
    public static final int B_RIGHT_MOTOR_PWM = 3; // Rear Right drive motor is wired to PWM out 3 
    public static final int L_CHAIN_MOTOR_PWM = 4; // Left chain motor is wired to PWM out 4
    public static final int R_CHAIN_MOTOR_PWM = 5; // Right chain motor is wired to PWM out 5
    public static final int R_ROLLER_MOTOR_PWM = 6; // Right roller motor is wired to PWM out 6
    public static final int L_ROLLER_MOTOR_PWM = 7; // Left roller motor is wired to PWM out 7
    
    
    /*
     * Solenoid PCMs
     */
    public static final int L_ROLLER_AIR_IN_PCM = 0; // Left Roller Solenoid is wired to PCM 0
    public static final int L_ROLLER_AIR_OUT_PCM = 7; // Right Roller Solenoid is wired to PCM 1
    public static final int R_ROLLER_AIR_IN_PCM = 1; // Left Roller Solenoid is wired to PCM 0
    public static final int R_ROLLER_AIR_OUT_PCM = 6; // Right Roller Solenoid is wired to PCM 1
    public static final int BACK_SOLENOID_PCM = 2; // Left Roller Solenoid is wired to PCM 0
    public static final int FORWARD_SOLENOID_PCM = 5; // Left Roller Solenoid is wired to PCM 0
    public static final int DRIVE_TRAIN_AIR_IN = 3; //Drive Train High Gear Solenoid set to Relay cartridge 1
    public static final int DRIVE_TRAIN_AIR_OUT = 4; //Drive Train Low Gear Solenoid set to Relay cartridge 2
    
    
    /*
     * DIGITAL SIDECAR DIGITAL INPUTS NUMBERING (can be 1-14)
     */
    public static final int PCM_ID = 1;
    public static final int PCM2_ID = 2;
    public static final int PRESSURE_SWITCH_DIG_IN = 14;
    public static final int HIGH_LIMIT_SWITCH = 1;
    public static final int LOW_LIMIT_SWITCH = 2;
    
    
    /*
     * SPEED CONSTANTS
     */
    public static final double AUTONOMOUS_SPEED= 0.40; //Autonomous speed set to 40%
    public static final double ROLLER_SPEED = 0.5;
    public static final double FORKLIFT_MOTOR_SPEED = -1; //chain motor lift speed is set to lift at half speed 50%
    public static final double FORKLIFT_OFF_MOTOR_SPEED = 0.0; //chain motor stationary is set to 0%
    public static final double FORKLIFT_REVERSE_MOTOR_SPEED = 1; //chain motor reverses at half speed -50%
    
    
    /*
     * Solenoid Booleans
     */
    public static final boolean FORKLIFT_SOLENOID_VALUE = true;
    public static final boolean ROLLER_PISTON_VALUE = true;
    public static final boolean LOW_GEAR_SOLENOID_VALUE = false;
    
    
    /*
     * Joystick Buttons
    */
    public static final int JOYSTICK_R_USB_NUMBER = 0;
    public static final int JOYSTICK_L_USB_NUMBER = 1;
    public static final Joystick DRIVER_JOYSTICK_R = new Joystick(JOYSTICK_R_USB_NUMBER);
    public static final Joystick DRIVER_JOYSTICK_L = new Joystick(JOYSTICK_L_USB_NUMBER);
    
    //Right Joystick Buttons
    public static final JoystickButton BUTTON_SHIFT_GEAR = new JoystickButton(DRIVER_JOYSTICK_R, 1);
    public static final JoystickButton BUTTON_FORKLIFT_DOWN = new JoystickButton(DRIVER_JOYSTICK_R, 2);
    public static final JoystickButton BUTTON_FORKLIFT_UP = new JoystickButton(DRIVER_JOYSTICK_R, 3);
    public static final JoystickButton BUTTON_FORKLIFT_BACK = new JoystickButton(DRIVER_JOYSTICK_R, 4);
    public static final JoystickButton BUTTON_FORKLIFT_FORWARD = new JoystickButton(DRIVER_JOYSTICK_R, 5);
    
    //Left Joystick Buttons
    public static final JoystickButton BUTTON_ROLLER_MOTOR_IN = new JoystickButton(DRIVER_JOYSTICK_L, 1);
    public static final JoystickButton BUTTON_ROLLER_IN = new JoystickButton(DRIVER_JOYSTICK_L, 2);
    public static final JoystickButton BUTTON_ROLLER_OUT = new JoystickButton(DRIVER_JOYSTICK_L, 3);
    public static final JoystickButton BUTTON_ROLLER_SPIN_LEFT = new JoystickButton(DRIVER_JOYSTICK_L, 4);
    public static final JoystickButton BUTTON_ROLLER_SPIN_RIGHT = new JoystickButton(DRIVER_JOYSTICK_L, 5);
    public static final JoystickButton BUTTON_ROLLER_MOTOR_OUT = new JoystickButton(DRIVER_JOYSTICK_L, 6);
    
    //public static final JoystickButton BUTTON_ROLLER_IN = new JoystickButton(DRIVER_JOYSTICK, 7);
    //public static final JoystickButton BUTTON_ROLLER_OUT = new JoystickButton(DRIVER_JOYSTICK, 6);
    //public static final JoystickButton BUTTON_ROLLER_MOTOR_IN = new JoystickButton(DRIVER_JOYSTICK, 5);
    //public static final JoystickButton BUTTON_ROLLER_MOTOR_OUT = new JoystickButton(DRIVER_JOYSTICK, 4);
    //public static final JoystickButton BUTTON_FORKLIFT_UP = new JoystickButton(DRIVER_JOYSTICK, 3);
    //public static final JoystickButton BUTTON_FORKLIFT_DOWN = new JoystickButton(DRIVER_JOYSTICK, 2);
    //public static final JoystickButton BUTTON_SHIFT_GEAR = new JoystickButton(DRIVER_JOYSTICK, 1);
    //public static final JoystickButton BUTTON_FORKLIFT_BACK = new JoystickButton(DRIVER_JOYSTICK, 8);
    //public static final JoystickButton BUTTON_FORKLIFT_FORWARD = new JoystickButton(DRIVER_JOYSTICK, 9);
    //public static final JoystickButton BUTTON_ROLLER_SPIN_RIGHT = new JoystickButton(DRIVER_JOYSTICK, 11);
    //public static final JoystickButton BUTTON_ROLLER_SPIN_LEFT = new JoystickButton(DRIVER_JOYSTICK, 10);
    
    
    /*
     * Camera
     */   
    public static final String CAM_ID = "cam1";
    public static int camCounter = 0;
    public static final int IMAGE_QUALITY = 100;
    public static final int SAVE_IMAGE_QUALITY = 100;
    public static final String IMAGE_PATH = "/images/test.jpg";
    public static final int DISTANCE_CHANNEL = 0;
    public static final int CAMERA_SESSION = NIVision.IMAQdxOpenCamera("cam0", NIVision.IMAQdxCameraControlMode.CameraControlModeController); 
    //this may need to change to "cam1" depending if using test board or multiple cameras
    public static final Image FRAME = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);

    
   /*
    * Unknown
    */
   //public static final int COMPRESSOR_RELAY = 5;

   //public static final int DIG_IN_CHNNEL1 = 1;
    //public static final int DIG_IN_CHANNEL2 = 2;
    
}



