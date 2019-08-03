package frc.robot.subsystems;

import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Camera extends Subsystem {
  public static UsbCamera visionCam;
  int width=320;
  int height=240;
  int fps=10;
  CvSource processedStream;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public Camera(){
    visionCam=CameraServer.getInstance().startAutomaticCapture("Vision Camera",RobotMap.VISION_CAMERA);
    visionCam.setResolution(width,height);
    visionCam.setFPS(fps);
    visionCam.setExposureManual(24);

    processedStream=CameraServer.getInstance().putVideo("Processed",width,height);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}