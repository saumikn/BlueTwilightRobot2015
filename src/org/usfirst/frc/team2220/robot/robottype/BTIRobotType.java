package org.usfirst.frc.team2220.robot.robottype;

import org.usfirst.frc.team2220.robot.electronics.BTCompressor;
import org.usfirst.frc.team2220.robot.electronics.BTEncoder;
import org.usfirst.frc.team2220.robot.electronics.BTGyro;
import org.usfirst.frc.team2220.robot.electronics.BTIPiston;
import org.usfirst.frc.team2220.robot.electronics.BTLimitSwitch;
import org.usfirst.frc.team2220.robot.motor.BTIMotor;

import edu.wpi.first.wpilibj.CANTalon;

public interface BTIRobotType
{
	public BTIMotor getFrontLeftMotor();
	public BTIMotor getFrontRightMotor();
	public BTIMotor getBackLeftMotor();
	public BTIMotor getBackRightMotor();
	
	public BTIMotor getLeftForkLeft();
	public BTIMotor getLeftForkRight();
	public BTIMotor getRightForkLeft();
	public BTIMotor getRightForkRight();

	public CANTalon getBarrelMotorLeft();
	public CANTalon getBarrelMotorRight();
	public BTIMotor getCollectorMotorLeft();
	public BTIMotor getCollectorMotorRight();
	
	public BTLimitSwitch getToteLimit();
	public BTLimitSwitch getLeftToteLowerLimit();
	public BTLimitSwitch getRightToteLowerLimit();
	public BTLimitSwitch getLeftToteMiddleLimit();
	public BTLimitSwitch getRightToteMiddleLimit();
	public BTLimitSwitch getLeftToteUpperLimit();
	public BTLimitSwitch getRightToteUpperLimit();
	public BTLimitSwitch getBarrelLowerLimit();
	public BTLimitSwitch getBarrelUpperLimit();
	
	public BTEncoder getFrontLeftEncoder();
	public BTEncoder getFrontRightEncoder();
	public BTEncoder getBackLeftEncoder();
	public BTEncoder getBackRightEncoder();
	
	public BTIPiston getToteClamp();
	public BTIPiston getBarrelHolder();
	public BTIPiston getDrivetrainSwitch();
	
	public BTGyro getGyro();
	
	public BTCompressor getCompressor();
}
