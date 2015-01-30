package org.usfirst.frc.team2220.robot.electronics; 
 
 
import edu.wpi.first.wpilibj.Solenoid; 

public class BTPiston
{ 
	Solenoid left;
	Solenoid right;
	
	public BTPiston(int left, int right)
	{
		this.left = new Solenoid(left);
		this.right = new Solenoid(right);
	}
}