package org.usfirst.frc.team2220.robot.manipulator;

import org.usfirst.frc.team2220.robot.BTConstants;
import org.usfirst.frc.team2220.robot.BTStorage;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	boolean isToteMiddle;
	boolean isLeftToteUpper;
	boolean isRightToteUpper;
	boolean isSecondaryUpper = false;
	
	double toteCollectUp = 0.0;
	double toteCollectDown = 0.0;
	boolean isReleasing = false;
	boolean isReleasingDown = false;
	boolean isClaspRelease = false;
	
	boolean isSecondaryCollectButtonUp;
	boolean isSecondaryCollectButtonDown;
	boolean isBarrelRelease = false;
	boolean isExtended = false;
	boolean keepExtended = false;
	boolean isGoingUp;
	
	private int totecount = 0;
	private boolean isBarrelCollectorUpper = false;
	
	boolean waitingForUpper = false;
	
	@Override
	public void perform()
	{
		isToteIn = storage.robot.getToteLimit().getValue();
		isLeftToteLower = storage.robot.getLeftToteLowerLimit().getValue();
		isRightToteLower = storage.robot.getRightToteLowerLimit().getValue();
		isToteMiddle = storage.robot.getToteMiddleLimit().getValue();
		isLeftToteUpper = storage.robot.getLeftToteUpperLimit().getValue();
		isRightToteUpper = storage.robot.getRightToteUpperLimit().getValue();
		isSecondaryUpper = storage.robot.getSecondaryUpperLimit().getValue();
		
		
//		SmartDashboard.putBoolean("Tote In", isToteIn);
//		SmartDashboard.putBoolean("Left Lower", isLeftToteLower);
//		SmartDashboard.putBoolean("Right Lower", isRightToteLower);
//		SmartDashboard.putBoolean("Tote Middle", isToteMiddle);
//		SmartDashboard.putBoolean("Left Upper", isLeftToteUpper);
//		SmartDashboard.putBoolean("Right Upper", isRightToteUpper);
//		SmartDashboard.putBoolean("Secondary Upper", isSecondaryUpper);
		
		toteCollectUp = storage.controller.getToteCollect().getValue();
		toteCollectDown = storage.controller.getToteCollectDown().getValue();
		isReleasing = storage.controller.getToteRelease().getButtonValue();
		isBarrelRelease = storage.controller.getBarrelRelease().getLeadingEdge();
		isClaspRelease = storage.controller.getClaspRelease().getLeadingEdge();
		
		isSecondaryCollectButtonUp = storage.controller.getBarrelCollect().getButtonValue();
		isSecondaryCollectButtonDown = storage.controller.getBarrelCollectDown().getButtonValue();
		
//		SmartDashboard.putBoolean("Collecting", isCollecting);
//		SmartDashboard.putBoolean("Collecting Down", isCollectingDown);
//		SmartDashboard.putBoolean("Releasing", isReleasing);
//		SmartDashboard.putBoolean("Secondary Up", isSecondaryCollectButtonUp);
//		SmartDashboard.putBoolean("Secondary Down", isSecondaryCollectButtonDown);
		
		if((toteCollectUp > 0)||(toteCollectDown > 0))
		{
			collectTote();
		}
		
		if(isClaspRelease)
		{
			claspRelease();
		}
		
		if(isReleasing)
		{
			releaseTotes();
		}
		
		if ((toteCollectUp == 0) && (toteCollectDown == 0) && !isReleasing)
		{
			moveRightForkMotors(0);
			moveLeftForkMotors(0);
		}
		
		if(toteCollectUp > 0)
		{
			if ((isToteMiddle && (!isLeftToteUpper && !isRightToteUpper)) && !isToteIn)
			{
				keepExtended = true; 
				storage.robot.getToteClamp().retract(); // retract claws to let tote go by
				storage.robot.getBarrelHolder().retract();
			}
			else if (keepExtended && isLeftToteUpper && isRightToteUpper)
			{
				keepExtended = false;
				storage.robot.getToteClamp().extend();
				//storage.robot.getBarrelHolder().extend();
			}
			else if (!keepExtended)
			{
				storage.robot.getToteClamp().extend();
				//storage.robot.getBarrelHolder().extend();
			}
		}
		
		if (isBarrelRelease)
		{
			releaseBarrel();
		}
			
		
		
		if (isSecondaryCollectButtonDown)
		{
			lowerSecondary();
		}
		else if ((isSecondaryCollectButtonUp) && !isSecondaryUpper)
		{
			liftSecondary();
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
			
		if((toteCollectUp > 0) && !isLeftToteUpper)
		{
			moveLeftForkMotors(-BTConstants.TOTE_MOTOR_POWER);
		}
		else if((toteCollectDown > 0) && !isLeftToteLower)
		{
			moveLeftForkMotors(BTConstants.TOTE_MOTOR_POWER);
		}
		else
		{
			moveLeftForkMotors(0);
		}
		
		if((toteCollectUp > 0) && !isRightToteUpper)
		{
			moveRightForkMotors(BTConstants.TOTE_MOTOR_POWER);
		}
		else if((toteCollectDown > 0) && !isRightToteLower)
		{
			moveRightForkMotors(-BTConstants.TOTE_MOTOR_POWER);
		}
		else
		{
			moveRightForkMotors(0);
		}
			
			//set robot color to blue
	}
	
	public void claspRelease()
	{
		if (storage.robot.getToteClamp().isExtended())
		{
			storage.robot.getToteClamp().retract();
		}
		else
		{
			storage.robot.getToteClamp().extend();
		}
	}
			
	
	public void releaseTotes()
	{
		/*
		if (!isExtended)
		{ 
			if (!isLeftToteUpper)
			{
				moveLeftForkMotors(BTConstants.TOTE_MOTOR_POWER);
			}
			else 
			{
				moveLeftForkMotors(0);
			}
			if (!isRightToteUpper)
			{
				moveRightForkMotors(BTConstants.TOTE_MOTOR_POWER);
			}
			else 
			{
				moveRightForkMotors(0);
			}
			
			if (isLeftToteUpper && isRightToteUpper)
			{
				storage.robot.getToteClamp().extend();
				isExtended = true;
				moveRightForkMotors(0);
				moveLeftForkMotors(0);
			}
		}
		
		else
		{
			
			if (!isLeftToteLower)
			{
				moveLeftForkMotors(-BTConstants.TOTE_MOTOR_POWER);
			}
			else 
			{
				moveLeftForkMotors(0);
			}
			
			if (!isRightToteLower)
			{
				moveRightForkMotors(-BTConstants.TOTE_MOTOR_POWER);
			}
			else 
			{
				moveRightForkMotors(0);
			}
			
			if (isLeftToteLower && isRightToteLower)
			{
				isExtended = false;
				moveRightForkMotors(0);
				moveLeftForkMotors(0);
			}
			
			
		}
		*/
		storage.robot.getToteClamp().retract();
		storage.robot.getBarrelHolder().retract();
		isExtended = true;
	}
	
	public void releaseBarrel()
	{
		if(storage.robot.getBarrelHolder().isExtended())
		{
			storage.robot.getBarrelHolder().retract();
		}
		else
		{
			storage.robot.getBarrelHolder().extend();
		}
	}
	
//	public void startCollectorMotors()
//	{
//		if (BTConstants.COLLECTORS_REVERSED)
//		{
//			storage.robot.getCollectorMotorLeft().setX(BTConstants.COLLECTOR_MOTOR_POWER);
//			storage.robot.getCollectorMotorRight().setX(-BTConstants.COLLECTOR_MOTOR_POWER);
//		}
//		else
//		{
//			storage.robot.getCollectorMotorLeft().setX(-BTConstants.COLLECTOR_MOTOR_POWER);
//			storage.robot.getCollectorMotorRight().setX(BTConstants.COLLECTOR_MOTOR_POWER);
//		}
//	}
	
//	public void stopCollectorMotors()
//	{
//		storage.robot.getCollectorMotorLeft().setX(0);
//		storage.robot.getCollectorMotorRight().setX(0);
//	}
	
	public void startBarrelMotors(boolean goUp)
	{
		if (!goUp)
		{
			storage.robot.getBarrelMotorLeft().setX(BTConstants.BARREL_MOTOR_POWER_DOWN);
			storage.robot.getBarrelMotorRight().setX(BTConstants.BARREL_MOTOR_POWER_DOWN);
		}
		else
		{
			storage.robot.getBarrelMotorLeft().setX(-BTConstants.BARREL_MOTOR_POWER_UP);
			storage.robot.getBarrelMotorRight().setX(-BTConstants.BARREL_MOTOR_POWER_UP);
		}
	}
	
	public void stopBarrelMotors()
	{
		storage.robot.getBarrelMotorLeft().setX(0);
		storage.robot.getBarrelMotorRight().setX(0);
	}
	
	public void moveLeftForkMotors(double x)
	{
		storage.robot.getLeftForkLeft().setX(x);
		storage.robot.getLeftForkRight().setX(x);
//		System.out.println("Fork Left:\t" + x);
	}
	
	public void moveRightForkMotors(double x)
	{
		storage.robot.getRightForkLeft().setX(x);
		storage.robot.getRightForkRight().setX(x);
//		System.out.println("Fork Right:\t" + x);
	}
	
//	public boolean emergencyTimeMiddleForkTest(String methodname)
//	{
//		if (System.currentTimeMillis() - collectStartTime > BTConstants.EMERGENCY_STOP_TIME_MIDDLE)
//		{
//			//if the motor going up times out, move it back down to the bottom
//			moveForkMotors(-BTConstants.TOTE_MOTOR_POWER);
//			if (isLeftToteLower || isRightToteLower)
//			{
//				moveForkMotors(0);
//			}
//			//if that times out too, stop the motors
//			if (System.currentTimeMillis() - collectStartTime > 2 * BTConstants.EMERGENCY_STOP_TIME_MIDDLE)
//			{
//				moveForkMotors(0);
//				System.out.println("Error: Motor timed out in " + methodname + " method"
//						+ " AND emergency reset timed out");
//			}
//			System.out.println("Error: Motor timed out in " + methodname + " method.");
//			return true;
//		}
//		return false;
//	}
//
//	public boolean emergencyTimeUpperForkTest(String methodname)
//	{
//		if (System.currentTimeMillis() - collectStartTime > BTConstants.EMERGENCY_STOP_TIME_TOP)
//		{
//			//if the motor going up times out, move it back down to the bottom
//			moveForkMotors(-BTConstants.TOTE_MOTOR_POWER);
//			if (isLeftToteLower || isRightToteLower)
//			{
//				moveForkMotors(0);
//			}
//			//if that times out too, stop the motors
//			if (System.currentTimeMillis() - collectStartTime > 2 * BTConstants.EMERGENCY_STOP_TIME_TOP)
//			{
//				moveForkMotors(0);
//				System.out.println("Error: Motor timed out in " + methodname + " method"
//						+ " AND emergency reset timed out");
//			}
//			System.out.println("Error: Motor timed out in " + methodname + " method.");
//			return true;
//		}
//		return false;
//	}
}
