package org.usfirst.frc.team2220.robot.manipulator;

import org.usfirst.frc.team2220.robot.BTStorage;

public class BTManipulator implements BTIManipulator
{
	public BTStorage storage;
	
	public BTManipulator(BTStorage storage)
	{
		this.storage = storage;
	}
	
	boolean isToteSwitch;
	@Override
	public void perform()
	{
		isToteSwitch = storage.data.TOTE_SWITCH.getValue();		
	}

}
