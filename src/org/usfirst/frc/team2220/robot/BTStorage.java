package org.usfirst.frc.team2220.robot;

import org.usfirst.frc.team2220.robot.controller.BTXboxController;

public class BTStorage
{
    public BTData data;
    public BTXboxController xcon;
    
    public BTStorage()
    {
        data = new BTData();
        xcon = new BTXboxController(1);
    }
}
