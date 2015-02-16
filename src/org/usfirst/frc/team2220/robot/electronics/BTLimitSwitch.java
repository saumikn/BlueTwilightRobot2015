package org.usfirst.frc.team2220.robot.electronics;

import edu.wpi.first.wpilibj.DigitalInput;

public class BTLimitSwitch
{
	DigitalInput limitSwitch = null;
	
	public BTLimitSwitch(){}
	
	public BTLimitSwitch(int port)
	{
		if (port != -1)
		{
			limitSwitch = new DigitalInput(port);
		}
	}
	
	public boolean getValue()
	{
		if (limitSwitch != null)
		{
			return !limitSwitch.get();
		}
		return false;
	}
}
