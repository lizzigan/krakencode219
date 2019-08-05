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

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Hatch extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private WPI_TalonSRX bagMotor;
  private boolean extended;

  public Hatch()
  {
    // ROBOT MAP NEEDS UPDATING FOR ACTUAL ROBOT
    bagMotor = new WPI_TalonSRX(RobotMap.DEATHHEAD);
    bagMotor.getSensorCollection().setQuadraturePosition(0, 10);
    extended=true;
  }

  public void runMotor(double x)
  {
    bagMotor.set(x);
  }

  public double getMotorPos()
  {
    return -bagMotor.getSensorCollection().getQuadraturePosition()/4096.0*2*Math.PI*0.05;
  }
  
  public void setMotorPos()
  {
    bagMotor.getSensorCollection().setQuadraturePosition(0, 10);
  }

  public double current()
  {
    return bagMotor.getOutputCurrent();
  }

  public boolean getExtended()
  {
    return extended;
  }

  public void flipExtended()
  {
    extended=!extended;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
