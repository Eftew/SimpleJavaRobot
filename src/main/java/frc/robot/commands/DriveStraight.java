// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

// WPILib libraries
import edu.wpi.first.wpilibj2.command.CommandBase;

// Subsystems
import frc.robot.subsystems.DriveBase;

public class DriveStraight extends CommandBase {
  // Command variables
  private DriveBase m_driveBase;
  private double m_speed;

  /** Creates a new DriveStraight. */
  public DriveStraight(DriveBase driveBase, double speed) {
    m_driveBase = driveBase;
    m_speed = speed;
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveBase);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_driveBase.drive(m_speed, m_speed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_driveBase.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
