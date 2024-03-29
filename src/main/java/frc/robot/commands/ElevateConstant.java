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
public class ElevateConstant extends Command {
    private double startPos=0;
    private double dest=0;
    private double minSpeed = -.08;
    private double endPos;

  public ElevateConstant(double distance) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.ele);
    dest=distance;
    
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    startPos=Robot.ele.getPosition();
    endPos=dest+startPos;

      
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
      SmartDashboard.putNumber("EleCons", Robot.ele.getPosition()-startPos);
      //if(dest-(Robot.ele.getPosition()-startPos)>0) //&&!reach)
      if(Robot.ele.getPosition()<(dest+startPos))
      {
        Robot.ele.elevate(-0.5);
      }
    //   else if(!reach)
    //   {
    //     reach=!reach;
    //   }
      else
      {
          Robot.ele.elevate(minSpeed);  
      }
      
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
