/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Intake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private WPI_TalonSRX frontWheel;
  private WPI_TalonSRX backWheel; 

  public Intake()
  {
    // ROBOTMAP NEEDS UPDATING FOR ACTUAL ROBOT
    frontWheel = new WPI_TalonSRX(RobotMap.Wheel1);
    backWheel = new WPI_TalonSRX(RobotMap.Wheel2);
  }

  public void inCargo(double x)
  {
    frontWheel.set(-x);
    backWheel.set(-x);
  }

  public void outCargo(double x, double y)
  {
      frontWheel.set(x);
      backWheel.set(y);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //setDefaultCommand(new HarvestCargo());
    
  }
}
