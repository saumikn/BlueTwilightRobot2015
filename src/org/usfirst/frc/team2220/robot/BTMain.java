
package org.usfirst.frc.team2220.robot;


import org.usfirst.frc.team2220.robot.compressor.BTCompressor;
import org.usfirst.frc.team2220.robot.drivetrain.BTMecanum;
import org.usfirst.frc.team2220.robot.drivetrain.BTOctocanum;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SampleRobot;

public class BTMain extends SampleRobot
{
	BTCompressor comp;
	BTOctocanum octo;
	BTStorage storage;
	BTMecanum meca;
    
	public BTMain()
	{
		
	}
	
	@Override
    public void robotInit()
    {
		storage = new BTStorage();
    	octo = new BTOctocanum(storage);
    	meca = new BTMecanum(storage);
    	comp = new BTCompressor();
    }
	
	@Override
    public void autonomous()
    {
		BTConstants.AUTON_ROUTINE.autonomous();
    }
	
	@Override
    public void operatorControl()
    {
    	while(isOperatorControl() && isEnabled())
    	{
    		octo.drive();
    	}
    }
	
	@Override
    public void disabled()
    {
    	
    }
}
