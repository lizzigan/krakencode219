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
public class BarDownStick extends Command {
    private Timer time;
    private double stop;
    private double mult;
    private double startPos;
  public BarDownStick() {
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
          stop=3.2;
          mult=1;
      time=new Timer();
      time.start();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {/////
    //Robot.cargoArm.actuateCargo(Robot.m_oi.getSecondY());
    Robot.cargo.actuateCargo(Robot.m_oi.getSecondY()/2);
    Robot.cargo.runCargo(-0.8);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    //if(time.get()>stop)
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
      Robot.cargo.runCargo(0);

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
      end();
  }
}