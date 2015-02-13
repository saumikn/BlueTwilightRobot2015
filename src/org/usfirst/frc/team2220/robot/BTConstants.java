package org.usfirst.frc.team2220.robot;

import org.usfirst.frc.team2220.robot.autonomous.BTIAutonomousRoutine;
import org.usfirst.frc.team2220.robot.controller.BTIController;
import org.usfirst.frc.team2220.robot.controller.BTLogitechJoystick1;
import org.usfirst.frc.team2220.robot.drivetrain.BTIDrivetrain;
import org.usfirst.frc.team2220.robot.robottype.BTCompetitionRobot;
import org.usfirst.frc.team2220.robot.robottype.BTIRobotType;

public class BTConstants
{
	
	public static final BTIAutonomousRoutine AUTON_ROUTINE = null;				// The current autonomous routine
	public static final BTIController CONTROLLER = new BTLogitechJoystick1(0);	// The current controller. Either use BTLogitechJoystick1 or BTXboxController 
	public static final BTIDrivetrain DRIVETRAIN = null;
	public static final BTIRobotType ROBOT_TYPE = new BTCompetitionRobot();// The current drivetrain
	
	
	// Competition robot electronics ports
	
	// Gyro port
	public static final int COMPETITION_GYRO = 0;
	
	// Motor ports
	public static final int COMPETITION_FRONT_LEFT_MOTOR = 14;  // 1 
	public static final int COMPETITION_BACK_LEFT_MOTOR = 15;   // 3
	public static final int COMPETITION_FRONT_RIGHT_MOTOR = 0; // 4
	public static final int COMPETITION_BACK_RIGHT_MOTOR = 1; // 10
	public static final int COMPETITION_TOTE_MOTOR = -1;
	public static final int COMPETITION_BARREL_MOTOR_LEFT = 10;
	public static final int COMPETITION_BARREL_MOTOR_RIGHT = 11;
	public static final int COMPETITION_COLLECTOR_MOTOR_LEFT = -1;
	public static final int COMPETITION_COLLECTOR_MOTOR_RIGHT = -1;
	
	// Limit switch ports
	public static final int COMPETITION_TOTE_LIMIT = -1;
	public static final int COMPETITION_PRIMARY_LOWER_LIMIT_LEFT = 1;
	public static final int COMPETITION_PRIMARY_LOWER_LIMIT_RIGHT = -1;
	public static final int COMPETITION_PRIMARY_MIDDLE_LIMIT_LEFT = -1;
	public static final int COMPETITION_PRIMARY_MIDDLE_LIMIT_RIGHT = -1;
	public static final int COMPETITION_PRIMARY_UPPER_LIMIT_LEFT = -1;
	public static final int COMPETITION_PRIMARY_UPPER_LIMIT_RIGHT = -1;
	public static final int COMPETITION_SECONDARY_LOWER_LIMIT = -1;
	public static final int COMPETITION_SECONDARY_UPPER_LIMIT = -1;
	public static final int COMPETITION_LIMIT_SWITCH = -1;
	
	// Encoder ports
	public static final int COMPETITION_FRONT_RIGHT_ENCODER_A = 8;
	public static final int COMPETITION_FRONT_RIGHT_ENCODER_B = 9;
	public static final int COMPETITION_FRONT_LEFT_ENCODER_A = 2;
	public static final int COMPETITION_FRONT_LEFT_ENCODER_B = 3;
	public static final int COMPETITION_BACK_RIGHT_ENCODER_A = 6;
	public static final int COMPETITION_BACK_RIGHT_ENCODER_B = 7;
	public static final int COMPETITION_BACK_LEFT_ENCODER_A = 4;
	public static final int COMPETITION_BACK_LEFT_ENCODER_B = 5;
	
	// Solenoid ports
	public static final int COMPETITION_TOTE_CLAMP_EXTEND = 0;
	public static final int COMPETITION_TOTE_CLAMP_RETRACT = 1;
	public static final int COMPETITION_TOTE_COLLECTOR_EXTEND = -1;
	public static final int COMPETITION_TOTE_COLLECTOR_RETRACT = -1;
	public static final int COMPETITION_BARREL_HOLDER_EXTEND = -1;
	public static final int COMPETITION_BARREL_HOLDER_RETRACT = -1;
	
	// Drivetrain Constants: General
	public static final double MECANUM_SCALE_VALUE = 0.9;
	public static final double TOP_THROTTLE_MIN = 0.5;
	public static final int TOTE_MAX = 4;
	
	// Drivetrain Constants: Joystick curve
	public static final double DEADZONE_MAX_RANGE = 0.4;		//Below this radius, doesn't move
	public static final double SLOW_INCREASE_MAX_RANGE = 0.5;	//Below this radius, accelerates slowly
	public static final double FAST_INCREASE_MAX_RANGE = 0.8;	//Below this radius, accelerates quickly
	public static final double GLOBAL_MAX_RANGE = 1.0;			//Farthest that the joystick can be from center
	
	public static final double SLOW_INCREASE_MAX_SPEED = 0.3;	//Speed at SLOW_INCREASE_MAX_RANGE
	public static final double FAST_INCREASE_MAX_SPEED = 0.9;	//Speed at FAST_INCREAST_MAX_RANGE
	public static final double GLOBAL_MAX_SPEED = 1.0;			//Speed at GLOBAL_MAX_RANGE
	
	// Manipulator Constants
	public static final int MAX_TOTE_COUNT = 6;
	public static final int EMERGENCY_STOP_TIME = 3000;
	public static final double TOTE_MOTOR_POWER = 0.9;
	public static final double BARREL_MOTOR_POWER = 0.9;
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
	public static final double BACK_SHORT_SPEED = 0.3;
	public static final double BACK_LONG_SPEED = 0.3;
	
//	public static final int COLLECT_TIME = 1000;
	
	// Reverses selected motors
	public static final boolean FRONT_LEFT_REVERSED = false;
	public static final boolean BACK_LEFT_REVERSED = true;
	public static final boolean FRONT_RIGHT_REVERSED = false;
	public static final boolean BACK_RIGHT_REVERSED = true;
	public static final boolean FORK_REVERSED = false;
	public static final boolean COLLECTORS_REVERSED = false;
	public static final boolean BARREL_REVERSED = false;
	
}

