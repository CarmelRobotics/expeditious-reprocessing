
package org.usfirst.frc.team2035.robot;

import edu.wpi.first.wpilibj.IterativeRobot;  
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
//import org.usfirst.frc.team2035.robot.commands.Autonomous;



import org.usfirst.frc.team2035.robot.commands.*;
import org.usfirst.frc.team2035.robot.subsystems.*;

import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

/**
 * ORDER OF EXECUTION:
 * robotInit() - called once after the boot up of the roboRIO.
 * disabledInit() - called once, every time the robot is placed in disabled mode.
 * disabledPeriodic() - called multiple times each second, during which the robot is in disabled mode.
 * autonomousInit() - called once, every time the robot is placed in autonomous mode.
 * autonomousPeriodic() - called multiple times each second, during which the robot is autonomously controlled.
 * telopInit() - called once, every time the robot is placed in tele-operated mode.
 * teleopPeriodic() - called multiple times each second, during which the robot is user controlled.
 * 
 * On the competition field, the order of modes is:
 * disabled (while the field is getting ready)
 * autonomous (15 seconds duration)
 * disabled (briefly)
 * teleop (2 minute duration)
 * disabled (until the robot is powered off)
 */
public class Robot extends IterativeRobot{

	public static OI oi;
	private final double K_UPDATE_PERIOD = 0.005; // update every 0.005 seconds/5 milliseconds (200Hz)
	private static DriveTrain driver;
	private static Forklift fork;
	private static Rollers roller;

	//private static ProcessImage imageProcess;
	private static Compressor compressor;
	private static Vision grabImage;
//	private Autonomous autonomous;

    Command autonomousCommand;
    
    public Robot()
    {
    	driver = new DriveTrain();
    	//imageProcess = new ProcessImage();
        grabImage = new Vision();
    	
    }

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        // instantiate the command used for the autonomous period
        //autonomousCommand = new ExampleCommand();
        
        grabImage.visionInit();
        //imageProcess.initProcessImage();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        System.out.println("Auton Loop is running");
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        driver.arcadeDrive();
        
        grabImage.saveImage();
        //Timer.delay(K_UPDATE_PERIOD);
        //imageProcess.processImage();
        
    	System.out.println("Teleop Loop is running");
    	//Timer.delay(K_UPDATE_PERIOD);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    public static DriveTrain getDriveTrain() {
    	return driver;
    }
    
    public static Forklift getForklift() {
    	return fork;
    }
    
    public static Rollers getRollers()
    {
    	return roller;
    }
    //public static ProcessImage  getVision()
    //{
    	//return imageProcess;
    //}    
    
 }

