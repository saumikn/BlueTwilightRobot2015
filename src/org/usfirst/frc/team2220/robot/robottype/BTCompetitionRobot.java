package org.usfirst.frc.team2220.robot.robottype;

import org.usfirst.frc.team2220.robot.BTConstants;
import org.usfirst.frc.team2220.robot.electronics.BTCompressor;
import org.usfirst.frc.team2220.robot.electronics.BTEncoder;
import org.usfirst.frc.team2220.robot.electronics.BTGyro;
import org.usfirst.frc.team2220.robot.electronics.BTIPiston;
import org.usfirst.frc.team2220.robot.electronics.BTLimitSwitch;
import org.usfirst.frc.team2220.robot.motor.BTCANTalon;
import org.usfirst.frc.team2220.robot.motor.BTIMotor;
import org.usfirst.frc.team2220.robot.motor.BTTalonSRX;
import org.usfirst.frc.team2220.robot.electronics.BTDoublePiston;

public class BTCompetitionRobot implements BTIRobotType
{
	private final BTIMotor FRONT_LEFT_MOTOR;
	private final BTIMotor FRONT_RIGHT_MOTOR;
	private final BTIMotor BACK_LEFT_MOTOR;
	private final BTIMotor BACK_RIGHT_MOTOR;
	
	private final BTIMotor TOTE_MOTOR;
	private final BTIMotor BARREL_MOTOR_LEFT;
	private final BTIMotor BARREL_MOTOR_RIGHT;
	private final BTIMotor COLLECTOR_MOTOR_LEFT;
	private final BTIMotor COLLECTOR_MOTOR_RIGHT;
	
	private final BTLimitSwitch TOTE_LIMIT;
	private final BTLimitSwitch LEFT_TOTE_LOWER_LIMIT;
	private final BTLimitSwitch RIGHT_TOTE_LOWER_LIMIT;
	private final BTLimitSwitch LEFT_TOTE_MIDDLE_LIMIT;
	private final BTLimitSwitch RIGHT_TOTE_MIDDLE_LIMIT;
	private final BTLimitSwitch LEFT_TOTE_UPPER_LIMIT;
	private final BTLimitSwitch RIGHT_TOTE_UPPER_LIMIT;
	private final BTLimitSwitch BARREL_LOWER_LIMIT;
	private final BTLimitSwitch BARREL_UPPER_LIMIT;
	
	private final BTEncoder FRONT_LEFT_ENCODER;
	private final BTEncoder FRONT_RIGHT_ENCODER;
	private final BTEncoder BACK_LEFT_ENCODER;
	private final BTEncoder BACK_RIGHT_ENCODER;
	
	private final BTIPiston TOTE_CLAMP_PISTON;
	private final BTIPiston BARREL_CLAMP_PISTON;
	private final BTIPiston DRIVETRAIN_SWITCH_PISTON;
	
	private final BTGyro GYRO;
	
	private final BTCompressor COMPRESSOR;
	
	
	public BTCompetitionRobot()
	{
		FRONT_LEFT_MOTOR = new BTCANTalon(BTConstants.COMPETITION_FRONT_LEFT_MOTOR);
		FRONT_RIGHT_MOTOR = new BTCANTalon(BTConstants.COMPETITION_FRONT_RIGHT_MOTOR);
		BACK_LEFT_MOTOR = new BTCANTalon(BTConstants.COMPETITION_BACK_LEFT_MOTOR);
		BACK_RIGHT_MOTOR = new BTCANTalon(BTConstants.COMPETITION_BACK_RIGHT_MOTOR);
		
		
		TOTE_LIMIT = new BTLimitSwitch(BTConstants.COMPETITION_TOTE_LIMIT);
		LEFT_TOTE_LOWER_LIMIT = new BTLimitSwitch(BTConstants.COMPETITION_PRIMARY_LOWER_LIMIT_LEFT);
		RIGHT_TOTE_LOWER_LIMIT = new BTLimitSwitch(BTConstants.COMPETITION_PRIMARY_LOWER_LIMIT_RIGHT);
		LEFT_TOTE_MIDDLE_LIMIT = new BTLimitSwitch(BTConstants.COMPETITION_PRIMARY_MIDDLE_LIMIT_LEFT);
		RIGHT_TOTE_MIDDLE_LIMIT = new BTLimitSwitch(BTConstants.COMPETITION_PRIMARY_MIDDLE_LIMIT_RIGHT);
		LEFT_TOTE_UPPER_LIMIT = new BTLimitSwitch(BTConstants.COMPETITION_PRIMARY_UPPER_LIMIT_LEFT);
		RIGHT_TOTE_UPPER_LIMIT = new BTLimitSwitch(BTConstants.COMPETITION_PRIMARY_UPPER_LIMIT_RIGHT);
		BARREL_LOWER_LIMIT = new BTLimitSwitch(BTConstants.COMPETITION_SECONDARY_LOWER_LIMIT);
		BARREL_UPPER_LIMIT = new BTLimitSwitch(BTConstants.COMPETITION_SECONDARY_UPPER_LIMIT);
		
		FRONT_RIGHT_ENCODER = new BTEncoder(BTConstants.COMPETITION_FRONT_RIGHT_ENCODER_A,BTConstants.COMPETITION_FRONT_RIGHT_ENCODER_B);
		FRONT_LEFT_ENCODER = new BTEncoder(BTConstants.COMPETITION_FRONT_LEFT_ENCODER_A,BTConstants.COMPETITION_FRONT_LEFT_ENCODER_B);
		BACK_RIGHT_ENCODER = new BTEncoder(BTConstants.COMPETITION_BACK_RIGHT_ENCODER_A,BTConstants.COMPETITION_BACK_RIGHT_ENCODER_B);
		BACK_LEFT_ENCODER = new BTEncoder(BTConstants.COMPETITION_BACK_LEFT_ENCODER_A,BTConstants.COMPETITION_BACK_LEFT_ENCODER_B);
		
		TOTE_MOTOR = new BTTalonSRX(BTConstants.COMPETITION_TOTE_MOTOR);
		BARREL_MOTOR_LEFT = new BTTalonSRX(BTConstants.COMPETITION_BARREL_MOTOR_LEFT);
		BARREL_MOTOR_RIGHT = new BTTalonSRX(BTConstants.COMPETITION_BARREL_MOTOR_RIGHT);
		COLLECTOR_MOTOR_LEFT = new BTTalonSRX(BTConstants.COMPETITION_COLLECTOR_MOTOR_LEFT);
		COLLECTOR_MOTOR_RIGHT = new BTTalonSRX(BTConstants.COMPETITION_COLLECTOR_MOTOR_RIGHT);
		
		TOTE_CLAMP_PISTON = new BTDoublePiston(BTConstants.COMPETITION_TOTE_HOLDER_EXTEND, BTConstants.COMPETITION_TOTE_HOLDER_RETRACT);
		BARREL_CLAMP_PISTON = new BTDoublePiston(BTConstants.COMPETITION_BARREL_HOLDER_EXTEND, BTConstants.COMPETITION_BARREL_HOLDER_RETRACT);
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
	public BTIMotor getToteMotor()
	{
		return TOTE_MOTOR;
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

	@Override
	public BTLimitSwitch getToteLimit()
	{
		return TOTE_LIMIT;
	}

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

	@Override
	public BTLimitSwitch getLeftToteMiddleLimit()
	{
		return LEFT_TOTE_MIDDLE_LIMIT;
	}

	@Override
	public BTLimitSwitch getRightToteMiddleLimit()
	{
		return RIGHT_TOTE_MIDDLE_LIMIT;
	}

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

	@Override
	public BTLimitSwitch getBarrelLowerLimit()
	{
		return BARREL_LOWER_LIMIT;
	}

	@Override
	public BTLimitSwitch getBarrelUpperLimit()
	{
		return BARREL_UPPER_LIMIT;
	}

	@Override
	public BTEncoder getFrontLeftEncoder()
	{
		return FRONT_LEFT_ENCODER;
	}

	@Override
	public BTEncoder getFrontRightEncoder()
	{
		return FRONT_RIGHT_ENCODER;
	}

	@Override
	public BTEncoder getBackLeftEncoder()
	{
		return BACK_LEFT_ENCODER;
	}

	@Override
	public BTEncoder getBackRightEncoder()
	{
		return BACK_RIGHT_ENCODER;
	}

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
}
