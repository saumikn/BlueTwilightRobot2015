package org.usfirst.frc.team2220.robot.drivetrain;

import org.usfirst.frc.team2220.robot.BTConstants;
import org.usfirst.frc.team2220.robot.BTStorage;

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
		
		fr = -fr;
		br = -br;
		
		double max = Math.max(Math.abs(fr), Math.max(Math.abs(br), Math.max(Math.abs(fl), Math.abs(bl))));
		
		if(max < 1)
			max = 1;
		
		if(max != 0)
		{
			fr = fr / max;
			br = br / max;
			fl = fl / max;
			bl = bl / max;
		}
		
		fr = fr * BTConstants.MECANUM_SCALE_VALUE;
		br = br * BTConstants.MECANUM_SCALE_VALUE;
		fl = fl * BTConstants.MECANUM_SCALE_VALUE;
		bl = bl * BTConstants.MECANUM_SCALE_VALUE;
		
		storage.data.FRONT_RIGHT_MOTOR.setX(fr);
		storage.data.BACK_RIGHT_MOTOR.setX(br);
		storage.data.FRONT_LEFT_MOTOR.setX(fl);
		storage.data.BACK_LEFT_MOTOR.setX(bl);
		
		storage.data.FRONT_RIGHT_MOTOR.setX(.2);
		storage.data.BACK_RIGHT_MOTOR.setX(.2);
		storage.data.FRONT_LEFT_MOTOR.setX(.2);
		storage.data.BACK_LEFT_MOTOR.setX(.2);
		
	}

}
