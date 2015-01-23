
package org.usfirst.frc.team2220.robot;


import org.usfirst.frc.team2220.robot.compressor.BTCompressor;
import org.usfirst.frc.team2220.robot.drivetrain.BTMeca;

import edu.wpi.first.wpilibj.SampleRobot;

public class BTMain extends SampleRobot
{
	// Testing folders
	BTCompressor comp;
	BTMeca meca;
	BTStorage storage;
	
    public BTMain()
    {
    	
    }
	
	@Override
    public void robotInit()
    {
		storage = new BTStorage();
    	meca = new BTMeca(storage);	
    	//meca.init();
    	comp = new BTCompressor();
    }
	
	//@Override
    public void autonomous()
    {
		
    }
	
	//@Override
    public void operatorControl()
    {
    	while(isOperatorControl())
    	{
    		meca.drive();
    		//[something].perform();
    	}
    }
	
	//@Override
    public void disabled()
    {
    	
    }
}
