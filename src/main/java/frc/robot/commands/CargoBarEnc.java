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
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class CargoBarEnc extends Command {
    double rotate;
    double enc;
  public CargoBarEnc(double encTop) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.cargo);
    enc=encTop;
    // if(Robot.cargoArm.getActuatorPos()>0.15)
    // {
    //     mult=-1;
    // }
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
      //Robot.cargoArm.resetCargoActuator();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {/////
    //Robot.cargoArm.actuateCargo(Robot.m_oi.getSecondY());
    if(enc<rotate)//||Robot.cargoArm.getActuatorPos()<enc)
    {
        Robot.cargo.actuateCargo(-0.25);
    }
    else if(rotate<2)
    {
        Robot.cargo.actuateCargo(-0.1);
    }
    else
    {
        Robot.cargo.actuateCargo(0.1);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(Robot.cargo.getActuatorPos()>enc)
    {
        return true;
    }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
      Robot.cargo.actuateCargo(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
      end();
  }
}
