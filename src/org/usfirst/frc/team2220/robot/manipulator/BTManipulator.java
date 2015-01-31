package org.usfirst.frc.team2220.robot.manipulator;

import org.usfirst.frc.team2220.robot.BTConstants;
import org.usfirst.frc.team2220.robot.BTStorage;

public class BTManipulator implements BTIManipulator
{
	public BTStorage storage;
	
	public BTManipulator(BTStorage storage)
	{
		this.storage = storage;
		totecount = 0;
	}
	
	boolean isToteSwitch;
	boolean isLower;
	boolean isMiddle;
	boolean isUpper;
	
	boolean toteRelease;
	
	private int totecount = 0;
	
	private final double TOTE_MOTOR_POWER = 0.9;
	private final int EMERGENCY_STOP_TIME = 3000;
	
	public void forkToUpper()
	{
		//Fork starts moving up to Upper, which should cause TS to become false
		storage.data.FORK_MOTOR.setX(TOTE_MOTOR_POWER);
		long startTime = System.currentTimeMillis();
		
		//Fork stops when at Upper OR when it's been going for 3 seconds
		while (!isUpper && System.currentTimeMillis() - startTime > EMERGENCY_STOP_TIME){}
		storage.data.FORK_MOTOR.setX(0);
	}
	
	public void forkToMiddle()
	{
		//Fork starts moving up to Middle, which should cause TS to become false
		storage.data.FORK_MOTOR.setX(TOTE_MOTOR_POWER);
		long startTime = System.currentTimeMillis();
		
		//Fork stops when at Middle OR when it's been going for 3 seconds
		while (!isMiddle && System.currentTimeMillis() - startTime > EMERGENCY_STOP_TIME){}
		storage.data.FORK_MOTOR.setX(0);
	}
	
	public void forkToLower()
	{
		//Fork starts moving down to Lower, which should cause TS to become false
		storage.data.FORK_MOTOR.setX(-TOTE_MOTOR_POWER);
		long startTime = System.currentTimeMillis();
		
		//Fork stops when at Middle OR when it's been going for 3 seconds
		while (!isLower && System.currentTimeMillis() - startTime > EMERGENCY_STOP_TIME){}
		storage.data.FORK_MOTOR.setX(0);
	}
	
	@Override
	public void perform()
	{
		isToteSwitch = storage.data.TOTE_SWITCH.getValue();
		isLower = storage.data.LOW_LIMIT.getValue();
		isMiddle = storage.data.MIDDLE_LIMIT.getValue();
		isUpper = storage.data.UPPER_LIMIT.getValue();
		
		toteRelease = storage.controller.getToteRelease().getButtonValue();

		if (isToteSwitch && isLower && totecount == 4)
		{
			forkToMiddle();
		}
		if (isMiddle)
		{
			//Collector wheels stop
			storage.data.COLLECTOR_MOTOR_LEFT.setX(0);
			storage.data.COLLECTOR_MOTOR_RIGHT.setX(0);
			
			//Disable driving?
			
			//set robot color to red
			
			//Pistons retract
			storage.data.TOTE_HOLDER.retract();
			
			forkToUpper();
			
			//Pistons extend
			storage.data.TOTE_HOLDER.extend();
			
			totecount++;
			
			forkToLower();
			
			//Collector wheels start
			if (BTConstants.COLLECTORS_REVERSED)
			{
				storage.data.COLLECTOR_MOTOR_LEFT.setX(1);
				storage.data.COLLECTOR_MOTOR_RIGHT.setX(-1);
			}
			else
			{
				storage.data.COLLECTOR_MOTOR_LEFT.setX(-1);
				storage.data.COLLECTOR_MOTOR_RIGHT.setX(1);
			}
			
			//Enable driving?
			
			//set robot color to blue
	
			
			//TOTE RELEASE
	
			if (toteRelease)
			{
				//set robot color to green
				
				forkToUpper();
				
				//Pistons retract
				storage.data.TOTE_HOLDER.retract();
				
				forkToLower();
				
				//set robot color to yellow
				
				//open front containment
				
			}
		}
	}

}
