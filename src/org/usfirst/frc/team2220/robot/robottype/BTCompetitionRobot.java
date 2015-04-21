package org.usfirst.frc.team2220.robot.robottype;

import org.usfirst.frc.team2220.robot.BTConstants;
import org.usfirst.frc.team2220.robot.electronics.BTCompressor;
import org.usfirst.frc.team2220.robot.electronics.BTDoublePiston;
import org.usfirst.frc.team2220.robot.electronics.BTEncoder;
import org.usfirst.frc.team2220.robot.electronics.BTGyro;
import org.usfirst.frc.team2220.robot.electronics.BTIPiston;
import org.usfirst.frc.team2220.robot.electronics.BTLimitSwitch;
import org.usfirst.frc.team2220.robot.motor.BTCANTalon;
import org.usfirst.frc.team2220.robot.motor.BTIMotor;

public class BTCompetitionRobot implements BTIRobotType
{
	private final BTIMotor FRONT_LEFT_MOTOR;
	private final BTIMotor FRONT_RIGHT_MOTOR;
	private final BTIMotor BACK_LEFT_MOTOR;
	private final BTIMotor BACK_RIGHT_MOTOR;
	
	private final BTIMotor BARREL_MOTOR_LEFT;
	private final BTIMotor BARREL_MOTOR_RIGHT;
	private final BTIMotor COLLECTOR_MOTOR_LEFT;
	private final BTIMotor COLLECTOR_MOTOR_RIGHT;
	private final BTIMotor CONTAINMENT_MOTOR;
	
	private final BTIMotor LEFT_FORK_LEFT;
	private final BTIMotor LEFT_FORK_RIGHT;
	private final BTIMotor RIGHT_FORK_LEFT;
	private final BTIMotor RIGHT_FORK_RIGHT;
	
//	private final BTLimitSwitch TOTE_LIMIT;
	private final BTLimitSwitch LEFT_TOTE_LOWER_LIMIT;
	private final BTLimitSwitch RIGHT_TOTE_LOWER_LIMIT;
//	private final BTLimitSwitch TOTE_MIDDLE_LIMIT;
	private final BTLimitSwitch LEFT_TOTE_UPPER_LIMIT;
	private final BTLimitSwitch RIGHT_TOTE_UPPER_LIMIT;
//	private final BTLimitSwitch SECONDARY_UPPER_LIMIT;
	
	private final BTEncoder FRONT_LEFT_ENCODER;
	private final BTEncoder FRONT_RIGHT_ENCODER;
//	private final BTEncoder BACK_LEFT_ENCODER;
//	private final BTEncoder BACK_RIGHT_ENCODER;
	
	private final BTIPiston TOTE_CLAMP_PISTON;
	private final BTIPiston BARREL_CLAMP_PISTON;
	private final BTIPiston DRIVETRAIN_SWITCH_PISTON;
	
//	private final BTAnalogPotentiometer RIGHT_POT;
//	private final BTAnalogPotentiometer LEFT_POT;
	
	private final BTGyro GYRO;
	
	private final BTCompressor COMPRESSOR;
	
	public BTCompetitionRobot()
	{
		FRONT_LEFT_MOTOR  = new BTCANTalon(BTConstants.COMPETITION_FRONT_LEFT_MOTOR, false);
		FRONT_RIGHT_MOTOR = new BTCANTalon(BTConstants.COMPETITION_FRONT_RIGHT_MOTOR, false);
		BACK_LEFT_MOTOR   = new BTCANTalon(BTConstants.COMPETITION_BACK_LEFT_MOTOR, false);
		BACK_RIGHT_MOTOR  = new BTCANTalon(BTConstants.COMPETITION_BACK_RIGHT_MOTOR, false);
		
//		TOTE_LIMIT              = new BTLimitSwitch(BTConstants.COMPETITION_TOTE_LIMIT);
		LEFT_TOTE_LOWER_LIMIT   = new BTLimitSwitch(BTConstants.COMPETITION_PRIMARY_LOWER_LIMIT_LEFT);
		RIGHT_TOTE_LOWER_LIMIT  = new BTLimitSwitch(BTConstants.COMPETITION_PRIMARY_LOWER_LIMIT_RIGHT);
//		TOTE_MIDDLE_LIMIT  = new BTLimitSwitch(BTConstants.COMPETITION_PRIMARY_MIDDLE_LIMIT);
		LEFT_TOTE_UPPER_LIMIT   = new BTLimitSwitch(BTConstants.COMPETITION_PRIMARY_UPPER_LIMIT_LEFT);
		RIGHT_TOTE_UPPER_LIMIT  = new BTLimitSwitch(BTConstants.COMPETITION_PRIMARY_UPPER_LIMIT_RIGHT);
//		SECONDARY_UPPER_LIMIT	= new BTLimitSwitch(BTConstants.COMPETITION_SECONDARY_UPPER_LIMIT);
		
		FRONT_RIGHT_ENCODER = new BTEncoder(BTConstants.COMPETITION_FRONT_RIGHT_ENCODER_A,BTConstants.COMPETITION_FRONT_RIGHT_ENCODER_B);
		FRONT_LEFT_ENCODER  = new BTEncoder(BTConstants.COMPETITION_FRONT_LEFT_ENCODER_A,BTConstants.COMPETITION_FRONT_LEFT_ENCODER_B);
//		BACK_RIGHT_ENCODER  = new BTEncoder(BTConstants.COMPETITION_BACK_RIGHT_ENCODER_A,BTConstants.COMPETITION_BACK_RIGHT_ENCODER_B);
//		BACK_LEFT_ENCODER   = new BTEncoder(BTConstants.COMPETITION_BACK_LEFT_ENCODER_A,BTConstants.COMPETITION_BACK_LEFT_ENCODER_B);
		
//		RIGHT_POT = new BTAnalogPotentiometer(BTConstants.COMPEITION_ANALOG_POT_RIGHT);
//		LEFT_POT = new BTAnalogPotentiometer(BTConstants.COMPETITION_ANALOG_POT_LEFT);
//		
		
		LEFT_FORK_LEFT   = new BTCANTalon(BTConstants.COMPETITION_LEFT_FORK_LEFT, true);
		LEFT_FORK_RIGHT  = new BTCANTalon(BTConstants.COMPETITION_LEFT_FORK_RIGHT, true);
		RIGHT_FORK_LEFT  = new BTCANTalon(BTConstants.COMPETITION_RIGHT_FORK_LEFT, true);
		RIGHT_FORK_RIGHT = new BTCANTalon(BTConstants.COMPETITION_RIGHT_FORK_RIGHT, true);
		
		BARREL_MOTOR_LEFT     = new BTCANTalon(BTConstants.COMPETITION_BARREL_MOTOR_LEFT, true);
		BARREL_MOTOR_RIGHT    = new BTCANTalon(BTConstants.COMPETITION_BARREL_MOTOR_RIGHT, true);
		COLLECTOR_MOTOR_LEFT  = new BTCANTalon(BTConstants.COMPETITION_COLLECTOR_MOTOR_LEFT, true);
		COLLECTOR_MOTOR_RIGHT = new BTCANTalon(BTConstants.COMPETITION_COLLECTOR_MOTOR_RIGHT, true);
		CONTAINMENT_MOTOR = new BTCANTalon(BTConstants.COMPETITION_FRONT_CONTAINMENT_MOTOR, true);
		
		TOTE_CLAMP_PISTON        = new BTDoublePiston(BTConstants.COMPETITION_TOTE_CLAMP_EXTEND, BTConstants.COMPETITION_TOTE_CLAMP_RETRACT);
		BARREL_CLAMP_PISTON      = new BTDoublePiston(BTConstants.COMPETITION_BARREL_HOLDER_EXTEND, BTConstants.COMPETITION_BARREL_HOLDER_RETRACT);
		DRIVETRAIN_SWITCH_PISTON = new BTDoublePiston();
		
		GYRO = new BTGyro(BTConstants.COMPETITION_GYRO);
		
		COMPRESSOR = new BTCompressor();
	}
	
	
	

	@Override
	public BTIMotor getFrontLeftMotor()
	{
		return FRONT_LEFT_MOTOR;
	}

	@Override
	public BTIMotor getFrontRightMotor()
	{
		return FRONT_RIGHT_MOTOR;
	}
	
	@Override
	public BTIMotor getFrontContainmentMotor()
	{
		return CONTAINMENT_MOTOR;
	}

	@Override
	public BTIMotor getBackLeftMotor()
	{
		return BACK_LEFT_MOTOR;
	}

	@Override
	public BTIMotor getBackRightMotor()
	{
		return BACK_RIGHT_MOTOR;
	}

	@Override
	public BTIMotor getBarrelMotorLeft()
	{
		return BARREL_MOTOR_LEFT;
	}

	@Override
	public BTIMotor getBarrelMotorRight()
	{
		return BARREL_MOTOR_RIGHT;
	}

	@Override
	public BTIMotor getCollectorMotorLeft()
	{
		return COLLECTOR_MOTOR_LEFT;
	}

	@Override
	public BTIMotor getCollectorMotorRight()
	{
		return COLLECTOR_MOTOR_RIGHT;
	}

//	@Override
//	public BTLimitSwitch getToteLimit()
//	{
//		return TOTE_LIMIT;
//	}

	@Override
	public BTLimitSwitch getLeftToteLowerLimit()
	{
		return LEFT_TOTE_LOWER_LIMIT;
	}

	@Override
	public BTLimitSwitch getRightToteLowerLimit()
	{
		return RIGHT_TOTE_LOWER_LIMIT;
	}

//	@Override
//	public BTLimitSwitch getToteMiddleLimit()
//	{
//		return TOTE_MIDDLE_LIMIT;
//	}
	
	@Override
	public BTLimitSwitch getLeftToteUpperLimit()
	{
		return LEFT_TOTE_UPPER_LIMIT;
	}

	@Override
	public BTLimitSwitch getRightToteUpperLimit()
	{
		return RIGHT_TOTE_UPPER_LIMIT;
	}

//	@Override
//	public BTLimitSwitch getSecondaryUpperLimit()
//	{
//		return SECONDARY_UPPER_LIMIT;
//	}

	@Override
	public BTEncoder getLeftEncoder()
	{
		return FRONT_LEFT_ENCODER;
	}

	@Override
	public BTEncoder getRightEncoder()
	{
		return FRONT_RIGHT_ENCODER;
	}
//
//	@Override
//	public BTEncoder getBackLeftEncoder()
//	{
//		return BACK_LEFT_ENCODER;
//	}
//
//	@Override
//	public BTEncoder getBackRightEncoder()
//	{
//		return BACK_RIGHT_ENCODER;
//	}

	@Override
	public BTGyro getGyro()
	{
		return GYRO;
	}

	@Override
	public BTCompressor getCompressor()
	{
		return COMPRESSOR;
	}

	@Override
	public BTIPiston getToteClamp()
	{
		return TOTE_CLAMP_PISTON;
	}

	@Override
	public BTIPiston getBarrelHolder()
	{
		return BARREL_CLAMP_PISTON;
	}
	
	@Override
	public BTIPiston getDrivetrainSwitch()
	{
		return DRIVETRAIN_SWITCH_PISTON;
	}




	@Override
	public BTIMotor getLeftForkLeft() {
		return LEFT_FORK_LEFT;
	}




	@Override
	public BTIMotor getLeftForkRight() {
		return LEFT_FORK_RIGHT;
	}




	@Override
	public BTIMotor getRightForkLeft() {
		return RIGHT_FORK_LEFT;
	}

	@Override
	public BTIMotor getRightForkRight() {
		return RIGHT_FORK_RIGHT;
	}




//	public BTAnalogPotentiometer getFrontRightPot() {
//		return RIGHT_POT;
//	}
//	
//	public BTAnalogPotentiometer getFrontLeftPot() {
//		return LEFT_POT;
//	}
}
