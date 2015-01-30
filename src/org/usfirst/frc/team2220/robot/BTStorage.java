package org.usfirst.frc.team2220.robot;

import org.usfirst.frc.team2220.robot.controller.BTIController;
import org.usfirst.frc.team2220.robot.robottype.BTCompetitionRobot;

public class BTStorage
{
    public BTData data;
    public BTIController controller;
    public BTCompetitionRobot compRobot; // This lines determines which hardware the code is being sent to
    
    public BTStorage()
    {
        data = new BTData(compRobot);
        controller = BTConstants.CONTROLLER;
    }
}
