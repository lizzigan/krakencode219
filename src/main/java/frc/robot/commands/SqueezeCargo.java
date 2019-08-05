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
public class SqueezeCargo extends Command {
Timer time;
  public SqueezeCargo() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.cargo);
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
    // if ((Robot.m_oi.getPlusMinus()>0.2)||(Robot.m_oi.getPlusMinus()<-0.2));
    //   Robot.cargo.runCargo(Robot.m_oi.getPlusMinus());
    //   SmartDashboard.putNumber("Harvest", Robot.m_oi.getPlusMinus());
    Robot.cargo.runCargo(-0.8);
    //System.out.println(Robot.cargo.current());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (time.get()>0.5)
    {
        return true;
    }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end()
  {
    Robot.cargo.runCargo(0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}