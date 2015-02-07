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
import org.usfirst.frc.team2035.robot.RobotMap;

/**
 * This is a demo program showing the use of the NIVision class to do vision processing. 
 * The image is acquired from the USB Webcam, then a circle is overlayed on it. 
 * The NIVision class supplies dozens of methods for different types of processing. 
 * The resulting image can then be sent to the FRC PC Dashboard with setImage()
 */
public class Vision extends ExpeditiousSubsystem {
    private int camera;
    private Image frame;
    private NIVision.RawData colorTable;
    private CameraServer server;

    public Vision()
    {
    	super("Vision");
    }
    public void init()
    {
        frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);

        // the camera name (ex "cam0") can be found through the roborio web interface
        camera = NIVision.IMAQdxOpenCamera(RobotMap.CAM_ID,
        		NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        NIVision.IMAQdxConfigureGrab(camera);
        
        colorTable = new NIVision.RawData();
        
        server = CameraServer.getInstance();
        
        
    }

    public void save() {
        NIVision.IMAQdxStartAcquisition(camera);

        /**
         * grab an image, draw the circle, and provide it for the camera server
         * which will in turn send it to the dashboard.
         */
        NIVision.Rect rect = new NIVision.Rect(10, 10, 100, 100);

        //loops in autonomous

            NIVision.IMAQdxGrab(camera, frame, 1);
            NIVision.imaqWriteJPEGFile(frame, RobotMap.IMAGE_PATH, 200, colorTable);
            NIVision.imaqDrawShapeOnImage(frame, frame, rect,
                    DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);
            
            server.setImage(frame);

            /** robot code here! **/
            Timer.delay(0.005);		// wait for a motor update time
            
            //NIVision.IMAQdxStopAcquisition(session);
        
    }

    public void test() {
    }
    
    public void end() {
    	NIVision.IMAQdxStopAcquisition(camera);
    }
    
    protected void initDefaultCommand() {
    
    }
    
    
}
