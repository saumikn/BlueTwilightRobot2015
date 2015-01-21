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
	}
		
	double strafe = 0.0;
	double forward = 0.0;
	double rotate = 0.0;
	
	/**
	 * Applies the deadzone to the input axis
	 */
	public void setDeadzone()
	{
		if(strafe < BTConstants.MECANUM_DEADZONE && strafe > -BTConstants.MECANUM_DEADZONE)
		{
			strafe = 0;
		}
		if(forward < BTConstants.MECANUM_DEADZONE && forward > -BTConstants.MECANUM_DEADZONE)
		{
			forward = 0;
		}
		if(rotate < BTConstants.MECANUM_DEADZONE && rotate > -BTConstants.MECANUM_DEADZONE)
		{
			rotate = 0;
		}
	}

	@Override
	public void drive()
	{
		// Strafe is the left/right dimension of the joystick. Moves the robot left or right without rotating.
		strafe = storage.controller.getDriveLeftRight().getValue();
		// Forward is the forward/back dimension of the joystick. Moves the robot forward and backward.
		forward = storage.controller.getDriveFrontBack().getValue();
		// Rotate is how much the robot should turn.
		rotate = storage.controller.getDriveRotate().getValue();
		
		setDeadzone();
		
		double fr = strafe - forward + rotate;
		double br = strafe + forward + rotate;
		double fl = strafe + forward - rotate;
		double bl = strafe - forward - rotate;
		
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
		
		// Scale to the mecanum value, i.e. if we want to run at half power
		fr = fr * BTConstants.MECANUM_SCALE_VALUE;
		br = br * BTConstants.MECANUM_SCALE_VALUE;
		fl = fl * BTConstants.MECANUM_SCALE_VALUE;
		bl = bl * BTConstants.MECANUM_SCALE_VALUE;
		

		//System.out.println(storage.data.FRONT_RIGHT_MOTOR == null);
		SmartDashboard.putNumber("Y Axis Input", forward);
		SmartDashboard.putNumber("X Axis Input", strafe);
		SmartDashboard.putNumber("Z Axis Input", rotate);
		
		SmartDashboard.putNumber("Front Right Motor Power", fr);
		SmartDashboard.putNumber("Back Right Motor Power", br);
		SmartDashboard.putNumber("Front Left Motor Power", fl);
		SmartDashboard.putNumber("Back Left Motor Power", bl);
		
		//Set the motor powers
		storage.data.FRONT_RIGHT_MOTOR.setX(fr);
		storage.data.BACK_RIGHT_MOTOR.setX(br);
		storage.data.FRONT_LEFT_MOTOR.setX(fl);
		storage.data.BACK_LEFT_MOTOR.setX(bl);
		
		// test code for something
//		storage.data.FRONT_RIGHT_MOTOR.setX(.2);
//		storage.data.BACK_RIGHT_MOTOR.setX(.2);
//		storage.data.FRONT_LEFT_MOTOR.setX(.2);
//		storage.data.BACK_LEFT_MOTOR.setX(.2);
//		
	}

}
