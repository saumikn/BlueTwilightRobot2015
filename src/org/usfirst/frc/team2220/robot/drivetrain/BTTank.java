package org.usfirst.frc.team2220.robot.drivetrain;

import org.usfirst.frc.team2220.robot.BTStorage;

public class BTTank implements BTIDrivetrain
{
	private BTStorage storage;
	
	public BTTank(BTStorage storage)
	{
		this.storage = storage;
	}
	
	@Override
	public void drive()
	{
		storage.data.MOTOR_FL.setX(storage.xcon.getLeftDriveFrontBack().getValue());
        storage.data.MOTOR_FR.setX(storage.xcon.getRightDriveFrontBack().getValue());
        storage.data.MOTOR_BL.setX(storage.xcon.getLeftDriveFrontBack().getValue());
        storage.data.MOTOR_BR.setX(storage.xcon.getRightDriveFrontBack().getValue());
		
	}

}
