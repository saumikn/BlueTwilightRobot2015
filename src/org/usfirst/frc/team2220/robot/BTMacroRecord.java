package org.usfirst.frc.team2220.robot;
import java.io.FileWriter;
import java.io.IOException;

public class BTMacroRecord {
	FileWriter writer;
	long startTime;
	boolean isFirstTime;
	
	public BTMacroRecord() throws IOException
	{
		writer = new FileWriter(BTMain.autoFile);
		isFirstTime = true;
	}
	

	public void record(BTStorage storage) throws IOException
	{
		if (writer !=null)
		{
			if(isFirstTime)
			{
				startTime = System.currentTimeMillis();
				isFirstTime = false;
			}
			
			//time
			writer.append("" + (System.currentTimeMillis()-startTime));
			
			//drive motors
			writer.append("," + storage.robot.getFrontLeftMotor().get());
			writer.append("," + storage.robot.getFrontRightMotor().get());
			writer.append("," + storage.robot.getBackRightMotor().get());
			writer.append("," + storage.robot.getBackLeftMotor().get());
			//this is how you do a piston with this macro
			writer.append("," + storage.robot.getBarrelHolder().isExtended());
			
			/*
			 * THE LAST ENTRY OF THINGS YOU RECORD NEEDS TO HAVE A COMMA CONCATENATED TO 
			 * THE STRING AT THE END. OTHERWISE GIVES NOSUCHELEMENTEXCEPTION
			 */ 
			writer.append("," + storage.robot.getToteClamp().isExtended() + "\n");
		}
	}
	
	public void end() throws IOException
	{
		if (writer != null)
		{
			writer.flush();
			writer.close();
		}
	}
}
