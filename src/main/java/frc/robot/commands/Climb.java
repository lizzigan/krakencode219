package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;


public class Climb extends Command
{
    private double startPos;
    private boolean suck;
    public Climb(boolean s)
    {
        requires(Robot.climb);
        suck=s;
    }

    protected void initialize()
    {
       // Robot.ahrs.reset();
       startPos=(Robot.climb.getSparkRampPosition());
       System.out.println(Robot.climb.getSparkRampPosition());
    }

    protected void execute() {
        Robot.climb.runSparkRamp(Robot.m_oi.getSecondY());
        if(suck)
        {
            Robot.climb.suck(1);
        }
        SmartDashboard.putNumber("ClimberBorther",Robot.climb.getSparkRampPosition()-startPos);
    }
    protected boolean isFinished() 
    {
        // if (Robot.climb.sparkSRamp.getOutputCurrent()>=3.4)
        //  {
        //      return true;
        //  }
        return false;
    }
    protected void end() {
        Robot.climb.runSparkRamp(0);
        Robot.climb.suck(0);
        System.out.println(Robot.climb.getSparkRampPosition());
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}