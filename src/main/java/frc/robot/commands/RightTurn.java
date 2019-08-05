package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class RightTurn extends Command
{
    private double side;
    private Timer time;
    public RightTurn(double mult)
    {
        side=mult;
        requires(Robot.drive);
        //  Robot.ahrs.reset();
        //  offset=Robot.ahrs.getAngle()%360;
    }

    protected void initialize()
    {
        // System.out.println(Robot.ahrs.getAngle());
        //Robot.ahrs.reset();
        time=new Timer();
        time.start();
        // System.out.println(Robot.ahrs.getAngle());
    }

    protected void execute() {
        //Robot.drive.DriveCartesian(-Robot.m_oi.getYSpeed()*Math.abs(Robot.m_oi.getYSpeed()),Robot.m_oi.getXSpeed(),Robot.m_oi.getZTurn()/2);
        //double ys = Robot.m_oi.getYSpeed(), xs = Robot.m_oi.getXSpeed(), zs = Robot.m_oi.getZTurn();
        Robot.drive.DriveCartesian(0, 0,  0.25*side, Robot.ahrs.getAngle()%360);
        SmartDashboard.putNumber( "Angle",Robot.ahrs.getAngle());
        // Robot.drive.getSparkVel();
        // Robot.drive.getSparkPos();
        
    }
    protected boolean isFinished() {
        if (time.get()>0.25)
        {
            return true;
        }
        return false;
    }
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}