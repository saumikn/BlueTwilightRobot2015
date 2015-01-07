package org.usfirst.frc.team2220.robot.drivetrain;

import org.usfirst.frc.team2220.robot.BTStorage;

public class BTMecanum implements BTIDrivetrain
{
	public BTStorage storage;
	
	public BTMecanum(BTStorage storage)
	{
		this.storage = storage;
	}
	

	@Override
	public void drive()
	{
		double lr = storage.xcon.getDriveLeftRight().getValue();
        double ud = storage.xcon.getDriveFrontBack().getValue();
               
        double mag = Math.sqrt(lr * lr + ud * ud);
        double angle = Math.atan(ud / lr);
        double rotation = storage.xcon.getDriveRotate().getValue();
        
        double fl = mag * Math.sin(angle + Math.PI / 4) + rotation;
        double fr = mag * Math.cos(angle + Math.PI / 4) - rotation;
        double bl = mag * Math.cos(angle + Math.PI / 4) + rotation;
        double br = mag * Math.sin(angle + Math.PI / 4) - rotation;
        
        double max = 1;
        
        if(Math.abs(fl) > 1 || Math.abs(fr) > 1 || Math.abs(bl) > 1 || Math.abs(br) > 1)
        {
            max = Math.max(Math.abs(fl),Math.abs(fr));
            max = Math.max(max, Math.abs(bl));
            max = Math.max(max, Math.abs(br));
        }
        
        
        
        storage.data.MOTOR_BL.setX(-bl / max);
        storage.data.MOTOR_BR.setX(br / max);
        storage.data.MOTOR_FL.setX(-fl / max);
        storage.data.MOTOR_FR.setX(fr / max);
	}
	
}
