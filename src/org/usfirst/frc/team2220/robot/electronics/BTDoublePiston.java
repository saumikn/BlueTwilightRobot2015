package org.usfirst.frc.team2220.robot.electronics;

import edu.wpi.first.wpilibj.Solenoid;

public class BTDoublePiston implements BTIPiston
{
	private Solenoid left  = null;
	private Solenoid right = null;
	
	public BTDoublePiston(){}
	
	public BTDoublePiston(int extend, int retract)
	{
		if (extend != -1 && retract != -1)
		{
			left = new Solenoid(1, extend);
			right = new Solenoid(1, retract);
		}
	}
	
	public boolean exists()
	{
		return left != null && right != null;
	}
	
	public void set(boolean up)
 	{
	 	if (exists())
	 	{
	 		left.set(up);
		 	right.set(!up);
	 	}
 	}
	    
	 /**
	     * extends the piston
	     */
	 public void extend()
	 {
	 	if (exists())
	 	{
	 		right.set(false);
	 		left.set(true);
	 	}
	 }
	
	 /**
	  * retracts the piston
	  */
	 public void retract()
	 {
	 	if (exists())
	 	{
		 left.set(false);
		 right.set(true);
	 	}
	 }
	    
	 /**
	  * returns true if the piston is extended, false otherwise.
	  * @return true if the piston is extended, false otherwise.
	  */
	 public boolean isExtended()
	 {
	 	if (exists())
	 	{
	 		return left.get();
	 	}
	 	return false;
	 }
}
