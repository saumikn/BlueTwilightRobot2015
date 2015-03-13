/*
 * 
 */
package org.usfirst.frc.team2220.robot.electronics;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Timer;

/**
 * @author Ben
 * @date 3_7_2015
 * Creates a separate thread for the USB camera to run in, start function called
 * in BTMain as last method call in robotInit.
 * Hopefully takes advantage of dual-core roboRIo
 *
 */

public class BTCameraThreaded extends Thread
{
	CameraServer server;
	public int session;
	public Image frame;
	
	
	public BTCameraThreaded()
	{		
	}
	
	public void run()
	{
		NIVision.IMAQdxGrab(session,frame, 1);

        CameraServer.getInstance().setImage(frame);
        
        Timer.delay(0.000);
	}
}
