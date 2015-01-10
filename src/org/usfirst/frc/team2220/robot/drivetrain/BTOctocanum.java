package org.usfirst.frc.team2220.robot.drivetrain;

import org.usfirst.frc.team2220.robot.BTStorage;

public class BTOctocanum implements BTIDrivetrain
{
	public BTStorage storage;
	
	private BTMecanum meca;
	private BTTank tank;
	
	private boolean extended;
	
	public BTOctocanum(BTStorage storage)
	{
		this.storage = storage;
		meca = new BTMecanum(storage);
		tank = new BTTank(storage);
		extended = false;
	}

	@Override
	public void drive()
	{
//		boolean extend = storage.data.DRIVETRAIN.isExtended();
		if(storage.con.getOctoSwitch().getLeadingEdge())
		{
			System.out.println("Extended = " + extended);
			if(extended)
			{
				System.out.println("Extended was true");
				storage.data.DRIVETRAIN.retract();
				extended = false;
			}
			else
			{
				System.out.println("Extended was true");
				storage.data.DRIVETRAIN.extend();
				extended = true;
			}
		}
		
		if(extended)
		{
			meca.drive();
		}
		else
		{
			tank.drive();
		}
		
		
	}
	
	
	
}
