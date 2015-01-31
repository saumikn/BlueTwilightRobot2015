package org.usfirst.frc.team2220.robot;

import org.usfirst.frc.team2220.robot.controller.BTIController;
import org.usfirst.frc.team2220.robot.robottype.BTCompetitionRobot;
import org.usfirst.frc.team2220.robot.robottype.BTTestBot;

public class BTStorage
{
    public BTData data;
    public BTIController controller;
    public BTTestBot testbot = new BTTestBot(); // This lines determines which hardware the code is being sent to
    
    public BTStorage()
    {
        data = new BTData(testbot);
        controller = BTConstants.CONTROLLER;
    }
}
