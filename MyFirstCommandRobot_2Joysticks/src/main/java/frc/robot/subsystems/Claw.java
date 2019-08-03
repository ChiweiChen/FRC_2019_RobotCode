/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Claw extends Subsystem {
  
  private WPI_TalonSRX clawLeft;
  private WPI_TalonSRX clawRight;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public Claw(){
    clawLeft = new WPI_TalonSRX(RobotMap.CLAW_LEFT_PORT);
    clawRight = new WPI_TalonSRX(RobotMap.CLAW_RIGHT_PORT);
    //clawLeft.setNeutralMode(NeutralMode.Brake);
    //clawRight.setNeutralMode(NeutralMode.Brake);
  }

  public void intake(){
    clawLeft.set(0.35);
    clawRight.set(0.35);
  }

  public void outtake(){
    clawLeft.set(-0.35);
    clawRight.set(-0.35);
  }

  public void stop(){
    clawLeft.stopMotor();
    clawRight.stopMotor();
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
