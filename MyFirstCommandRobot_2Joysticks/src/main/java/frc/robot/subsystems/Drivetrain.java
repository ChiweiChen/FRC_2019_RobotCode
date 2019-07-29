package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.DriveByJoystick;

public class Drivetrain extends Subsystem{
    private CANSparkMax masterLeft;
    private CANSparkMax followerLeft;
    private CANSparkMax masterRight;
    private CANSparkMax followerRight;
    private DifferentialDrive drive;

    public Drivetrain(){
        masterLeft=new CANSparkMax(RobotMap.DRIVE_MASTER_LEFT_PORT, MotorType.kBrushless);
        followerLeft=new CANSparkMax(RobotMap.DRIVE_FOLLOWER_LEFT_PORT, MotorType.kBrushless);
        masterRight=new CANSparkMax(RobotMap.DRIVE_MASTER_RIGHT_PORT, MotorType.kBrushless);
        followerRight=new CANSparkMax(RobotMap.DRIVE_FOLLOWER_RIGHT_PORT, MotorType.kBrushless);
        followerLeft.follow(masterLeft);
        followerRight.follow(masterRight);
        masterLeft.setIdleMode(IdleMode.kCoast);
        followerLeft.setIdleMode(IdleMode.kCoast);
        masterRight.setIdleMode(IdleMode.kCoast);
        followerRight.setIdleMode(IdleMode.kCoast);
        drive = new DifferentialDrive(masterLeft, masterRight);
        drive.setSafetyEnabled(true);
        drive.setExpiration(0.1);
        drive.setMaxOutput(0.2);
    }
    public void driveByJoystick(double yDir,double xDir){
        SmartDashboard.putString("driveByJoystick?", yDir+","+xDir);
        drive.arcadeDrive(yDir, xDir);
    }
    public void stop(){
        drive.stopMotor();
    }
    public void forward(){
        masterLeft.set(0.2);
        masterRight.set(-0.2);
    }
    public void backward(){
        masterLeft.set(-0.2);
        masterRight.set(0.2);
    }
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DriveByJoystick());
    }
}