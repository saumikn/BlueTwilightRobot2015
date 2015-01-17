package org.usfirst.frc.team2220.robot;

import org.usfirst.frc.team2220.robot.autonomous.BTIAutonomousRoutine;
import org.usfirst.frc.team2220.robot.controller.BTFlightstick;
import org.usfirst.frc.team2220.robot.controller.BTIController;
import org.usfirst.frc.team2220.robot.drivetrain.BTIDrivetrain;

import edu.wpi.first.wpilibj.RobotDrive.MotorType;

// Just an idea, feel free to change it around
public class BTConstants
{
	// The current autonomous routine
	public static final BTIAutonomousRoutine AUTON_ROUTINE = null;
	
	// The current controller
	public static final BTIController CONTROLLER = new BTFlightstick(0);
	
	// The current drivetrain
	public static final BTIDrivetrain DRIVETRAIN = null;
	
	public static final int MEC_FRONT_LEFT = 0;
	public static final int MEC_BACK_LEFT = 1;
	public static final int MEC_FRONT_RIGHT = 2;
	public static final int MEC_BACK_RIGHT = 3;
	
	public static final double TANK_DEADZONE = 0.05;
	public static final double MECANUM_DEADZONE = 0.05;
	public static final double FPS_DEADZONE = 0.05;
	
	public static final double TANK_SCALE_VALUE = 1;
	public static final double MECANUM_SCALE_VALUE = 1;
	public static final double FPS_SCALE_VALUE = 1;
	
	
	public static final MotorType[] MOTOR_TYPES = { MotorType.kFrontLeft, MotorType.kRearLeft, MotorType.kFrontRight, MotorType.kRearRight };
	
	public static final MotorType[] REVERSED_MOTORS_TANK = { };
	
	public static final MotorType[] REVERSED_MOTORS_MECANUM = { MotorType.kRearRight, MotorType.kRearLeft };

}
