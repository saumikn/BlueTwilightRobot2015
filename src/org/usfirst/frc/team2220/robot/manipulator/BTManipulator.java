package org.usfirst.frc.team2220.robot.manipulator;

import org.usfirst.frc.team2220.robot.BTConstants;
import org.usfirst.frc.team2220.robot.BTStorage;
import org.usfirst.frc.team2220.robot.exceptions.BTSafetyTimeout;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BTManipulator implements BTIManipulator
{
	public BTStorage storage;
	
	public BTManipulator(BTStorage storage)
	{
		this.storage = storage;
		totecount = 0;
	}
	
	public static boolean isToteSwitch;
	boolean isLower;
	boolean isMiddle;
	boolean isUpper;
	
	boolean toteCollect;
	boolean toteRelease;
	
	private int totecount = 0;
	
	@Override
	public void perform()
	{
		isToteSwitch = storage.data.TOTE_SWITCH.getValue();
		isLower = storage.data.LOW_LIMIT.getValue();
		isMiddle = storage.data.MIDDLE_LIMIT.getValue();
		isUpper = storage.data.UPPER_LIMIT.getValue();
		
		toteCollect = storage.controller.getToteCollect().getButtonValue();
		toteRelease = storage.controller.getToteRelease().getButtonValue();
		
		if (toteCollect && totecount < BTConstants.MAX_TOTE_COUNT)
			collectTote();
		
		if (toteRelease)
			releaseTotes();
	}
	
	public void collectTote()
	{
		try
		{
			SmartDashboard.putString("Here", "Inside collectTote");
			startCollectorMotors();
			SmartDashboard.putString("Here", "Finished startCollectorMotors");
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
			storage.data.TOTE_COLLECTOR.retract();
			
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
			storage.data.TOTE_COLLECTOR.extend();
			
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
		while (!isUpper)
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
		while (!isMiddle)
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
		
		//Fork stops when at Middle OR when it's been going for 3 seconds
		while (!isLower)
		{
			if (System.currentTimeMillis() - startTime > BTConstants.EMERGENCY_STOP_TIME)
				throw new BTSafetyTimeout();
		}
		storage.data.TOTE_MOTOR.setX(0);
	}
	
	public void startCollectorMotors()
	{
		SmartDashboard.putString("Here", "Inside startCollectorMotors");
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

}
