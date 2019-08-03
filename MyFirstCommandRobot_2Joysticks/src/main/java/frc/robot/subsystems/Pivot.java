package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap; 
import frc.robot.commands.PivotHold;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX; 
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Pivot extends Subsystem {

  private WPI_TalonSRX pivot; 
	private double goalPivotPosition;

	public static final double PIVOT_DOWN_INCREMENT = 125;
	public static final double PIVOT_UP_INCREMENT = 200;
	public static final double PIVOT_GROUND = -3875;
	public static final double PIVOT_UP = -1371;
	public static final double PIVOT_M = 3000;
	public static final double PIVOT_TOLERANCE = 100;//all not sure

	public static enum PivotDirection {
		Up, Down
	};
  
  public Pivot() {
		pivot = new WPI_TalonSRX(RobotMap.PIVOT_TALON);
		pivot.setSensorPhase(true);
		setupPivotFPID();
		LiveWindow.add(pivot);
	}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new PivotHold());
  }

  // Put methods for controlling this subsystem
  // here. Call these from Commands.

	public void setupPivotFPID() {
		pivot.config_kF(0, 0, 10);
		pivot.config_kP(0, 0.1, 10);
		pivot.config_kI(0, 0, 10);
		pivot.config_kD(0, 0.1, 10);	
  }

  public void setPivotPosition(double pos){
    pivot.set(ControlMode.Position, pos); 
  }

  public void holdPivotPosition(){
		pivot.set(ControlMode.Position, goalPivotPosition);
  }

  public void pivotToGround(){
		pivot.set(ControlMode.Position, PIVOT_GROUND); 
  }

  public void pivotToRocket(){
		pivot.set(ControlMode.Position, PIVOT_UP); 
	}
	
	public void pivotToM(){
		pivot.set(ControlMode.Position, PIVOT_M); 
  }
	
	public void setGoalPivotPosition(double goal) {
		goalPivotPosition = goal;
	}
	
	public double getPivotPosition() {
		return pivot.getSelectedSensorPosition(0);
	}

	public void incrementPivot () {
		goalPivotPosition = getPivotPosition(); 
		goalPivotPosition += PIVOT_UP_INCREMENT;
	}

	public void decrementPivot () {
		goalPivotPosition = getPivotPosition(); 
		goalPivotPosition -= PIVOT_DOWN_INCREMENT;
	}

	public boolean checkCurrentPivotPosition(double goalPos) {
		boolean isFinished = (goalPos <= getPivotPosition() + PIVOT_TOLERANCE 
    && goalPos  >= getPivotPosition() - PIVOT_TOLERANCE);
    //System.out.println("isFinished: " + isFinished);
    return isFinished;
	}

	public void pivotStop(){
		pivot.stopMotor(); 
	}	
}