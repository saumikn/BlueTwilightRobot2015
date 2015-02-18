package org.usfirst.frc.team2220.robot;

import org.usfirst.frc.team2220.robot.electronics.BTEncoder;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BTTestClass
{
	public BTStorage storage;
	
	public BTTestClass(BTStorage storage)
	{
		this.storage = storage;

	}
	
	
	public void test()
	{
		SmartDashboard.putNumber("GyroAngle", storage.robot.getGyro().getAngle());
	}
}
