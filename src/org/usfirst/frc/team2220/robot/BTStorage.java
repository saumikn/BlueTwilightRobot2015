package org.usfirst.frc.team2220.robot;

import org.usfirst.frc.team2220.robot.controller.BTIController;
import org.usfirst.frc.team2220.robot.robottype.BTCompetitionRobot;
import org.usfirst.frc.team2220.robot.robottype.BTIRobotType;

public class BTStorage
{
    public BTIRobotType robot;
    public BTIController controller;
    
    public BTStorage()
    {
        robot = new BTCompetitionRobot();
        controller = BTConstants.CONTROLLER;
    }
}
