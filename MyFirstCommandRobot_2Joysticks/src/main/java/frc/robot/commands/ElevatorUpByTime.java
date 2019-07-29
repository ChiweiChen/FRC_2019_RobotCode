/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
public class ElevatorUpByTime extends Command {
  long startTime;
  int timeInMs;
  long runTime;
  public ElevatorUpByTime(int timeInMs) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.lift);
    this.timeInMs=timeInMs;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    startTime=System.currentTimeMillis();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    runTime=System.currentTimeMillis()-startTime;
    Robot.drivetrain.forward();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(runTime>timeInMs){
      Robot.drivetrain.stop();
      return true;
    }
    else
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.lift.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
