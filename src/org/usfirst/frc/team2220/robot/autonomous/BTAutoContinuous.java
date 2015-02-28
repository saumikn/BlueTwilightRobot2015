package org.usfirst.frc.team2220.robot.autonomous;

import org.usfirst.frc.team2220.robot.BTStorage;
import org.usfirst.frc.team2220.robot.BTConstants;
import org.usfirst.frc.team2220.robot.manipulator.BTManipulator;

public class BTAutoContinuous implements BTIAutonomousRoutine
{
	BTStorage storage;
	BTManipulator manipulator;
	
	double wheelSpeed = 0.75;
	double fl = 0.0;
	double bl = 0.0;
	double fr = 0.0;
	double br = 0.0;
	
	boolean isSecondaryUpper;
	
	long elapsedTime = 0;
	long startTime = 0;
	
	public BTAutoContinuous(BTStorage storage, BTManipulator manipulator)
	{
		this.storage = storage;
		this.manipulator = manipulator;
	}
	
	@Override
	public void runAutonomous()
	{
		runAutonomousCoop();
	}
	
	public void runAutonomousCoop()
	{	
		if(startTime == 0)
		{
			startTime = System.currentTimeMillis();
		}
		
		elapsedTime = System.currentTimeMillis() - startTime;
		isSecondaryUpper = storage.robot.getSecondaryUpperLimit().getValue();
		
		if(!isSecondaryUpper)
		{
			manipulator.startBarrelMotors(true);
		}
		else
		{
			manipulator.stopBarrelMotors();
		}
		
		if((elapsedTime > 4500) && (elapsedTime <= 5400))
		{
			moveForward();
		}
		else if((elapsedTime > 5400) && (elapsedTime <= 6750))
		{
			rotateOnlyRightWheels();
		}
		else if((elapsedTime > 6750) && (elapsedTime <= 8000))
		{
			moveLeft();
		}
		else if ((elapsedTime > 8000) && (elapsedTime <= 8900))
		{
			moveBackward();
		}
		else if((elapsedTime > 8900) && (elapsedTime <= 10150))
		{
			moveLeft();
		}
		else 
		{
			stopMotors();
		}
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
		storage.robot.getFrontLeftMotor().setX(0);
		storage.robot.getBackLeftMotor().setX(0);
		storage.robot.getFrontRightMotor().setX(0);
		storage.robot.getBackRightMotor().setX(0);
	}
	
	public void moveForward()
	{
		fl = wheelSpeed;
		fr = -wheelSpeed;
		bl = -wheelSpeed;
		br = wheelSpeed;
		
		invertMotors();
		
		storage.robot.getFrontLeftMotor().setX(fl);
		storage.robot.getBackLeftMotor().setX(bl);
		storage.robot.getFrontRightMotor().setX(fr);
		storage.robot.getBackRightMotor().setX(br);
	}
	
	public void moveBackward()
	{
		fl = -wheelSpeed;
		fr = wheelSpeed;
		bl = wheelSpeed;
		br = -wheelSpeed;
		
		invertMotors();
		
		storage.robot.getFrontLeftMotor().setX(fl);
		storage.robot.getBackLeftMotor().setX(bl);
		storage.robot.getFrontRightMotor().setX(fr);
		storage.robot.getBackRightMotor().setX(br);
	}
	
	public void moveLeft()
	{
		fl = -wheelSpeed;
		fr = -wheelSpeed;
		bl = -wheelSpeed;
		br = -wheelSpeed;
		
		invertMotors();
		
		storage.robot.getFrontLeftMotor().setX(fl);
		storage.robot.getBackLeftMotor().setX(bl);
		storage.robot.getFrontRightMotor().setX(fr);
		storage.robot.getBackRightMotor().setX(br);
	}
	
	public void rotateOnlyRightWheels()
	{
		fr = -wheelSpeed;
		br = wheelSpeed;
		fl = 0;
		bl = 0;
		
		invertMotors();
		
		storage.robot.getFrontLeftMotor().setX(fl);
		storage.robot.getBackLeftMotor().setX(bl);
		storage.robot.getFrontRightMotor().setX(fr);
		storage.robot.getBackRightMotor().setX(br);
	}
	
	public void resetTimer()
	{
		startTime = 0; 
	}
}
