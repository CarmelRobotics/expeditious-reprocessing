package org.usfirst.frc.team2035.robot.subsystems;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.vision.*;


public class CameraFeeds {

	protected int camera;
	protected Image frame;
	protected CameraServer server;
	//protected USBCamera cam;
	
	public CameraFeeds()
	{
        //camera = NIVision.IMAQdxOpenCamera("cam1", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        //cam = new USBCamera("cam1");
        frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
        server = CameraServer.getInstance();
        server.setQuality(60);
        server.startAutomaticCapture("cam1");
        
	}
	
	public void init()
	{
		//NIVision.IMAQdxConfigureGrab(camera);
		//NIVision.IMAQdxStartAcquisition(camera);
		//cam.startCapture();
	}
	
	public void run()
	{
		//NIVision.IMAQdxGrab(camera, frame, 1);
		
		server.setImage(frame);
	}
	
	public void liveStream()
	{
		//NIVision.IMAQdxStopAcquisition(camera);
		//cam.stopCapture();
		//server.startAutomaticCapture("cam1");
		
	}
	
	/**
	 * Stop aka close camera stream
	 */
	public void end()
	{
		//NIVision.IMAQdxStopAcquisition(camera);

	}
	
	public void setFrame(Image image)
	{
		frame = image;
	}
	
	public Image getFrame()
	{
		return frame;
	}
}
