package org.usfirst.frc.team2220.robot.electronics;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2220.robot.BTConstants;

public class BTLights 
{
	DigitalOutput bit0 = new DigitalOutput(BTConstants.ARDUINO_BIT0);
	DigitalOutput bit1 = new DigitalOutput(BTConstants.ARDUINO_BIT1);
	DigitalOutput bit2 = new DigitalOutput(BTConstants.ARDUINO_BIT2);
	
	public void setLEDColor(int color)
	{
		writeColor(color);
		SmartDashboard.putNumber("LED Color command", color);
	}
	
	private void writeColor(int color)
	{
		boolean b0 = (color & 1) > 0;
		boolean b1 = (color & 2) > 0;
		boolean b2 = (color & 4) > 0;
	
		bit0.set(b0);
		bit1.set(b1);
		bit2.set(b2);
	}
}
