package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class SeperateRampConst extends Command
{
    private double stop;
    private double startPos;
    //hi judges!!! <3
    private double pidConst = 1/10000;//FINE TUNE
    private double r=0.05;//??
    private double gr=25;//??
    private double cap = .45; //Kappa
    private double error;
    public SeperateRampConst()
    {
        requires(Robot.rampSeperator);
        
    }

    protected void initialize()
    {
        //Robot.rampSeperator.setTalonRamp(0);
        //Robot.ahrs.reset();
    }

    protected void execute()
    {
        Robot.rampSeperator.runTalonRamp(.45);
    }
    protected boolean isFinished() 
    {
        // if (Robot.climb.sparkSRamp.getOutputCurrent()>=3.4)
        //  {
        //      return true;
        //  }

        // if(Robot.rampSeperator.getTalonRampPosition()>stop)
        // {
        //     return true;
        // }
        return false;
    }
    protected void end() {
        Robot.rampSeperator.runTalonRamp(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}