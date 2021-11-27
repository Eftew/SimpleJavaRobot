// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

// WPILib libraries
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// Subsystems
import frc.robot.subsystems.*;

// User code
import static frc.robot.Constants.Speed;
import static frc.robot.Constants.Time;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Auto extends SequentialCommandGroup {
  /** Creates a new Auto. */
  public Auto(DriveBase driveBase, Sucker sucker, Shooter shooter) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new Suck(sucker, Speed.SUCK_SPEED).withTimeout(Time.EXECUTION_PADDING), new DriveStraight(driveBase, Speed.DRIVE_SPEED).withTimeout(Time.EXECUTION_PADDING));
  }
}
