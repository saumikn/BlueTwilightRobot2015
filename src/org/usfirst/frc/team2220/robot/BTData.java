package org.usfirst.frc.team2220.robot;

import org.usfirst.frc.team2220.robot.electronics.BTEncoder;
import org.usfirst.frc.team2220.robot.motor.BTDummyMotor;
import org.usfirst.frc.team2220.robot.motor.BTIMotor;
import org.usfirst.frc.team2220.robot.motor.BTTalon;
import org.usfirst.frc.team2220.robot.motor.BTTalonSRX;
import org.usfirst.frc.team2220.robot.robottype.BTCompetitionRobot;
import org.usfirst.frc.team2220.robot.robottype.BTTestBot;
import org.usfirst.frc.team2220.robot.electronics.BTLimitSwitch;
import org.usfirst.frc.team2220.robot.electronics.BTPiston;

public class BTData
{
	//Drivetrain
	
	public BTIMotor FRONT_LEFT_MOTOR;
	public BTIMotor FRONT_RIGHT_MOTOR;
	public BTIMotor BACK_LEFT_MOTOR;
	public BTIMotor BACK_RIGHT_MOTOR;
	
	//Manipulator
	
	public BTLimitSwitch TOTE_SWITCH; //
	public BTLimitSwitch LOW_LIMIT; //
	public BTLimitSwitch MIDDLE_LIMIT; //
	public BTLimitSwitch UPPER_LIMIT; // 
		
	public BTEncoder FRONT_RIGHT_ENCODER;
	public BTEncoder FRONT_LEFT_ENCODER;
	public BTEncoder BACK_RIGHT_ENCODER;
	public BTEncoder BACK_LEFT_ENCODER;
	
	public BTIMotor TOTE_MOTOR;
	public BTIMotor BIN_MOTOR;
	
	public BTIMotor COLLECTOR_MOTOR_LEFT;
	public BTIMotor COLLECTOR_MOTOR_RIGHT;
	
	public BTPiston TOTE_HOLDER;
	
	public BTData(BTCompetitionRobot compRobot)
	{
		this.FRONT_LEFT_MOTOR = compRobot.FRONT_LEFT_MOTOR;
		this.FRONT_RIGHT_MOTOR = compRobot.FRONT_RIGHT_MOTOR;
		this.BACK_LEFT_MOTOR = compRobot.BACK_LEFT_MOTOR;
		this.BACK_RIGHT_MOTOR = compRobot.BACK_RIGHT_MOTOR;
		
		this.FRONT_RIGHT_ENCODER = compRobot.FRONT_RIGHT_ENCODER;
		this.FRONT_LEFT_ENCODER = compRobot.FRONT_LEFT_ENCODER;
		this.BACK_RIGHT_ENCODER = compRobot.BACK_RIGHT_ENCODER;
		this.BACK_LEFT_ENCODER = compRobot.BACK_RIGHT_ENCODER;
		
		this.TOTE_SWITCH = compRobot.TOTE_SWTICH;
		this.LOW_LIMIT = compRobot.LOW_LIMIT;
		this.MIDDLE_LIMIT = compRobot.MIDDLE_LIMIT;
		this.UPPER_LIMIT = compRobot.UPPER_LIMIT;
		
		this.TOTE_MOTOR = compRobot.TOTE_MOTOR;
		this.BIN_MOTOR = compRobot.BIN_MOTOR;
		this.COLLECTOR_MOTOR_LEFT = compRobot.COLLECTOR_MOTOR_LEFT;
		this.COLLECTOR_MOTOR_RIGHT = compRobot.COLLECTOR_MOTOR_RIGHT;
		
		this.TOTE_HOLDER = compRobot.TOTE_HOLDER;
	}
	
	public BTData(BTTestBot testbot)
	{
		this.FRONT_LEFT_MOTOR = testbot.FRONT_LEFT_MOTOR;
		this.FRONT_RIGHT_MOTOR = testbot.FRONT_RIGHT_MOTOR;
		this.BACK_LEFT_MOTOR = testbot.BACK_LEFT_MOTOR;
		this.BACK_RIGHT_MOTOR = testbot.BACK_RIGHT_MOTOR;
	}
	
//	public BTData()
//	{
//		if (BTConstants.IS_TEST_BOARD)
//		{
//			LIMIT_SWITCH	  = new BTLimitSwitch(0);
//			FRONT_LEFT_MOTOR  = new BTDummyMotor();
//			BACK_LEFT_MOTOR   = new BTDummyMotor();
//			FRONT_RIGHT_MOTOR = new BTDummyMotor();
//			BACK_RIGHT_MOTOR  = new BTDummyMotor();	
//		}
//		else if(!BTConstants.IS_SRX)
//		{
//			FRONT_LEFT_MOTOR  = new BTTalon(BTConstants.MEC_FRONT_LEFT);
//			BACK_LEFT_MOTOR   = new BTTalon(BTConstants.MEC_BACK_LEFT);
//			FRONT_RIGHT_MOTOR = new BTTalon(BTConstants.MEC_FRONT_RIGHT);
//			BACK_RIGHT_MOTOR  = new BTTalon(BTConstants.MEC_BACK_RIGHT);	
//		}
//		else
//		{
//			FRONT_LEFT_MOTOR  = new BTTalonSRX(BTConstants.MEC_FRONT_LEFT);
//			BACK_LEFT_MOTOR   = new BTTalonSRX(BTConstants.MEC_BACK_LEFT);
//			FRONT_RIGHT_MOTOR = new BTTalonSRX(BTConstants.MEC_FRONT_RIGHT);
//			BACK_RIGHT_MOTOR  = new BTTalonSRX(BTConstants.MEC_BACK_RIGHT);			
//		}
//	}
	
	
	
}
