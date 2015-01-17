package org.usfirst.frc.team2220.robot.drivetrain;
//Ben was here again
import org.usfirst.frc.team2220.robot.BTConstants;
import org.usfirst.frc.team2220.robot.BTStorage;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;

public class BTOctocanum implements BTIDrivetrain
{
	public BTStorage storage;
	
	private RobotDrive robotDrive;
		
	private boolean extended;
	
	private int counter = 0;
	
	public BTOctocanum(BTStorage storage)
	{
		this.storage = storage;
		robotDrive = new RobotDrive(BTConstants.MEC_FRONT_LEFT,
					BTConstants.MEC_BACK_LEFT, 
					BTConstants.MEC_FRONT_RIGHT, 
					BTConstants.MEC_BACK_RIGHT);
	}
	
	public void init()
	{
		storage.data.DRIVETRAIN_PISTON.retract();
		extended = false;
		for (MotorType motor : BTConstants.MOTOR_TYPES)
		{
			robotDrive.setInvertedMotor(motor, false);
			for (MotorType reversedMotor : BTConstants.REVERSED_MOTORS_TANK)
			{
				if (reversedMotor.equals(motor))
				{
					robotDrive.setInvertedMotor(motor, true);
				}
			}
		}
	}

	@Override
	public void drive()
	{
		// Toggle piston extension if the switch was pressed
		if(storage.controller.getOctoSwitch().getLeadingEdge())
		{
			if(extended)
			{
				storage.data.DRIVETRAIN_PISTON.retract();
				extended = false;
				for (MotorType motor : BTConstants.MOTOR_TYPES)
				{
					robotDrive.setInvertedMotor(motor, false);
					for (MotorType reversedMotor : BTConstants.REVERSED_MOTORS_TANK)
					{
						if (reversedMotor.equals(motor))
						{
							robotDrive.setInvertedMotor(motor, true);
						}
					}
				}
			}
			else
			{
				storage.data.DRIVETRAIN_PISTON.extend();
				extended = true;
				for (MotorType motor : BTConstants.MOTOR_TYPES)
				{
					robotDrive.setInvertedMotor(motor, false);
					for (MotorType reversedMotor : BTConstants.REVERSED_MOTORS_MECANUM)
					{
						if (reversedMotor.equals(motor))
						{
							robotDrive.setInvertedMotor(motor, true);
						}
					}
				}
			}
		}
		
		//System.out.println("IS EXTENDED? " + extended);
		
		// Use a mecanum drive or a tank drive depending on if the piston was extended		
		if(extended)
		{
			
			double stickLeftRight = storage.controller.getDriveLeftRight().getValue();
			if (Math.abs(stickLeftRight) < 0.05) stickLeftRight = 0.0;
	        double stickFrontBack = storage.controller.getDriveFrontBack().getValue();
	        if (Math.abs(stickFrontBack) < 0.05) stickFrontBack = 0.0;
	        double direction = 0;
	        
	        double magnitude = Math.sqrt(stickLeftRight * stickLeftRight + stickFrontBack * stickFrontBack);
	       
	        if (stickLeftRight == 0)
	        {
	        	if (stickFrontBack > 0)
	        	{
	        		direction = 90.0;
	        	}
	        	else
	        	{
	        		direction = 270.0;
	        	}
	        }
	        else
	        {
		        direction = Math.toDegrees(Math.atan(stickFrontBack / stickLeftRight));
	        }
	        
	        if (stickLeftRight < 0)
	        {
	        	direction += 180;
	        }
	        
	        direction += 360 * 5;
	        direction = direction % 360;
	        
	        double rotation = storage.controller.getDriveRotate().getValue();
	        if (Math.abs(rotation) < 0.05) rotation = 0.0;
	        
	        if (counter % 300 == 0)
	        {
		        System.out.println("DIRECTION IS " + direction);
		        System.out.println("ROTATION IS " + rotation);
		        System.out.println("MAGNITUDE IS " + magnitude);
	        }
	        counter++;

			robotDrive.mecanumDrive_Polar(magnitude, direction, rotation);
		}
		else
		{
			robotDrive.tankDrive(storage.controller.getLeftDriveFrontBack().getValue(), storage.controller.getRightDriveFrontBack().getValue());
		}
		
	}
	
	
	
}
