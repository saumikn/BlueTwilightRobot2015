package org.usfirst.frc.team2220.robot;

public class BTTestClass
{
	BTStorage storage;
	
	public BTTestClass(BTStorage storage)
	{
		this.storage = storage;
	}
	
	public void test()
	{
		if(storage.controller.getToteRelease().getButtonValue())
		{
			storage.data.FRONT_LEFT_MOTOR.setX(0.9);
			storage.data.FRONT_RIGHT_MOTOR.setX(0.9);
			storage.data.BACK_LEFT_MOTOR.setX(0.9);
			storage.data.BACK_RIGHT_MOTOR.setX(0.9);
		}
	}
}
