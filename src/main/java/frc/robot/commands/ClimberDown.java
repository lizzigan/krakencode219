package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class ClimberDown extends Command
{
    public ClimberDown()
    {
        requires(Robot.climb);
    }

    protected void initialize()
    {
        //Robot.ahrs.reset();
        //Robot.rampSeperator.setTalonRamp(0);
    }

    protected void execute() {
        Robot.climb.runSparkRamp(Robot.m_oi.getSecondY());
    }
    protected boolean isFinished() 
    {
        // if (Robot.rampSeperator.getTalonRampPosition()>2)
        // {
        //     return true;
        // }
        // if (Robot.climb.sparkSRamp.getOutputCurrent()>=3.4)
        //  {
        //      return true;
        //  }
        return false;
    }
    protected void end() {
        Robot.climb.runSparkRamp(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}