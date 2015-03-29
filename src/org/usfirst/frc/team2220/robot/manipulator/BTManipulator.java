package org.usfirst.frc.team2220.robot.manipulator;

import org.usfirst.frc.team2220.robot.BTConstants;
import org.usfirst.frc.team2220.robot.BTStorage;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BTManipulator implements BTIManipulator
{
	public BTStorage storage;
	
	public BTManipulator(BTStorage storage)
	{
		this.storage = storage;
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
	
	double encodeFR; 
	double encodeFL;
	double encoder_delta;
	
	double turnFR;
	double turnFL;
	double rev_right;
	double rev_left;
	
	boolean waitingForUpper = false;
	boolean isRevvedRight = false;
	boolean isRevvedLeft = false;
	boolean isCorrecting = false;
	
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
		
		toteCollectUp = storage.controller.getToteCollect().getValue();
		toteCollectDown = storage.controller.getToteCollectDown().getValue();
		isReleasing = storage.controller.getToteRelease().getButtonValue();
		isBarrelRelease = storage.controller.getBarrelRelease().getButtonValue();
		isClaspRelease = storage.controller.getClaspRelease().getLeadingEdge();
		
		encodeFR = storage.robot.getFrontRightEncoder().getValue();
		encodeFL = storage.robot.getFrontLeftEncoder().getValue();
		
		turnFR = storage.robot.getFrontRightPot().getValue();
		turnFL = storage.robot.getFrontLeftPot().getValue();
		
		SmartDashboard.putNumber("Front Right", turnFR);
		SmartDashboard.putNumber("Front Left", turnFL);
		
		isSecondaryCollectButtonUp = storage.controller.getBarrelCollect().getButtonValue();
		isSecondaryCollectButtonDown = storage.controller.getBarrelCollectDown().getButtonValue();
		
		if((toteCollectUp > 0)||(toteCollectDown > 0))
		{
			collectTote();
		}
		
		if (isLeftToteUpper || isLeftToteLower)
		{
			rev_left = 0;
		}
		
		if (isRightToteUpper || isRightToteLower)
		{
			rev_right = 0;
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
		
		if (isBarrelRelease)
		{
			storage.robot.getBarrelHolder().extend();
		}
		else 
		{
			storage.robot.getBarrelHolder().retract();
		}
		
		if (isSecondaryCollectButtonDown) //aka start collector motors in reverse, i'm lazy
		{
			reverseCollectorMotors();
		}
		else if (isSecondaryCollectButtonUp) //aka start collector motors forward, i'm lazy
		{
			startCollectorMotors();
		}
		else
		{
			stopCollectorMotors();
		}
		
	}
	
	public void liftSecondary()
	{
		startBarrelMotors(false); //based on the ways the barrel motors are wired
	}
	
	public void lowerSecondary()
	{
		startBarrelMotors(true); //based on the ways the barrel motors are wired
	}
	
	public void stopSecondary()
	{
		stopBarrelMotors();
	}
	
	public void collectTote()
	{
		if(!isCorrecting)
		{
			if((toteCollectUp > 0) && !isLeftToteUpper)
			{
				moveLeftForkMotors(-BTConstants.TOTE_MOTOR_POWER_DOWN);
			}
			else if((toteCollectDown > 0) && !isLeftToteLower)
			{
				moveLeftForkMotors(BTConstants.TOTE_MOTOR_POWER_UP);
			}
			else
			{
				moveLeftForkMotors(0);
			}
		}
		
		
		if(!isCorrecting)
		{
			if((toteCollectUp > 0) && !isRightToteUpper)
			{
				moveRightForkMotors(BTConstants.TOTE_MOTOR_POWER_DOWN);
			}
			else if((toteCollectDown > 0) && !isRightToteLower)
			{
				moveRightForkMotors(-BTConstants.TOTE_MOTOR_POWER_UP);
			}
			else
			{
				moveRightForkMotors(0);
			}
		}
		
//		if (toteCollectUp > 0)
//		{
//			if ((turnFR > 0 && turnFR < BTConstants.POT_REVOLUTION_ERROR_UP) && !isRevvedRight)
//			{
//				rev_right++;
//				isRevvedRight = true;
//			}
//			if ((turnFL > 0 && turnFL < BTConstants.POT_REVOLUTION_ERROR_UP) && !isRevvedLeft)
//			{
//				rev_left++;
//				isRevvedLeft = true;
//			}
//			
//			if (turnFR > BTConstants.POT_REVOLUTION_ERROR_UP && turnFR < BTConstants.POT_FULL_REV)
//			{
//				isRevvedRight = false;
//			}
//			
//			if (turnFL > BTConstants.POT_REVOLUTION_ERROR_UP && turnFL < BTConstants.POT_FULL_REV)
//			{
//				isRevvedLeft = false;
//			}
//			
//			if (((rev_left * BTConstants.POT_FULL_REV) + turnFL) < ((rev_right * BTConstants.POT_FULL_REV) + turnFR))
//			{
//				lowerRightSideSpeed();
//				isCorrecting = true;
//			}
//			else if (((rev_right * BTConstants.POT_FULL_REV) + turnFR) < ((rev_left * BTConstants.POT_FULL_REV) + turnFL))
//			{
//				lowerLeftSideSpeed();
//				isCorrecting = true;
//			}
//			else
//			{
//				isCorrecting = false;
//			}
//			
//		}
//		
//		if (toteCollectDown > 0)
//		{
//			if ((turnFR < 0 && turnFR > BTConstants.POT_REVOLUTION_ERROR_DOWN) && !isRevvedRight)
//			{
//				rev_right++;
//				isRevvedRight = true;
//			}
//			if ((turnFL < 0 && turnFL > BTConstants.POT_REVOLUTION_ERROR_DOWN) && !isRevvedLeft)
//			{
//				rev_left++;
//				isRevvedLeft = true;
//			}
//			
//			if (turnFR < BTConstants.POT_REVOLUTION_ERROR_DOWN && turnFR > 0)
//			{
//				isRevvedRight = false;
//			}
//			
//			if (turnFL < BTConstants.POT_REVOLUTION_ERROR_DOWN && turnFL > 0)
//			{
//				isRevvedLeft = false;
//			}
//			
//			if (((rev_left * BTConstants.POT_FULL_REV) + turnFL) > ((rev_right * BTConstants.POT_FULL_REV) + turnFR))
//			{
//				lowerRightSideSpeed();
//				isCorrecting = true;
//			}
//			else if (((rev_right * BTConstants.POT_FULL_REV) + turnFR) > ((rev_left * BTConstants.POT_FULL_REV) + turnFL))
//			{
//				lowerLeftSideSpeed();
//				isCorrecting = true;
//			}
//			else
//			{
//				isCorrecting = false;
//			}
//		}
	}
	
	public void startCollectorMotors()
	{
		storage.robot.getCollectorMotorLeft().setX(BTConstants.COLLECTOR_MOTOR_POWER_COLLECT);
		storage.robot.getCollectorMotorRight().setX(BTConstants.COLLECTOR_MOTOR_POWER_COLLECT);
	}
	
	public void reverseCollectorMotors()
	{
		storage.robot.getCollectorMotorLeft().setX(-BTConstants.COLLECTOR_MOTOR_POWER_EJECT);
		storage.robot.getCollectorMotorRight().setX(-BTConstants.COLLECTOR_MOTOR_POWER_EJECT);
	}
	
	public void stopCollectorMotors()
	{
		storage.robot.getCollectorMotorLeft().setX(0);
		storage.robot.getCollectorMotorRight().setX(0);
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
		storage.robot.getToteClamp().retract();
		storage.robot.getBarrelHolder().retract();
		isExtended = true;
	}
	
	
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
	
	public void lowerRightSideSpeed()
	{
		storage.robot.getRightForkLeft().setX(BTConstants.TOTE_MOTOR_POWER_UP * BTConstants.POT_MOTOR_CORRECTION);
		storage.robot.getRightForkRight().setX(BTConstants.TOTE_MOTOR_POWER_UP * BTConstants.POT_MOTOR_CORRECTION);
	}
	
	public void lowerLeftSideSpeed()
	{
		storage.robot.getLeftForkLeft().setX(BTConstants.TOTE_MOTOR_POWER_UP * BTConstants.POT_MOTOR_CORRECTION);
		storage.robot.getLeftForkRight().setX(BTConstants.TOTE_MOTOR_POWER_UP * BTConstants.POT_MOTOR_CORRECTION);
	}
	
}