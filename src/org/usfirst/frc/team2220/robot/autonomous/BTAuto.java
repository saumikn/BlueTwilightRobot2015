package org.usfirst.frc.team2220.robot.autonomous;

import org.usfirst.frc.team2220.robot.BTStorage;
import org.usfirst.frc.team2220.robot.BTConstants;
import org.usfirst.frc.team2220.robot.manipulator.BTManipulator;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BTAuto implements BTIAutonomousRoutine
{
	BTStorage storage;
	BTManipulator manipulator;
	
	double fl;
	double bl;
	double fr;
	double br;
	
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
		case 5: SmartDashboard.putString(BTConstants.AUTONOMOUS_METHOD_KEY, "Running Test Autonomous");
				runAutonomousTest();
				break;
		case 4: SmartDashboard.putString(BTConstants.AUTONOMOUS_METHOD_KEY, "Running Autonomous 4");
				runAutonomous4();
				break;
		case 3: SmartDashboard.putString(BTConstants.AUTONOMOUS_METHOD_KEY, "Running Autonomous 3");
				runAutonomous3();
				break;
		case 2: SmartDashboard.putString(BTConstants.AUTONOMOUS_METHOD_KEY, "Running Autonomous 2");
				runAutonomous2();
				break;
		case 1:	SmartDashboard.putString(BTConstants.AUTONOMOUS_METHOD_KEY, "Running Autonomous 1");
				runAutonomous1();
				break;
		default:	break;
		
		}
	}
	
	public void runAutonomousTest()
	{
		moveBack(BTConstants.MOVE_BACK_TIME_SHORT);
		strafeRight();
		moveForward();
		manipulator.collectTote();
		moveBack(BTConstants.MOVE_BACK_TIME_LONG);
	}
	
	public void runAutonomous4()
	{
		SmartDashboard.putString(BTConstants.AUTONOMOUS_STAGE_KEY, "Autonomous phase 1 of 6: Collecting tote 1 of 3");
		manipulator.collectTote();
		
		SmartDashboard.putString(BTConstants.AUTONOMOUS_STAGE_KEY, "Autonomous phase 2 of 6: Strafing right");
		strafeRight();
		
		SmartDashboard.putString(BTConstants.AUTONOMOUS_STAGE_KEY, "Autonomous phase 3 of 6: Collecting tote 2 of 3");
		manipulator.collectTote();
		
		SmartDashboard.putString(BTConstants.AUTONOMOUS_STAGE_KEY, "Autonomous phase 4 of 6: Strafing right");
		strafeRight();
		
		SmartDashboard.putString(BTConstants.AUTONOMOUS_STAGE_KEY, "Autonomous phase 5 of 6: Collecting tote 3 of 3");
		manipulator.collectTote();
		
		SmartDashboard.putString(BTConstants.AUTONOMOUS_STAGE_KEY, "Autonomous phase 6 of 6: Moving backwards");
		moveBack(BTConstants.MOVE_BACK_TIME_SHORT);
	}
	
	public void runAutonomous3()
	{
		manipulator.collectTote();
		strafeRight();
		manipulator.collectTote();
		moveBack(BTConstants.MOVE_BACK_TIME_SHORT);
	}
	
	public void runAutonomous2()
	{
		manipulator.collectTote();
		moveBack(BTConstants.MOVE_BACK_TIME_SHORT);
	}
	
	public void runAutonomous1()
	{
		moveBack(BTConstants.MOVE_BACK_TIME_SHORT);
	}
	
	public void strafeRight()
	{
		long startTime = System.currentTimeMillis();
		startStrafingRight();
		while(System.currentTimeMillis() - startTime < BTConstants.STRAFE_RIGHT_TIME){}
		stopMotors();
	}
	
	public void moveBack(int time)
	{
		long startTime = System.currentTimeMillis();
		startMovingBack();
		while(System.currentTimeMillis() - startTime < time){}
		stopMotors();
	}
	
	public void moveForward()
	{
		long startTime = System.currentTimeMillis();
		startMovingForward();
		//while(storage.data.TOTE_SWITCH.getValue() == false){}
		while(System.currentTimeMillis() - startTime < 3000){}
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
		double speed = BTConstants.STRAFE_SPEED;
		
		fl = speed;
		bl = -speed;
		fr = -speed;
		br = speed;
		
		invertMotors();
		
		storage.data.FRONT_LEFT_MOTOR.setX(fl);
		storage.data.BACK_LEFT_MOTOR.setX(bl);
		storage.data.FRONT_RIGHT_MOTOR.setX(fr);
		storage.data.BACK_RIGHT_MOTOR.setX(br);
	}
	
	public void startMovingForward()
	{
		double speed = BTConstants.FORWARD_SPEED;
		
		fl = -speed;
		bl = speed;
		fr = speed;
		br = -speed;
		
		invertMotors();
		
		storage.data.FRONT_LEFT_MOTOR.setX(fl);
		storage.data.BACK_LEFT_MOTOR.setX(bl);
		storage.data.FRONT_RIGHT_MOTOR.setX(fr);
		storage.data.BACK_RIGHT_MOTOR.setX(br);
	}
	
	public void startStrafingRight()
	{
		double speed = BTConstants.STRAFE_SPEED;
		
		fl = -speed;
		bl = -speed;
		fr = -speed;
		br = -speed;
		
		invertMotors();
		
		storage.data.FRONT_LEFT_MOTOR.setX(fl);
		storage.data.BACK_LEFT_MOTOR.setX(bl);
		storage.data.FRONT_RIGHT_MOTOR.setX(fr);
		storage.data.BACK_RIGHT_MOTOR.setX(br);
	}
	
	public void invertMotors()
	{
		if (BTConstants.FRONT_LEFT_REVERSED)
		{
			fl = -fl;
		}
		if (BTConstants.BACK_LEFT_REVERSED)
		{
			bl = -bl;
		}
		if (BTConstants.FRONT_RIGHT_REVERSED)
		{
			fr = -fr;
		}
		if (BTConstants.BACK_RIGHT_REVERSED)
		{
			br = -br;
		}
	}
	
	public void stopMotors()
	{
		storage.data.FRONT_LEFT_MOTOR.setX(0);
		storage.data.BACK_LEFT_MOTOR.setX(0);
		storage.data.FRONT_RIGHT_MOTOR.setX(0);
		storage.data.BACK_RIGHT_MOTOR.setX(0);	
	}
}
