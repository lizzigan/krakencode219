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
public class ToggleHatch extends Command {
    double mult=0;
    double upper=0.046;//0.034
    double lower=0;
    double relative=0;
    private Timer time;
  public ToggleHatch() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.hatch);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
      if(!Robot.hatch.getExtended())
      {
        mult=1;
        //target=1;//filler
      }
      else
      {
        mult=-1.5;
       // target=0;
      }
      //relative=Robot.hatch.getMotorPos();
      //upper=upper+relative;
      //lower=lower+relative;
      time=new Timer();
      time.start();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.hatch.runMotor(0.2*mult);  
    SmartDashboard.putNumber("CurrentHatch", Robot.hatch.current());
    //SmartDashboard.putNumber("HatchExt", Robot.hatch.getMotorPos());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    SmartDashboard.putNumber("Hatch ext",Math.abs(Robot.hatch.getMotorPos()-relative));
    // if(((Math.abs(Robot.hatch.getMotorPos()-relative))>upper && mult==-1.5)||(Math.abs(Robot.hatch.getMotorPos()-relative)>upper&&mult==1))
    // {
    //   SmartDashboard.putNumber("Encoders Buckaroo", 10000);
    //   return true;
    // }
    SmartDashboard.putNumber("CurrentHatch", Robot.hatch.current());
    if (time.get()>2)//Try higher currents if we go bust
     {
      SmartDashboard.putNumber("CurrentStop", 10000);
       return true;
     }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.hatch.runMotor(0);
    Robot.hatch.flipExtended();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}