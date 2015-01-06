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
	}

	@Override
	public void drive()
	{
		boolean extend = storage.data.DRIVETRAIN.isExtended();
		if(storage.xcon.getOctoSwitch().getLeadingEdge())
		{
			if(extend)
			{
				storage.data.DRIVETRAIN.retract();
			}
			else
			{
				storage.data.DRIVETRAIN.extend();
			}
		}
		
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
