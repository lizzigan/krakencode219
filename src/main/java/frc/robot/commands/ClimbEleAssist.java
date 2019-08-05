package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class ClimbEleAssist extends Command
{
    private double startPos;
    private double eleStartPos;
    public ClimbEleAssist()
    {
        requires(Robot.climb);
        requires(Robot.ele);
    }

    protected void initialize()
    {
       // Robot.ahrs.reset();
       startPos=Robot.climb.getSparkRampPosition();
       eleStartPos=Robot.ele.getPosition();
    }

    protected void execute() {
        Robot.climb.runSparkRamp(Robot.m_oi.getSecondY());
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
        Robot.ele.elevate(0);
        System.out.println(Robot.climb.getSparkRampPosition());
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}