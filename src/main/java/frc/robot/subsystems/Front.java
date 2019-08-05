// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

// package frc.robot.subsystems;
// import edu.wpi.first.wpilibj.AnalogInput;
// import edu.wpi.first.wpilibj.command.Subsystem;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import frc.robot.RobotMap;
// import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
// import edu.wpi.first.wpilibj.command.Subsystem;

// import edu.wpi.first.wpilibj.AnalogInput;

// /**
//  * An example subsystem.  You can replace me with your own Subsystem.
//  */
// public class Front extends Subsystem {
//     private WPI_TalonSRX cargoCollect;
//     private Boolean harvested;
//     private WPI_TalonSRX cargoActuate; 
//     private boolean peeked;
//     private AnalogInput ai;
//     private WPI_TalonSRX bagMotor;
//     private boolean extended;
//     private WPI_TalonSRX deathHeadAct;
//     private double r=0.05;
//     private double gr=25;
//     private boolean up=true;

//     private WPI_TalonSRX elev;

//   public Front() {
//       //Elevator
//     elev = new WPI_TalonSRX(RobotMap.TALONELEVATOR);
//     elev.getSensorCollection().setQuadraturePosition(0, 10);
//     ai=new AnalogInput(1);
//     //Cargo
//     cargoCollect = new WPI_TalonSRX(RobotMap.CARGOINTAKE);
//     harvested=false;
//     cargoActuate = new WPI_TalonSRX(RobotMap.CARGOARM);
//     SmartDashboard.putBoolean("Bar Up", true);
//     peeked=true;
//     //Hatch
//     bagMotor = new WPI_TalonSRX(RobotMap.DEATHHEAD);
//     bagMotor.getSensorCollection().setQuadraturePosition(0, 10);
//     extended=true;
//     //HatchActuator
//     deathHeadAct= new WPI_TalonSRX(RobotMap.DEATHHEADACTUATE);
//     deathHeadAct.getSensorCollection().setQuadraturePosition(0, 10);

//     // Set the default command for a subsystem here.
//     // setDefaultCommand(new MySpecialCommand());
//   }
//   public void runCargo(double x)
//   {
//     cargoCollect.set(x);
//   }

//   public double cargoCurrent()
//   {
//     return cargoCollect.getOutputCurrent();
//   }

//   public boolean getHarvested()
//   {
//     return harvested;
//   }

//   public void setHarvested(boolean b)
//   {
//     harvested=b;
//   }

//     public void actuateCargo(double x)
//   {
//     cargoActuate.set(x);
//   }

//   public void resetCargoActuator()
//   {
//     cargoActuate.getSensorCollection().setQuadraturePosition(0, 10);
//   }

//   public double getActuatorPos()
//   {
//     return cargoActuate.getSensorCollection().getQuadraturePosition()/4096.0*Math.PI*2*0.05;
//   }

//   public void flipPeeked()
//   {
//     peeked=!peeked;
//   }

//   public boolean getPeeked()
//   {
//     return peeked;
//   }

//   public void setPeeked(boolean state)
//   {
//     peeked=state;
//   }
//   public void elevate(double x)
//   {
//       elev.set(x);
//   }

//   public void setPosition(double x)
//   {
//     elev.getSensorCollection().setQuadraturePosition(0, 10);
//   }

//   public double getPosition()
//   {
//     SmartDashboard.putNumber("raw rotatons",elev.getSensorCollection().getQuadraturePosition()/4096.0);
//     return elev.getSensorCollection().getQuadraturePosition()/4096.0*Math.PI*2*0.05/0.046*(50/44.0);///gr;//*55/97;//This is partially fudged borther
//   }

//   public double getSwitch()
//   {
//     return ai.getValue();
//   }
//   //Hatch
//   public void runMotor(double x)
//   {
//     bagMotor.set(x);
//   }

//   public double getMotorPos()
//   {
//     return -bagMotor.getSensorCollection().getQuadraturePosition()/4096.0*2*Math.PI*0.05;
//   }
  
//   public void setMotorPos()
//   {
//     bagMotor.getSensorCollection().setQuadraturePosition(0, 10);
//   }

//   public double bagCurrent()
//   {
//     return bagMotor.getOutputCurrent();
//   }

//   public boolean getExtended()
//   {
//     return extended;
//   }

//   public void flipExtended()
//   {
//     extended=!extended;
//   }
//   //Hatch Actuator
//   public void actuate(double x)
//   {
//       deathHeadAct.set(x);
//   }

//   public double getActPos()
//   {
//       return deathHeadAct.getSensorCollection().getQuadraturePosition()*Math.PI*r/gr*2;
//   }

//   public double deathCurrent()
//   {
//     return deathHeadAct.getOutputCurrent();
//   }

//   public boolean isUp()
//   {
//     return up;
//   }

//   public void down()
//   {
//     up=false;
//   }
//   @Override
//   public void initDefaultCommand() {
//     // Set the default command for a subsystem here.
//     // setDefaultCommand(new MySpecialCommand());
//   }
// }
