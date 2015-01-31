package org.usfirst.frc.team2220.robot.robottype;

import org.usfirst.frc.team2220.robot.BTConstants;
import org.usfirst.frc.team2220.robot.electronics.BTEncoder;
import org.usfirst.frc.team2220.robot.electronics.BTLimitSwitch;
import org.usfirst.frc.team2220.robot.motor.BTTalonSRX;
import org.usfirst.frc.team2220.robot.electronics.BTPiston;

public class BTCompetitionRobot
{
	public BTTalonSRX FRONT_LEFT_MOTOR = new BTTalonSRX(BTConstants.COMPETITION_FRONT_LEFT_MOTOR);
	public BTTalonSRX FRONT_RIGHT_MOTOR = new BTTalonSRX(BTConstants.COMPETITION_FRONT_RIGHT_MOTOR);
	public BTTalonSRX BACK_LEFT_MOTOR = new BTTalonSRX(BTConstants.COMPETITION_BACK_LEFT_MOTOR);
	public BTTalonSRX BACK_RIGHT_MOTOR = new BTTalonSRX(BTConstants.COMPETITION_BACK_RIGHT_MOTOR);
	
	
	public BTLimitSwitch TOTE_SWTICH = new BTLimitSwitch(BTConstants.COMPETITION_TOTE_SWITCH); //
	public BTLimitSwitch LOW_LIMIT = new BTLimitSwitch(BTConstants.COMPETITION_LOW_SWITCH); //
	public BTLimitSwitch MIDDLE_LIMIT = new BTLimitSwitch(BTConstants.COMPETITION_MIDDLE_SWITCH); //
	public BTLimitSwitch UPPER_LIMIT = new BTLimitSwitch(BTConstants.COMPETITION_UPPER_SWITCH); // 
	public BTLimitSwitch LIMIT_SWITCH = new BTLimitSwitch(BTConstants.COMPETITION_LIMIT_SWITCH);
	
	public BTEncoder FRONT_RIGHT_ENCODER = new BTEncoder(BTConstants.COMPETITION_FRONT_RIGHT_ENCODER_A,BTConstants.COMPETITION_FRONT_RIGHT_ENCODER_B);
	public BTEncoder FRONT_LEFT_ENCODER = new BTEncoder(BTConstants.COMPETITION_FRONT_LEFT_ENCODER_A,BTConstants.COMPETITION_FRONT_LEFT_ENCODER_B);
	public BTEncoder BACK_RIGHT_ENCODER = new BTEncoder(BTConstants.COMPETITION_BACK_RIGHT_ENCODER_A,BTConstants.COMPETITION_BACK_RIGHT_ENCODER_B);
	public BTEncoder BACK_LEFT_ENCODER = new BTEncoder(BTConstants.COMPETITION_BACK_LEFT_ENCODER_A,BTConstants.COMPETITION_BACK_LEFT_ENCODER_B);
	
	public BTTalonSRX FORK_MOTOR = new BTTalonSRX(BTConstants.COMPETITION_FORK_MOTOR);
	public BTTalonSRX COLLECTOR_MOTOR_LEFT = new BTTalonSRX(BTConstants.COMPETITION_COLLECTOR_MOTOR_LEFT);
	public BTTalonSRX COLLECTOR_MOTOR_RIGHT = new BTTalonSRX(BTConstants.COMPETITION_COLLECTOR_MOTOR_RIGHT);
	
	public BTPiston TOTE_HOLDER = new BTPiston(BTConstants.COMPETITION_TOTE_HOLDER_PISTON_EXTEND, BTConstants.COMPETITION_TOTE_HOLDER_PISTON_RETRACT);
}
