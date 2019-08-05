/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class ReleaseCargo extends Command {
    private Timer time;
    private double stop;
    private double full;
  public ReleaseCargo(double t, double max) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.hatchAct);
    stop=t;
    full=max;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    time=new Timer();
    time.start();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(Robot.hatchAct.isUp()==true)
    {
      Robot.hatchAct.actuate(-0.25);
    }
    else if(time.get()<0.5)
    {
      // Robot.hatchAct.actuate(-full*(0.25-Math.abs(time.get()-0.25)));
      Robot.hatchAct.actuate(full*(0.25-Math.abs(time.get()-0.25)));
    }
    else
    {
      Robot.hatchAct.actuate(-0.25);
    }
    // if (time.get()<3)
    // {
     // Robot.hatchAct.actuate(-full);
    // }
    // else
    // {
    //   Robot.hatchAct.actuate(0.04);
    // }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (time.get()>stop)
    {
      return true;
    }
    // else if (Robot.hatchAct.current()>3.4)
    // {
    //   return true;
    // }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.hatchAct.actuate(0);
    Robot.hatchAct.down();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}