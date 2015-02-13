package org.usfirst.frc.team2220.robot;

import org.usfirst.frc.team2220.robot.controller.BTIController;
import org.usfirst.frc.team2220.robot.robottype.BTCompetitionRobot;
import org.usfirst.frc.team2220.robot.robottype.BTIRobotType;
import org.usfirst.frc.team2220.robot.robottype.BTTestBot;

public class BTStorage
{
    public BTIRobotType robot;
    public BTIController controller;
    
    public BTStorage()
    {
        robot = BTConstants.ROBOT_TYPE;
        controller = BTConstants.CONTROLLER;
    }
}
