/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.WPILibVersion;
import frc.robot.RobotMap;
import frc.robot.commands.LiftHold;

/**
 * Add your docs here.
 */
public class Lift extends Subsystem {
  private WPI_TalonSRX talon;
  public static final double LIFT_TOLERANCE=20;//not sure
  public static final double FIRST_GOAL_POS=0.0;
  public static final double THIRD_GOAL_POS=2475.0;
  public static final double SECOND_GOAL_POS=3100.0;//not sure
  public static final double ALL_TO_ZERO=0.0;
  public static final int MAX_CRUISE_VELOCITY=500;//not sure
  public static final int MAX_ACCELERATION=800;//not sure

  public double goalPos;
  public Lift(){
    talon=new WPI_TalonSRX(RobotMap.ELEVATOR_PORT);
    talon.setInverted(true);
    talon.setSensorPhase(true);
    talon.config_kF(0,0.20,10);//n s
    talon.config_kP(0,0.15,10);//n s
    talon.config_kI(0,0,10);//n s
    talon.config_kD(0,0.10,10);//n s
    talon.configMotionAcceleration(MAX_ACCELERATION);
    talon.configMotionCruiseVelocity(MAX_CRUISE_VELOCITY);
    talon.setNeutralMode(NeutralMode.Brake);
  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public void up(){
    talon.set(0.8);
  }
  public void down(){
    talon.set(-0.5);
  }
  public void stop(){
    talon.set(0);
  }
  public int getPosition(){
    return talon.getSelectedSensorPosition(0);
  }
  public void setGoalLiftPos(double pos) {
    goalPos=pos;
  }
  public void liftStop(){
    goalPos=getPosition();
    holdLiftPosition();
  }
  public void holdLiftPosition(){
    talon.set(ControlMode.MotionMagic,goalPos);
    SmartDashboard.putNumber("lift velocity", talon.getSelectedSensorPosition());
  }
  public boolean checkCurrentPosition(double goalPos){
    boolean isFinished;
    isFinished = (goalPos + LIFT_TOLERANCE >= getPosition() && goalPos - LIFT_TOLERANCE <= getPosition());
    return isFinished;
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new LiftHold());
  }
}
