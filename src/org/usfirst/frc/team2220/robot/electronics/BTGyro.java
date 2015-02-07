package org.usfirst.frc.team2220.robot.electronics;
import edu.wpi.first.wpilibj.Gyro;

public class BTGyro
{

    private Gyro gyro;

    public BTGyro(){}

    public BTGyro(int port)
    {
        gyro = new Gyro(port);
    }
    
    public void reset()
    {
    	gyro.reset();
    }
    
    public double getAngle()
    {
    	return gyro.getAngle();
    }
}