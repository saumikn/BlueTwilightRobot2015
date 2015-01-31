
package org.usfirst.frc.team2220.robot;


import org.usfirst.frc.team2220.robot.autonomous.BTAuto1;
import org.usfirst.frc.team2220.robot.autonomous.BTIAutonomousRoutine;
import org.usfirst.frc.team2220.robot.drivetrain.BTMeca;

import edu.wpi.first.wpilibj.SampleRobot;

public class BTMain extends SampleRobot
{
	// Testing folders
	BTMeca meca;
	BTStorage storage;
	BTIAutonomousRoutine auto;
	BTTestClass test;
	
    public BTMain()
    {
    	
    }
	
	@Override
    public void robotInit()
    {
		storage = new BTStorage();
    	meca = new BTMeca(storage);	
    	auto = new BTAuto1(storage);
    	test = new BTTestClass(storage);
    	
    	//meca.init();
    }
	
	//@Override
    public void autonomous()
    {
		auto.runAutonomous();
    }
	
	//@Override
    public void operatorControl()
    {
    	while(isOperatorControl())
    	{
    		test.test();
    		//meca.drive();
    		//[something].perform();
    	}
    }
	
	//@Override
    public void disabled()
    {
    	
    }
}
