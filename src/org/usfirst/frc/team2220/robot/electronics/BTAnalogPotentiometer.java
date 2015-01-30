package org.usfirst.frc.team2220.robot.electronics;

import edu.wpi.first.wpilibj.AnalogPotentiometer;

public class BTAnalogPotentiometer
{
	AnalogPotentiometer analogPotentiometer;
	
	public BTAnalogPotentiometer(int port)
	{
		analogPotentiometer = new AnalogPotentiometer(port);
	}
	
	public double getValue()
	{
		return analogPotentiometer.get();
	}
}
