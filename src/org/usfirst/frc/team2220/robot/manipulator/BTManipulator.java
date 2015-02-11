package org.usfirst.frc.team2220.robot.manipulator;

import org.usfirst.frc.team2220.robot.BTConstants;
import org.usfirst.frc.team2220.robot.BTStorage;
import org.usfirst.frc.team2220.robot.exceptions.BTSafetyTimeout;

public class BTManipulator implements BTIManipulator
{
	public BTStorage storage;
	
	public BTManipulator(BTStorage storage)
	{
		this.storage = storage;
		totecount = 0;
	}
	
	public static boolean isToteSwitch;
	boolean isPrimaryLowerLeft;
	boolean isPrimaryLowerRight;
	boolean isPrimaryMiddleLeft;
	boolean isPrimaryMiddleRight;
	boolean isPrimaryUpperLeft;
	boolean isPrimaryUpperRight;
	boolean isSecondaryLower;
	boolean isSecondaryUpper;
	
	boolean toteCollect;
	boolean toteRelease;
	boolean closeToteContainment;
	
	boolean secondaryAct;
	
	private int totecount = 0;
	private boolean secondaryIsLifted = false;
	
	@Override
	public void perform()
	{
		isToteSwitch = storage.data.TOTE_LIMIT.getValue();
		isPrimaryLowerLeft = storage.data.PRIMARY_LOWER_LIMIT_LEFT.getValue();
		isPrimaryLowerRight = storage.data.PRIMARY_LOWER_LIMIT_RIGHT.getValue();
		isPrimaryMiddleLeft = storage.data.PRIMARY_MIDDLE_LIMIT_LEFT.getValue();
		isPrimaryMiddleRight = storage.data.PRIMARY_MIDDLE_LIMIT_RIGHT.getValue();
		isPrimaryUpperLeft = storage.data.PRIMARY_UPPER_LIMIT_LEFT.getValue();
		isPrimaryUpperRight = storage.data.PRIMARY_UPPER_LIMIT_RIGHT.getValue();
		isSecondaryLower = storage.data.SECONDARY_LOWER_LIMIT.getValue();
		isSecondaryUpper = storage.data.SECONDARY_UPPER_LIMIT.getValue();
		
		toteCollect = storage.controller.getToteCollect().getButtonValue();
		toteRelease = storage.controller.getToteRelease().getButtonValue();
		
		secondaryAct = storage.controller.getBarrelCollect().getButtonValue();
		
		if (toteCollect && totecount < BTConstants.MAX_TOTE_COUNT)
			collectTote();
		
		if (toteRelease)
			releaseTotes();
		
		if (closeToteContainment)
			storage.data.TOTE_CONTAINMENT.retract();//only place opened is in release totes
		
		if (secondaryAct)
		{
			if (secondaryIsLifted)
				lowerSecondary();
			else
				liftSecondary();
		}
	}
	
	public void liftSecondary()
	{
		try
		{
			//Barrel manipulator starts going up
			if (BTConstants.BARREL_REVERSED)
			{
				storage.data.BARREL_MOTOR_LEFT.setX(-BTConstants.BARREL_MOTOR_POWER);
				storage.data.BARREL_MOTOR_RIGHT.setX(BTConstants.BARREL_MOTOR_POWER);
			}
			else
			{
				storage.data.BARREL_MOTOR_LEFT.setX(BTConstants.BARREL_MOTOR_POWER);
				storage.data.BARREL_MOTOR_RIGHT.setX(-BTConstants.BARREL_MOTOR_POWER);
			}
			
			long startTime = System.currentTimeMillis();
			
			//Fork stops when at Secondary Upper OR when it's been going for 3 seconds
			while (!isSecondaryUpper)
			{
				if (System.currentTimeMillis() - startTime > BTConstants.EMERGENCY_STOP_TIME)
					throw new BTSafetyTimeout();
			}
			stopBarrelMotors();
			
			secondaryIsLifted = true;
		}
		catch (BTSafetyTimeout safety)
		{
			stopBarrelMotors();
			System.out.println("Error: Motor timed out in liftSecondary method.");
		}
	}
	
	public void lowerSecondary()
	{
		try
		{
			//Barrel manipulator starts going up
			if (BTConstants.BARREL_REVERSED)
			{
				storage.data.BARREL_MOTOR_LEFT.setX(BTConstants.BARREL_MOTOR_POWER);
				storage.data.BARREL_MOTOR_RIGHT.setX(-BTConstants.BARREL_MOTOR_POWER);
			}
			else
			{
				storage.data.BARREL_MOTOR_LEFT.setX(-BTConstants.BARREL_MOTOR_POWER);
				storage.data.BARREL_MOTOR_RIGHT.setX(BTConstants.BARREL_MOTOR_POWER);
			}
			
			long startTime = System.currentTimeMillis();
			
			//Fork stops when at Secondary Lower OR when it's been going for 3 seconds
			while (!isSecondaryLower)
			{
				if (System.currentTimeMillis() - startTime > BTConstants.EMERGENCY_STOP_TIME)
					throw new BTSafetyTimeout();
			}
			stopBarrelMotors();
			
			secondaryIsLifted = false;
		}
		catch (BTSafetyTimeout safety)
		{
			stopBarrelMotors();
			System.out.println("Error: Motor timed out in lowerSecondary method.");
		}
	}
	
	public void collectTote()
	{
		try
		{
			startCollectorMotors();
			while (!isToteSwitch){}	//Don't continue until the tote switch is activated
			stopCollectorMotors();
			
			forkToMiddle();
			
			//set robot color to red
			
			//Pistons retract
			storage.data.TOTE_HOLDER.retract();
			
			forkToUpper();
			
			//Pistons extend
			storage.data.TOTE_HOLDER.extend();
			
			totecount++;
			
			forkToLower();
			
			//close front containment
			//NOT SURE IF BELONGS HERE, SHOUDLN'T IT ALREADY BE CLOSED?
//			storage.data.TOTE_CONTAINMENT.retract();
			
			//set robot color to blue
		}
		catch (BTSafetyTimeout safety)
		{
			storage.data.TOTE_MOTOR.setX(0);
			stopCollectorMotors();
			System.out.println("Error: Motor timed out in collectTote method.");
		}
	}
	
	public void releaseTotes()
	{
		try
		{
			//set robot color to green
			
			forkToUpper();
			
			//Pistons retract
			storage.data.TOTE_HOLDER.retract();
			
			forkToLower();
			
			//set robot color to yellow
			
			//open front containment
			storage.data.TOTE_CONTAINMENT.extend();
			
			totecount = 0;
		}
		catch (BTSafetyTimeout safety)
		{
			storage.data.TOTE_MOTOR.setX(0);
			stopCollectorMotors();
			System.out.println("Error: Motor timed out in releaseTotes method.");
		}
	}
	
	public void forkToUpper() throws BTSafetyTimeout
	{
		//Fork starts moving up to Upper, which should cause TS to become false
		storage.data.TOTE_MOTOR.setX(BTConstants.TOTE_MOTOR_POWER);
		long startTime = System.currentTimeMillis();
		
		//Fork stops when at Upper OR when it's been going for 3 seconds
		while (!isPrimaryUpperLeft)
		{
			if (System.currentTimeMillis() - startTime > BTConstants.EMERGENCY_STOP_TIME)
				throw new BTSafetyTimeout();
		}
		storage.data.TOTE_MOTOR.setX(0);
	}
	
	public void forkToMiddle() throws BTSafetyTimeout
	{
		//Fork starts moving up to Middle, which should cause TS to become false
		storage.data.TOTE_MOTOR.setX(BTConstants.TOTE_MOTOR_POWER);
		long startTime = System.currentTimeMillis();
		
		//Fork stops when at Middle OR when it's been going for 3 seconds
		while (!isPrimaryMiddleLeft)
		{
			if (System.currentTimeMillis() - startTime > BTConstants.EMERGENCY_STOP_TIME)
				throw new BTSafetyTimeout();
		}
		storage.data.TOTE_MOTOR.setX(0);
	}
	
	public void forkToLower() throws BTSafetyTimeout
	{
		//Fork starts moving down to Lower, which should cause TS to become false
		storage.data.TOTE_MOTOR.setX(-BTConstants.TOTE_MOTOR_POWER);
		long startTime = System.currentTimeMillis();
		
		//Fork stops when at Lower OR when it's been going for 3 seconds
		while (!isPrimaryLowerLeft)
		{
			if (System.currentTimeMillis() - startTime > BTConstants.EMERGENCY_STOP_TIME)
				throw new BTSafetyTimeout();
		}
		storage.data.TOTE_MOTOR.setX(0);
	}
	
	public void startCollectorMotors()
	{
		if (BTConstants.COLLECTORS_REVERSED)
		{
			storage.data.COLLECTOR_MOTOR_LEFT.setX(BTConstants.COLLECTOR_MOTOR_POWER);
			storage.data.COLLECTOR_MOTOR_RIGHT.setX(-BTConstants.COLLECTOR_MOTOR_POWER);
		}
		else
		{
			storage.data.COLLECTOR_MOTOR_LEFT.setX(-BTConstants.COLLECTOR_MOTOR_POWER);
			storage.data.COLLECTOR_MOTOR_RIGHT.setX(BTConstants.COLLECTOR_MOTOR_POWER);
		}
	}
	
	public void stopCollectorMotors()
	{
		storage.data.COLLECTOR_MOTOR_LEFT.setX(0);
		storage.data.COLLECTOR_MOTOR_RIGHT.setX(0);
	}
	
	public void stopBarrelMotors()
	{
		storage.data.BARREL_MOTOR_LEFT.setX(0);
		storage.data.BARREL_MOTOR_RIGHT.setX(0);
	}

}
