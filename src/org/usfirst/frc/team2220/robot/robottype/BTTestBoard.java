package org.usfirst.frc.team2220.robot.robottype;

import org.usfirst.frc.team2220.robot.electronics.BTCompressor;
import org.usfirst.frc.team2220.robot.electronics.BTEncoder;
import org.usfirst.frc.team2220.robot.electronics.BTGyro;
import org.usfirst.frc.team2220.robot.electronics.BTIPiston;
import org.usfirst.frc.team2220.robot.electronics.BTLimitSwitch;
import org.usfirst.frc.team2220.robot.motor.BTCANTalon;
import org.usfirst.frc.team2220.robot.motor.BTIMotor;

public class BTTestBoard implements BTIRobotType
{
	private final BTIMotor FRONT_LEFT_MOTOR;
	private final BTIMotor FRONT_RIGHT_MOTOR;
	private final BTIMotor BACK_LEFT_MOTOR;
	private final BTIMotor BACK_RIGHT_MOTOR;
	
//	private final BTIMotor BARREL_MOTOR_LEFT;
//	private final BTIMotor BARREL_MOTOR_RIGHT;
//	private final BTIMotor COLLECTOR_MOTOR_LEFT;
//	private final BTIMotor COLLECTOR_MOTOR_RIGHT;
//	
//	private final BTIMotor LEFT_FORK_LEFT;
//	private final BTIMotor LEFT_FORK_RIGHT;
//	private final BTIMotor RIGHT_FORK_LEFT;
//	private final BTIMotor RIGHT_FORK_RIGHT;
//	
//	private final BTLimitSwitch TOTE_LIMIT;
//	private final BTLimitSwitch LEFT_TOTE_LOWER_LIMIT;
//	private final BTLimitSwitch RIGHT_TOTE_LOWER_LIMIT;
//	private final BTLimitSwitch LEFT_TOTE_MIDDLE_LIMIT;
//	private final BTLimitSwitch RIGHT_TOTE_MIDDLE_LIMIT;
//	private final BTLimitSwitch LEFT_TOTE_UPPER_LIMIT;
//	private final BTLimitSwitch RIGHT_TOTE_UPPER_LIMIT;
//	private final BTLimitSwitch BARREL_LOWER_LIMIT;
//	private final BTLimitSwitch BARREL_UPPER_LIMIT;
//	
//	private final BTEncoder FRONT_LEFT_ENCODER;
//	private final BTEncoder FRONT_RIGHT_ENCODER;
//	private final BTEncoder BACK_LEFT_ENCODER;
//	private final BTEncoder BACK_RIGHT_ENCODER;
//	
//	private final BTIPiston TOTE_CLAMP_PISTON;
//	private final BTIPiston BARREL_CLAMP_PISTON;
//	private final BTIPiston DRIVETRAIN_SWITCH_PISTON;
//	
//	private final BTGyro GYRO;
//	
//	private final BTCompressor COMPRESSOR;
	
	public BTTestBoard()
	{
		FRONT_LEFT_MOTOR = new BTCANTalon(2, false);
		FRONT_RIGHT_MOTOR = new BTCANTalon(3, false);
		BACK_LEFT_MOTOR = new BTCANTalon(1, false);
		BACK_RIGHT_MOTOR = new BTCANTalon(4, false);
		
	//	FRONT_LEFT_ENCODER = new BTEncoder(1,2);
	}
	

	@Override
	public BTIMotor getFrontLeftMotor()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BTIMotor getFrontRightMotor()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BTIMotor getBackLeftMotor()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BTIMotor getBackRightMotor() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BTIMotor getLeftForkLeft()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BTIMotor getLeftForkRight()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BTIMotor getRightForkLeft()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BTIMotor getRightForkRight()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BTIMotor getBarrelMotorLeft()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BTIMotor getBarrelMotorRight()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BTIMotor getCollectorMotorLeft()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BTIMotor getCollectorMotorRight() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BTLimitSwitch getToteLimit() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BTLimitSwitch getLeftToteLowerLimit() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BTLimitSwitch getRightToteLowerLimit() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BTLimitSwitch getToteMiddleLimit() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BTLimitSwitch getLeftToteUpperLimit() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BTLimitSwitch getRightToteUpperLimit() 
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public BTLimitSwitch getSecondaryUpperLimit() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BTEncoder getFrontLeftEncoder() 
	{
		return null;
	}

	@Override
	public BTEncoder getFrontRightEncoder() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BTEncoder getBackLeftEncoder() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BTEncoder getBackRightEncoder() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BTIPiston getToteClamp() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BTIPiston getBarrelHolder() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BTIPiston getDrivetrainSwitch() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BTGyro getGyro() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BTCompressor getCompressor() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
}
