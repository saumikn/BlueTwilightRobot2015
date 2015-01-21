package org.usfirst.frc.team2220.robot;

import org.usfirst.frc.team2220.robot.motor.BTTalon;

public class BTData
{
	public BTTalon FRONT_LEFT_MOTOR;
	public BTTalon FRONT_RIGHT_MOTOR;
	public BTTalon BACK_LEFT_MOTOR;
	public BTTalon BACK_RIGHT_MOTOR;
	
	public BTData()
	{
		FRONT_LEFT_MOTOR = new BTTalon(BTConstants.MEC_FRONT_LEFT);
		BACK_LEFT_MOTOR = new BTTalon(BTConstants.MEC_BACK_LEFT);
		FRONT_RIGHT_MOTOR = new BTTalon(BTConstants.MEC_FRONT_RIGHT);
		BACK_RIGHT_MOTOR = new BTTalon(BTConstants.MEC_BACK_RIGHT);		
	}
	
}
