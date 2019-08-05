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
public class WheelsUpOverride extends Command {
    private Timer time;
  public WheelsUpOverride() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.acty);
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
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {/////
    //Robot.cargoArm.actuateCargo(Robot.m_oi.getSecondY());

            //Robot.acty.actuate(0.6);
            Robot.acty.actuate(0.3+0.6*(Math.pow(Robot.m_oi.getSecondY(),3)));
            Robot.acty.actuate(0.3+0.6*(Math.pow(Robot.m_oi.getSecondY(),3)));
        // else if (Robot.m_oi.getSecondY()>-0.1)
        // {
            
        //     Robot.acty.actuate(0.1);
        // }
        SmartDashboard.putNumber("Joy", 0.6*(Math.pow(Robot.m_oi.getSecondY(),3)));
        SmartDashboard.putNumber("Acty", Robot.acty.getActPos());

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
      Robot.acty.actuate(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
      end();
  }
}
