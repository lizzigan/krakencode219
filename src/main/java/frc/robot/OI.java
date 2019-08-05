 /*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.*;
import frc.robot.commands.BarDown;
import frc.robot.commands.BarDownStick;
import frc.robot.commands.BarPeek;
import frc.robot.commands.BarUp;
import frc.robot.commands.CargoBarHarvest;
import frc.robot.commands.Climb;
import frc.robot.commands.ClimbEncoderMotion;
import frc.robot.commands.ClimbTime;
import frc.robot.commands.ClimberDown;
import frc.robot.commands.ElevateConstant;
import frc.robot.commands.ElevateJoystick;
import frc.robot.commands.ElevateMotionGroup;
import frc.robot.commands.ElevateTime;
import frc.robot.commands.ElevatorControl;
import frc.robot.commands.ElevatorMotion;
import frc.robot.commands.HarvestCargoDown;
import frc.robot.commands.HarvestCargoSeq;
import frc.robot.commands.PrecisionDrive;
import frc.robot.commands.ReleaseCargo;
import frc.robot.commands.SeperateRampEncoders;
import frc.robot.commands.SonicSensor;
import frc.robot.commands.ToggleHatch;
import frc.robot.commands.WheelIntake;
import frc.robot.commands.WheelOut;
import frc.robot.commands.WheelsUp;
import frc.robot.commands.WheelsUpOverride;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);
  public Joystick mainDriver;
  public Joystick driver2;
  public Joystick xbox;

  public Button one;
  public Button two;
  public Button three;
  public Button four;
  public Button five;
  public Button six;
  public Button seven;
  public Button eight;
  public Button nine;
  public Button ten;
  public Button eleven;
  public Button twelve;

  public Button oneTwo;
  public Button twoTwo;
  public Button threeTwo;
  public Button fourTwo;
  public Button fiveTwo;
  public Button sixTwo;
  public Button sevenTwo;
  public Button eightTwo;
  public Button nineTwo;
  public Button tenTwo;
  public Button elevenTwo;
  public Button twelveTwo;

  public Button a;
  public Button b;
	public Button x;
	public Button y;
	public Button rbump;
	public Button lbump;
	public Button lstick;
	public Button rstick;


  
  public OI()
	{
		
		mainDriver= new Joystick(0);
		driver2=new Joystick(1);
		xbox=new Joystick(4);

		one = new JoystickButton(mainDriver,1);
		two= new JoystickButton(mainDriver, 2);
		three = new JoystickButton(mainDriver,3);
		four = new JoystickButton(mainDriver, 4);
		five = new JoystickButton(mainDriver,5);
		six= new JoystickButton(mainDriver, 6);
		seven= new JoystickButton(mainDriver,7);
		eight = new JoystickButton(mainDriver,8);
		nine = new JoystickButton(mainDriver,9);
		ten = new JoystickButton(mainDriver, 10);
		eleven = new JoystickButton(mainDriver, 11);
		twelve = new JoystickButton(mainDriver, 12);

		oneTwo = new JoystickButton(driver2, 1);
		twoTwo = new JoystickButton(driver2, 2);
		threeTwo = new JoystickButton(driver2, 3);
		fourTwo = new JoystickButton(driver2, 4);
		fiveTwo = new JoystickButton(driver2, 5);
		sixTwo = new JoystickButton(driver2, 6);
		sevenTwo =new JoystickButton(driver2 , 7);
		eightTwo = new JoystickButton(driver2, 8);
		nineTwo = new JoystickButton(driver2, 9);
		tenTwo = new JoystickButton(driver2, 10);
		elevenTwo = new JoystickButton(driver2, 11);
		twelveTwo = new JoystickButton(driver2, 12);

		a= new JoystickButton(xbox,1);
		b= new JoystickButton(xbox,2);
		x= new JoystickButton(xbox,3);
		y= new JoystickButton(xbox,4);
		rbump= new JoystickButton(xbox, 6);
		lbump= new JoystickButton(xbox, 5);
		lstick= new JoystickButton(xbox, 9);
		rstick = new JoystickButton(xbox,10);

		a.toggleWhenPressed(new ToggleHatch());
		//y.toggleWhenPressed(new HarvestCargoDown());
		//b.toggleWhenPressed(new ToggleHatch());
		//x.toggleWhenPressed(new ReleaseCargo(1.4,3.4));
		//rbump.toggleWhenPressed(new BarDown());
		//lbump.toggleWhenPressed(new BarUp());
		lbump.whileHeld(new WheelOut(0.54,0.54));//bakcwards
		rbump.whileHeld(new WheelIntake(0.45));
		lstick.whileHeld(new PrecisionDrive(3,2,2));

		// one.whileHeld(new PrecisionDrive(3,2,1));
		// two.toggleWhenPressed(new SeperateRampEncoders(9));
		// three.toggleWhenPressed(new SeperateRampEncoders(13));//First Bot
		// four.toggleWhenPressed(new SeperateRampEncoders(17));//Second Bot
		// five.toggleWhenPressed(new ElevatorMotion(72,1));
		// six.toggleWhenPressed(new HarvestCargoSeq(2, 0.055));
		// seven.toggleWhenPressed(new ElevateMotionGroup(44, 1));
		// eleven.toggleWhenPressed(new CargoBarHarvest(0.055));
		// //twelve.toggleWhenPressed(new CargoBar(0.7));
		// //twelve.toggleWhenPressed(new CargoBar(2.8,-300));
		
		// oneTwo.toggleWhenPressed(new ReleaseCargo(1.1,3.6));
		// //oneTwo.toggleWhenPressed(new ReleaseCargo(1.1,8.0))
		
		// //oneTwo.toggleWhenPressed(new ReleaseCargo(1.3,0.9));
		// twoTwo.toggleWhenPressed(new ElevatorMotion(28,1));//Hatch High
		// threeTwo.toggleWhenPressed(new ElevatorMotion(56,1));//Hatch High
		// fourTwo.toggleWhenPressed(new ElevatorMotion(44,1));
		// //fourTwo.toggleWhenPressed(new ElevatorControl(2));//26.5
		// //fourTwo.toggleWhenPressed(new ElevateConstant(1));
		// //fiveTwo.toggleWhenPressed(new ElevatorMotion(-0.9,2.4,));
		// //fiveTwo.toggleWhenPressed(new ElevatorControl(2*28));
		// sixTwo.toggleWhenPressed(new HarvestCargoDown());
		// fiveTwo.toggleWhenPressed(new ElevatorMotion(17,0.8));
		// //sixTwo.toggleWhenPressed(new ClimbEncoderMotion(5.0,1.0,1.0));
		// //sevenTwo.toggleWhenPressed(new ClimbTime(2.64,2.0));
		// sevenTwo.toggleWhenPressed(new Climb());
		// eightTwo.toggleWhenPressed(new ToggleHatch());
		// nineTwo.toggleWhenPressed(new ElevatorMotion(21,0.8));
		// tenTwo.toggleWhenPressed(new ClimberDown());
		// elevenTwo.toggleWhenPressed(new BarPeek());
		// twelveTwo.toggleWhenPressed(new ElevateJoystick());








		// // MAIN CONTROLS VALUES NOT ALL VALID!

		// one.whileHeld(new PrecisionDrive(3, 2, 2));
		// two.toggleWhenPressed(new ReleaseCargo(1.4,3.4));
		// three.toggleWhenPressed(new CargoBarHarvest(0.048));
		// four.toggleWhenPressed(new BarPeek());
		// five.toggleWhenPressed(new HarvestCargoDown());
		// six.toggleWhenPressed(new ToggleHatch());
		// //seven.toggleWhenPressed(new ElevateTime(28,1.5));
		// //eight.toggleWhenPressed(new ElevateTime(56,3));
		// //nineTwo.toggleWhenPressed(new ElevateTime(43,2.5));
		// ten.toggleWhenPressed(new ElevateTime(70.5,3.5));
		// //elevenTwo.toggleWhenPressed(new ElevateTime(15.5,0.75));
		// //twelve.toggleWhenPressed(new ElevateTime(20,0.8));
		

		oneTwo.whileHeld(new WheelsUpOverride());
		twoTwo.whileHeld(new WheelOut(0.9,0.9));

		//threeTwo.toggleWhenPressed(new Climb(true));//0.165
		
		 elevenTwo.toggleWhenPressed(new WheelsUp(0.99,0.01,0.2,true,0.25));
		 nineTwo.toggleWhenPressed(new WheelsUp(0.9,0.01,0.25,true,0.25));//CargoShip
		 sevenTwo.toggleWhenPressed(new WheelsUp(0.74,0.01,0.25,true,0.2));//Rocket1
		eightTwo.toggleWhenPressed(new SeperateRampEncoders(9));
		fiveTwo.toggleWhenPressed(new Climb(true));
		twelveTwo.toggleWhenPressed(new Climb(false));//Time(1.85, 1));//try lower
		//threeTwo.toggleWhenPressed(new ToggleHatch());
		fourTwo.toggleWhenPressed(new SeperateRampEncoders(18));//n+6
		// sevenTwo.toggleWhenPressed(new ElevateTime(15.5,0.85));//How hei
		// eightTwo.toggleWhenPressed(new ElevateTime(28,1.7));
		// nineTwo.toggleWhenPressed(new ElevateTime(43,2.7));
		// tenTwo.toggleWhenPressed(new ElevateTime(56.3,3.4));
		// elevenTwo.toggleWhenPressed(new ElevateTime(70.5,4.2));


		// sevenTwo.toggleWhenPressed(new ElevatorMotion(15.5, 0.8));
		// eightTwo.toggleWhenPressed(new ElevatorMotion(28,1));
		// nineTwo.toggleWhenPressed(new ElevatorMotion(43,1));
		// //tenTwo.toggleWhenPressed(new ElevatorMotion(56,1));
		// elevenTwo.toggleWhenPressed(new ElevatorMotion(70.5,1));
		// //twelveTwo.toggleWhenPressed(new ElevatorMotion(20,1));

		//twelveTwo.toggleWhenPressed(new Climb());
		//eightTwo.toggleWhenPressed(new ElevateMotionGroup(28,1));

	}
	public double getYSpeed() 
	{
		if(Math.abs(mainDriver.getRawAxis(1)) >= .2)
		{
			// if(mainDriver.getRawAxis(1)> 0)
			// {
			// 	return (mainDriver.getRawAxis(1)-.10)/.90;
			// }
			// else
			// {
			// 	return (mainDriver.getRawAxis(1)+.10)/.90;
			// }
			SmartDashboard.putNumber("Yaxis", mainDriver.getRawAxis(1));
			return (mainDriver.getRawAxis(1));
		}
		
	
		return 0.0;
  }
  public double getXSpeed() 
	{
		if(Math.abs(mainDriver.getRawAxis(0)) >= .2)
		{
//			if(mainDriver.getRawAxis(5)> 0)
//			{
//				return (mainDriver.getRawAxis(5)-.10)/.90;
//			}
//			else
//			{
//				return (mainDriver.getRawAxis(5)+.10)/.90;
//			}
      SmartDashboard.putNumber("Xaxis", mainDriver.getRawAxis(0));
			return (mainDriver.getRawAxis(0));
		}
		return 0.0;
	}
	
	public double getZTurn() 
	{
		if(Math.abs(mainDriver.getRawAxis(2)) >= .2)
		{
//			if(mainDriver.getRawAxis(5)> 0)
//			{
//				return (mainDriver.getRawAxis(5)-.10)/.90;
//			}
//			else
//			{
//				return (mainDriver.getRawAxis(5)+.10)/.90;
//			}

			SmartDashboard.putNumber("Zaxis", mainDriver.getRawAxis(2));
			return (mainDriver.getRawAxis(2));
		}
		return -0.0;
	}

	public double getPlusMinus()
	{
		return driver2.getRawAxis(3);
	}

	public double getSecondX()
	{
		return (driver2.getRawAxis(0));
	}
	
	public double getSecondY()
	{
		return (driver2.getRawAxis(1));
	}


	public double getxboxYSpeed() 
	{
		if(Math.abs(xbox.getRawAxis(1)) >= .2)
		{
			// if(mainDriver.getRawAxis(1)> 0)
			// {
			// 	return (mainDriver.getRawAxis(1)-.10)/.90;
			// }
			// else
			// {
			// 	return (mainDriver.getRawAxis(1)+.10)/.90;
			// }
			SmartDashboard.putNumber("Yaxis", xbox.getRawAxis(1));
			return (xbox.getRawAxis(1));
		}
		
	
		return 0.0;
  }
  public double getxboxXSpeed() 
	{
		if(Math.abs(xbox.getRawAxis(0)) >= .2)
		{
//			if(mainDriver.getRawAxis(5)> 0)
//			{
//				return (mainDriver.getRawAxis(5)-.10)/.90;
//			}
//			else
//			{
//				return (mainDriver.getRawAxis(5)+.10)/.90;
//			}
      SmartDashboard.putNumber("Xaxis", xbox.getRawAxis(0));
			return (xbox.getRawAxis(0));
		}
		return 0.0;
	}
	
	public double getxboxZTurn() 
	{
		if(Math.abs(xbox.getRawAxis(4)) >= .2)
		{
//			if(mainDriver.getRawAxis(5)> 0)
//			{
//				return (mainDriver.getRawAxis(5)-.10)/.90;
//			}
//			else
//			{
//				return (mainDriver.getRawAxis(5)+.10)/.90;
//			}

			SmartDashboard.putNumber("Zaxis", xbox.getRawAxis(4));
			return (xbox.getRawAxis(4));
		}
		return -0.0;
	}
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());