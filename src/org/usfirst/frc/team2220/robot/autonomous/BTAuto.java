package org.usfirst.frc.team2220.robot.autonomous;

import org.usfirst.frc.team2220.robot.BTStorage;
import org.usfirst.frc.team2220.robot.BTConstants;
import org.usfirst.frc.team2220.robot.manipulator.BTManipulator;

public class BTAuto implements BTIAutonomousRoutine
{
	BTStorage storage;
	BTManipulator manipulator;
	
	public BTAuto(BTStorage storage, BTManipulator manipulator)
	{
		this.storage = storage;
		this.manipulator = manipulator;
	}
	
	@Override
	public void runAutonomous()
	{
		switch (BTConstants.ACTIVE_AUTONOMOUS)
		{
		case 4: runAutonomous4();
				break;
		case 3: runAutonomous3();
				break;
		case 2: runAutonomous2();
				break;
		case 1:	runAutonomous1();
				break;
		default:	break;
		
		}
	}
	
	public void runAutonomous4()
	{
		manipulator.collectTote();
		strafeRight();
		manipulator.collectTote();
		strafeRight();
		manipulator.collectTote();
		moveBack();
	}
	
	public void runAutonomous3()
	{
		manipulator.collectTote();
		strafeRight();
		manipulator.collectTote();
		moveBack();
	}
	
	public void runAutonomous2()
	{
		manipulator.collectTote();
		moveBack();
	}
	
	public void runAutonomous1()
	{
		moveBack();
	}
	
	public void strafeRight()
	{
		long startTime = System.currentTimeMillis();
		startStrafingRight();
		while(System.currentTimeMillis() - startTime < BTConstants.STRAFE_RIGHT_TIME){}
		stopMotors();
	}
	
	public void moveBack()
	{
		long startTime = System.currentTimeMillis();
		startMovingBack();
		while(System.currentTimeMillis() - startTime < BTConstants.MOVE_BACK_TIME){}
		stopMotors();
	}

//	public void pickTote()
//	{
//		long startTime = System.currentTimeMillis();
//		startCollectorMotors();
//		while(System.currentTimeMillis() - startTime < BTConstants.COLLECT_TIME){}
//		stopCollectorMotors();
//	}
//	
//	public void startCollectorMotors()
//	{
//		if (BTConstants.COLLECTORS_REVERSED)
//		{
//			storage.data.COLLECTOR_MOTOR_LEFT.setX(BTConstants.COLLECTOR_MOTOR_POWER);
//			storage.data.COLLECTOR_MOTOR_RIGHT.setX(-BTConstants.COLLECTOR_MOTOR_POWER);
//		}
//		else
//		{
//			storage.data.COLLECTOR_MOTOR_LEFT.setX(-BTConstants.COLLECTOR_MOTOR_POWER);
//			storage.data.COLLECTOR_MOTOR_RIGHT.setX(BTConstants.COLLECTOR_MOTOR_POWER);
//		}
//	}
//	
//	public void stopCollectorMotors()
//	{
//		storage.data.COLLECTOR_MOTOR_LEFT.setX(0);
//		storage.data.COLLECTOR_MOTOR_RIGHT.setX(0);
//	}
	
	public void startMovingBack()
	{
		storage.data.FRONT_LEFT_MOTOR.setX(-0.9);
		storage.data.FRONT_RIGHT_MOTOR.setX(0.9);
		storage.data.BACK_LEFT_MOTOR.setX(0.9);
		storage.data.BACK_RIGHT_MOTOR.setX(-0.9);
	}
	
	public void startStrafingRight()
	{
		storage.data.FRONT_LEFT_MOTOR.setX(0.9);
		storage.data.FRONT_RIGHT_MOTOR.setX(0.9);
		storage.data.BACK_LEFT_MOTOR.setX(0.9);
		storage.data.BACK_RIGHT_MOTOR.setX(0.9);
	}
	
	public void stopMotors()
	{
		storage.data.FRONT_LEFT_MOTOR.setX(0);
		storage.data.FRONT_RIGHT_MOTOR.setX(0);
		storage.data.BACK_LEFT_MOTOR.setX(0);
		storage.data.BACK_RIGHT_MOTOR.setX(0);	
	}
}
