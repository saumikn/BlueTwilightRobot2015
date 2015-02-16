package org.usfirst.frc.team2220.robot.motor;

import edu.wpi.first.wpilibj.CANTalon;

public class BTCANTalon implements BTIMotor
{
	private CANTalon canTalon = null;
	
//	public BTCANTalon(int port)
//	{
//		if (port != -1)
//		{
//			canTalon = new CANTalon(port);
//		}
//	}
	
	public BTCANTalon(int port, boolean isBrake)
	{
		if (port != -1)
		{
			canTalon = new CANTalon(port);
			canTalon.enableBrakeMode(isBrake);
		}
	}
	

	@Override
	public void setX(double x)
	{
		if (canTalon != null)
		{
			canTalon.set(x);
		}
	}
	
	@Override
	public double getCurrent()
	{
		if (canTalon != null)
		{
			return canTalon.getOutputCurrent();
		}
		return 0.0d;
	}


	@Override
	public double get()
	{
		return canTalon.get();
	}
	
	

}
