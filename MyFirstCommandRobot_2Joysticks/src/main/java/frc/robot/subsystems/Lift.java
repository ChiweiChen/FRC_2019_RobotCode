/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.util.WPILibVersion;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Lift extends Subsystem {
  private WPI_TalonSRX talon;
  public Lift(){
    talon=new WPI_TalonSRX(RobotMap.ELEVATOR_PORT);
    talon.setNeutralMode(NeutralMode.Brake);
  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public void up(){
    talon.set(0.1);
  }
  public void down(){
    talon.set(-0.1);
  }
  public void stop(){
    talon.set(0);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
