package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Timer;



public class ClimbEncoderMotion extends Command
{
    private double finish;
    private double max;
    private double min;
    private double startpos;
    private Timer time;
    
    public ClimbEncoderMotion(double end,double maxSpeed, double minSpeed)
    {
        requires(Robot.climb);
        finish = end;
        max=maxSpeed;
        min=minSpeed;

    }

    protected void initialize()
    {
       // Robot.ahrs.reset();
        startpos= Robot.climb.getSparkRampPosition();
        
    }

    protected void execute() {
        if(max*(-1+Math.abs(1/(finish/2)*(finish/2-Robot.climb.getSparkRampPosition()-startpos)))>min)
        {
            Robot.climb.runSparkRamp(max*(-1+Math.abs(1/(finish/2)*(finish/2-Robot.climb.getSparkRampPosition()-startpos))));
        }
        else
        {
            Robot.climb.runSparkRamp(min);
        }
        SmartDashboard.putNumber("ClimPos", Robot.climb.getSparkRampPosition());
        SmartDashboard.putNumber("ClimbVel",Robot.climb.getSparkRampVelocity());
    }
    protected boolean isFinished() 
    {
        // if (Robot.climb.sparkSRamp.getOutputCurrent()>=3.4)
        //  {
        //      return true;
        //  }
        if (Math.abs(Robot.climb.getSparkRampPosition()-startpos)>finish)
        {
            return true;
        }
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