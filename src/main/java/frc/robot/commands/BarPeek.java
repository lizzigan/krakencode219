/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import javax.lang.model.util.ElementScanner6;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class BarPeek extends Command {
    private Timer time;
    private double stop;
    private double mult;
    private double startPos;
  public BarPeek() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.cargo);
    // if (Robot.cargo.getPeeked())
    // {
    //     stop=1.7;
    //     mult=-1;
    // }
    // else
    // {
    //     stop=2.8;
    //     mult=1;
    // }
    // if(Robot.cargoArm.getActuatorPos()>0.15)
    // {
    //     mult=-1;
    // }
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
      //Robot.cargo.resetCargoActuator();
      if (Robot.cargo.getPeeked())
      {
          stop=2.1;
          mult=-2;
      }
      else
      {
          stop=3.2;
          mult=1;
      }
      time=new Timer();
      time.start();
      startPos=Robot.cargo.getActuatorPos();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {/////
    //Robot.cargoArm.actuateCargo(Robot.m_oi.getSecondY());
    if(mult==1&&Math.abs(Robot.cargo.getActuatorPos()-startPos)<0.165)
    {
        Robot.cargo.actuateCargo(-0.35*mult);
    }
    else
    {
        Robot.cargo.actuateCargo(-0.12*mult);
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    //if(time.get()>stop)
    if(Math.abs(Robot.cargo.getActuatorPos()-startPos)>0.18)
    {
        SmartDashboard.putNumber("ended",Robot.cargo.getActuatorPos()-startPos );
        return true;
    }
    // if(Math.abs((Robot.cargoArm.getActuatorPos()/4096))>=rotate)
    // {
    //     return true;
    // }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
      Robot.cargo.actuateCargo(0);
      Robot.cargo.flipPeeked();
      if(Robot.cargo.getPeeked()==true)
      {
          SmartDashboard.putBoolean("Bar Up", true);
      }
      else
      {
          SmartDashboard.putBoolean("Bar Up", false);
      }
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
      end();
  }
}
