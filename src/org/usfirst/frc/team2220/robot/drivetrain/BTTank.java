package org.usfirst.frc.team2220.robot.drivetrain;

import org.usfirst.frc.team2220.robot.BTConstants;
import org.usfirst.frc.team2220.robot.BTStorage;

public class BTTank implements BTIDrivetrain
{
	private BTStorage storage;
	
	double left = storage.controller.getLeftDriveFrontBack().getValue();
	double right = storage.controller.getRightDriveFrontBack().getValue();
		
	public BTTank(BTStorage storage)
	{
		this.storage = storage;
	}
	
	@Override
	public void drive()
	{
		setDeadzone();
		
		storage.data.FRONT_LEFT_MOTOR.setX(left);
		storage.data.FRONT_LEFT_MOTOR.setX(left);
		storage.data.FRONT_LEFT_MOTOR.setX(right);
		storage.data.FRONT_LEFT_MOTOR.setX(right);
	}
	
	public void setDeadzone()
	{
		if(left < BTConstants.TANK_DEADZONE && left > -BTConstants.TANK_DEADZONE)
		{
			left = 0;
		}
		if(right < BTConstants.TANK_DEADZONE && right > -BTConstants.TANK_DEADZONE)
		{
			right = 0;
		}
	}
}
