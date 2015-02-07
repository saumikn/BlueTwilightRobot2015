
package org.usfirst.frc.team2220.robot;


import org.usfirst.frc.team2220.robot.autonomous.BTAuto;
import org.usfirst.frc.team2220.robot.autonomous.BTIAutonomousRoutine;
import org.usfirst.frc.team2220.robot.drivetrain.BTMeca;
import org.usfirst.frc.team2220.robot.drivetrain.BTOcto;
import org.usfirst.frc.team2220.robot.manipulator.BTManipulator;

import edu.wpi.first.wpilibj.SampleRobot;

public class BTMain extends SampleRobot
{
	// Testing folder
	//BTMeca meca;
	//BTOcto octo;
	BTStorage storage;
	BTIAutonomousRoutine auto;
	BTTestClass test;
	BTManipulator manipulator;
	
    public BTMain()
    {
    	
    }
	
	@Override
    public void robotInit()
    {
		storage = new BTStorage();
    	//meca = new BTMeca(storage);	
    	//manipulator = new BTManipulator(storage);
    	auto = new BTAuto(storage, manipulator);
    	test = new BTTestClass(storage);
    	//octo = new BTOcto(storage);
    	
    	//meca.init();
    	
    	storage.data.GYRO.reset();
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
