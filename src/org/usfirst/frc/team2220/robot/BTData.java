package org.usfirst.frc.team2220.robot;

import org.usfirst.frc.team2220.robot.motor.BTDummyMotor;
import org.usfirst.frc.team2220.robot.motor.BTIMotor;
import org.usfirst.frc.team2220.robot.motor.BTTalon;
import org.usfirst.frc.team2220.robot.motor.BTTalonSRX;
import org.usfirst.frc.team2220.robot.sensor.BTLimitSwitch;

public class BTData
{
	public BTIMotor FRONT_LEFT_MOTOR;
	public BTIMotor FRONT_RIGHT_MOTOR;
	public BTIMotor BACK_LEFT_MOTOR;
	public BTIMotor BACK_RIGHT_MOTOR;
	
	public BTLimitSwitch LIMIT_SWITCH;
	
	public BTData()
	{
		if (BTConstants.IS_TEST_BOARD)
		{
			LIMIT_SWITCH	  = new BTLimitSwitch(0);
			FRONT_LEFT_MOTOR  = new BTDummyMotor();
			BACK_LEFT_MOTOR   = new BTDummyMotor();
			FRONT_RIGHT_MOTOR = new BTDummyMotor();
			BACK_RIGHT_MOTOR  = new BTDummyMotor();	
		}
		else if(!BTConstants.IS_SRX)
		{
			FRONT_LEFT_MOTOR  = new BTTalon(BTConstants.MEC_FRONT_LEFT);
			BACK_LEFT_MOTOR   = new BTTalon(BTConstants.MEC_BACK_LEFT);
			FRONT_RIGHT_MOTOR = new BTTalon(BTConstants.MEC_FRONT_RIGHT);
			BACK_RIGHT_MOTOR  = new BTTalon(BTConstants.MEC_BACK_RIGHT);	
		}
		else
		{
			FRONT_LEFT_MOTOR  = new BTTalonSRX(BTConstants.MEC_FRONT_LEFT);
			BACK_LEFT_MOTOR   = new BTTalonSRX(BTConstants.MEC_BACK_LEFT);
			FRONT_RIGHT_MOTOR = new BTTalonSRX(BTConstants.MEC_FRONT_RIGHT);
			BACK_RIGHT_MOTOR  = new BTTalonSRX(BTConstants.MEC_BACK_RIGHT);			
		}
	}
	
}
