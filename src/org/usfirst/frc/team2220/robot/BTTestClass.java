package org.usfirst.frc.team2220.robot;

import org.usfirst.frc.team2220.robot.electronics.BTEncoder;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BTTestClass
{
	public BTStorage storage;

	boolean barrelUp;
	boolean barrelDown;
	
	boolean toteUp;
	boolean toteDown;
	
	public BTTestClass(BTStorage storage)
	{
		this.storage = storage;

	}
	
	
	public void test()
	{
		SmartDashboard.putNumber("aaasd", storage.robot.getFrontLeftEncoder().getValue() / 256.);
		barrelUp = storage.controller.getBarrelCollect().getButtonValue();
		barrelDown = storage.controller.getBarrelCollectDown().getButtonValue();

		toteUp = storage.controller.getToteCollect().getButtonValue();
		toteDown = storage.controller.getToteCollectDown().getButtonValue();

		SmartDashboard.putBoolean("Test", toteUp);
		
		if(barrelUp)
		{
			storage.robot.getBarrelMotorLeft().setX(-.9);
			storage.robot.getBarrelMotorRight().setX(.9);
		}
		else if(barrelDown)
		{
			storage.robot.getBarrelMotorLeft().setX(.9);
			storage.robot.getBarrelMotorRight().setX(.9);
		}
		else
		{
			storage.robot.getBarrelMotorLeft().setX(0);
			storage.robot.getBarrelMotorRight().setX(0);
		}
		
		if(toteUp)
		{
			storage.robot.getLeftForkLeft().setX(.5);
			storage.robot.getLeftForkRight().setX(-.5);
			storage.robot.getRightForkLeft().setX(-.5);
			storage.robot.getRightForkRight().setX(.5);			
		}
		else if(toteDown)
		{
			storage.robot.getLeftForkLeft().setX(-.5);
			storage.robot.getLeftForkRight().setX(.5);
			storage.robot.getRightForkLeft().setX(.5);
			storage.robot.getRightForkRight().setX(-.5);
		}
		else
		{
			storage.robot.getLeftForkLeft().setX(0);
			storage.robot.getLeftForkRight().setX(0);
			storage.robot.getRightForkLeft().setX(0);
			storage.robot.getRightForkRight().setX(0);
		}
		
	}
}
