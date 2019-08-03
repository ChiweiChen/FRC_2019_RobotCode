/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.DriveHook;

/**
 * Add your docs here.
 */
public class Hook extends Subsystem {
  private WPI_TalonSRX hookMotor;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public Hook(){
    hookMotor=new WPI_TalonSRX(RobotMap.HOOK_TALON);
  }
  public void hookDrive(double yDir){
    yDir=yDir*0.1;
    hookMotor.set(yDir);
  }
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveHook());
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
