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
public class ElevatorControl extends Command {
    private double startPos=0;
    private double dest=0;
    private double pidConst = 1;
    private double minSpeed = -.08;
    private double moe=0.2;
  public ElevatorControl(double distance) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.ele);
    dest=distance;
    
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    startPos=Robot.ele.getPosition();

      
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
      SmartDashboard.putNumber("Ele", Robot.ele.getPosition()-startPos);
      if((((dest/2 - (Robot.ele.getPosition()-startPos))*1/(dest/2)))>0.7)
      {
        Robot.ele.elevate(-(dest/2 - Robot.ele.getPosition()-startPos)*1/(dest/2));
      }
      else if(dest-(Robot.ele.getPosition()-startPos)>0)
      {
        Robot.ele.elevate(-0.7);
      }
      else
      {
          Robot.ele.elevate(minSpeed);
          
      }
      SmartDashboard.putNumber("Ele Cont", Robot.ele.getPosition());
      
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    // if (Math.abs(Robot.ele.getPosition()-dest)<moe)
    // {
    //   return true;
    // }
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
