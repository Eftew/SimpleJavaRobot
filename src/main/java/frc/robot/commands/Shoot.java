// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

// WPILib libraries
import edu.wpi.first.wpilibj2.command.CommandBase;

// Subsystems
import frc.robot.subsystems.Shooter;

public class Shoot extends CommandBase {
  // Command variables
  private Shooter m_shooter;
  private double m_speed;

  /** Creates a new Shoot. */
  public Shoot(Shooter shooter, double speed) {
    m_shooter = shooter;
    m_speed = speed;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_shooter.shoot(m_speed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_shooter.reset();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
