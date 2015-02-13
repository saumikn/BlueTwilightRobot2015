//package org.usfirst.frc.team2220.robot;
//
//import org.usfirst.frc.team2220.robot.electronics.BTEncoder;
//import org.usfirst.frc.team2220.robot.motor.BTDummyMotor;
//import org.usfirst.frc.team2220.robot.motor.BTIMotor;
//import org.usfirst.frc.team2220.robot.motor.BTTalon;
//import org.usfirst.frc.team2220.robot.motor.BTTalonSRX;
//import org.usfirst.frc.team2220.robot.robottype.BTCompetitionRobot;
//import org.usfirst.frc.team2220.robot.robottype.BTTestBot;
//import org.usfirst.frc.team2220.robot.electronics.BTGyro;
//import org.usfirst.frc.team2220.robot.electronics.BTLimitSwitch;
//import org.usfirst.frc.team2220.robot.electronics.BTDoublePiston;
//
//public class BTData
//{
//	//Drivetrain
//	
//	public BTIMotor FRONT_LEFT_MOTOR;
//	public BTIMotor FRONT_RIGHT_MOTOR;
//	public BTIMotor BACK_LEFT_MOTOR;
//	public BTIMotor BACK_RIGHT_MOTOR;
//	
//	public BTDoublePiston DRIVETRAIN_PISTON;
//	
//	//Manipulator
//	
//	public BTLimitSwitch TOTE_LIMIT; //
//	public BTLimitSwitch PRIMARY_LOWER_LIMIT_LEFT; //
//	public BTLimitSwitch PRIMARY_LOWER_LIMIT_RIGHT;
//	public BTLimitSwitch PRIMARY_MIDDLE_LIMIT_LEFT; //
//	public BTLimitSwitch PRIMARY_MIDDLE_LIMIT_RIGHT;
//	public BTLimitSwitch PRIMARY_UPPER_LIMIT_LEFT; // 
//	public BTLimitSwitch PRIMARY_UPPER_LIMIT_RIGHT; // 
//	public BTLimitSwitch SECONDARY_LOWER_LIMIT;
//	public BTLimitSwitch SECONDARY_UPPER_LIMIT;
//		
//	public BTEncoder FRONT_RIGHT_ENCODER;
//	public BTEncoder FRONT_LEFT_ENCODER;
//	public BTEncoder BACK_RIGHT_ENCODER;
//	public BTEncoder BACK_LEFT_ENCODER;
//	
//	public BTIMotor TOTE_MOTOR;
//	public BTIMotor BARREL_MOTOR_LEFT;
//	public BTIMotor BARREL_MOTOR_RIGHT;
//	
//	public BTIMotor COLLECTOR_MOTOR_LEFT;
//	public BTIMotor COLLECTOR_MOTOR_RIGHT;
//	
//	public BTDoublePiston TOTE_HOLDER;
//	public BTDoublePiston BARREL_HOLDER;
//	
//	public BTGyro GYRO;
//	
//	public BTData(BTCompetitionRobot compRobot)
//	{
//		this.FRONT_LEFT_MOTOR = compRobot.FRONT_LEFT_MOTOR;
//		this.FRONT_RIGHT_MOTOR = compRobot.FRONT_RIGHT_MOTOR;
//		this.BACK_LEFT_MOTOR = compRobot.BACK_LEFT_MOTOR;
//		this.BACK_RIGHT_MOTOR = compRobot.BACK_RIGHT_MOTOR;
//		
//		this.GYRO = compRobot.GYRO;
//		
//		//this.FRONT_RIGHT_ENCODER = compRobot.FRONT_RIGHT_ENCODER;
//		//this.FRONT_LEFT_ENCODER = compRobot.FRONT_LEFT_ENCODER;
//		//this.BACK_RIGHT_ENCODER = compRobot.BACK_RIGHT_ENCODER;
//		//this.BACK_LEFT_ENCODER = compRobot.BACK_RIGHT_ENCODER;
//		
//		this.TOTE_LIMIT = compRobot.TOTE_LIMIT;
//		this.PRIMARY_LOWER_LIMIT_LEFT = compRobot.PRIMARY_LOWER_LIMIT_LEFT;
////		this.PRIMARY_LOWER_LIMIT_RIGHT = compRobot.PRIMARY_LOWER_LIMIT_RIGHT;
////		this.PRIMARY_MIDDLE_LIMIT_LEFT = compRobot.PRIMARY_MIDDLE_LIMIT_LEFT;
////		this.PRIMARY_MIDDLE_LIMIT_RIGHT = compRobot.PRIMARY_MIDDLE_LIMIT_RIGHT;
////		this.PRIMARY_UPPER_LIMIT_LEFT = compRobot.PRIMARY_UPPER_LIMIT_LEFT;
////		this.PRIMARY_UPPER_LIMIT_RIGHT = compRobot.PRIMARY_UPPER_LIMIT_RIGHT;
////		this.SECONDARY_LOWER_LIMIT = compRobot.SECONDARY_LOWER_LIMIT;
////		this.SECONDARY_UPPER_LIMIT = compRobot.SECONDARY_UPPER_LIMIT;
//		
//		//this.TOTE_MOTOR = compRobot.TOTE_MOTOR;
//		//this.BARREL_MOTOR_LEFT = compRobot.BARREL_MOTOR_LEFT;
//		//this.BARREL_MOTOR_RIGHT = compRobot.BARREL_MOTOR_RIGHT;
//		//this.COLLECTOR_MOTOR_LEFT = compRobot.COLLECTOR_MOTOR_LEFT;
//		//this.COLLECTOR_MOTOR_RIGHT = compRobot.COLLECTOR_MOTOR_RIGHT;
//		
//		//this.TOTE_HOLDER = compRobot.TOTE_HOLDER;
//		//this.TOTE_COLLECTOR = compRobot.TOTE_COLLECTOR;
//		//this.BARREL_HOLDER = compRobot.BARREL_HOLDER;
//	}
//	
//	public BTData(BTTestBot testbot)
//	{
//		this.FRONT_LEFT_MOTOR = testbot.FRONT_LEFT_MOTOR;
//		this.FRONT_RIGHT_MOTOR = testbot.FRONT_RIGHT_MOTOR;
//		this.BACK_LEFT_MOTOR = testbot.BACK_LEFT_MOTOR;
//		this.BACK_RIGHT_MOTOR = testbot.BACK_RIGHT_MOTOR;
//		
//		this.DRIVETRAIN_PISTON = testbot.DRIVETRAIN_PISTON;
//		
//		this.GYRO = testbot.GYRO;
//		
//		this.TOTE_LIMIT = testbot.TOTE_LIMIT;
//		this.PRIMARY_LOWER_LIMIT_LEFT = testbot.LOW_LIMIT;
//	}
//	
////	public BTData()
////	{
////		if (BTConstants.IS_TEST_BOARD)
////		{
////			LIMIT_SWITCH	  = new BTLimitSwitch(0);
////			FRONT_LEFT_MOTOR  = new BTDummyMotor();
////			BACK_LEFT_MOTOR   = new BTDummyMotor();
////			FRONT_RIGHT_MOTOR = new BTDummyMotor();
////			BACK_RIGHT_MOTOR  = new BTDummyMotor();	
////		}
////		else if(!BTConstants.IS_SRX)
////		{
////			FRONT_LEFT_MOTOR  = new BTTalon(BTConstants.MEC_FRONT_LEFT);
////			BACK_LEFT_MOTOR   = new BTTalon(BTConstants.MEC_BACK_LEFT);
////			FRONT_RIGHT_MOTOR = new BTTalon(BTConstants.MEC_FRONT_RIGHT);
////			BACK_RIGHT_MOTOR  = new BTTalon(BTConstants.MEC_BACK_RIGHT);	
////		}
////		else
////		{
////			FRONT_LEFT_MOTOR  = new BTTalonSRX(BTConstants.MEC_FRONT_LEFT);
////			BACK_LEFT_MOTOR   = new BTTalonSRX(BTConstants.MEC_BACK_LEFT);
////			FRONT_RIGHT_MOTOR = new BTTalonSRX(BTConstants.MEC_FRONT_RIGHT);
////			BACK_RIGHT_MOTOR  = new BTTalonSRX(BTConstants.MEC_BACK_RIGHT);			
////		}
////	}
//	
//	
//	
//}
