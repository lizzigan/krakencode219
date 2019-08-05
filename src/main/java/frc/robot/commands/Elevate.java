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
public class Elevate extends Command {
    private double e;
    private double stop;
    private Timer time;
  public Elevate(double x, double dest) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.ele);
    e=x;
    stop=dest;
    time = new Timer();
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
      Robot.ele.setPosition(0);
      time.start();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
      Robot.ele.elevate(e);
      System.out.println(Robot.ele.getPosition());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (Robot.ele.getPosition()>stop)
    {
        return true;
    }
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