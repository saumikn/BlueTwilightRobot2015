package org.usfirst.frc.team2220.robot;

import org.usfirst.frc.team2220.robot.autonomous.BTIAutonomousRoutine;
import org.usfirst.frc.team2220.robot.controller.BTFlightstick;
import org.usfirst.frc.team2220.robot.controller.BTIController;
import org.usfirst.frc.team2220.robot.drivetrain.BTIDrivetrain;

public class BTConstants
{
	// The current autonomous routine
	public static final BTIAutonomousRoutine AUTON_ROUTINE = null;
	
	// The current controller
	public static final BTIController CONTROLLER = new BTFlightstick(0);
	
	// The current drivetrain
	public static final BTIDrivetrain DRIVETRAIN = null;
	
	// Numbers used to represent motors
	public static final int MEC_FRONT_LEFT = 0;
	public static final int MEC_BACK_LEFT = 1;
	public static final int MEC_FRONT_RIGHT = 2;
	public static final int MEC_BACK_RIGHT = 3;
	
	// Deadzone radius specification
	public static final double MECANUM_DEADZONE = 0.05;
	
	// Power scaling value for mecanum motors
	public static final double MECANUM_SCALE_VALUE = 0.9;
	
	// Minimum scaling for the top [speed] control
	public static final double TOP_THROTTLE_MIN = 0.1;
	
	// Reverses selected wheels
	public static final boolean FRONT_LEFT_REVERSED = false;
	public static final boolean BACK_LEFT_REVERSED = true;
	public static final boolean FRONT_RIGHT_REVERSED = false;
	public static final boolean BACK_RIGHT_REVERSED = true;
	
	// If we're using the test board. Disables any motors etc.
	public static final boolean TEST_BOARD = false;

}
