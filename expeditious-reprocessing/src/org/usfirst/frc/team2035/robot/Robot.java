package org.usfirst.frc.team2035.robot;

import org.usfirst.frc.team2035.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2035.robot.subsystems.Forklift;
import org.usfirst.frc.team2035.robot.subsystems.Rollers;
import org.usfirst.frc.team2035.robot.subsystems.Vision;
import org.usfirst.frc.team2035.robot.subsystems.MaxbotixUltrasonic;

import edu.wpi.first.wpilibj.IterativeRobot;  
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import org.usfirst.frc.team2035.robot.commands.WinAutonomous;





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

	private final double K_UPDATE_PERIOD = 0.005; // update every 0.005 seconds/5 milliseconds (200Hz)
	private static DriveTrain driver;
	private static Forklift fork;
	private static Rollers roller;
	private static MaxbotixUltrasonic sonar;
	private static Vision grabImage;

	private static CompressorA compressor;
	private WinAutonomous winAutonomous;	
    Command autonomousCommand;;
    
    public Robot()
    {
    	driver = new DriveTrain();
    }

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		OI oi = new OI();
		winAutonomous = new WinAutonomous();
		winAutonomous.initialize();
        // instantiate the command used for the autonomous period
        //autonomousCommand = new ExampleCommand();
		compressor = new CompressorA();
		fork = new Forklift();
		roller = new Rollers();
		sonar = new MaxbotixUltrasonic(0);
		grabImage = new Vision();
		OI.initialize();
		driver.shiftHighGear();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		
	}

    public void autonomousInit() {
        //schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
        winAutonomous.execute();
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
        driver.shiftHighGear();
        grabImage.init();
        //oi.initialize();
          
        
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	
    	grabImage.end();
    	
    	
    }

    /**
     * This function is called periodically during operator control
     */
    
    
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        driver.arcadeDrive();
        
        //Timer.delay(K_UPDATE_PERIOD);
    	System.out.println("Teleop Loop is running");
        	grabImage.sendImage();
        Timer.delay(K_UPDATE_PERIOD);
        
        compressor.start();
        
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
    public static MaxbotixUltrasonic getMaxbotixUltrasonic()
    {
    	return sonar;
    }
    
 }

