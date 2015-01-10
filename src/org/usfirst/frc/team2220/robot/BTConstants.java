package org.usfirst.frc.team2220.robot;

import org.usfirst.frc.team2220.robot.autonomous.BTIAutonomousRoutine;
import org.usfirst.frc.team2220.robot.controller.BTIController;
import org.usfirst.frc.team2220.robot.controller.BTXboxController;
import org.usfirst.frc.team2220.robot.drivetrain.BTIDrivetrain;

import edu.wpi.first.wpilibj.RobotDrive.MotorType;

// Just an idea, feel free to change it around
public class BTConstants
{
	// The current autonomous routine
	public static final BTIAutonomousRoutine AUTON_ROUTINE = null;
	
	// The current controller
	public static final BTIController CONTROLLER = new BTXboxController(1);
	
	// The current drivetrain
	public static final BTIDrivetrain DRIVETRAIN = null;
	
	public static final int MEC_FRONT_LEFT = 1;
			
	public static final int MEC_BACK_LEFT = 0;

	public static final int MEC_FRONT_RIGHT = 3;

	public static final int MEC_BACK_RIGHT = 2;
	
	public static final int TANK_FRONT_LEFT = 1;
	
	public static final int TANK_BACK_LEFT = 0;

	public static final int TANK_FRONT_RIGHT = 3;

	public static final int TANK_BACK_RIGHT = 2;
	
	public static final MotorType[] REVERSED_MOTORS = { };

}
