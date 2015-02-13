package org.usfirst.frc.team2220.robot.robottype;

import org.usfirst.frc.team2220.robot.electronics.BTGyro;
import org.usfirst.frc.team2220.robot.electronics.BTLimitSwitch;
import org.usfirst.frc.team2220.robot.electronics.BTDoublePiston;
import org.usfirst.frc.team2220.robot.motor.BTTalon;

public class BTTestBot
{
	public BTDoublePiston DRIVETRAIN_PISTON = new BTDoublePiston(0,1);
	
	public BTTalon FRONT_LEFT_MOTOR = new BTTalon(0);
	public BTTalon FRONT_RIGHT_MOTOR = new BTTalon(1);
	public BTTalon BACK_LEFT_MOTOR = new BTTalon(2);
	public BTTalon BACK_RIGHT_MOTOR = new BTTalon(3);
	
	public BTGyro GYRO = new BTGyro();
	
	public BTLimitSwitch TOTE_LIMIT = new BTLimitSwitch();
	public BTLimitSwitch LOW_LIMIT = new BTLimitSwitch();
	
}
