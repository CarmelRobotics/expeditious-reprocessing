package org.usfirst.frc.team2035.robot.subsystems;

import org.usfirst.frc.team2035.robot.RobotMap; 

import edu.wpi.first.wpilibj.Compressor;

public class CompressorA extends ExpeditiousSubsystem {
	
	private static Compressor compress;

	public CompressorA() {
		super("Compressor");
		compress = new Compressor(RobotMap.PCM_ID);
		
		// TODO auto-generated method stub
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}
	
	public void start() {
		compress.start();
	}
	
	public void checkPressure()
	{
		if(!compress.getPressureSwitchValue())
        {
        	if(compress.enabled())
        	{
        		compress.stop();
        	}
        }
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}
