package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.Pivot.PivotDirection;
import edu.wpi.first.wpilibj.command.Command;

public class PivotManual extends Command {

  private PivotDirection direction;

  public PivotManual(PivotDirection direction) {
    this.direction = direction;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.pivot);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (direction == PivotDirection.Up) {
      Robot.pivot.incrementPivot();
    } else {
      Robot.pivot.decrementPivot();
    }
    Robot.pivot.holdPivotPosition();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.pivot.pivotStop();
  }
}