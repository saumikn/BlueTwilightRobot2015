package org.usfirst.frc.team2220.robot;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class BTMacroPlay {
	Scanner scanner;
	long startTime;

	boolean onTime = true;
	double nextDouble;
	

	public BTMacroPlay() throws FileNotFoundException
	{
		scanner = new Scanner(new File(BTMain.autoFile));
		
		scanner.useDelimiter(",|\\n");
		startTime = System.currentTimeMillis();	
	}
	
	public void play(BTStorage storage)
	{
		if ((scanner != null) && (scanner.hasNextDouble()))
		{
			double t_delta;
			if(onTime)
			{
				nextDouble = scanner.nextDouble();
			}
			//time recorded for values minus how far into replaying it we are--> if not zero, hold up
			t_delta = nextDouble - (System.currentTimeMillis()-startTime);
			
			if (t_delta <= 0)
			{
				storage.robot.getFrontLeftMotor().setX(scanner.nextDouble());
				storage.robot.getFrontRightMotor().setX(scanner.nextDouble());
				storage.robot.getBackRightMotor().setX(scanner.nextDouble());
				storage.robot.getBackLeftMotor().setX(scanner.nextDouble());
				storage.robot.getBarrelHolder().set(scanner.nextBoolean());
				storage.robot.getToteClamp().set(scanner.nextBoolean());
				
				onTime = true;
			}	
			else
			{
				onTime = false;
			}
		}
		else
		{
			this.end(storage);
			if (scanner != null) 
			{
				scanner.close();
				scanner = null;
			}
		}
		
	}
	
	public void end(BTStorage storage)
	{
		storage.robot.getFrontLeftMotor().setX(0);
		storage.robot.getBackLeftMotor().setX(0);
		storage.robot.getFrontRightMotor().setX(0);
		storage.robot.getBackRightMotor().setX(0);
		storage.robot.getBarrelHolder().set(storage.robot.getBarrelHolder().isExtended());
		storage.robot.getToteClamp().set(storage.robot.getToteClamp().isExtended());
		
		
		if (scanner != null) 
		{
			scanner.close();
		}
		
	}
	
}
