package org.usfirst.frc.team2220.robot.drivetrain;

import org.usfirst.frc.team2220.robot.BTStorage;

public class BTOctocanum implements BTIDrivetrain
{
	public BTStorage storage;
	
	private BTMecanum meca;
	private BTTank tank;
	
	public BTOctocanum(BTStorage storage)
	{
		this.storage = storage;
		meca = new BTMecanum(storage);
		tank = new BTTank(storage);
	}

	@Override
	public void drive()
	{
		boolean extend = storage.data.DRIVETRAIN.isExtended();
		if(storage.xcon.getOctoSwitch().getValue())
		{
			if(extend)
			{
				storage.data.DRIVETRAIN.retract();
				System.out.println("DID RETRACT");
			}
			else
			{
				storage.data.DRIVETRAIN.extend();
				System.out.println("DID EXTEND");
			}
			System.out.println(extend);
		}
		System.out.println("THIS IS A PRINT");
		if(extend)
		{
			meca.drive();
		}
		else
		{
			tank.drive();
		}
		
		
	}
	
	
	
}
