package org.usfirst.frc.team2220.robot.drivetrain;

import java.util.Arrays;

import org.usfirst.frc.team2220.robot.BTConstants;
import org.usfirst.frc.team2220.robot.BTStorage;

import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BTMeca implements BTIDrivetrain
{
	
	public BTStorage storage;
	
	public BTMeca(BTStorage storage)
	{
		this.storage = storage;
		//storage.data.DRIVETRAIN_PISTON.retract();
	}
		
	double strafe = 0.0;
	double forward = 0.0;
	double rotate = 0.0;
	double maxPower = 0.0;
	
	double encodeFR;
	double encodeFL;
	double encodeBL;
	double encodeBR;
	
	double flCurrent;
	double frCurrent;
	double blCurrent;
	double brCurrent;
	double maxCurrent;
	
	boolean isToteFront = true;
	boolean isTurbo = false;
	
	public double curve(double rawValue)
	{
		//Checks for and stores negative status of the input value, to be re-added at the end
		boolean isNegative = false;
		if (rawValue < 0)
			isNegative = true;
		rawValue = Math.abs(rawValue);
		
		final double DEADZONE_MAX_RANGE = BTConstants.DEADZONE_MAX_RANGE;
		final double SLOW_INCREASE_MAX_RANGE = BTConstants.SLOW_INCREASE_MAX_RANGE;	//Below this radius, accelerates slowly
		final double FAST_INCREASE_MAX_RANGE = BTConstants.FAST_INCREASE_MAX_RANGE;	//Below this radius, accelerates quickly
		final double GLOBAL_MAX_RANGE = BTConstants.GLOBAL_MAX_RANGE;				//Farthest that the joystick can be from center
		
		final double SLOW_INCREASE_MAX_SPEED = BTConstants.SLOW_INCREASE_MAX_SPEED;	//Speed at SLOW_INCREASE_MAX_RANGE
		final double FAST_INCREASE_MAX_SPEED = BTConstants.FAST_INCREASE_MAX_SPEED;	//Speed at FAST_INCREAST_MAX_RANGE
		final double GLOBAL_MAX_SPEED = BTConstants.GLOBAL_MAX_SPEED;				//Speed at GLOBAL_MAX_RANGE
		
		double result;
		
		//Range 1: Deadzone
		if (rawValue < DEADZONE_MAX_RANGE)
		{
			result = 0;
		}
		
		//If driver has activated turbo mode, full power immediately outside deadzone
		else if(isTurbo)
		{
			result = 1;
		}
		
		//Range 2: Slow increase zone
		else if (rawValue < SLOW_INCREASE_MAX_RANGE)
		{
			double rise = SLOW_INCREASE_MAX_SPEED;
			double run = SLOW_INCREASE_MAX_RANGE - DEADZONE_MAX_RANGE;
			double slope = rise / run;
			result = (rawValue - DEADZONE_MAX_RANGE) * slope;
		}
		
		//Range 3: Fast increase zone
		else if (rawValue < FAST_INCREASE_MAX_RANGE)
		{
			double rise = FAST_INCREASE_MAX_SPEED - SLOW_INCREASE_MAX_SPEED;
			double run = FAST_INCREASE_MAX_RANGE - SLOW_INCREASE_MAX_RANGE;
			double slope = rise / run;
			result = ((rawValue - SLOW_INCREASE_MAX_RANGE) * slope) + SLOW_INCREASE_MAX_SPEED;
		}
		
		//Range 4: Upper zone
		else
		{
			double rise = GLOBAL_MAX_SPEED - FAST_INCREASE_MAX_SPEED;
			double run = GLOBAL_MAX_RANGE - FAST_INCREASE_MAX_RANGE;
			double slope = rise / run;
			result = ((rawValue - FAST_INCREASE_MAX_RANGE) * slope) + FAST_INCREASE_MAX_SPEED;
		}
		
		if (isNegative)
			return -1 * result;
		return result;
	}
	
	@Override
	public void drive()
	{
		if(storage.controller.getTurboToggle().getLeadingEdge())
			isTurbo = !isTurbo;

		if(storage.controller.getDrivetrainOrientationSwitch().getLeadingEdge())
		{
			isToteFront = !isToteFront;
		}
		SmartDashboard.putBoolean("Is tote collector front", isToteFront);
		
		if(isToteFront)
		{
			// Strafe is the left/right dimension of the joystick. Moves the robot left or right without rotating.
			strafe = storage.controller.getDriveLeftRight().getValue();
			// Forward is the forward/back dimension of the joystick. Moves the robot forward and backward.
			forward = storage.controller.getDriveFrontBack().getValue();
			// Rotate is how much the robot should turn.
			rotate = -storage.controller.getDriveRotate().getValue();
		}
		else
		{
			// Strafe is the left/right dimension of the joystick. Moves the robot left or right without rotating.
			forward = storage.controller.getDriveLeftRight().getValue();
			// Forward is the forward/back dimension of the joystick. Moves the robot forward and backward.
			strafe = -storage.controller.getDriveFrontBack().getValue();
			// Rotate is how much the robot should turn.
			rotate = -storage.controller.getDriveRotate().getValue();
		}
		
		
		
		
		SmartDashboard.putNumber("Y Axis Input", forward);
		SmartDashboard.putNumber("X Axis Input", strafe);
		SmartDashboard.putNumber("Z Axis Input", rotate);
		
		// Curves the strafe, forward, and rotate values according to a piecewise function
		strafe = curve(strafe);
		forward = curve(forward);
		rotate = curve(rotate);
		
		SmartDashboard.putNumber("Curved Y Axis Input", forward);
		SmartDashboard.putNumber("Curved X Axis Input", strafe);
		SmartDashboard.putNumber("Curved Z Axis Input", rotate);
		
		//setDeadzone();
		
		double fl = strafe - forward - rotate;
		double bl = strafe + forward + rotate;
		double fr = strafe + forward - rotate;
		double br = strafe - forward + rotate;
				
		// Reverse front and back left motors
		
		if (BTConstants.FRONT_LEFT_REVERSED)
		{
			fl = -fl;
		}
		if (BTConstants.BACK_LEFT_REVERSED)
		{
			bl = -bl;
		}
		if (BTConstants.FRONT_RIGHT_REVERSED)
		{
			fr = -fr;
		}
		if (BTConstants.BACK_RIGHT_REVERSED)
		{
			br = -br;
		}
		
		// Get the maximum motor power, before scaling. If it's over 1, that will break the code.
		// We need to scale it down then, so if one motor is 2.0 and the rest are 1.0, the 2.0 will
		// be scaled to 1.0, the rest to 0.5.
		double max = Math.max(Math.abs(fr), Math.max(Math.abs(br), Math.max(Math.abs(fl), Math.abs(bl))));
		
		// Don't upscale so we can drive slowly
		if(max < 1)
		{
			max = 1;
		}

		// Scale the motor powers down so they are all <= 1.0
		fr = fr / max;
		br = br / max;
		fl = fl / max;
		bl = bl / max;
				
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
		
//		encodeFR = storage.robot.getRightEncoder().getValue();
//		encodeFL = storage.robot.getLeftEncoder().getValue();
//		encodeBL = storage.robot.getBackLeftEncoder().getValue();
//		encodeBR = storage.robot.getBackRightEncoder().getValue();
		
		SmartDashboard.putNumber("Front Right Encoder Reading", encodeFR);
		SmartDashboard.putNumber("Back Right Encoder Reading", encodeFL);
		SmartDashboard.putNumber("Front Left Encoder Reading", encodeBL);
		SmartDashboard.putNumber("Back Left Encoder Reading", encodeBR);

		//System.out.println(storage.data.FRONT_RIGHT_MOTOR == null);
		
		//double throttle = storage.controller.getDriveRotate().getValue();
		//SmartDashboard.putNumber("Throttle Rotator", throttle);
		
		
		
		//Set the motor powers
		
		SmartDashboard.putNumber("Front Right Motor Power Before", fr);
		SmartDashboard.putNumber("Back Right Motor Power Before", br);
		SmartDashboard.putNumber("Front Left Motor Power Before", fl);
		SmartDashboard.putNumber("Back Left Motor Power Before", bl);
				
		flCurrent = storage.robot.getFrontLeftMotor().getCurrent();
		frCurrent = storage.robot.getFrontRightMotor().getCurrent();
		blCurrent = storage.robot.getBackLeftMotor().getCurrent();
		brCurrent = storage.robot.getBackRightMotor().getCurrent();
				
		SmartDashboard.putNumber("Front Right Current Reading Before", frCurrent);
		SmartDashboard.putNumber("Back Right Current Reading Before", brCurrent);
		SmartDashboard.putNumber("Front Left Current Reading Before", flCurrent);
		SmartDashboard.putNumber("Back Left Current Reading Before", blCurrent);
		
//		maxCurrent = Math.max(Math.max(Math.max(flCurrent, frCurrent), blCurrent), brCurrent);
//		
//		flCurrent = flCurrent / maxCurrent;
//		frCurrent = frCurrent / maxCurrent;
//		blCurrent = blCurrent / maxCurrent;
//		brCurrent = brCurrent / maxCurrent;
		
		
		fl = fl * BTConstants.FRONT_LEFT_SCALE;
		fr = fr * BTConstants.FRONT_RIGHT_SCALE;
		bl = bl * BTConstants.BACK_LEFT_SCALE;
		br = br * BTConstants.BACK_RIGHT_SCALE;
		
		storage.robot.getFrontLeftMotor().setX(fl);
		storage.robot.getBackLeftMotor().setX(bl);
		storage.robot.getFrontRightMotor().setX(fr);
		storage.robot.getBackRightMotor().setX(br);
		
		SmartDashboard.putNumber("Front Right Current Reading", frCurrent);
		SmartDashboard.putNumber("Back Right Current Reading", brCurrent);
		SmartDashboard.putNumber("Front Left Current Reading", flCurrent);
		SmartDashboard.putNumber("Back Left Current Reading", blCurrent);

		SmartDashboard.putNumber("Front Right Motor Power", fr);
		SmartDashboard.putNumber("Back Right Motor Power", br);
		SmartDashboard.putNumber("Front Left Motor Power", fl);
		SmartDashboard.putNumber("Back Left Motor Power", bl);
	}
}
