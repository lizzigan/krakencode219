/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.HatchDropper;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class HatchActuator extends Subsystem {
    private WPI_TalonSRX deathHeadAct;
    private double r=0.05;
    private double gr=25;
    private boolean up=true;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public HatchActuator()
  {
    deathHeadAct= new WPI_TalonSRX(RobotMap.DEATHHEADACTUATE);
    deathHeadAct.getSensorCollection().setQuadraturePosition(0, 10);
  }

  public void actuate(double x)
  {
      deathHeadAct.set(x);
  }

  public double getActPos()
  {
      return deathHeadAct.getSensorCollection().getQuadraturePosition()*Math.PI*r/gr*2;
  }

  public double current()
  {
    return deathHeadAct.getOutputCurrent();
  }

  public boolean isUp()
  {
    return up;
  }

  public void down()
  {
    up=false;
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //setDefaultCommand(new HatchDropper());
  }
}
