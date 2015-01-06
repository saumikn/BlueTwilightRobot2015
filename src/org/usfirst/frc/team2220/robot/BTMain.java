
package org.usfirst.frc.team2220.robot;


import org.usfirst.frc.team2220.robot.compressor.BTCompressor;
import org.usfirst.frc.team2220.robot.drivetrain.BTOctocanum;

import edu.wpi.first.wpilibj.SampleRobot;

public class BTMain extends SampleRobot
{
	BTCompressor comp;
	BTOctocanum octo;
	BTStorage storage;
	
    
	@Override
    public void robotInit()
    {
    	octo = new BTOctocanum(storage);
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
    	while(isOperatorControl())
    	{
    		octo.drive();
    		
    	}
    }
	
	@Override
    public void disabled()
    {
    	
    }
}
