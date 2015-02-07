package org.usfirst.frc.team2220.robot.electronics;

import edu.wpi.first.wpilibj.DigitalInput;

public class BTLimitSwitch
{
	DigitalInput limitSwitch;
	
	public BTLimitSwitch(){}
	
	public BTLimitSwitch(int port)
	{
		limitSwitch = new DigitalInput(port);
	}
	
	public boolean getValue()
	{
		return limitSwitch.get();
	}
}
