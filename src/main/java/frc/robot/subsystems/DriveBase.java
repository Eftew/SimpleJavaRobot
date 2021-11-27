// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

// WPILib libraries
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Joystick;

// Vendor libraries
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.NeutralMode;

// User code
import static frc.robot.Constants.DeviceID;
import static frc.robot.Constants.Speed;
import static frc.robot.Constants.Axes;

public class DriveBase extends SubsystemBase {
  // Driving motors
  private WPI_TalonSRX rightMaster = new WPI_TalonSRX(DeviceID.RIGHT_MASTER_CAN);
  private WPI_TalonSRX rightFollow = new WPI_TalonSRX(DeviceID.RIGHT_FOLLOW_CAN);
  private WPI_TalonSRX leftMaster = new WPI_TalonSRX(DeviceID.LEFT_MASTER_CAN);
  private WPI_TalonSRX leftFollow = new WPI_TalonSRX(DeviceID.LEFT_FOLLOW_CAN);

  // Joysticks
  private Joystick driveStick = new Joystick(DeviceID.DRIVE_STICK_PORT);

  // Class constructor
  public DriveBase() {
    // Set master-follower relations
    rightFollow.follow(rightMaster);
    leftFollow.follow(leftMaster);

    // Set neutral mode to reduce motion
    rightMaster.setNeutralMode(NeutralMode.Brake);
    rightFollow.setNeutralMode(NeutralMode.Brake);
    leftMaster.setNeutralMode(NeutralMode.Brake);
    leftFollow.setNeutralMode(NeutralMode.Brake);

    // Invert left motor row to synchronize controls
    leftMaster.setInverted(true);
    leftFollow.setInverted(true);
  }

  // User methods
  public void drive(double left, double right) {
    rightMaster.set(right);
    leftMaster.set(left);
  }

  public void stop() {
    rightMaster.set(0);
    leftMaster.set(0);
  }

  // Scheduler method
  @Override
  public void periodic() {
    drive(driveStick.getRawAxis(Axes.AXIS_X) * Speed.DRIVE_SPEED, driveStick.getRawAxis(Axes.AXIS_Y) * Speed.DRIVE_SPEED);
  }
}
