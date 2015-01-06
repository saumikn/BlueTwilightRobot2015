package org.usfirst.frc.team2220.robot;

import org.usfirst.frc.team2220.robot.motor.BTTalon;
import org.usfirst.frc.team2220.robot.piston.BTPiston;

public class BTData
{
	public BTTalon MOTOR_FL;
	public BTTalon MOTOR_FR;
	public BTTalon MOTOR_BL;
	public BTTalon MOTOR_BR;
	
	public BTPiston DRIVETRAIN;
	
	public BTData()
	{
		MOTOR_FL = new BTTalon(0);
		MOTOR_FR = new BTTalon(2);
		MOTOR_BL = new BTTalon(1);
		MOTOR_BR = new BTTalon(3);
		
		DRIVETRAIN = new BTPiston(0,1);
	}
	
}
