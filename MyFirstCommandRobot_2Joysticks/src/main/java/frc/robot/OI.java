/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;
import frc.robot.subsystems.Lift;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
  Joystick drivingStick = new Joystick(RobotMap.DRIVER_PORT);
  Joystick operatorStick = new Joystick(RobotMap.OPERATOR_PORT);
  //Joystick drivingStick;
  Button button1=new JoystickButton(drivingStick, 1);
  Button button2=new JoystickButton(drivingStick, 2);
  Button buttonEleUp=new JoystickButton(operatorStick, 1);
  Button buttonEleDown=new JoystickButton(operatorStick, 2);
  Button buttonEleStop=new JoystickButton(operatorStick, 3);
  Button buttonIntake=new JoystickButton(operatorStick, 7);
  Button buttonOuttake=new JoystickButton(operatorStick, 8);
  Button buttonPD=new JoystickButton(operatorStick, 6);
  //Button buttonPM=new JoystickButton(operatorStick, 7);
  Button buttonClawStop = new JoystickButton(operatorStick, 4);
  Button buttonPU=new JoystickButton(operatorStick, 5);
  public OI(){
    drivingStick=new Joystick(0);
    operatorStick=new Joystick(1);
    button1.whenPressed(new DriveForwardByTime(2000));
    button2.whenPressed(new DriveStop());
    buttonEleUp.whenPressed(new LiftToSetPoint(Lift.SECOND_GOAL_POS));
    buttonEleDown.whenPressed(new LiftToSetPoint(Lift.FIRST_GOAL_POS));
    buttonEleStop.whenPressed(new LiftHold());
    buttonIntake.whenPressed(new Intake());
    buttonOuttake.whenPressed(new Outtake());
    buttonClawStop.whenPressed(new ClawStop());
    //buttonPD.whenPressed(new PivotToGround());
    //buttonPM.whenPressed(new PivotToM());
    //buttonPU.whenPressed(new PivotUp());
  }
  public double getDrivingStickY(){
    return drivingStick.getY();
  }
  public double getDrivingStickX(){
    return drivingStick.getX();
  }
}