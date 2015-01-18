package org.usfirst.frc.team2220.robot.controller.modules;

import edu.wpi.first.wpilibj.Joystick;

public class BTAxisButton extends BTJoyAxis implements BTIConButton
{
	private boolean previousVal = false;
	private boolean currentVal = false;

	public BTAxisButton(Joystick joy, int port)
	{
		super(joy, port);
	}

	@Override
	public double getValue()
	{
		return super.getValue();
	}
	
	@Override
	public boolean getButtonValue()
	{
		return getValue() > 0.5;
	}

	@Override
	public boolean getLeadingEdge()
	{
		getButtonValue();
		if (currentVal && !previousVal) {
			return true;
		}
		return false;
	}

	@Override
	public boolean getContinuousEdge()
	{
		getButtonValue();
		if (currentVal && previousVal) {
			return true;
		}
		return false;
	}

	@Override
	public boolean getBackEdge()
	{
		getButtonValue();
		if (!currentVal && previousVal) {
			return true;
		}
		return false;
	}

}
