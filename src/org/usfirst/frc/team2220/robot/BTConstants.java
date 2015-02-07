package org.usfirst.frc.team2220.robot;

import org.usfirst.frc.team2220.robot.autonomous.BTIAutonomousRoutine;
import org.usfirst.frc.team2220.robot.controller.BTIController;
import org.usfirst.frc.team2220.robot.controller.BTLogitechJoystick1;
import org.usfirst.frc.team2220.robot.drivetrain.BTIDrivetrain;
import org.usfirst.frc.team2220.robot.robottype.BTCompetitionRobot;

public class BTConstants
{
	
	public static final BTIAutonomousRoutine AUTON_ROUTINE = null;				// The current autonomous routine
	public static final BTIController CONTROLLER = new BTLogitechJoystick1(0);	// The current controller
	public static final BTIDrivetrain DRIVETRAIN = null;						// The current drivetrain
	
	
	// Competition robot electronics ports
	public static final int COMPETITION_FRONT_LEFT_MOTOR = 5;
	public static final int COMPETITION_BACK_LEFT_MOTOR = 1;
	public static final int COMPETITION_FRONT_RIGHT_MOTOR = 7;
	public static final int COMPETITION_BACK_RIGHT_MOTOR = 3;
	public static final int COMPETITION_TOTE_MOTOR = -1;
	public static final int COMPETITION_BARREL_MOTOR = -1;
	public static final int COMPETITION_COLLECTOR_MOTOR_LEFT = -1;
	public static final int COMPETITION_COLLECTOR_MOTOR_RIGHT = -1;
	
	public static final int COMPETITION_TOTE_SWITCH = -1;
	public static final int COMPETITION_LOW_SWITCH = -1;
	public static final int COMPETITION_MIDDLE_SWITCH = -1;
	public static final int COMPETITION_UPPER_SWITCH = -1;
	public static final int COMPETITION_LIMIT_SWITCH = 0;
	
	public static final int COMPETITION_FRONT_RIGHT_ENCODER_A = 1;
	public static final int COMPETITION_FRONT_RIGHT_ENCODER_B = 2;
	public static final int COMPETITION_FRONT_LEFT_ENCODER_A = 3;
	public static final int COMPETITION_FRONT_LEFT_ENCODER_B = 4;
	public static final int COMPETITION_BACK_RIGHT_ENCODER_A = 7;
	public static final int COMPETITION_BACK_RIGHT_ENCODER_B = 8;
	public static final int COMPETITION_BACK_LEFT_ENCODER_A = 5;
	public static final int COMPETITION_BACK_LEFT_ENCODER_B = 6;
	
	public static final int COMPETITION_TOTE_HOLDER_EXTEND = -1;
	public static final int COMPETITION_TOTE_HOLDER_RETRACT = -1;
	public static final int COMPETITION_TOTE_COLLECTOR_EXTEND = -1;
	public static final int COMPETITION_TOTE_COLLECTOR_RETRACT = -1;
	public static final int COMPETITION_BARREL_HOLDER_EXTEND = -1;
	public static final int COMPETITION_BARREL_HOLDER_RETRACT = -1;
	
	// Drivetrain Constants
	public static final double MECANUM_DEADZONE = 0.05;
	public static final double MECANUM_SCALE_VALUE = 0.9;
	public static final double TOP_THROTTLE_MIN = 0.5;
	
	// Manipulator Constants
	public static final int MAX_TOTE_COUNT = 6;
	public static final int EMERGENCY_STOP_TIME = 3000;
	public static final double TOTE_MOTOR_POWER = 0.9;
	public static final double COLLECTOR_MOTOR_POWER = 0.9;
	
	// Electronics Constants
	public static final double KP = 0.03;
	
	// Autonomous Constants
	public static final int ACTIVE_AUTONOMOUS = 1;
	public static final String AUTONOMOUS_METHOD_KEY = "AutonomousMethodKey";
	public static final String AUTONOMOUS_STAGE_KEY = "AutonomousStageKey";
	public static final int MOVE_BACK_TIME_SHORT = 1000;
	public static final int MOVE_BACK_TIME_LONG = 3000;
	public static final int MOVE_FORWARD_TIME_SHORT = 1000;
	public static final int STRAFE_RIGHT_TIME = 4000;
	public static final double FORWARD_SPEED = 0.3;
	public static final double STRAFE_SPEED = 0.3;
//	public static final int COLLECT_TIME = 1000;
	
	// Reverses selected motors
	public static final boolean FRONT_LEFT_REVERSED = false;
	public static final boolean BACK_LEFT_REVERSED = true;
	public static final boolean FRONT_RIGHT_REVERSED = false;
	public static final boolean BACK_RIGHT_REVERSED = true;
	public static final boolean FORK_REVERSED = false;
	public static final boolean COLLECTORS_REVERSED = false;
	
}
