package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.RobotMap;
import org.usfirst.frc.team2035.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2035.robot.subsystems.Rollers;

import edu.wpi.first.wpilibj.Timer;


public class Autonomous2 extends CommandBase {
	
	private final DriveTrain DRIVE;
	private final Rollers ROLLER;
	private Timer autonomousTimer;
	private Vision2 vision;
	private ImageProcess process;

	
	public Autonomous2(){
		super("drive");
		DRIVE = Robot.getDriveTrain();
		ROLLER = Robot.getRollers();
		vision = new Vision2();
		process = new ImageProcess();
	}
	
	
	public void initialize() {
		autonomousTimer = new Timer();
		vision.visionInit();
		process.initProcessImage();
		process.setTote(false);
		autonomousTimer.start();
	}
	
	public void execute() 
	{
		
		ROLLER.rollerOut();
		
		while(autonomousTimer.get() < 5.0)
		{
			DRIVE.drive(-RobotMap.AUTONOMOUS_SPEED);
			
		}
		while(autonomousTimer.get() > 5.0 && autonomousTimer.get() < 5.5)
		{
			DRIVE.drive(RobotMap.AUTONOMOUS_SPEED);
		}
		while(autonomousTimer.get() > 5.5 && autonomousTimer.get() < 14.5)
		{
		DRIVE.drive(0);
		}
		
	}
	
	public boolean isFinished() {
		if (autonomousTimer.get() > 15.0) {
            return true;
        }
        return false;
	}
	
	public void interrupted() 
	{
		DRIVE.drive(0.0);
	}
	public void end()
	{
		DRIVE.drive(0.0);
	}	
}
