package org.usfirst.frc.team2220.robot;

import org.usfirst.frc.team2220.robot.autonomous.BTIAutonomousRoutine;
import org.usfirst.frc.team2220.robot.controller.BTFlightstick;
import org.usfirst.frc.team2220.robot.controller.BTIController;
import org.usfirst.frc.team2220.robot.drivetrain.BTIDrivetrain;
import org.usfirst.frc.team2220.robot.robottype.BTCompetitionRobot;

public class BTConstants
{
	
	public static final BTIAutonomousRoutine AUTON_ROUTINE = null;			// The current autonomous routine
	public static final BTIController CONTROLLER = new BTFlightstick(0);	// The current controller
	public static final BTIDrivetrain DRIVETRAIN = null;					// The current drivetrain
	
	
	// Competition robot electronics ports
	public static final int COMPETITION_FRONT_LEFT_MOTOR = 5;
	public static final int COMPETITION_BACK_LEFT_MOTOR = 1;
	public static final int COMPETITION_FRONT_RIGHT_MOTOR = 7;
	public static final int COMPETITION_BACK_RIGHT_MOTOR = 3;
	public static final int COMPETITION_FORK_MOTOR = -1;
	
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
	
	
	// Drivetrain Constants
	public static final double MECANUM_DEADZONE = 0.05;
	public static final double MECANUM_SCALE_VALUE = 0.9;
	public static final double TOP_THROTTLE_MIN = 0.5;
	
	// Manipulator Constants
	
	// Reverses selected motors
	public static final boolean FRONT_LEFT_REVERSED = false;
	public static final boolean BACK_LEFT_REVERSED = true;
	public static final boolean FRONT_RIGHT_REVERSED = false;
	public static final boolean BACK_RIGHT_REVERSED = true;
	public static final boolean FORK_REVERSED = false;
}
