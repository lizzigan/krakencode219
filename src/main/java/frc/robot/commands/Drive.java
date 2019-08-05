package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Drive extends Command
{
    private double offset;
    public Drive()
    {
        requires(Robot.drive);
        //  Robot.ahrs.reset();
        //  offset=Robot.ahrs.getAngle()%360;
    }

    protected void initialize()
    {
        // System.out.println(Robot.ahrs.getAngle());
        Robot.ahrs.reset();
        // System.out.println(Robot.ahrs.getAngle());
    }

    protected void execute() {
        //Robot.drive.DriveCartesian(-Robot.m_oi.getYSpeed()*Math.abs(Robot.m_oi.getYSpeed()),Robot.m_oi.getXSpeed(),Robot.m_oi.getZTurn()/2);
        //double ys = Robot.m_oi.getYSpeed(), xs = Robot.m_oi.getXSpeed(), zs = Robot.m_oi.getZTurn();
        double ys = Robot.m_oi.getxboxYSpeed(), xs = Robot.m_oi.getxboxXSpeed(), zs = Robot.m_oi.getxboxZTurn();
        Robot.drive.DriveCartesian(-ys * Math.abs(ys)*0.85, -xs ,  Math.pow(zs, 3)/2); //Robot.ahrs.getAngle()%360);
        SmartDashboard.putNumber( "Angle",Robot.ahrs.getAngle());
        SmartDashboard.putNumber("FL", Robot.drive.getWheelPositionFL());
        SmartDashboard.putNumber("FR", Robot.drive.getWheelPositionFR());
        SmartDashboard.putNumber("BL", Robot.drive.getWheelPositionBL());
        SmartDashboard.putNumber("BR", Robot.drive.getWheelPositionBR());
        // Robot.drive.getSparkVel();
        // Robot.drive.getSparkPos();
        
    }
    protected boolean isFinished() {
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