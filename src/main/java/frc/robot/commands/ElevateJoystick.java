/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class ElevateJoystick extends Command {
    double e;
    double startPos;
  public ElevateJoystick() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.ele);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
      //Robot.ele.setPosition(0);
      startPos=Robot.ele.getPosition();

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
     //System.out.println("Yeet my yote");
    //  if(!Robot.cargo.getPeeked())
    //  {
    SmartDashboard.putNumber("Ele",Robot.ele.getPosition()-startPos);
    SmartDashboard.putNumber("Ele Switch",Robot.ele.getSwitch());
     if(Math.pow(Robot.m_oi.getSecondY(),3) >= -0.04 && SmartDashboard.getBoolean("Bar Up", true))
     {
        if(Robot.m_oi.getSecondY() > 0.9)
        {
            Robot.ele.elevate(0);
        }
        else
        {
            Robot.ele.elevate(-0.08);
        }
     }
     else
     {
        if (Math.pow(Robot.m_oi.getSecondY(),3)<-0.08&&Robot.ele.getSwitch()<200)
        {
        Robot.ele.elevate(Math.pow(Robot.m_oi.getSecondY(),3));
        }
        else 
        {
            Robot.ele.elevate(-0.08);
        }
     }
    // }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {

    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
      Robot.ele.elevate(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
      end();
  }
}