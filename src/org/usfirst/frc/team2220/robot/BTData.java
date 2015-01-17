package org.usfirst.frc.team2220.robot;

import org.usfirst.frc.team2220.robot.motor.BTTalon;
import org.usfirst.frc.team2220.robot.piston.BTPiston;

public class BTData
{
	public BTPiston DRIVETRAIN_PISTON;
	public BTTalon FRONT_LEFT_MOTOR;
	public BTTalon FRONT_RIGHT_MOTOR;
	public BTTalon BACK_LEFT_MOTOR;
	public BTTalon BACK_RIGHT_MOTOR;
	
	
	public BTData()
	{
		DRIVETRAIN_PISTON = new BTPiston(0,1);
		FRONT_LEFT_MOTOR = new BTTalon(0);
		FRONT_LEFT_MOTOR = new BTTalon(1);
		FRONT_LEFT_MOTOR = new BTTalon(2);
		FRONT_LEFT_MOTOR = new BTTalon(3);		
	}
	
}
