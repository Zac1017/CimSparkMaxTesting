// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.RunMotor;
import frc.robot.subsystems.Motor;

public class RobotContainer {
  private final Motor motor = new Motor();
  private final CommandXboxController operatorController = new CommandXboxController(2);
  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    motor.setDefaultCommand(new RunMotor(motor, () -> operatorController.getLeftX()));
  }


}
