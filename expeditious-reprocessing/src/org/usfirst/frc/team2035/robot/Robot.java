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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2035.robot.commands.Autonomous2;





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
	
	private static SmartDashboard dash;

	private static CompressorA compressor;
	private static WinAutonomous winAutonomous;	
	private static Autonomous2 auto2;
    Command autonomousCommand;
    
    public Robot()
    {
    	driver = new DriveTrain();
    	fork = new Forklift();
		roller = new Rollers();
		sonar = new MaxbotixUltrasonic(0);
		winAutonomous = new WinAutonomous();
		compressor = new CompressorA();
		grabImage = new Vision();
		auto2 = new Autonomous2();
		dash = new SmartDashboard();
    }

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		OI oi = new OI();
		//winAutonomous.initialize();
        // instantiate the command used for the autonomous period
        //autonomousCommand = new ExampleCommand();
		OI.initialize();
		driver.shiftLowGear();
		
		//auto2.initialize();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		
	}

    public void autonomousInit() {

    	//winAutonomous.initialize();
    	//auto2.initialize(); !! We want this later as code proper!!
    	//schedule the autonomous command (example)
    	
    	//If button is pressed, run vision autonomous.  If not, run simple autonomous.
    	/*
    	if(dash.getBoolean("DB/Button 0") == true)
    	{
    		dash.putString("DB/String 0", "Running Vision Autonomous");
    		if (winAutonomous != null) winAutonomous.start();
    		winAutonomous.execute();
    		
    	}
    	else
    	{
    		dash.putString("DB/String 0", "Running Simple Autonomous");
    		if(auto2 != null) auto2.start();
    		auto2.execute();
    		
    	}
    	*/
    	//if(auto2 != null) auto2.start(); !!We want this later as code proper!!
		//auto2.execute();
    	
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        //Scheduler.getInstance().run(); !!We want this later as code proper!!
        //System.out.println("Auton Loop is running"); !!We want this later as code proper!!
        
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
    	System.out.println("first teleop init");
        //if (winAutonomous != null) winAutonomous.cancel();
        if(auto2 != null) auto2.cancel();
        driver.shiftLowGear();
        grabImage.init();
        fork.retractForklift();
        System.out.println("teleop init");
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
        System.out.println("Teleop running");
        if(fork.getLimit().get() == true)
        {
        	dash.putString("DB/String 1", "True");
        }
        else if(fork.getLimit().get() == false)
        {
        	dash.putString("DB/String 1", "False");
        }
        
        driver.arcadeDrive();
        //System.out.println(fork.getLimit().get());
        //Timer.delay(K_UPDATE_PERIOD);
    	//System.out.println("LIMIT SWITCH VALUE: " + fork.getLimit().get());
        	grabImage.sendImage();
        //Timer.delay(K_UPDATE_PERIOD);
        
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

