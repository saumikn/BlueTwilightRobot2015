package org.usfirst.frc.team2220.robot.piston;

import edu.wpi.first.wpilibj.Solenoid;

public class BTPiston
{
	private final Solenoid left;
	private final Solenoid right;
	
	public BTPiston(int extend, int retract)
	{
		left = new Solenoid(1, extend);
		right = new Solenoid(1, retract);
	}
	
	 public void set(boolean up)
	 {
		 left.set(up);
		 right.set(!up);
	 }
	    
	 /**
	     * extends the piston
	     */
	 public void extend()
	 {
		 right.set(false);
		 left.set(true);
	 }
	
	 /**
	  * retracts the piston
	  */
	 public void retract()
	 {
		 left.set(false);
		 right.set(true);
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
