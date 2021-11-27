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

public class Sucker extends SubsystemBase {
  // Sucker motor
  WPI_TalonSRX sucker = new WPI_TalonSRX(DeviceID.SUCKER_CAN);

  // Class constructor
  public Sucker() {}
  
  // User methods
  public void suck(double speed) {
    sucker.set(speed);
  }

  public void release() {
    sucker.set(0);
  }

  // Scheduler method
  @Override
  public void periodic() {}
}
