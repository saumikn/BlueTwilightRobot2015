package org.usfirst.frc.team2220.robot;

import org.usfirst.frc.team2220.robot.controller.modules.BTJoyAxis;
import org.usfirst.frc.team2220.robot.controller.modules.BTJoyButton;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BTTestClass
{
	BTStorage storage;
	boolean button1;
	boolean button2;
	
	public BTTestClass(BTStorage storage)
	{
		this.storage = storage;
	}
	
	public void test()
	{
		button1 = storage.controller.getToteRelease().getButtonValue();
		
		SmartDashboard.putBoolean("Button 1", button1);
		if(button1)
		{
			storage.data.FRONT_LEFT_MOTOR.setX(0.2);
			storage.data.FRONT_RIGHT_MOTOR.setX(0.2);
			storage.data.BACK_LEFT_MOTOR.setX(0.2);
			storage.data.BACK_RIGHT_MOTOR.setX(0.2);
		}
		else
		{
			storage.data.FRONT_LEFT_MOTOR.setX(0);
			storage.data.FRONT_RIGHT_MOTOR.setX(0);
			storage.data.BACK_LEFT_MOTOR.setX(0);
			storage.data.BACK_RIGHT_MOTOR.setX(0);	
		}
		
		button2 = storage.controller.getToteCollect().getButtonValue();
		
		SmartDashboard.putBoolean("Button 2", button2);
		if(button2)
		{
			storage.data.FRONT_LEFT_MOTOR.setX(0.9);
			storage.data.FRONT_RIGHT_MOTOR.setX(0.9);
			storage.data.BACK_LEFT_MOTOR.setX(0.9);
			storage.data.BACK_RIGHT_MOTOR.setX(0.9);
		}
		else
		{
			storage.data.FRONT_LEFT_MOTOR.setX(0);
			storage.data.FRONT_RIGHT_MOTOR.setX(0);
			storage.data.BACK_LEFT_MOTOR.setX(0);
			storage.data.BACK_RIGHT_MOTOR.setX(0);	
		}
	}
}
