package org.usfirst.frc.team2220.robot.motor;

import edu.wpi.first.wpilibj.Talon;

public class BTTalon implements BTIMotor
{
	private final Talon talon;
	
	public BTTalon(int port)
	{
		talon = new Talon(port);
	}

	@Override
	public void setX(double x)
	{
		talon.set(x);
	}

}
