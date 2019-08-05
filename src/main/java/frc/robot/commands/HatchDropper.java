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
public class HatchDropper extends Command {
    private Timer time;
   //private double stop;
  public HatchDropper() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.hatchAct);
 
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
    if(time.get()<1&&Robot.hatchAct.isUp()==true)
    {
        Robot.hatchAct.actuate(0.15);
    }
    if (time.get()>1)
    {
     Robot.hatchAct.down();
    }
    // else
    // {
    //   Robot.hatchAct.actuate(0.04);
    // }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    // else if (Robot.hatchAct.current()>3.4)
    // {
    //   return true;
    // }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}