package org.usfirst.frc.team2220.robot.robottype;

import org.usfirst.frc.team2220.robot.BTConstants;
import org.usfirst.frc.team2220.robot.electronics.BTCompressor;
import org.usfirst.frc.team2220.robot.electronics.BTEncoder;
import org.usfirst.frc.team2220.robot.electronics.BTGyro;
import org.usfirst.frc.team2220.robot.electronics.BTLimitSwitch;
import org.usfirst.frc.team2220.robot.motor.BTCANTalon;
import org.usfirst.frc.team2220.robot.motor.BTTalonSRX;
import org.usfirst.frc.team2220.robot.electronics.BTPiston;

public class BTCompetitionRobot
{
	public BTCANTalon FRONT_LEFT_MOTOR = new BTCANTalon(BTConstants.COMPETITION_FRONT_LEFT_MOTOR);
	public BTCANTalon FRONT_RIGHT_MOTOR = new BTCANTalon(BTConstants.COMPETITION_FRONT_RIGHT_MOTOR);
	public BTCANTalon BACK_LEFT_MOTOR = new BTCANTalon(BTConstants.COMPETITION_BACK_LEFT_MOTOR);
	public BTCANTalon BACK_RIGHT_MOTOR = new BTCANTalon(BTConstants.COMPETITION_BACK_RIGHT_MOTOR);
	
	
	public BTLimitSwitch TOTE_LIMIT = new BTLimitSwitch(BTConstants.COMPETITION_TOTE_SWITCH); //
	public BTLimitSwitch LOW_LIMIT = new BTLimitSwitch(BTConstants.COMPETITION_LOW_SWITCH); //
//	public BTLimitSwitch MIDDLE_LIMIT = new BTLimitSwitch(BTConstants.COMPETITION_MIDDLE_SWITCH); //
//	public BTLimitSwitch UPPER_LIMIT = new BTLimitSwitch(BTConstants.COMPETITION_UPPER_SWITCH); // 
//	public BTLimitSwitch LIMIT_SWITCH = new BTLimitSwitch(BTConstants.COMPETITION_LIMIT_SWITCH);
	
//	public BTEncoder FRONT_RIGHT_ENCODER = new BTEncoder(BTConstants.COMPETITION_FRONT_RIGHT_ENCODER_A,BTConstants.COMPETITION_FRONT_RIGHT_ENCODER_B);
//	public BTEncoder FRONT_LEFT_ENCODER = new BTEncoder(BTConstants.COMPETITION_FRONT_LEFT_ENCODER_A,BTConstants.COMPETITION_FRONT_LEFT_ENCODER_B);
//	public BTEncoder BACK_RIGHT_ENCODER = new BTEncoder(BTConstants.COMPETITION_BACK_RIGHT_ENCODER_A,BTConstants.COMPETITION_BACK_RIGHT_ENCODER_B);
//	public BTEncoder BACK_LEFT_ENCODER = new BTEncoder(BTConstants.COMPETITION_BACK_LEFT_ENCODER_A,BTConstants.COMPETITION_BACK_LEFT_ENCODER_B);
	
//	public BTTalonSRX TOTE_MOTOR = new BTTalonSRX(BTConstants.COMPETITION_TOTE_MOTOR);
//	public BTTalonSRX BARREL_MOTOR = new BTTalonSRX(BTConstants.COMPETITION_BARREL_MOTOR);
//	public BTTalonSRX COLLECTOR_MOTOR_LEFT = new BTTalonSRX(BTConstants.COMPETITION_COLLECTOR_MOTOR_LEFT);
//	public BTTalonSRX COLLECTOR_MOTOR_RIGHT = new BTTalonSRX(BTConstants.COMPETITION_COLLECTOR_MOTOR_RIGHT);
	
//	public BTPiston TOTE_HOLDER = new BTPiston(BTConstants.COMPETITION_TOTE_HOLDER_EXTEND, BTConstants.COMPETITION_TOTE_HOLDER_RETRACT);
//	public BTPiston TOTE_COLLECTOR = new BTPiston(BTConstants.COMPETITION_TOTE_COLLECTOR_EXTEND, BTConstants.COMPETITION_TOTE_COLLECTOR_RETRACT);
//	public BTPiston BARREL_HOLDER = new BTPiston(BTConstants.COMPETITION_BARREL_HOLDER_EXTEND, BTConstants.COMPETITION_BARREL_HOLDER_RETRACT);
	
	public BTGyro GYRO = new BTGyro(1);
	
	public BTCompressor COMP = new BTCompressor();
}
