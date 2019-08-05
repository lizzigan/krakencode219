package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;
import frc.robot.commands.Drive;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DriveTrain extends Subsystem {

	// Put methods for controlling this subsystem
    // here. Call these from Commands.
    private CANSparkMax sparkFL, sparkFR, sparkBL, sparkBR;
    //private WPI_TalonSRX motorBR, motorFR, motorFL, motorBL;
    private MecanumDrive Mike;
	
  	public DriveTrain()
	{
        // The RobotMap needs updating for actual robot
        sparkBL= new CANSparkMax(RobotMap.SPARKBL,MotorType.kBrushless);
        sparkFL = new CANSparkMax(RobotMap.SPARKFL,MotorType.kBrushless);
        sparkBR = new CANSparkMax(RobotMap.SPARKBR,MotorType.kBrushless);
        sparkFR = new CANSparkMax(RobotMap.SPARKFR,MotorType.kBrushless);
        // motorFR = new WPI_TalonSRX(3);
        // motorFL = new WPI_TalonSRX(2);
        // motorBL = new WPI_TalonSRX(6);
        // motorBR = new WPI_TalonSRX(1);
        Mike = new MecanumDrive(sparkBL, sparkFL, sparkBR, sparkFR);
        // Mike = new MecanumDrive(motorBL, motorFL, motorBR, motorFR);
    }
    public void DriveCartesian(double x, double y, double rot)
    {
        Mike.driveCartesian(y, x, rot);
    }

    public void DrivePolar(double mag, double ang, double rot)
    {
        Mike.drivePolar(mag, ang, rot);
    } 

    public void DriveCartesian(double x, double y, double rot, double gyro)
    {
        Mike.driveCartesian(y, x, rot, gyro);
    }

    public double getWheelPositionBL()
    {
        return sparkBL.getEncoder().getPosition();
    }

    public double getWheelPositionFL()
    {
        return sparkFL.getEncoder().getPosition();
    }

    public double getWheelPositionBR()
    {
        return sparkBR.getEncoder().getPosition();
    }

    public double getWheelPositionFR()
    {
        return sparkFR.getEncoder().getPosition();
    }

    public double getWheelVelocity()
    {
        return sparkBL.getEncoder().getVelocity();
    }

    public void resetEncoders()
    {
        // Probably can be removed
    }

    // @Override
    // public Command getCurrentCommand() {
    // }


    @Override
    protected void initDefaultCommand()
    {
      setDefaultCommand(new Drive());
      //setDefaultCommand(new Sparxy());
      // TODO Auto-generated method stub
    }
}