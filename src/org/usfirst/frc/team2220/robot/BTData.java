package org.usfirst.frc.team2220.robot;

import org.usfirst.frc.team2220.robot.piston.BTPiston;

public class BTData
{
	public BTPiston DRIVETRAIN;
	
	public BTData()
	{
		DRIVETRAIN = new BTPiston(0,1);
	}
	
}
