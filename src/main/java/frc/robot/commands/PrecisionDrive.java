package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class PrecisionDrive extends Command
{
    private double factX, factY, factZ;//X is strafe, y is front back, z is rotate
    public PrecisionDrive(double y, double x, double z)
    {
        requires(Robot.drive);
        factY=y;
        factX=x;
        factZ=z;

    }

    protected void initialize()
    {
        //Robot.ahrs.reset();
    }

    protected void execute() {
        //Robot.drive.DriveCartesian(-Robot.m_oi.getYSpeed()*Math.abs(Robot.m_oi.getYSpeed()),Robot.m_oi.getXSpeed(),Robot.m_oi.getZTurn()/2);
        double ys = Robot.m_oi.getYSpeed(), xs = Robot.m_oi.getXSpeed(), zs = Robot.m_oi.getZTurn();
        Robot.drive.DriveCartesian(-ys * Math.abs(ys)/factY, -xs/factX,  zs/2/factZ, -Robot.ahrs.getAngle()%360);
        SmartDashboard.putNumber( "Angle",Robot.ahrs.getAngle());
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