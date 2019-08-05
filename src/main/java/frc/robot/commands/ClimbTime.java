package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Timer;



public class ClimbTime extends Command
{
    private double finish;
    private double plateau;
    private double startpos;
    private Timer time;
    
    public ClimbTime(double end,double rampUp)
    {
        requires(Robot.climb);
        finish = end;
        plateau=rampUp;

    }

    protected void initialize()
    {
        //Robot.ahrs.reset();
        startpos= Robot.climb.getSparkRampPosition();
        time = new Timer();
        time.start();
    }

    protected void execute() {
        Robot.climb.suck(1);
        if(time.get()<plateau)
        {
            Robot.climb.runSparkRamp(-0.6*(1/plateau*time.get()));
        }
        else
        {
            Robot.climb.runSparkRamp(-0.6);
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
        Robot.climb.suck(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}