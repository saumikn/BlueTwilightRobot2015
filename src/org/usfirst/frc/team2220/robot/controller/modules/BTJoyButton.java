package org.usfirst.frc.team2220.robot.controller.modules;

import edu.wpi.first.wpilibj.Joystick;

public class BTJoyButton implements BTIConButton
{
	private final Joystick joy;
	private final int port;
	private boolean previousVal = false;
	private boolean currentVal = false;
	
	public BTJoyButton(Joystick joy, int port)
	{
		this.joy = joy;
		this.port = port;
	}

	@Override
	public boolean getValue()
	{
		previousVal = currentVal;
		currentVal = joy.getRawButton(port);
		return currentVal;
	}

	@Override
	public boolean getLeadingEdge()
	{
		getValue();
		if (currentVal && !previousVal) {
			return true;
		}
		return false;
	}

	@Override
	public boolean getContinuousEdge()
	{
		getValue();
		if (currentVal && previousVal) {
			return true;
		}
		return false;
	}

	@Override
	public boolean getBackEdge()
	{
		getValue();
		if (!currentVal && previousVal) {
			return true;
		}
		return false;
	}

}
