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
	
	boolean isLeftToteLower;
	boolean isRightToteLower;
	boolean isLeftToteUpper;
	boolean isRightToteUpper;
	
	double toteCollectUp = 0.0;
	double toteCollectDown = 0.0;
	boolean isReleasing = false;
	boolean isReleasingDown = false;
	boolean isClaspRelease = false;
	
	boolean isCollectorWheelButtonCollect;
	boolean isCollectorWheelButtonEject;
	boolean isFrontContainmentButtonOut;
	boolean isFrontContainmentButtonIn;
	boolean isBarrelRelease = false;
	boolean isExtended = false;
	boolean keepExtended = false;
	boolean isGoingUp;
	
	double encodeFR; 
	double encodeFL;
	double encoder_delta;
	
	int counter = 0;
	
	boolean waitingForUpper = false;
	boolean isRevvedRight = false;
	boolean isRevvedLeft = false;
	boolean isCorrecting = false;
	
	@Override
	public void perform()
	{
		isLeftToteLower = storage.robot.getLeftToteLowerLimit().getValue();
		isRightToteLower = storage.robot.getRightToteLowerLimit().getValue();
		isLeftToteUpper = storage.robot.getLeftToteUpperLimit().getValue();
		isRightToteUpper = storage.robot.getRightToteUpperLimit().getValue();
		
		toteCollectUp = storage.controller.getToteCollect().getValue();
		toteCollectDown = storage.controller.getToteCollectDown().getValue();
		isReleasing = storage.controller.getToteRelease().getButtonValue();
		isBarrelRelease = storage.controller.getBarrelRelease().getButtonValue();
		isClaspRelease = storage.controller.getClaspRelease().getLeadingEdge();
		
		encodeFR = storage.robot.getRightEncoder().getValue();
		encodeFL = storage.robot.getLeftEncoder().getValue();
		encoder_delta = encodeFR - encodeFL;
		
//		if (counter == 50)
//		{
//			SmartDashboard.putNumber("Right Encoder", storage.robot.getRightEncoder().getValue());
//			SmartDashboard.putNumber("Left Encoder", storage.robot.getLeftEncoder().getValue());
//			SmartDashboard.putNumber("Encoder delta", encoder_delta);
//			SmartDashboard.putNumber("Left Fork Motor", storage.robot.getRightForkLeft().get());
//			SmartDashboard.putNumber("Right Fork Motor", storage.robot.getRightForkRight().get());
//			counter = 0;
//		}
//		else
//		{
//			counter++;
//		}
		
		isCollectorWheelButtonCollect = storage.controller.getCollectorWheelsCollect().getButtonValue();
		isCollectorWheelButtonEject = storage.controller.getCollectorWheelsEject().getButtonValue();
		isFrontContainmentButtonIn = storage.controller.getFrontContainmentIn().getButtonValue();
		isFrontContainmentButtonOut = storage.controller.getFrontContainmentOut().getButtonValue();
		
		
		if((toteCollectUp > 0)||(toteCollectDown > 0))
		{
			collectTote();
		}

		if (isFrontContainmentButtonIn)
		{
			containmentIn();
		}
		else if (isFrontContainmentButtonOut)
		{
			containmentOut();
		}
		else 
		{
			storage.robot.getFrontContainmentMotor().setX(0);
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
		
		if (isCollectorWheelButtonEject)
		{
			reverseCollectorMotors();
		}
		else if (isCollectorWheelButtonCollect) 
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
//		if( counter == 250)
//		{
//		SmartDashboard.putBoolean("Left Up Limit" , isLeftToteUpper);
//		SmartDashboard.putBoolean("Right Up Limit" , isRightToteUpper);
//		SmartDashboard.putBoolean("Left Down Limit" , isLeftToteLower);
//		SmartDashboard.putBoolean("Right Down Limit" , isRightToteLower);
//		counter = 0;
//		}
//		counter++;
		
		if (Math.abs(encoder_delta) > BTConstants.ENCODER_MARGIN_OF_ERROR)
		{
			isCorrecting = true;
		}
		else
		{
			isCorrecting = false;
		}
		
//		isCorrecting = false;
		double leftCorrection = 1.0;
		double rightCorrection = 1.0;
		
		if((toteCollectUp > 0) && !isLeftToteUpper)
			{
				if(isCorrecting == true)
				{
					if (encodeFL > encodeFR)
					{
						leftCorrection = 0.9;
					}
				}
				moveLeftForkMotors(BTConstants.TOTE_MOTOR_POWER_DOWN * leftCorrection);
			}
			else if((toteCollectDown > 0) && !isLeftToteLower)
			{
				if( isCorrecting == true)
				{
					if (encodeFR > encodeFL)
					{
						leftCorrection = 0.9;
					}
				}
				moveLeftForkMotors(-BTConstants.TOTE_MOTOR_POWER_UP * leftCorrection);
			}
			else
			{
				moveLeftForkMotors(0);
			}
			
			if((toteCollectUp > 0) && !isRightToteUpper)
			{
				if( isCorrecting == true)
				{
					if (encodeFR > encodeFL)
					{
						rightCorrection = 0.9;
					}
				}
				moveRightForkMotors(-BTConstants.TOTE_MOTOR_POWER_DOWN_RIGHT* rightCorrection);
			}
			else if((toteCollectDown > 0) && !isRightToteLower)
			{
				if( isCorrecting == true)
				{
					if (encodeFL > encodeFR)
					{
						rightCorrection = 0.9;
					}
				}
				moveRightForkMotors(BTConstants.TOTE_MOTOR_POWER_UP_RIGHT * rightCorrection);
			}
			else
			{
				moveRightForkMotors(0);
			}
		
/*		if (isCorrecting)
		{
			if (encoder_delta > BTConstants.ENCODER_MARGIN_OF_ERROR)
			{
				if((toteCollectUp > 0) && !isLeftToteUpper)
				{
					moveRightForkMotors(-BTConstants.TOTE_MOTOR_POWER_DOWN * BTConstants.ENCODER_MOTOR_CORRECTION);
					moveLeftForkMotors(BTConstants.TOTE_MOTOR_POWER_DOWN);
				}
				else if((toteCollectDown > 0) && !isLeftToteLower)
				{
					moveRightForkMotors(BTConstants.TOTE_MOTOR_POWER_UP * BTConstants.ENCODER_MOTOR_CORRECTION);
					moveLeftForkMotors(-BTConstants.TOTE_MOTOR_POWER_UP);
				}
				else
				{
					moveRightForkMotors(0);
					moveLeftForkMotors(0);
				}
			}
			else 
			{
				if((toteCollectUp > 0) && !isLeftToteUpper)
				{
					moveLeftForkMotors(-BTConstants.TOTE_MOTOR_POWER_DOWN * BTConstants.ENCODER_MOTOR_CORRECTION);
					moveRightForkMotors(BTConstants.TOTE_MOTOR_POWER_DOWN);
				}
				else if((toteCollectDown > 0) && !isLeftToteLower)
				{
					moveLeftForkMotors(BTConstants.TOTE_MOTOR_POWER_UP * BTConstants.ENCODER_MOTOR_CORRECTION);
					moveRightForkMotors(-BTConstants.TOTE_MOTOR_POWER_UP);
				}
				else
				{
					moveLeftForkMotors(0);
					moveRightForkMotors(0);
				}
			}	
		}
	*/	
		if (isLeftToteUpper && isRightToteUpper)
		{
			storage.robot.getLeftEncoder().reset();
			storage.robot.getRightEncoder().reset();
		}
		
		if (isLeftToteLower && isRightToteLower)
		{
			storage.robot.getLeftEncoder().reset();
			storage.robot.getRightEncoder().reset();
		}
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
		if(toteCollectUp > 0)
		{
		storage.robot.getRightForkLeft().setX(-BTConstants.TOTE_MOTOR_POWER_UP * BTConstants.ENCODER_MOTOR_CORRECTION);
		storage.robot.getRightForkRight().setX(-BTConstants.TOTE_MOTOR_POWER_UP * BTConstants.ENCODER_MOTOR_CORRECTION);
		}
		if(toteCollectDown > 0)
		{
		storage.robot.getRightForkLeft().setX(BTConstants.TOTE_MOTOR_POWER_UP * BTConstants.ENCODER_MOTOR_CORRECTION);
		storage.robot.getRightForkRight().setX(BTConstants.TOTE_MOTOR_POWER_UP * BTConstants.ENCODER_MOTOR_CORRECTION);
		}
	}
	
	public void lowerLeftSideSpeed()
	{
		if(toteCollectUp > 0)
		{
		storage.robot.getLeftForkLeft().setX(-BTConstants.TOTE_MOTOR_POWER_UP * BTConstants.ENCODER_MOTOR_CORRECTION);
		storage.robot.getLeftForkRight().setX(-BTConstants.TOTE_MOTOR_POWER_UP * BTConstants.ENCODER_MOTOR_CORRECTION);
		}
		if (toteCollectDown > 0)
		{
			storage.robot.getLeftForkLeft().setX(BTConstants.TOTE_MOTOR_POWER_UP * BTConstants.ENCODER_MOTOR_CORRECTION);
			storage.robot.getLeftForkRight().setX(BTConstants.TOTE_MOTOR_POWER_UP * BTConstants.ENCODER_MOTOR_CORRECTION);
		}
		
	}
	
	public void containmentIn()
	{
		storage.robot.getFrontContainmentMotor().setX(BTConstants.FRONT_CONTAINMENT_MOTOR_POWER);
	}
	
	public void containmentOut()
	{
		storage.robot.getFrontContainmentMotor().setX(-BTConstants.FRONT_CONTAINMENT_MOTOR_POWER);
	}
	
}