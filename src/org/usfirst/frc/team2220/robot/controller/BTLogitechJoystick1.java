package org.usfirst.frc.team2220.robot.controller;

import org.usfirst.frc.team2220.robot.controller.modules.BTIConAxis;
import org.usfirst.frc.team2220.robot.controller.modules.BTIConButton;
import org.usfirst.frc.team2220.robot.controller.modules.BTJoyAxis;
import org.usfirst.frc.team2220.robot.controller.modules.BTJoyButton;

import edu.wpi.first.wpilibj.Joystick;

public class BTLogitechJoystick1 implements BTIController
{
	private Joystick joy;
	
	private final BTJoyAxis X_AXIS;
	private final BTJoyAxis Y_AXIS;
	private final BTJoyAxis Z_AXIS;
	private final BTJoyAxis SLIDER;
	
	private final BTJoyButton BUTTON_1;
	private final BTJoyButton BUTTON_2;
	private final BTJoyButton BUTTON_3;
	private final BTJoyButton BUTTON_4;
	private final BTJoyButton BUTTON_5;
	private final BTJoyButton BUTTON_6;
	private final BTJoyButton BUTTON_7;
	private final BTJoyButton BUTTON_8;
	private final BTJoyButton BUTTON_9;
	private final BTJoyButton BUTTON_10;
	private final BTJoyButton BUTTON_11;
	private final BTJoyButton BUTTON_12;
	
	
	public BTLogitechJoystick1(int port)
	{
		joy = new Joystick(port);
		
		X_AXIS = new BTJoyAxis(joy, 0);
		Y_AXIS = new BTJoyAxis(joy, 1);
		Z_AXIS = new BTJoyAxis(joy, 2);
		SLIDER = new BTJoyAxis(joy, 2);
		
		BUTTON_1 = new BTJoyButton(joy, 1);
		BUTTON_2 = new BTJoyButton(joy, 2);
		BUTTON_3 = new BTJoyButton(joy, 3);
		BUTTON_4 = new BTJoyButton(joy, 4);
		BUTTON_5 = new BTJoyButton(joy, 5);
		BUTTON_6 = new BTJoyButton(joy, 6);
		BUTTON_7 = new BTJoyButton(joy, 7);
		BUTTON_8 = new BTJoyButton(joy, 8);
		BUTTON_9 = new BTJoyButton(joy, 9);
		BUTTON_10 = new BTJoyButton(joy, 10);
		BUTTON_11 = new BTJoyButton(joy, 11);
		BUTTON_12 = new BTJoyButton(joy, 12);
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
	public BTIConAxis getDriveLeftRight()
	{
		return X_AXIS;
	}

	@Override
	public BTIConAxis getDriveFrontBack()
	{
		return Y_AXIS;
	}

	@Override
	public BTIConAxis getDriveRotate()
	{
		return Z_AXIS;
	}

	@Override
	public BTIConAxis getMaxSpeed()
	{
		return SLIDER;
	}

	@Override
	public BTIConButton getToteCollect()
	{
		return BUTTON_6;
	}
	
	@Override
	public BTIConButton getToteCollectDown()
	{
		return BUTTON_4;
	}

	@Override
	public BTIConButton getToteRelease()
	{
		return BUTTON_3;
	}	
	
	@Override
	public BTIConButton getDrivetrainOrientationSwitch()
	{
		return BUTTON_1;
	}
	
	@Override
	public BTIConButton getBarrelCollect()
	{
		return BUTTON_5;
	}
	
	@Override
	public BTIConButton getBarrelCollectDown()
	{
		return BUTTON_3;
	}
}
