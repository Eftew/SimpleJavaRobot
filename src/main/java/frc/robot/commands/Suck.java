// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

// WPILib libraries
import edu.wpi.first.wpilibj2.command.CommandBase;

// Subsystems
import frc.robot.subsystems.Sucker;

public class Suck extends CommandBase {
  // Command variables
  private Sucker m_sucker;
  private double m_speed;

  /** Creates a new Suck. */
  public Suck(Sucker sucker, double speed) {
    m_sucker = sucker;
    m_speed = speed;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(sucker);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_sucker.suck(m_speed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_sucker.release();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
