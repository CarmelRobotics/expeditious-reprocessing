package org.usfirst.frc.team2035.robot;

import org.usfirst.frc.team2035.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2035.robot.subsystems.Forklift;
import org.usfirst.frc.team2035.robot.subsystems.Rollers;
import org.usfirst.frc.team2035.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.IterativeRobot; 
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.CameraServer;
import org.usfirst.frc.team2035.robot.commands.Autonomous;



import org.usfirst.frc.team2035.robot.subsystems.*;

import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	private final double K_UPDATE_PERIOD = 0.005; // update every 0.005 seconds/5 milliseconds (200Hz)
	private static DriveTrain driver;
	private static Forklift fork;
	private static Rollers roller;
	private static CompressorA compressor;
	
	private static Vision grabImage;
	private Autonomous autonomous;
    private Command autonomousCommand;
    
    //public Robot()
    //{
    //	super();
    //}

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
        //autonomousCommand = new ExampleCommand();
		grabImage = new Vision();
		driver = new DriveTrain();
		compressor = new CompressorA();
		fork = new Forklift();
		roller = new Rollers();
		OI.initialize();
		
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		
	}

    public void autonomousInit() {
        //schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        System.out.println("Auton Loop Running");
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        
        //grabImage.init();
        RobotMap.camCounter = 0;
        //oi.initialize();
          
        
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	
    	//grabImage.end();
    	
    	
    }

    /**
     * This function is called periodically during operator control
     */
    
    
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        driver.arcadeDrive();
        
        
        //if(RobotMap.camCounter % 100 == 0)
        //{	
        	//grabImage.save();
        	//System.out.println("Saving image");
        //}
        //RobotMap.camCounter++;
        
    	System.out.println("Teleop Loop is running");
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
    
    
 }

