/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1529.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	/**VictorSPX Left = new VictorSPX(0);
	VictorSPX Middle = new VictorSPX(2);
	VictorSPX Right = new VictorSPX(1);**/
	//Joystick Xbox = new Joystick(0);
	Talon FrontLeft;
	Talon RearLeft;
	Talon FrontRight;
	Talon RearRight;
	//Joystick Xbox = new Joystick(0);
	private ADXRS450_Gyro gyro;
	private double kp = 0.03;

	private Joystick left;
	private Joystick right;
	private Encoder enc;
	private Robot myRobot;
	int angle;
	
	static int ENCODER_OFFSET;
	int step = 0;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	
	public void robotInit() {
		ENCODER_OFFSET = 12;
		gyro = new ADXRS450_Gyro();
		gyro.calibrate();
		left = new Joystick(2);
		right = new Joystick(3);
		 FrontLeft = new Talon(7);
		 RearLeft = new Talon(6);
		 FrontRight = new Talon(9);
		 RearRight =new Talon(8);
		 enc = new Encoder(8,9,false, Encoder.EncodingType.k4X);
		 enc.setDistancePerPulse((7.5*3.14159)/360);
		 
		
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional comparisons to
	 * the switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		gyro.reset();
		enc.reset();
		
		
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		//System.out.println(gyro.getAngle());
		
		System.out.println(enc.getDistance());
		
		FrontLeft.set(.5);
		RearLeft.set(.5);
		FrontRight.set(-.5);
		RearRight.set(-.5);
		
		if(enc.getDistance() > -144 + ENCODER_OFFSET){

			FrontLeft.set(.5);
			FrontRight.set(.5);
			RearLeft.set(.5);
			RearRight.set(.5);
			gyro.reset();
		}
		
		if(gyro.getAngle() > 90){
		FrontLeft.set(.5);
		RearLeft.set(.5);
		FrontRight.set(-.5);
		RearRight.set(-.5);
		enc.reset();
		}
		
		if(enc.getDistance() > -144 + ENCODER_OFFSET){
			
			FrontLeft.set(0);
			FrontRight.set(-0);
			RearLeft.set(0);
			RearRight.set(-0);
			
		}
		
	}
	
	@Override
	public void teleopInit(){
		
		gyro.reset();
		
	}
	

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {

		//FrontLeft.set(-right.getRawAxis(1));
		//RearLeft.set(-right.getRawAxis(1));
		//FrontRight.set(left.getRawAxis(1));
		//RearRight.set(left.getRawAxis(1));
		
		//encoder
		//enc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
		//enc.setMaxPeriod(.5);
		
		//enc.setReverseDirection(true);
		
		//double axis = Xbox.getRawAxis(1);
		//double axis1 = Xbox.getRawAxis(5);
	
		left.getRawAxis(1);
		right.getRawAxis(1);
	
		 //xbox configuration
		//double button = Xbox.getRawButton(1);
		FrontLeft.set(-left.getRawAxis(1));
		RearLeft.set(-left.getRawAxis(1));
		FrontRight.set(right.getRawAxis(1));
		RearRight.set(right.getRawAxis(1));
		//Left.set(ControlMode.PercentOutput, Xbox.getRawAxis(5));
		//Middle.set(ControlMode.PercentOutput, 50);
		//Right.set(ControlMode.PercentOutput, 100);
		//gyro configuration
		double angle = gyro.getAngle();
		double rate = gyro.getRate();
		System.out.println(angle);
		
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
		
	}
}
