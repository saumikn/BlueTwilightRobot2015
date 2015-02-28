
package org.usfirst.frc.team2220.robot;


import org.usfirst.frc.team2220.robot.autonomous.BTAuto;
import org.usfirst.frc.team2220.robot.autonomous.BTAutoContinuous;
import org.usfirst.frc.team2220.robot.autonomous.BTIAutonomousRoutine;
//import org.usfirst.frc.team2220.robot.drivetrain.BTMeca;
//import org.usfirst.frc.team2220.robot.drivetrain.BTOcto;
import org.usfirst.frc.team2220.robot.drivetrain.BTTankMeca;
import org.usfirst.frc.team2220.robot.manipulator.BTManipulator;


//import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.SampleRobot;

public class BTMain extends SampleRobot
{
	// Testing folders
	BTTankMeca meca;
	//BTOcto octo;
	BTStorage storage;
	BTIAutonomousRoutine auto;
	//BTTestClass test;
	BTManipulator manipulator;
	//CameraServer server;
	
    public BTMain()
    {
    	
    }
	
	@Override
    public void robotInit()
    {
		Compressor comp = new Compressor();
		
		
		storage = new BTStorage();
		if(BTConstants.IS_TEST)
		{
		//	test = new BTTestClass(storage);
			meca = new BTTankMeca(storage);
		}
		else
		{
			meca = new BTTankMeca(storage);
			manipulator = new BTManipulator(storage);
			auto = new BTAutoContinuous(storage, manipulator);
		}
    	//octo = new BTOcto(storage);   	
		if (storage.robot.getGyro() != null)
		{
			storage.robot.getGyro().reset();
		}
		
		storage.robot.getBarrelHolder().retract();
//	   	server = CameraServer.getInstance();
//        server.setQuality(50);
//        server.startAutomaticCapture("cam0");
	}
	
	//@Override
    public void autonomous()
    {
		while (isAutonomous())
		{
			auto.runAutonomous();
		}
    	
    }
	
	//@Override
    public void operatorControl()
    {
    	while(isOperatorControl())
    	{
    		//test.test();
    		meca.drive();
    		manipulator.perform();
		}
    }
	
	//@Override
    public void disabled()
    {
    	
    }
}
