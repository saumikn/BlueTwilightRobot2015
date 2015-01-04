package org.usfirst.frc.team2220.robot.controller;

import org.usfirst.frc.team2220.robot.controller.modules.BTIConAxis;
import org.usfirst.frc.team2220.robot.controller.modules.BTIConButton;

public interface BTIController
{
	// For debug use
	public BTIConAxis getAxis(int port);
	public BTIConButton getButton(int port);
	// public BTIConAxis[] getAllAxis();
	// public BTIConButton[] getAllButtons();
	
	// Drivetrain controls
	public BTIConAxis getDriveLeftRight();
	public BTIConAxis getDriveFrontBack();
	public BTIConAxis getDriveRotate();
	public BTIConButton getShift();
	public BTIConButton getOctoSwitch();	
	
	// Manipulator controls
}
