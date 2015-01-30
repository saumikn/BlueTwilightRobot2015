package org.usfirst.frc.team2220.robot.electronics;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Encoder;

public class BTEncoder
{
	private final Encoder encoder;
	
	public BTEncoder(int port1, int port2)
	{
		encoder = new Encoder(port1, port2);
	}
	
	public double getValue()
	{
		return encoder.get();
	}
	
	public void reset()
	{
		encoder.reset();
	}
	
	public void setPulse(double distance)
	{
		encoder.setDistancePerPulse(distance);
	}
	
	public double getDistance()
	{
		return encoder.getDistance();
	}
	

}
