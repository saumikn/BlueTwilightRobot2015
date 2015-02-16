package org.usfirst.frc.team2220.robot;

import org.usfirst.frc.team2220.robot.electronics.BTEncoder;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BTTestClass
{
	
	boolean barrelButton;
	
	Solenoid a = new Solenoid(0);
	Solenoid b = new Solenoid(1);
	
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
		if(storage.controller.getBarrelCollect().getLeadingEdge())
		{
			if(a.get())
			{
				a.set(false);
				b.set(true);
			}
			else
			{
				a.set(true);
				b.set(false);
			}
		}
		
		
		
		
//		SmartDashboard.putNumber("aaasd", storage.robot.getFrontLeftEncoder().getValue() / 256.);
//		barrelUp = storage.controller.getBarrelCollect().getButtonValue();
//		barrelDown = storage.controller.getBarrelCollectDown().getButtonValue();
//
//		toteUp = storage.controller.getToteCollect().getButtonValue();
//		toteDown = storage.controller.getToteCollectDown().getButtonValue();
//
//		SmartDashboard.putBoolean("Test", toteUp);
//		
//		if(barrelUp)
//		{
//			storage.robot.getBarrelMotorLeft().set(-.9);
//			storage.robot.getBarrelMotorRight().set(.9);
//		}
//		else if(barrelDown)
//		{
//			storage.robot.getBarrelMotorLeft().set(.9);
//			storage.robot.getBarrelMotorRight().set(.9);
//		}
//		else
//		{
//			storage.robot.getBarrelMotorLeft().set(0);
//			storage.robot.getBarrelMotorRight().set(0);
//		}
//		
//		if(toteUp)
//		{
//			storage.robot.getLeftForkLeft().setX(.5);
//			storage.robot.getLeftForkRight().setX(-.5);
//			storage.robot.getRightForkLeft().setX(-.5);
//			storage.robot.getRightForkRight().setX(.5);			
//		}
//		else if(toteDown)
//		{
//			storage.robot.getLeftForkLeft().setX(-.5);
//			storage.robot.getLeftForkRight().setX(.5);
//			storage.robot.getRightForkLeft().setX(.5);
//			storage.robot.getRightForkRight().setX(-.5);
//		}
//		else
//		{
//			storage.robot.getLeftForkLeft().setX(0);
//			storage.robot.getLeftForkRight().setX(0);
//			storage.robot.getRightForkLeft().setX(0);
//			storage.robot.getRightForkRight().setX(0);
//		}
		
		
		
	}
}
