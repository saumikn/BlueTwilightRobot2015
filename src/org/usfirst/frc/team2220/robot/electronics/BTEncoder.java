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
	

}
