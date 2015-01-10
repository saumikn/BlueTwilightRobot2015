package org.usfirst.frc.team2220.robot;

import org.usfirst.frc.team2220.robot.controller.BTIController;

public class BTStorage
{
    public BTData data;
    public BTIController con;
    
    public BTStorage()
    {
        data = new BTData();
        con = BTConstants.CONTROLLER;
    }
}
