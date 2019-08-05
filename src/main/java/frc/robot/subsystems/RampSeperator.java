/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.AnalogInput;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class RampSeperator extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private WPI_TalonSRX talonRamp;
  private boolean seperated;
  private double r=0.80;
  private AnalogInput input;

  public RampSeperator()
  {
    input = new AnalogInput(0);
    seperated=false;
    talonRamp = new WPI_TalonSRX(RobotMap.TALONRAMP);
    setTalonRamp(0);
  }

  public void runTalonRamp(double x)
  {
    talonRamp.set(x);
  }

  public int getTalonRampVelocity()
  {
    return talonRamp.getSensorCollection().getQuadratureVelocity();
  }

  public double getTalonRampPosition()
  {
    return talonRamp.getSensorCollection().getQuadraturePosition()/4096.0*2*Math.PI*r;
  }

  public void setTalonRamp(double x)
  {
    talonRamp.getSensorCollection().setQuadraturePosition(0, 10);
  }
  public boolean getSeperated()
  {
    return seperated;
  }
  public void setSeperated(boolean sep) {
    seperated = sep;
  }

  public int getSwitch()
  {
    return input.getValue();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}