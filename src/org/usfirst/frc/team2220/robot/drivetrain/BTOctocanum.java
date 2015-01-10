package org.usfirst.frc.team2220.robot.drivetrain;

import org.usfirst.frc.team2220.robot.BTConstants;
import org.usfirst.frc.team2220.robot.BTStorage;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;

public class BTOctocanum implements BTIDrivetrain
{
	public BTStorage storage;
	
	private RobotDrive meca;
	
	private RobotDrive tank;
	
	private boolean extended;
	
	public BTOctocanum(BTStorage storage)
	{
		this.storage = storage;
		meca = new RobotDrive(BTConstants.MEC_FRONT_LEFT,
					BTConstants.MEC_BACK_LEFT, 
					BTConstants.MEC_FRONT_RIGHT, 
					BTConstants.MEC_BACK_RIGHT);
		for (MotorType motor : BTConstants.REVERSED_MOTORS)
		{
			meca.setInvertedMotor(motor, true);
		}
		tank = new RobotDrive(BTConstants.TANK_FRONT_LEFT,
					BTConstants.TANK_BACK_LEFT, 
					BTConstants.TANK_FRONT_RIGHT, 
					BTConstants.TANK_BACK_RIGHT);
		for (MotorType motor : BTConstants.REVERSED_MOTORS)
		{
			tank.setInvertedMotor(motor, true);
		}
		extended = false;
	}

	@Override
	public void drive()
	{
//		boolean extend = storage.data.DRIVETRAIN.isExtended();
		if(storage.controller.getOctoSwitch().getLeadingEdge())
		{
			System.out.println("Extended = " + extended);
			if(extended)
			{
				System.out.println("Extended was true");
				storage.data.DRIVETRAIN.retract();
				extended = false;
			}
			else
			{
				System.out.println("Extended was true");
				storage.data.DRIVETRAIN.extend();
				extended = true;
			}
		}
		
		if(extended)
		{
			double lr = storage.controller.getDriveLeftRight().getValue();
	        double ud = storage.controller.getDriveFrontBack().getValue();
	               
	        double mag = Math.sqrt(lr * lr + ud * ud);
	        double dir = Math.atan(ud / lr);
	        double rotation = storage.controller.getDriveRotate().getValue();
	        
			meca.mecanumDrive_Polar(mag, dir, rotation);
		}
		else
		{
			tank.tankDrive(storage.controller.getLeftDriveFrontBack().getValue(), storage.controller.getDriveFrontBack().getValue());
		}
		
		
	}
	
	
	
}
