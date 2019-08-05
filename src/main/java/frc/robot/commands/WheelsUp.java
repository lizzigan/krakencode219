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
public class WheelsUp extends Command {
    private Timer time;
    private double startPos;
    private double stop, hold,timed,add;
    private boolean smooth;
  public WheelsUp(double t,double x, double h, boolean sm, double additive) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.acty);
    stop=x;
    hold=h;
    timed=t;
    smooth=sm;
    add=additive;
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
      time=new Timer();
      time.start();
      startPos=Robot.cargo.getActuatorPos();
      SmartDashboard.putNumber("HoldVal",hold);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {/////
    //Robot.cargoArm.actuateCargo(Robot.m_oi.getSecondY());
    //if(Math.abs(Robot.acty.getActPos()-startPos)<stop)
    if(time.get()<timed)
    {
        Robot.acty.actuate(add+hold+(0.5-hold)*Math.abs(time.get()/((timed)/2)-1));
        SmartDashboard.putNumber("Acty", Robot.acty.getActPos()-startPos);
    }
    else
    {
        Robot.acty.actuate(hold);
        //Robot.acty.actuate(hold+SmartDashboard.getNumber("Joy",0))
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
      if (!smooth)
      {
        Robot.acty.actuate(0);
      }
      else
      {
          Robot.acty.actuate(hold);
      }

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
      end();
  }
}
