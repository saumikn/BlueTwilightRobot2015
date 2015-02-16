package org.usfirst.frc.team2220.robot.controller;
//package org.usfirst.frc.team2220.robot.controller;
//
//import org.usfirst.frc.team2220.robot.controller.modules.BTIConButton;
//import org.usfirst.frc.team2220.robot.controller.modules.BTIConButton;
//import org.usfirst.frc.team2220.robot.controller.modules.BTIConAxis;
//import org.usfirst.frc.team2220.robot.controller.modules.BTIConButton;
//import org.usfirst.frc.team2220.robot.controller.modules.BTJoyAxis;
//import org.usfirst.frc.team2220.robot.controller.modules.BTJoyButton;
//
//import edu.wpi.first.wpilibj.Joystick;
//
//public class BTXboxController implements BTIController
//{
//	private final BTJoyAxis LEFT_STICK_X_AXIS;
//	private final BTJoyAxis LEFT_STICK_Y_AXIS;
//	private final BTJoyAxis LEFT_TRIGGER;
//	private final BTJoyAxis RIGHT_TRIGGER;
//	private final BTJoyAxis RIGHT_STICK_X_AXIS;
//	private final BTJoyAxis RIGHT_STICK_Y_AXIS;
//	
//	private final BTJoyButton A_BUTTON;
//	private final BTJoyButton B_BUTTON;
//	private final BTJoyButton X_BUTTON;
//	private final BTJoyButton Y_BUTTON;
//	private final BTJoyButton LEFT_BUMPER_BUTTON;
//	private final BTJoyButton RIGHT_BUMPER_BUTTON;
//	private final BTJoyButton BACK_BUTTON;
//	private final BTJoyButton START_BUTTON;
//	private final BTJoyButton LEFT_STICK_BUTTON;
//	private final BTJoyButton RIGHT_STICK_BUTTON;
//	
//	private Joystick joy;
//	
//	public BTXboxController(int port)
//	{
//		joy = new Joystick(port);
//		
//		LEFT_STICK_X_AXIS = new BTJoyAxis(joy, 0);
//		LEFT_STICK_Y_AXIS = new BTJoyAxis(joy, 1);
//		LEFT_TRIGGER = new BTJoyAxis(joy, 2);
//		RIGHT_TRIGGER = new BTJoyAxis(joy, 3);
//		RIGHT_STICK_X_AXIS = new BTJoyAxis(joy, 4);
//		RIGHT_STICK_Y_AXIS = new BTJoyAxis(joy, 5);
//		
//		A_BUTTON = new BTJoyButton(joy, 1);
//		B_BUTTON = new BTJoyButton(joy, 2);
//		X_BUTTON = new BTJoyButton(joy, 3);
//		Y_BUTTON = new BTJoyButton(joy, 4);
//		LEFT_BUMPER_BUTTON = new BTJoyButton(joy, 5);
//		RIGHT_BUMPER_BUTTON = new BTJoyButton(joy, 6);
//		BACK_BUTTON = new BTJoyButton(joy, 7);
//		START_BUTTON = new BTJoyButton(joy, 8);
//		LEFT_STICK_BUTTON = new BTJoyButton(joy, 9);
//		RIGHT_STICK_BUTTON = new BTJoyButton(joy, 10);
//
//	}
//
//	@Override
//	public BTIConAxis getAxis(int port)
//	{
//		return new BTJoyAxis(joy, port);
//	}
//
//	@Override
//	public BTIConButton getButton(int port)
//	{
//		return new BTJoyButton(joy, port);
//	}
//
//	@Override
//	public BTIConAxis getDriveLeftRight()
//	{
//		return LEFT_STICK_X_AXIS;
//	}
//
//	@Override
//	public BTIConAxis getDriveFrontBack()
//	{
//		return LEFT_STICK_Y_AXIS;
//	}
//
//	@Override
//	public BTIConAxis getDriveRotate()
//	{
//		return RIGHT_STICK_X_AXIS;
//	}
//	
//	@Override
//	public BTIConAxis getMaxSpeed()
//	{
//		return null;
//	}
//	
//	@Override
//	public BTIConButton getToteCollect()
//	{
//		return X_BUTTON;
//	}
//
//	@Override
//	public BTIConButton getToteRelease()
//	{
//		return LEFT_BUMPER_BUTTON;
//	}
//
//	@Override
//	public BTIConButton getDrivetrainOrientationSwitch() {
//		return START_BUTTON;
//	}
//
//	@Override
//	public BTIConButton getBarrelCollect()
//	{
//		return Y_BUTTON;
//	}
//	
//	@Override
//	public BTIConButton getBarrelCollectDown()
//	{
//		return B_BUTTON;
//	}
//
//	@Override
//	public BTIConButton getToteCollectDown() 
//	{
//		return A_BUTTON;
//	}
//	
//	@Override
//	public BTIConButton getTurboToggle()
//	{
//		return null;
//	}
//
//	@Override
//	public BTIConAxis getLeftJoystickFrontBack() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public BTIConAxis getLeftJoystickLeftRight() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public BTIConAxis getRightJoystickFrontBack() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public BTIConAxis getRightJoystickLeftRight() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
