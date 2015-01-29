package org.usfirst.frc.team2220.robot.motor;

import edu.wpi.first.wpilibj.TalonSRX;

public class BTTalonSRX implements BTIMotor
{
	private final TalonSRX talonSRX;
	
	public BTTalonSRX(int port)
	{
		talonSRX = new TalonSRX(port);
	}

	@Override
	public void setX(double x)
	{
		talonSRX.set(x);		
	}

}
