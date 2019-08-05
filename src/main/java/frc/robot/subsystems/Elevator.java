/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
//import frc.robot.commands.EleSafety;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Elevator extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private WPI_TalonSRX elev;
  private AnalogInput ai;

  public Elevator()
  {
      elev = new WPI_TalonSRX(RobotMap.TALONELEVATOR);
      elev.getSensorCollection().setQuadraturePosition(0, 10);
      ai=new AnalogInput(1);
  }

  public void elevate(double x)
  {
      elev.set(x);
  }

  public void setPosition(double x)
  {
    elev.getSensorCollection().setQuadraturePosition(0, 10);
  }

  public double getPosition()
  {
    SmartDashboard.putNumber("raw rotatons",elev.getSensorCollection().getQuadraturePosition()/4096.0);
    return elev.getSensorCollection().getQuadraturePosition()/4096.0*Math.PI*2*0.05/0.046*(50/44.0);///gr;//*55/97;//This is partially fudged borther
  }

  public double getSwitch()
  {
    return ai.getValue();
  }

  @Override
  protected void initDefaultCommand()
  {
    //setDefaultCommand(new EleSafety());
    //setDefaultCommand(new Sparxy());
    // TODO Auto-generated method stub
    //setDefaultCommand(new ElevateJoystick());
  }
}
