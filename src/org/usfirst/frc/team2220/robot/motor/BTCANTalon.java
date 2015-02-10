package org.usfirst.frc.team2220.robot.motor;

import edu.wpi.first.wpilibj.CANTalon;

public class BTCANTalon implements BTIMotor
{
	private final CANTalon canTalon;
	
	public BTCANTalon(int port)
	{
		canTalon = new CANTalon(port);
	}

	@Override
	public void setX(double x)
	{
		canTalon.set(x);
	}

}
