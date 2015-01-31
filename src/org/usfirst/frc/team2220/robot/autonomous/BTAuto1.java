package org.usfirst.frc.team2220.robot.autonomous;

import org.usfirst.frc.team2220.robot.BTStorage;

public class BTAuto1 implements BTIAutonomousRoutine
{
	BTStorage storage;
	
	public BTAuto1(BTStorage storage)
	{
		this.storage = storage;
	}
	
	@Override
	public void runAutonomous()
	{
		moveBack();
	}
	
	public void moveBack()
	{
		long startTime = System.currentTimeMillis();
		while(System.currentTimeMillis() - startTime < 3000)
		{
			storage.data.FRONT_LEFT_MOTOR.setX(-0.9);
			storage.data.FRONT_RIGHT_MOTOR.setX(0.9);
			storage.data.BACK_LEFT_MOTOR.setX(0.9);
			storage.data.BACK_RIGHT_MOTOR.setX(-0.9);			
		}
	}

}
