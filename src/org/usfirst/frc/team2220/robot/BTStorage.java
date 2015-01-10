package org.usfirst.frc.team2220.robot;

import org.usfirst.frc.team2220.robot.controller.BTIController;

public class BTStorage
{
    public BTData data;
    public BTIController controller;
    
    public BTStorage()
    {
        data = new BTData();
        controller = BTConstants.CONTROLLER;
    }
}
