/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  public static final int DRIVER_PORT=0;
  public static final int OPERATOR_PORT=1;
  public static final int DRIVE_MASTER_LEFT_PORT=1;
  public static final int DRIVE_FOLLOWER_LEFT_PORT=2;
  public static final int DRIVE_MASTER_RIGHT_PORT=3;
  public static final int DRIVE_FOLLOWER_RIGHT_PORT=5;
  public static final int ELEVATOR_PORT=8;
  public static final int CLAW_LEFT_PORT=6;
  public static final int CLAW_RIGHT_PORT=7;
  public static final int PIVOT_TALON=10;
  public static final int HOOK_TALON=9;
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
