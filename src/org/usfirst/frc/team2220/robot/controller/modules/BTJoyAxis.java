package org.usfirst.frc.team2220.robot.controller.modules;

import edu.wpi.first.wpilibj.Joystick;

public class BTJoyAxis implements BTIConAxis
{
	private final Joystick joy;
	private final int port;
	
	public BTJoyAxis(Joystick joy, int port)
	{
		this.joy = joy;
		this.port = port;
	}

	@Override
	public double getValue()
	{
		return joy.getRawAxis(port);
	}

}
