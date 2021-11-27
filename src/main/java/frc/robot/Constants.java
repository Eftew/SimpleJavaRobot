// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final class DeviceID {
    public static final int RIGHT_MASTER_CAN = 0;
    public static final int RIGHT_FOLLOW_CAN = 1;
    public static final int LEFT_MASTER_CAN = 2;
    public static final int LEFT_FOLLOW_CAN = 3;
    public static final int SUCKER_CAN = 4;
    public static final int SHOOTER_CAN = 5;
    public static final int DRIVE_STICK_PORT = 0;
  }

  public static final class Speed {
    public static final double DRIVE_SPEED = 1.25;
    public static final double SUCK_SPEED = 0.8;
    public static final double SHOOT_SPEED = 2;
  }

  public static final class Button {
    public static final int DRIVE_STRAIGHT = 8;
    public static final int SUCK = 9;
    public static final int SHOOT = 10;
  }

  public static final class Axes {
    public static final int AXIS_X = 0;
    public static final int AXIS_Y = 1;
  }
}
