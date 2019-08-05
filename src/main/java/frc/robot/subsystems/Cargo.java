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
public class Cargo extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private WPI_TalonSRX cargoCollect;
  private Boolean harvested;
  private WPI_TalonSRX cargoActuate; 
  private boolean peeked;

  public Cargo()
  {
    // ROBOTMAP NEEDS UPDATING FOR ACTUAL ROBOT
    cargoCollect = new WPI_TalonSRX(RobotMap.CARGOINTAKE);
    harvested=false;
    cargoActuate = new WPI_TalonSRX(RobotMap.CARGOARM);
    SmartDashboard.putBoolean("Bar Up", true);
    peeked=true;
  }

  public void runCargo(double x)
  {
    cargoCollect.set(x);
  }

  public double current()
  {
    return cargoCollect.getOutputCurrent();
  }

  public boolean getHarvested()
  {
    return harvested;
  }

  public void setHarvested(boolean b)
  {
    harvested=b;
  }

    public void actuateCargo(double x)
  {
    cargoActuate.set(x);
  }

  public void resetCargoActuator()
  {
    cargoActuate.getSensorCollection().setQuadraturePosition(0, 10);
  }

  public double getActuatorPos()
  {
    return cargoActuate.getSensorCollection().getQuadraturePosition()/4096.0*Math.PI*2*0.05;
  }

  public void flipPeeked()
  {
    peeked=!peeked;
  }

  public boolean getPeeked()
  {
    return peeked;
  }

  public void setPeeked(boolean state)
  {
    peeked=state;
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //setDefaultCommand(new HarvestCargo());
    
  }
}
