package org.usfirst.frc.team2220.robot.motor;

import edu.wpi.first.wpilibj.TalonSRX;

public class BTTalonSRX implements BTIMotor
{
	private TalonSRX talonSRX = null;
	
	public BTTalonSRX(int port)
	{
		if (port != -1)
		{
			talonSRX = new TalonSRX(port);
		}
	}

	@Override
	public void setX(double x)
	{
		if (talonSRX != null)
		{
			talonSRX.set(x);	
		}
	}

	@Override
	public double getCurrent()
	{
		return 0;
	}

	@Override
	public double get() {
		// TODO Auto-generated method stub
		return 0;
	}

}
