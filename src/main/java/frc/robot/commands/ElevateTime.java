/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class ElevateTime extends Command {
    private double stop;
    private double cut;
    private double pid;
    private Timer time;
    private double startPos;
    private double top;
  public ElevateTime(double dest, double t) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.ele);
    stop=dest;
    top=t;
    //cut=pos;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // time= new Timer();
    // time.start();
    //Robot.ele.setPosition(0);
    time=new Timer();
    time.start();
    startPos=Robot.ele.getPosition();
    SmartDashboard.putNumber("Ele", 0);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    SmartDashboard.putNumber("Ele", Robot.ele.getPosition()-startPos);
    if((Robot.ele.getPosition()-startPos)-stop>0)
    {
        Robot.ele.elevate(-0.08);
    }
    else if(Math.abs(1-((top/2-time.get())/(top/2)))>0.2)
    {
        Robot.ele.elevate(-Math.abs(1-(Math.abs((top/2-time.get())/(top/2)))));
    }
    
    //Robot.ele.elevate(Math.abs(1-((time/2-time.get())/(time/2))));
    else 
    {
      Robot.ele.elevate(-0.2);
    }
    //   if(time.get()>down)
    //   {
    //       e=-0.05;
    //   }
    SmartDashboard.putNumber("Ele Switch",Robot.ele.getSwitch());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (SmartDashboard.getBoolean("Bar Up", true))
    {

        return true;
    }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
      //Robot.ele.elevate(0);
      if(SmartDashboard.getBoolean("Bar Up", true))
      {
        SmartDashboard.putNumber("Help", 1);
        Robot.ele.elevate(-0.08);
      }
      else
      {
        Robot.ele.elevate(0);
      }
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
      end();
  }
}