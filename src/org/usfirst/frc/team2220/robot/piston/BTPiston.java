package org.usfirst.frc.team2220.robot.piston;

import edu.wpi.first.wpilibj.Solenoid;

public class BTPiston
{
	private final Solenoid left;
	private final Solenoid right;
	
	public BTPiston(int extend, int retract)
	{
		left = new Solenoid(extend);
		right = new Solenoid(retract);
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
		 set(true);
	 }
	
	 /**
	  * retracts the piston
	  */
	 public void retract()
	 {
		 set(false);
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
