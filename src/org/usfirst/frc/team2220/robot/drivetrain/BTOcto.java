package org.usfirst.frc.team2220.robot.drivetrain;

import org.usfirst.frc.team2220.robot.BTStorage;

public class BTOcto implements BTIDrivetrain
{
	public BTStorage storage;
	public BTMeca meca;
	//public BTTank tank;
	private boolean isExtended;
	
	
	public BTOcto(BTStorage storage)
	{
		this.storage = storage;
	}

	public void init()
	{
		meca = new BTMeca(storage);
		//tank = new BTTank(storage);
		storage.data.DRIVETRAIN_PISTON.retract();
		isExtended = true;		
	}
	
	@Override
	public void drive()
	{
//		toggleOcto();
		
		if(isExtended)
		{
			meca.drive();
		}
		else
		{
			//tank.drive();
		}
	}
	
//	public void toggleOcto()
//	{
//		if(storage.controller.getOctoSwitch().getLeadingEdge())
//		{
//			if(isExtended)
//			{
//				storage.data.DRIVETRAIN_PISTON.retract();
//				isExtended = false;				
//			}
//			else
//			{
//				storage.data.DRIVETRAIN_PISTON.extend();
//				isExtended = true;
//			}
//		}
//	}
}
