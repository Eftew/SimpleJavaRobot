// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

// WPILib libraries
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// Vendor libraries
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

// User code
import static frc.robot.Constants.DeviceID;

public class Shooter extends SubsystemBase {
  // Shooter motor
  WPI_TalonSRX shooter = new WPI_TalonSRX(DeviceID.SHOOTER_CAN);

  // Class constructor
  public Shooter() {}

  // User methods
  public void shoot(double speed) {
    shooter.set(speed);
  }

  public void reset() {
    shooter.set(0);
  }

  // Scheduler method
  @Override
  public void periodic() {}
}
