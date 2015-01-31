package org.usfirst.frc.team2220.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BTTestClass
{
	BTStorage storage;
	
	public BTTestClass(BTStorage storage)
	{
		this.storage = storage;
	}
	
	public void test()
	{
		boolean button = storage.controller.getToteRelease().getContinuousEdge();
		SmartDashboard.putBoolean("A Button", button);
		if(button)
		{
			storage.data.FRONT_LEFT_MOTOR.setX(0.9);
			storage.data.FRONT_RIGHT_MOTOR.setX(0.9);
			storage.data.BACK_LEFT_MOTOR.setX(0.9);
			storage.data.BACK_RIGHT_MOTOR.setX(0.9);
		}
	}
}
