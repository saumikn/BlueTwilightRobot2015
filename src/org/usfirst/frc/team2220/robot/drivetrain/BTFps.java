package org.usfirst.frc.team2220.robot.drivetrain;

import org.usfirst.frc.team2220.robot.BTConstants;
import org.usfirst.frc.team2220.robot.BTStorage;

public class BTFps implements BTIDrivetrain
{
	private BTStorage storage;
	
	double frontBack = storage.controller.getDriveFrontBack().getValue();
	double rotate = storage.controller.getDriveRotate().getValue();
	
	public BTFps(BTStorage storage)
	{
		this.storage = storage;
	}
	
	@Override
	public void drive()
	{
		double fl = storage.controller.getLeftDriveFrontBack().getValue();
		double bl = storage.controller.getLeftDriveFrontBack().getValue();
		double fr = storage.controller.getRightDriveFrontBack().getValue();
		double br = storage.controller.getRightDriveFrontBack().getValue();
		
		storage.data.FRONT_LEFT_MOTOR.setX(fl);
		storage.data.FRONT_LEFT_MOTOR.setX(bl);
		storage.data.FRONT_LEFT_MOTOR.setX(fr);
		storage.data.FRONT_LEFT_MOTOR.setX(br);
	}
	
	public void setDeadzone()
	{
		if(frontBack < BTConstants.TANK_DEADZONE && frontBack > -BTConstants.TANK_DEADZONE)
		{
			frontBack = 0;
		}
		if(rotate < BTConstants.TANK_DEADZONE && frontBack > -BTConstants.TANK_DEADZONE)
		{
			rotate = 0;
		}
	}
}
