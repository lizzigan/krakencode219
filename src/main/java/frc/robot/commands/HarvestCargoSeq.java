/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class HarvestCargoSeq extends CommandGroup {
  public HarvestCargoSeq(double t, double enc) {
    // Use requires() here to declare subsystem dependencies
    //addSequential(new HarvestCargoTime(2,0.055));//Change
    addSequential(new HarvestCargoTime(t,enc));
    addSequential(new HarvestCargoDown());
  }
}