package org.usfirst.frc.team2220.robot.controller;

import org.usfirst.frc.team2220.robot.controller.modules.BTIConAxis;
import org.usfirst.frc.team2220.robot.controller.modules.BTIConButton;
import org.usfirst.frc.team2220.robot.controller.modules.BTJoyAxis;
import org.usfirst.frc.team2220.robot.controller.modules.BTJoyButton;

import edu.wpi.first.wpilibj.Joystick;

public class BTFlightstick implements BTIController
{
	private final BTJoyAxis JOYSTICK_X;
	private final BTJoyAxis JOYSTICK_Y;
	private final BTJoyAxis JOYSTICK_Z_ROTATE;
	private final BTJoyAxis THROTTLE;
	private final BTJoyAxis TOP_THROTTLE;
	
	private final BTJoyButton A_BUTTON;
	private final BTJoyButton E_BUTTON;
	
	private Joystick joy;
	
	public BTFlightstick(int port)
	{
		joy = new Joystick(port);
		
		JOYSTICK_X = new BTJoyAxis(joy, 0);
		JOYSTICK_Y = new BTJoyAxis(joy, 1);
		JOYSTICK_Z_ROTATE = new BTJoyAxis(joy, 5);
		THROTTLE = new BTJoyAxis(joy, 2);
		TOP_THROTTLE = new BTJoyAxis(joy, 4);
		
		A_BUTTON = new BTJoyButton(joy, 2);
		E_BUTTON = new BTJoyButton(joy, 7);
	}

	@Override
	public BTIConAxis getAxis(int port)
	{
		return new BTJoyAxis(joy, port);
	}

	@Override
	public BTIConButton getButton(int port)
	{
		return new BTJoyButton(joy, port);
	}

	@Override
	public BTIConAxis getLeftDriveFrontBack()
	{
		return JOYSTICK_X;
	}

	@Override
	public BTIConAxis getRightDriveFrontBack()
	{
		return JOYSTICK_X;
	}

	@Override
	public BTIConAxis getDriveLeftRight()
	{
		return JOYSTICK_Y;
	}

	@Override
	public BTIConAxis getDriveFrontBack()
	{
		return JOYSTICK_X;
	}

	@Override
	public BTIConAxis getDriveRotate()
	{
		return JOYSTICK_Z_ROTATE;
	}
	
	@Override
	public BTIConAxis getTopThrottle()
	{
		return TOP_THROTTLE;
	}
	
	@Override
	public BTIConButton getToteCollect()
	{
		return E_BUTTON;
	}
	
	@Override
	public BTIConButton getToteRelease()
	{
		return A_BUTTON;
	}

	@Override
	public BTIConButton getTest() {
		// TODO Auto-generated method stub
		return null;
	}
}
