package org.usfirst.frc.team2220.robot.robottype;

import org.usfirst.frc.team2220.robot.electronics.BTLimitSwitch;
import org.usfirst.frc.team2220.robot.electronics.BTPiston;
import org.usfirst.frc.team2220.robot.motor.BTTalon;

public class BTTestBot
{
	public BTPiston DRIVETRAIN_PISTON = new BTPiston(0,1);
	
	public BTTalon FRONT_LEFT_MOTOR = new BTTalon(0);
	public BTTalon FRONT_RIGHT_MOTOR = new BTTalon(1);
	public BTTalon BACK_LEFT_MOTOR = new BTTalon(2);
	public BTTalon BACK_RIGHT_MOTOR = new BTTalon(3);
	
	
	
}
