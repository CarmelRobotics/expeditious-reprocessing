package org.usfirst.frc.team2035.robot.subsystems;

import com.ni.vision.NIVision; 
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;
import com.ni.vision.NIVision.RawData;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This is a demo program showing the use of the NIVision class to do vision processing. 
 * The image is acquired from the USB Webcam, then a circle is overlayed on it. 
 * The NIVision class supplies dozens of methods for different types of processing. 
 * The resulting image can then be sent to the FRC PC Dashboard with setImage()
 */
public class Vision extends Subsystem {
    int session;
    Image frame;
    NIVision.RawData colorTable;
    CameraServer server;

    public void visionInit()
    {
        frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);

        // the camera name (ex "cam0") can be found through the roborio web interface
        session = NIVision.IMAQdxOpenCamera("cam1",
                NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        NIVision.IMAQdxConfigureGrab(session);
        
        colorTable = new NIVision.RawData();
    }

    public void saveImage() {
        NIVision.IMAQdxStartAcquisition(session);

        /**
         * grab an image, draw the circle, and provide it for the camera server
         * which will in turn send it to the dashboard.
         */
        NIVision.Rect rect = new NIVision.Rect(10, 10, 100, 100);

        //loops in autonomous

            NIVision.IMAQdxGrab(session, frame, 1);
            NIVision.imaqWriteJPEGFile(frame, "/images/test.jpg", 200, colorTable);
            NIVision.imaqDrawShapeOnImage(frame, frame, rect,
                    DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);
            
            CameraServer.getInstance().setImage(frame);

            /** robot code here! **/
            Timer.delay(0.005);		// wait for a motor update time
        
        NIVision.IMAQdxStopAcquisition(session);
    }

    public void test() {
    }

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
