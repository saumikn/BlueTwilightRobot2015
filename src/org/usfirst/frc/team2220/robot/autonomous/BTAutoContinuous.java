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
	double degree = 0.0;
	
	int barrelCount = 0;
	
	boolean isSecondaryUpper;
	boolean correcting = false;
	boolean barrelCollectComplete = false;
	
	long elapsedTime = 0;
	long startTime = 0;
	long setUpTime = 2500;
	long extraMoveLeftTime = 0;
	long moveLeftTime = 0;
	long moveLeftStartTime = 0;
	long moveLeftElapsedTime = 0;
	
	public BTAutoContinuous(BTStorage storage, BTManipulator manipulator)
	{
		this.storage = storage;
		this.manipulator = manipulator;
	}
	
	@Override
	public void runAutonomous()
	{
		barrelSteal();
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
		
		if((elapsedTime > 45000) && (elapsedTime <= 54000))
		{
			moveForward();
		}
		else if((elapsedTime > 54000) && (elapsedTime <= 67500))
		{
			rotateOnlyRightWheels(true);
		}
		else if((elapsedTime > 67500) && (elapsedTime <= 80000))
		{
			moveLeft();
		}
		else if ((elapsedTime > 80000) && (elapsedTime <= 89000))
		{
			moveBackward();
		}
		else if((elapsedTime > 89000) && (elapsedTime <= 101500))
		{
			moveLeft();
		}
		else 
		{
			stopMotors();
		}
	}
	
	public void barrelSteal()
	{
//		if (barrelCount == 2)
//		{
//			if (extraMoveLeftTime == 0)
//			{
//				extraMoveLeftTime = System.currentTimeMillis();
//			}
//			
//			if (extraMoveLeftTime - System.currentTimeMillis() <= 2500)
//			{
//				if (!correcting)
//				{
//					moveLeft();
//				}
//				
//				degree = storage.robot.getGyro().getAngle();
//				
//				if(degree < (-BTConstants.ANGLE_ERROR)) //adjust front wheel speed to turn robot 
//				{
//					fr = wheelSpeed - (wheelSpeed * BTConstants.MOTOR_ERROR);
//					fl = wheelSpeed - (wheelSpeed * BTConstants.MOTOR_ERROR);
//		
//					invertMotors();
//		
//					storage.robot.getFrontLeftMotor().setX(fl);
//					storage.robot.getFrontRightMotor().setX(fr);
//					correcting = true;
//				}
//				else if(degree > (BTConstants.ANGLE_ERROR)) //adjust back wheel speed to turn robot 
//				{
//					br = wheelSpeed - (wheelSpeed * BTConstants.MOTOR_ERROR);					
//					bl = wheelSpeed - (wheelSpeed * BTConstants.MOTOR_ERROR);
//		
//					invertMotors();
//		
//					storage.robot.getBackLeftMotor().setX(bl);
//					storage.robot.getBackRightMotor().setX(br);	
//					correcting = true;
//				}
//				else
//				{
//					correcting = false;
//				}
//			}
//			else
//			{
//				stopMotors();
//			}
//		}
		if (barrelCount >= 4)	//We don't expect this to happen given the short time for autonomous
		{
			stopMotors();
			manipulator.stopBarrelMotors();
		}
		
		else if (barrelCount <= 3)
		{
			
			
			if (!barrelCollectComplete)
			{
				liftBarrel();
			}
			
//			correcting = false;	//Commented out by Jacob E. because this would *keep* being set to false with every pass through this method,
								//meaning that the corrections would never actually happen. The initialization as false in the definition
								//should be enough.
			
			if(moveLeftStartTime == 0)
			{
				moveLeftStartTime = System.currentTimeMillis();
			}
			
			moveLeftElapsedTime = System.currentTimeMillis() - moveLeftStartTime;
			
			
			
			if (barrelCollectComplete && moveLeftElapsedTime < (12_000 + setUpTime))
			{
				if (!correcting)
				{
					moveLeft();
				}
				
				degree = storage.robot.getGyro().getAngle();
				
				if(degree < (-BTConstants.ANGLE_ERROR)) //If robot pointing too far left, adjust front wheel speed to turn robot 
				{
					fr = wheelSpeed - (wheelSpeed * BTConstants.MOTOR_ERROR);
					fl = wheelSpeed - (wheelSpeed * BTConstants.MOTOR_ERROR);
		
					invertMotors();
		
					storage.robot.getFrontLeftMotor().setX(fl);
					storage.robot.getFrontRightMotor().setX(fr);
					correcting = true;
				}
				else if(degree > (BTConstants.ANGLE_ERROR)) //If robot pointing too far right, adjust back wheel speed to turn robot 
				{
					br = wheelSpeed - (wheelSpeed * BTConstants.MOTOR_ERROR);					
					bl = wheelSpeed - (wheelSpeed * BTConstants.MOTOR_ERROR);
		
					invertMotors();
		
					storage.robot.getBackLeftMotor().setX(bl);
					storage.robot.getBackRightMotor().setX(br);	
					correcting = true;
				}
				else
				{
					correcting = false;
				}
				
			}
			if( moveLeftElapsedTime > 10_000 + setUpTime && barrelCount != 2)
			{
				stopMotors();
				barrelCollectComplete = false;
				moveLeftStartTime = 0;
				if (barrelCount == 3)
				{
					liftBarrel(); 
				}
			}
			
			if (moveLeftElapsedTime > 12_000 + setUpTime && barrelCount == 2)
			{
				stopMotors();
				barrelCollectComplete = false;
				moveLeftStartTime = 0;
			}
		}
		
		

	}
		
	public void liftBarrel()
	{
		if(startTime == 0)
		{
			startTime = System.currentTimeMillis();
		}
		
		elapsedTime = System.currentTimeMillis() - startTime;	//Time since the operation began running
		
		if (elapsedTime >= 0 && elapsedTime < (0 + setUpTime))
		{
			manipulator.startBarrelMotors(false);	//Barrel motors start moving down
		}
		
//		else if (elapsedTime == setUpTime)
//		{
//			manipulator.stopBarrelMotors();
//		}
		
		else if(elapsedTime > (0 + setUpTime) && elapsedTime <= (250 + setUpTime))
		{
			manipulator.stopBarrelMotors();
			secondaryActuate();	//Currently does nothing
		}
		
		else if(elapsedTime > (250 + setUpTime) && elapsedTime < (1000 + setUpTime))
		{
			manipulator.startBarrelMotors(true);	//Barrel motors start moving up
		}
		
//		else if (elapsedTime == 10000 + setUpTime)
//		{
//			manipulator.stopBarrelMotors();
//		}
		
		else if (elapsedTime > (1000 + setUpTime) && elapsedTime < (3000 + setUpTime))
		{
			if(barrelCount < 3)
			{
				manipulator.stopBarrelMotors();
				rotateOnlyLeftWheels(false);	//Rotates only the left wheels, moving the robot (clockwise?)
			}
			else
			{
				manipulator.stopBarrelMotors();
				rotateOnlyRightWheels(false);	//Rotates only the right wheels, moving the robot (clockwise?)
			}
		}
		
//		else if (elapsedTime == 3000 + setUpTime)
//		{
//			stopMotors();
//		}
		
		else if (elapsedTime > (3000 + setUpTime) && elapsedTime < (5000 + setUpTime))
		{
			stopMotors();
			manipulator.startBarrelMotors(false);	//Barrel motors start moving down
		}
		
//		else if (elapsedTime == 5000 + setUpTime)	//NOTE: Commented out by Jacob E. because there's no guarantee this method will run
//		{											//every single millisecond, and this block would only take effect if elapsedTime was
//			stopMotors();							//equal to a single, specific millisecond value. I transfered the two lines in this
//			manipulator.stopBarrelMotors();			//if statement to the following one.
//		}
		
		else if (elapsedTime > (5000 + setUpTime) && elapsedTime <= (5250 + setUpTime))
		{
			stopMotors();
			manipulator.stopBarrelMotors();
			secondaryActuate();
		}
		
		else if (elapsedTime > (5250 + setUpTime) && elapsedTime < (7250 + setUpTime))
		{
			manipulator.startBarrelMotors(true);	//Barrel motors start moving up
		}
		
//		else if (elapsedTime == 72500+setUpTime)
//		{
//			manipulator.stopBarrelMotors();
//		}
		
		else if	(elapsedTime > (7250 + setUpTime) && elapsedTime <= (9250 + setUpTime))
		{
			if(barrelCount < 3)
			{
				manipulator.stopBarrelMotors();
				rotateOnlyLeftWheels(true);		//Rotates only the left wheels, moving the robot (counterclockwise?)
			}
			else
			{
				manipulator.stopBarrelMotors();
				rotateOnlyRightWheels(true);	//Rotates only the right wheels, moving the robot (counterclockwise?)
			}
		}
		
		else if(elapsedTime > (9250 + setUpTime))
		{
			stopMotors();
			startTime = 0;
			barrelCount++;
			barrelCollectComplete = true;
		}
	}
	
	public void secondaryActuate()
	{
	
	//barrelClamp does not exist yet, will be written in storage once solenoid ports have been determined
	
//		if (storage.robot.getBarrelHolder().isExtended())
//		{
//			storage.robot.getBarrelHolder().retract();
//		}
//		else
//		{
//			storage.robot.getBarrelHolder().extend();
//		}
		
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
	
	public void rotateOnlyRightWheels(boolean direction)
	{
		if(!direction)
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
		
		if(direction)
		{
			fr = wheelSpeed;
			br = -wheelSpeed;
			fl = 0;
			bl = 0;
		
			invertMotors();
		
			storage.robot.getFrontLeftMotor().setX(fl);
			storage.robot.getBackLeftMotor().setX(bl);
			storage.robot.getFrontRightMotor().setX(fr);
			storage.robot.getBackRightMotor().setX(br);	
		}
	}
	
	public void rotateOnlyLeftWheels(boolean direction)
	{
		if(!direction)
		{
			fr = 0;
			br = 0;
			fl = wheelSpeed;
			bl = -wheelSpeed;
		
			invertMotors();
		
			storage.robot.getFrontLeftMotor().setX(fl);
			storage.robot.getBackLeftMotor().setX(bl);
			storage.robot.getFrontRightMotor().setX(fr);
			storage.robot.getBackRightMotor().setX(br);
		}
		
		if(direction)
		{
			fr = 0;
			br = 0;
			fl = -wheelSpeed;
			bl = wheelSpeed;
		
			invertMotors();
		
			storage.robot.getFrontLeftMotor().setX(fl);
			storage.robot.getBackLeftMotor().setX(bl);
			storage.robot.getFrontRightMotor().setX(fr);
			storage.robot.getBackRightMotor().setX(br);	
		}
	}
	
	
	public void resetTimer()
	{
		startTime = 0; 
	}
}
