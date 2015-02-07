package org.usfirst.frc.team2220.robot;

import org.usfirst.frc.team2220.robot.controller.modules.BTJoyAxis;
import org.usfirst.frc.team2220.robot.controller.modules.BTJoyButton;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BTTestClass
{
	public BTStorage storage;
	
	double angle;
	boolean limit1;
	boolean limit2;
	
	public BTTestClass(BTStorage storage)
	{
		this.storage = storage;
		storage.data.GYRO.reset();
	}
	
	public void test()
	{
		angle = storage.data.GYRO.getAngle();
		limit1 = storage.data.TOTE_LIMIT.getValue();
		limit2 = storage.data.LOW_LIMIT.getValue();
		//storage.data.GYRO.reset();
		SmartDashboard.putNumber("Angle", angle);
		SmartDashboard.putBoolean("Limit 1", limit1);
		SmartDashboard.putBoolean("Limit 2", limit2);
		
		
	}
}
