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
public class CargoBarHarvest extends Command {
    double rotate;
    double enc;
    double startPos;
    Timer time;
  public CargoBarHarvest(double encTop) {
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
      time=new Timer();
      time.start();
      startPos=Robot.cargo.getActuatorPos();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {/////
    //Robot.cargoArm.actuateCargo(Robot.m_oi.getSecondY());
    SmartDashboard.putNumber("BarHeight",Robot.cargo.getActuatorPos()-startPos);
    if((Robot.cargo.getActuatorPos()-startPos)>-enc)//||Robot.cargoArm.getActuatorPos()<enc)
    {
        Robot.cargo.actuateCargo(-0.3);
        SmartDashboard.putNumber("BarHeight",Robot.cargo.getActuatorPos()-startPos);
    }
    else{
        Robot.cargo.actuateCargo(-0.08);
    }
    Robot.cargo.runCargo(-0.8);
    SmartDashboard.putNumber("Cargo current",Robot.cargo.current());
    //  if(Robot.cargo.current()>12)
    //  {
    //      Robot.cargo.actuateCargo(0);
    //      Robot.cargo.runCargo(-0.2);
    //  }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    // if(Math.abs((Robot.cargoArm.getActuatorPos()/4096))>=rotate)
    // {
    //     return true;
    // }
    // if (Robot.cargo.current()>1.5)
    // {
    //     return true;
    // }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
      Robot.cargo.actuateCargo(0);
      Robot.cargo.runCargo(-0.2);
      Robot.cargo.runCargo(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
      end();
  }
}