package org.usfirst.frc.team2220.robot.robottype;

import org.usfirst.frc.team2220.robot.electronics.BTEncoder;
import org.usfirst.frc.team2220.robot.electronics.BTLimitSwitch;
import org.usfirst.frc.team2220.robot.motor.BTTalonSRX;

public class BTCompetitionRobot
{
	public BTTalonSRX FRONT_LEFT_MOTOR = new BTTalonSRX(0);
	public BTTalonSRX FRONT_RIGHT_MOTOR = new BTTalonSRX(1);
	public BTTalonSRX BACK_LEFT_MOTOR = new BTTalonSRX(2);
	public BTTalonSRX BACK_RIGHT_MOTOR = new BTTalonSRX(3);
	
	
	public BTLimitSwitch TOTE_SWTICH; //
	public BTLimitSwitch LOW_LIMIT; //
	public BTLimitSwitch MEDIUM_LIMIT; //
	public BTLimitSwitch UPPER_LIMIT; // 
	
	public BTLimitSwitch LIMIT_SWITCH = new BTLimitSwitch(9);
	
	public BTEncoder FRONT_RIGHT_ENCODER = new BTEncoder(0,1);
	public BTEncoder FRONT_LEFT_ENCODER = new BTEncoder(2,3);
	public BTEncoder BACK_RIGHT_ENCODER = new BTEncoder(4,5);
	public BTEncoder BACK_LEFT_ENCODER = new BTEncoder(6,7);
}
