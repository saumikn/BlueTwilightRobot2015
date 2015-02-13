package org.usfirst.frc.team2220.robot.electronics;

import edu.wpi.first.wpilibj.Solenoid;

public class BTSinglePiston implements BTIPiston
{
	private Solenoid left;
	private Solenoid right;
	
	public BTSinglePiston(){}
	
	public BTSinglePiston(int extend, int retract)
	{
		left = new Solenoid(1, extend);
		right = new Solenoid(1, retract);
	}
	
	 public void set(boolean up)
	 {
		 left.set(up);
		 right.set(up);
	 }
	    
	 /**
	  * extends the piston
	  */
	 public void extend()
	 {
		 right.set(true);
		 left.set(true);
	 }
	
	 /**
	  * retracts the piston
	  */
	 public void retract()
	 {
		 left.set(false);
		 right.set(false);
	 }
	    
	 /**
	  * returns true if the piston is extended, false otherwise.
	  * @return true if the piston is extended, false otherwise.
	  */
	 public boolean isExtended()
	 {
		 return left.get();
	 }
}
