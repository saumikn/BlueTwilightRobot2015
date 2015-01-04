package org.usfirst.frc.team2220.robot.controller.modules;

public interface BTIConButton
{
	/**
	 * Gets the current state of the joystick button
	 * 
	 * @return	If the button is pressed
	 */
	public boolean getValue();
	
	
	/**
	 * Returns if the button has been pressed since getValue() was
	 * previously called
	 * 
	 * @return	If the button was pressed since the last invocation of getValue()
	 */
	public boolean getLeadingEdge();
	
	/**
	 * Returns if the button is held down, but not just pressed
	 * 
	 * @return	If the button is held down
	 */
	public boolean getContinuousEdge();
	
	
	/**
	 * Returns if the button was released since getValue() was
	 * previously called
	 * 
	 * @return	If the button was released
	 */
	public boolean getBackEdge();
}
