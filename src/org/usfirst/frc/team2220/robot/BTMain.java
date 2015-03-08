
package org.usfirst.frc.team2220.robot;

import org.usfirst.frc.team2220.robot.electronics.BTCameraThreaded;
import org.usfirst.frc.team2220.robot.autonomous.BTAuto;
import org.usfirst.frc.team2220.robot.autonomous.BTAutoContinuous;
import org.usfirst.frc.team2220.robot.autonomous.BTIAutonomousRoutine;
//import org.usfirst.frc.team2220.robot.drivetrain.BTMeca;
//import org.usfirst.frc.team2220.robot.drivetrain.BTOcto;
import org.usfirst.frc.team2220.robot.drivetrain.BTTankMeca;
import org.usfirst.frc.team2220.robot.manipulator.BTManipulator;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;

public class BTMain extends SampleRobot
{
	// Testing folders
	BTTankMeca meca;
	//BTOcto octo;
	BTStorage storage;
	BTIAutonomousRoutine auto;
	//BTTestClass test;
	BTManipulator manipulator;
	CameraServer server;
	BTCameraThreaded T1 = new BTCameraThreaded();
	
	
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
		
		
		T1.start();
		T1.setPriority(Thread.MIN_PRIORITY);
		T1.frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
        T1.session = NIVision.IMAQdxOpenCamera("cam0", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        NIVision.IMAQdxConfigureGrab(T1.session);
        
//	   	server = CameraServer.getInstance();
//        server.setQuality(50);
//        server.startAutomaticCapture("cam0");
		
		
	}
	
	//@Override
    public void autonomous()
    {
    	auto.resetTimer();
		while (isAutonomous())
		{
			auto.runAutonomous();
		}
    	
    }
	
	//@Override
    public void operatorControl()
    {
    	NIVision.IMAQdxStartAcquisition(T1.session);
        
        
    	while(isOperatorControl())
    	{
    		T1.run();
         
    		meca.drive();
    		manipulator.perform();
		}
    	NIVision.IMAQdxStopAcquisition(T1.session);
    }
	
	//@Override
    public void disabled()
    {
    	
    }
}
