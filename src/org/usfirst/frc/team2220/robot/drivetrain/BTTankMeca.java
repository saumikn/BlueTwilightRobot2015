package org.usfirst.frc.team2220.robot.drivetrain;

import java.util.Arrays;

import org.usfirst.frc.team2220.robot.BTConstants;
import org.usfirst.frc.team2220.robot.BTStorage;

import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BTTankMeca implements BTIDrivetrain 
{
public BTStorage storage;
	
	public BTTankMeca(BTStorage storage)
	{
		this.storage = storage;
		//storage.data.DRIVETRAIN_PISTON.retract();
	}
		
	double left_joystick_front_back = 0;
	double left_joystick_left_right = 0;
	double right_joystick_front_back = 0;
	double right_joystick_left_right = 0;
	
	double front_left_motor = 0;
	double front_right_motor = 0;
	double back_left_motor = 0;
	double back_right_motor = 0;
	
	double encodeFR = 0;
	double encodeFL = 0;
	double encodeBL = 0;
	double encodeBR = 0;
	
	double flCurrent = 0;
	double frCurrent = 0;
	double blCurrent = 0;
	double brCurrent = 0;
	double maxCurrent = 0;
	
	boolean isToteFront = true;
	boolean isTurbo = false;

	@Override
	public void drive() 
	{
		
		left_joystick_front_back = storage.controller.getLeftJoystickFrontBack().getValue();
		left_joystick_left_right = storage.controller.getLeftJoystickLeftRight().getValue();
		right_joystick_front_back = storage.controller.getRightJoystickFrontBack().getValue();
		right_joystick_left_right = storage.controller.getRightJoystickLeftRight().getValue();
		
		if (Math.abs(left_joystick_front_back) > BTConstants.DEADZONE_MAX_RANGE)
		{
			front_left_motor = -BTConstants.MECANUM_SCALE_VALUE * left_joystick_front_back;
			back_left_motor = -BTConstants.MECANUM_SCALE_VALUE * left_joystick_front_back;
		}
		else if (Math.abs(left_joystick_left_right) > BTConstants.DEADZONE_MAX_RANGE)
		{
			front_left_motor = BTConstants.MECANUM_SCALE_VALUE * left_joystick_left_right;
			back_left_motor = -BTConstants.MECANUM_SCALE_VALUE * left_joystick_left_right;
		}
		else
		{
			front_left_motor = 0;
			back_left_motor = 0;
		}	
		
		if (Math.abs(right_joystick_front_back) > BTConstants.DEADZONE_MAX_RANGE)
		{
			front_right_motor = BTConstants.MECANUM_SCALE_VALUE * right_joystick_front_back;
			back_right_motor = BTConstants.MECANUM_SCALE_VALUE * right_joystick_front_back;
		}
		else if (Math.abs(right_joystick_left_right) > BTConstants.DEADZONE_MAX_RANGE)
		{
			front_right_motor = BTConstants.MECANUM_SCALE_VALUE * right_joystick_left_right;
			back_right_motor = -BTConstants.MECANUM_SCALE_VALUE * right_joystick_left_right;
		}
		else 
		{
			front_right_motor = 0;
			back_right_motor = 0;
		}
		
				
		// Reverse front and back left motors
		
//		if (BTConstants.FRONT_LEFT_REVERSED)
//		{
//			front_left_motor = -front_left_motor;
//		}
//		if (BTConstants.BACK_LEFT_REVERSED)
//		{
//			back_left_motor = -back_left_motor;
//		}
//		if (BTConstants.FRONT_RIGHT_REVERSED)
//		{
//			front_right_motor = -front_right_motor;
//		}
//		if (BTConstants.BACK_RIGHT_REVERSED)
//		{
//			back_right_motor = -back_right_motor;
//		}
		
//		// Get the maximum motor power, before scaling. If it's over 1, that will break the code.
//		// We need to scale it down then, so if one motor is 2.0 and the rest are 1.0, the 2.0 will
//		// be scaled to 1.0, the rest to 0.5.
//		double max = Math.max(Math.abs(front_right_motor), Math.max(Math.abs(back_right_motor), Math.max(Math.abs(front_left_motor), Math.abs(back_left_motor))));
//		
//		// Don't upscale so we can drive slowly
//		if(max < 1)
//		{
//			max = 1;
//		}
//
//		// Scale the motor powers down so they are all <= 1.0
//		front_right_motor = front_right_motor / max;
//		back_right_motor = back_right_motor / max;
//		front_left_motor = front_left_motor / max;
//		back_left_motor = back_left_motor / max;
				
//		//If no value for top throttle (i.e. not using flight stick), sets to default value for max power
//		if (storage.controller.getTopThrottle() == null)
//		{
//			maxPower = BTConstants.MECANUM_SCALE_VALUE;
//		}
		
//		//If top throttle exists, set max power to top throttle value
//		else
//		{
//			double topThrottle = (storage.controller.getTopThrottle().getValue() + 1.0);
//			topThrottle = Math.max(BTConstants.TOP_THROTTLE_MIN, topThrottle);
//			maxPower =  topThrottle / 2.0;
//		}
//		
//		// Scale to the mecanum value, i.e. if we want to run at half power
//		fr = fr * maxPower;
//		br = br * maxPower;
//		fl = fl * maxPower;
//		bl = bl * maxPower;
		
		encodeFR = storage.robot.getFrontRightEncoder().getValue();
		encodeFL = storage.robot.getFrontLeftEncoder().getValue();
		encodeBL = storage.robot.getBackLeftEncoder().getValue();
		encodeBR = storage.robot.getBackRightEncoder().getValue();
		
//		SmartDashboard.putNumber("Front Right Encoder Reading", encodeFR);
//		SmartDashboard.putNumber("Back Right Encoder Reading", encodeFL);
//		SmartDashboard.putNumber("Front Left Encoder Reading", encodeBL);
//		SmartDashboard.putNumber("Back Left Encoder Reading", encodeBR);

		//System.out.println(storage.data.FRONT_RIGHT_MOTOR == null);
		
		//double throttle = storage.controller.getDriveRotate().getValue();
		//SmartDashboard.putNumber("Throttle Rotator", throttle);
		
		
		
		//Set the motor powers
		
//		SmartDashboard.putNumber("Front Right Motor Power Before", front_right_motor);
//		SmartDashboard.putNumber("Back Right Motor Power Before", back_right_motor);
//		SmartDashboard.putNumber("Front Left Motor Power Before", front_left_motor);
//		SmartDashboard.putNumber("Back Left Motor Power Before", back_left_motor);
				
		flCurrent = storage.robot.getFrontLeftMotor().getCurrent();
		frCurrent = storage.robot.getFrontRightMotor().getCurrent();
		blCurrent = storage.robot.getBackLeftMotor().getCurrent();
		brCurrent = storage.robot.getBackRightMotor().getCurrent();
				
//		SmartDashboard.putNumber("Front Right Current Reading Before", frCurrent);
//		SmartDashboard.putNumber("Back Right Current Reading Before", brCurrent);
//		SmartDashboard.putNumber("Front Left Current Reading Before", flCurrent);
//		SmartDashboard.putNumber("Back Left Current Reading Before", blCurrent);
		
//		maxCurrent = Math.max(Math.max(Math.max(flCurrent, frCurrent), blCurrent), brCurrent);
//		
//		flCurrent = flCurrent / maxCurrent;
//		frCurrent = frCurrent / maxCurrent;
//		blCurrent = blCurrent / maxCurrent;
//		brCurrent = brCurrent / maxCurrent;
		
		
		front_left_motor = front_left_motor * BTConstants.FRONT_LEFT_SCALE;
		front_right_motor = front_right_motor * BTConstants.FRONT_RIGHT_SCALE;
		back_left_motor = back_left_motor * BTConstants.BACK_LEFT_SCALE;
		back_right_motor = back_right_motor * BTConstants.BACK_RIGHT_SCALE;
		
		storage.robot.getFrontLeftMotor().setX(front_left_motor);
		storage.robot.getBackLeftMotor().setX(back_left_motor);
		storage.robot.getFrontRightMotor().setX(front_right_motor);
		storage.robot.getBackRightMotor().setX(back_right_motor);
		
//		SmartDashboard.putNumber("Front Right Current Reading", frCurrent);
//		SmartDashboard.putNumber("Back Right Current Reading", brCurrent);
//		SmartDashboard.putNumber("Front Left Current Reading", flCurrent);
//		SmartDashboard.putNumber("Back Left Current Reading", blCurrent);

//		SmartDashboard.putNumber("Front Right Motor Power", front_right_motor);
//		SmartDashboard.putNumber("Back Right Motor Power", back_right_motor);
//		SmartDashboard.putNumber("Front Left Motor Power", front_left_motor);
//		SmartDashboard.putNumber("Back Left Motor Power", back_left_motor);
	}

}
