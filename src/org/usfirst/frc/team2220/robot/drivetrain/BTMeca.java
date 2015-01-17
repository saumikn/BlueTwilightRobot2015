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
		
	double xAxis = storage.controller.getDriveLeftRight().getValue();
	double yAxis = storage.controller.getDriveFrontBack().getValue();
	double zAxis = storage.controller.getDriveRotate().getValue();
	
	
	
	public void setDeadzone()
	{
		if(xAxis < BTConstants.MECANUM_DEADZONE && xAxis > -BTConstants.MECANUM_DEADZONE)
		{
			xAxis = 0;
		}
		if(yAxis < BTConstants.MECANUM_DEADZONE && yAxis > -BTConstants.MECANUM_DEADZONE)
		{
			yAxis = 0;
		}
		if(zAxis < BTConstants.MECANUM_DEADZONE && zAxis > -BTConstants.MECANUM_DEADZONE)
		{
			zAxis = 0;
		}
	}

	@Override
	public void drive()
	{
		setDeadzone();
		
		double fr = xAxis - yAxis + zAxis;
		double br = xAxis + yAxis + zAxis;
		double fl = xAxis + yAxis - zAxis;
		double bl = xAxis - yAxis - zAxis;
		
		fr = -fr;
		br = -br;
		
		double max = Math.max(Math.abs(fr), Math.max(Math.abs(br),Math.max(Math.abs(fl), Math.abs(bl))));
		
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
