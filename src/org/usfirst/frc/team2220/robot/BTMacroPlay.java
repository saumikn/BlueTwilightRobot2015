package org.usfirst.frc.team2220.robot;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class BTMacroPlay {
	Scanner scanner;
	long startTime;
	

	public BTMacroPlay() throws FileNotFoundException
	{
		scanner = new Scanner(new File("/home/lvuser/recordedAuto.csv"));
		
		scanner.useDelimiter(",");
		startTime = System.currentTimeMillis();	
	}
	
	public void play(BTStorage storage)
	{
		//time recorded for values - how far into replaying it we are--> if not zero, hold up
		double t_delta = scanner.nextDouble() - (System.currentTimeMillis()-startTime);
		if (t_delta <= 0)
		{
			storage.robot.getFrontLeftMotor().setX(scanner.nextDouble());
			storage.robot.getBackLeftMotor().setX(scanner.nextDouble());
			storage.robot.getFrontRightMotor().setX(scanner.nextDouble());
			storage.robot.getBackRightMotor().setX(scanner.nextDouble());
			
			storage.robot.getBarrelMotorLeft().setX(scanner.nextDouble());
			storage.robot.getBarrelMotorRight().setX(scanner.nextDouble());
			
			storage.robot.getLeftForkLeft().setX(scanner.nextDouble());
			storage.robot.getLeftForkRight().setX(scanner.nextDouble());
			storage.robot.getRightForkLeft().setX(scanner.nextDouble());
			storage.robot.getRightForkRight().setX(scanner.nextDouble());
		}	
		
	}
	
	public void end(BTStorage storage)
	{
		storage.robot.getFrontLeftMotor().setX(0);
		storage.robot.getBackLeftMotor().setX(0);
		storage.robot.getFrontRightMotor().setX(0);
		storage.robot.getBackRightMotor().setX(0);
		
		storage.robot.getBarrelMotorLeft().setX(0);
		storage.robot.getBarrelMotorRight().setX(0);
		
		storage.robot.getLeftForkLeft().setX(0);
		storage.robot.getLeftForkRight().setX(0);
		storage.robot.getRightForkLeft().setX(0);
		storage.robot.getRightForkRight().setX(0);
	}
	
}
