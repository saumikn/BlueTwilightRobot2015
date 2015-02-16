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
		stopSecondary();
	}
	
	boolean isToteIn;
	boolean isLeftToteLower;
	boolean isRightToteLower;
	boolean isLeftToteMiddle;
	boolean isRightToteMiddle;
	boolean isLeftToteUpper;
	boolean isRightToteUpper;
	boolean isBarrelLower;
	boolean isBarrelUpper;
	
	boolean isToteCollectButton;
	boolean isToteReleaseButton;
	
	boolean isBarrelCollectButtonUp;
	boolean isBarrelCollectButtonDown;
	
	private int totecount = 0;
	private boolean isBarrelCollectorUpper = false;
	
	@Override
	public void perform()
	{
		isToteIn = storage.robot.getToteLimit().getValue();
		isLeftToteLower = storage.robot.getLeftToteLowerLimit().getValue();
		isRightToteLower = storage.robot.getRightToteLowerLimit().getValue();
		isLeftToteMiddle = storage.robot.getLeftToteMiddleLimit().getValue();
		isRightToteMiddle = storage.robot.getRightToteMiddleLimit().getValue();
		isLeftToteUpper = storage.robot.getLeftToteUpperLimit().getValue();
		isRightToteUpper = storage.robot.getRightToteUpperLimit().getValue();
		isBarrelLower = storage.robot.getBarrelLowerLimit().getValue();
		isBarrelUpper = storage.robot.getBarrelUpperLimit().getValue();
		
		isToteCollectButton = storage.controller.getToteCollect().getButtonValue();
		isToteReleaseButton = storage.controller.getToteRelease().getButtonValue();
		
		isBarrelCollectButtonUp = storage.controller.getBarrelCollect().getButtonValue();
		isBarrelCollectButtonDown = storage.controller.getBarrelCollectDown().getButtonValue();
		
		if (isToteCollectButton && totecount < BTConstants.MAX_TOTE_COUNT)
			collectTote();
//		
//		if (isToteReleaseButton)
//			releaseTotes();
		
		if (isBarrelCollectButtonUp)
		{
			liftSecondary();
		}
		
		else if (isBarrelCollectButtonDown)
		{
			lowerSecondary();
		}
		
		else
		{
			stopSecondary();
		}
	}
	
	public void liftSecondary()
	{
		startBarrelMotors(true);
	}
	
	public void lowerSecondary()
	{
		startBarrelMotors(false);
	}
	
	public void stopSecondary()
	{
		stopBarrelMotors();
	}
	
	public void collectTote()
	{
		try
		{
			//startCollectorMotors();
			//while (!isToteIn){}	//Don't continue until the tote switch is activated
			//stopCollectorMotors();
			
			forkToMiddle();
			
			//set robot color to red
			
			//Pistons retract
			storage.robot.getToteClamp().retract();
			storage.robot.getBarrelHolder().retract();
			
			forkToUpper();
			
			//Pistons extend
			storage.robot.getToteClamp().extend();
			storage.robot.getBarrelHolder().extend();
			
			totecount++;
			
			if(totecount < BTConstants.MAX_TOTE_COUNT)
			{
				forkToLower();
			}
			
			//set robot color to blue
		}
		catch (BTSafetyTimeout safety)
		{
			moveForkMotors(0);
			stopCollectorMotors();
			System.out.println("Error: Motor timed out in collectTote method.");
		}
	}
	
	public void releaseTotes()
	{
		try
		{
			//set robot color to green
			
			if(totecount < BTConstants.MAX_TOTE_COUNT)
			{
				forkToUpper();
			}
			
			//Pistons retract
			storage.robot.getToteClamp().retract();
			
			forkToLower();
			
			//set robot color to yellow
			
			totecount = 0;
		}
		catch (BTSafetyTimeout safety)
		{
			moveForkMotors(0);
			stopCollectorMotors();
			System.out.println("Error: Motor timed out in releaseTotes method.");
		}
	}
	
	public void forkToUpper() throws BTSafetyTimeout
	{
		//Fork starts moving up to Upper, which should cause TS to become false
		moveForkMotors(BTConstants.TOTE_MOTOR_POWER);
		long startTime = System.currentTimeMillis();
		
		//Fork stops when at Upper OR when it's been going for 3 seconds
		while (!isLeftToteUpper)
		{
			if (System.currentTimeMillis() - startTime > BTConstants.EMERGENCY_STOP_TIME)
				throw new BTSafetyTimeout();
		}
		moveForkMotors(0);
	}
	
	public void forkToMiddle() throws BTSafetyTimeout
	{
		//Fork starts moving up to Middle, which should cause TS to become false
		moveForkMotors(BTConstants.TOTE_MOTOR_POWER);
		long startTime = System.currentTimeMillis();
		
		//Fork stops when at Middle OR when it's been going for 3 seconds
		while (!isLeftToteMiddle)
		{
			if (System.currentTimeMillis() - startTime > BTConstants.EMERGENCY_STOP_TIME)
				throw new BTSafetyTimeout();
		}
		moveForkMotors(0);
	}
	
	public void forkToLower() throws BTSafetyTimeout
	{
		//Fork starts moving down to Lower, which should cause TS to become false
		moveForkMotors(-BTConstants.TOTE_MOTOR_POWER);
		long startTime = System.currentTimeMillis();
		
		//Fork stops when at Lower OR when it's been going for 3 seconds
		while (!isLeftToteLower)
		{
			if (System.currentTimeMillis() - startTime > BTConstants.EMERGENCY_STOP_TIME)
				throw new BTSafetyTimeout();
		}
		moveForkMotors(0);
	}
	
	public void startCollectorMotors()
	{
		if (BTConstants.COLLECTORS_REVERSED)
		{
			storage.robot.getCollectorMotorLeft().setX(BTConstants.COLLECTOR_MOTOR_POWER);
			storage.robot.getCollectorMotorRight().setX(-BTConstants.COLLECTOR_MOTOR_POWER);
		}
		else
		{
			storage.robot.getCollectorMotorLeft().setX(-BTConstants.COLLECTOR_MOTOR_POWER);
			storage.robot.getCollectorMotorRight().setX(BTConstants.COLLECTOR_MOTOR_POWER);
		}
	}
	
	public void stopCollectorMotors()
	{
		storage.robot.getCollectorMotorLeft().setX(0);
		storage.robot.getCollectorMotorRight().setX(0);
	}
	
	public void startBarrelMotors(boolean goUp)
	{
		if (!goUp)
		{
			storage.robot.getBarrelMotorLeft().set(-BTConstants.BARREL_MOTOR_POWER_DOWN);
			storage.robot.getBarrelMotorRight().set(BTConstants.BARREL_MOTOR_POWER_DOWN);
		}
		else
		{
			storage.robot.getBarrelMotorLeft().set(BTConstants.BARREL_MOTOR_POWER_UP);
			storage.robot.getBarrelMotorRight().set(-BTConstants.BARREL_MOTOR_POWER_UP);
		}
	}
	
	public void stopBarrelMotors()
	{
		storage.robot.getBarrelMotorLeft().set(0);
		storage.robot.getBarrelMotorRight().set(0);
	}
	
	public void moveForkMotors(double x)
	{
		storage.robot.getLeftForkLeft().setX(x);
		storage.robot.getLeftForkRight().setX(-x);
		storage.robot.getRightForkLeft().setX(x);
		storage.robot.getRightForkRight().setX(-x);
	}

}
