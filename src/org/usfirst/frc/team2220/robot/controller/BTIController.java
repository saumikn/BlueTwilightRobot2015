package org.usfirst.frc.team2220.robot.controller;

import org.usfirst.frc.team2220.robot.controller.modules.BTIConAxis;
import org.usfirst.frc.team2220.robot.controller.modules.BTIConButton;

public interface BTIController
{
	public BTIConAxis getAxis(int port);
	public BTIConButton getButton(int port);
	
	// Drivetrain parameters
	public BTIConAxis getDriveLeftRight();
	public BTIConAxis getDriveFrontBack();
	public BTIConAxis getDriveRotate();
	public BTIConAxis getMaxSpeed();
	
	// Manipulator parameters
	public BTIConButton getToteCollect();
	public BTIConButton getToteCollectDown();
	public BTIConButton getToteRelease();
	public BTIConButton getDrivetrainOrientationSwitch();
	public BTIConButton getBarrelCollect();
	public BTIConButton getBarrelCollectDown();
	public BTIConButton getTurboToggle();

}
