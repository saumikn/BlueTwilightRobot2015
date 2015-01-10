package org.usfirst.frc.team2220.robot.drivetrain;

import org.usfirst.frc.team2220.robot.BTConstants;
import org.usfirst.frc.team2220.robot.BTStorage;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;

public class BTOctocanum implements BTIDrivetrain
{
	public BTStorage storage;
	
	private RobotDrive roboDrive;
	
	private RobotDrive tank;
	
	private boolean extended;
	
	public BTOctocanum(BTStorage storage)
	{
		this.storage = storage;
		roboDrive = new RobotDrive(BTConstants.MEC_FRONT_LEFT,
					BTConstants.MEC_BACK_LEFT, 
					BTConstants.MEC_FRONT_RIGHT, 
					BTConstants.MEC_BACK_RIGHT);
		for (MotorType motor : BTConstants.REVERSED_MOTORS)
		{
			roboDrive.setInvertedMotor(motor, true);
		}
		tank = roboDrive;
		for (MotorType motor : BTConstants.REVERSED_MOTORS)
		{
			tank.setInvertedMotor(motor, true);
		}
	}
	
	public void init()
	{
		storage.data.DRIVETRAIN.retract();
		extended = false;
	}

	@Override
	public void drive()
	{
		// Toggle piston extension if the switch was pressed
		if(storage.controller.getOctoSwitch().getLeadingEdge())
		{
			if(extended)
			{
				storage.data.DRIVETRAIN.retract();
				extended = false;
			}
			else
			{
				storage.data.DRIVETRAIN.extend();
				extended = true;
			}
		}
		
		System.out.println("IS EXTENDED? " + extended);
		
		// Use a mecanum drive or a tank drive depending on if the piston was extended		
		if(extended)
		{
			double lr = storage.controller.getDriveLeftRight().getValue();
	        double ud = storage.controller.getDriveFrontBack().getValue();
	               
	        double mag = Math.sqrt(lr * lr + ud * ud);
	        double dir = Math.atan(ud / lr);
	        double rotation = storage.controller.getDriveRotate().getValue();
	        
			roboDrive.mecanumDrive_Polar(mag, dir, rotation);
		}
		else
		{
			roboDrive.tankDrive(storage.controller.getLeftDriveFrontBack().getValue(), storage.controller.getRightDriveFrontBack().getValue());
		}
		
		
	}
	
	
	
}
