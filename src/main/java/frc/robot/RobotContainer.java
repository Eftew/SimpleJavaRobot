// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

// WPILib libraries
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
// Subsystems
import frc.robot.subsystems.*;

// Commands
import frc.robot.commands.*;

// User code
import static frc.robot.Constants.DeviceID;
import static frc.robot.Constants.Speed;
import static frc.robot.Constants.Button;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // Joysticks
  private static Joystick m_stick = new Joystick(DeviceID.DRIVE_STICK_PORT);

  // Subsystems
  private DriveBase m_driveBase = new DriveBase();
  private Sucker m_sucker = new Sucker();
  private Shooter m_shooter = new Shooter();

  // Commands
  private DriveStraight m_driveStraight = new DriveStraight(m_driveBase, Speed.DRIVE_SPEED);
  private Suck m_suck = new Suck(m_sucker, Speed.SUCK_SPEED);
  private Shoot m_shoot = new Shoot(m_shooter, Speed.SHOOT_SPEED);
  private Auto m_auto = new Auto(m_driveBase, m_sucker, m_shooter);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(m_stick, Button.DRIVE_STRAIGHT).whenActive(m_driveStraight);
    new JoystickButton(m_stick, Button.SUCK).whenActive(m_suck);
    new JoystickButton(m_stick, Button.SHOOT).whenActive(m_shoot);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return m_auto;
  }
}
