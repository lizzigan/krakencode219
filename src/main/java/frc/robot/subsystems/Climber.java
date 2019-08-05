/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Climber extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private CANSparkMax sparkRamp;
  private WPI_TalonSRX suc, suc2;

  public Climber()
  {
    sparkRamp = new CANSparkMax(RobotMap.RAMPDEPLOY, MotorType.kBrushless);
    suc= new WPI_TalonSRX(RobotMap.SUCTION);
    suc2= new WPI_TalonSRX(RobotMap.SUCTION2);
  }

  public void runSparkRamp(double x)
  {
      sparkRamp.set(x);
  }
  
  public double getSparkRampPosition()
  {
      return sparkRamp.getEncoder().getPosition()/25.0*Math.PI*2.0*0.05;
  }

  public double getSparkRampVelocity()
  {
      return sparkRamp.getEncoder().getVelocity();
  }

  public void suck(double x)
  {
    suc2.set(ControlMode.PercentOutput, x);
    suc.set(ControlMode.PercentOutput, x);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
