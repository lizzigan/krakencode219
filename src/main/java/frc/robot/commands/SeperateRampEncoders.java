package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;


public class SeperateRampEncoders extends Command
{
    private double stop;
    private double startPos;

    public SeperateRampEncoders(double en)
    {
        requires(Robot.rampSeperator);
        stop=en;
        //Robot.rampSeperator.setTalonRamp(0);
        //Robot.ahrs.reset();
    }

    @Override
    protected void initialize() {
        startPos=Robot.rampSeperator.getTalonRampPosition();
        if(Robot.rampSeperator.getSeperated()==true)
        {
            stop=1.5;
        }
    }

    protected void execute()
    {
        Robot.rampSeperator.runTalonRamp(-0.75);//-0.75
        SmartDashboard.putNumber("RampPos", Robot.rampSeperator.getTalonRampPosition()-startPos);
        //System.out.println(Robot.rampSeperator.getTalonRampPosition());
        SmartDashboard.putNumber("Switch", Robot.rampSeperator.getSwitch());
    }
    protected boolean isFinished() 
    {
        // if(Robot.rampSeperator.getTalonRampPosition()/4096*Math.PI*2*r*gr>stop)
        // {
        //     return true;
        // }
        if(Robot.rampSeperator.getSwitch() < 10 || Math.abs(Robot.rampSeperator.getTalonRampPosition()-startPos)>stop)//||Robot.m_oi.getPlusMinus()>0)
        {
            return true;
        }
        return false;
    }
    protected void end() {
        Robot.rampSeperator.runTalonRamp(0);
        if (!Robot.rampSeperator.getSeperated()&&Robot.m_oi.getPlusMinus()<0)
        {
            Robot.rampSeperator.setSeperated(true);
        }
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}