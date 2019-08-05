/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class Motion extends Command {
    double x=0;
  public Motion() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.climb);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
      x=Robot.climb.getSparkRampPosition();
  }

  // Called repeatedly when this Command is scheduled to run
  
  @Override
  protected void execute() {
      // if(Robot.drive.getSparkPos()-x<1000)
      // {
      //   Robot.drive.runSpark(0.25);
      // }
      // else if(Robot.drive.getSparkPos()-x<2000)
      // {
      //   Robot.drive.runSpark(0.5);
      // }
      // else if(Robot.drive.getSparkPos()-x<3000)
      // {
      //   Robot.drive.runSpark(0.75);
      // }
      // else if(Robot.drive.getSparkPos()-x<4000)
      // {
      //   Robot.drive.runSpark(1);
      // }
  

      // if (Robot.drive.getSparkPos()<19)
      // {
      //   Robot.drive.runSpark(Robot.drive.getSparkPos()/20.0 + 0.1);
      // }
      // else if(Robot.drive.getSparkPos()<50)
      // {
      //   Robot.drive.runSpark(1.0);
      // }
      // else if (Robot.drive.getSparkPos() < 65)
      // {
      //   Robot.drive.runSpark(1.0-((Robot.drive.getSparkPos()-50.0)/20.0));
      // }
      // else if (Robot.drive.getSparkPos() < 70)
      // {
      //   Robot.drive.runSpark(0.2);
      // }
      // else
      // {
      //   Robot.drive.runSpark(0.0);
      // }
      
      if (Robot.climb.getSparkRampPosition()<19)
      {
        Robot.climb.runSparkRamp(Robot.climb.getSparkRampPosition()/20.0 + 0.1);
      }
      else if(Robot.climb.getSparkRampPosition()<50)
      {
        Robot.climb.runSparkRamp(1.0);
      }
      else if (Robot.climb.getSparkRampPosition() < 65)
      {
        Robot.climb.runSparkRamp(1.0-((Robot.climb.getSparkRampPosition()-50.0)/20.0));
      }
      else if (Robot.climb.getSparkRampPosition() < 70)
      {
        Robot.climb.runSparkRamp(0.2);
      }
      else
      {
        Robot.climb.runSparkRamp(0.0);
      }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    // if(Robot.drive.getSparkPos()>700)
    // {
    //     return true;
    // }
    if(Robot.climb.getSparkRampPosition()>700)
    {
      return true;
    }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
      //Robot.drive.runSpark(0);
      Robot.climb.runSparkRamp(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
      end();
  }
}
