# TestBoard - CyberCards

2018 CyberCards Robot Code

* Google Doc Robotics (Programming Group): https://docs.google.com/document/d/10W7AAliv-2adE1QoT-_Ebd4NKI2lYRccigRrX4KrVFQ/edit?ts=5a6ca1b0
* Google Doc Programming Goals/Accompishments: https://docs.google.com/document/d/11C0cntJ3zXXpDE_p-TRt8IizJ0WNeosob3VPjqPvYfQ/edit

## Getting Started

* Install Eclipse: https://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/keplersr1
* Install GitHub Desktop: https://desktop.github.com/
* Clone this repository on your machine.

## How to Git

* Keep the master branch history linear and clear.
* When you are working on a task, make sure you use your own feature-branch. For example: deanGyro. This means that Dean is working on Gyro on his feature-branch.
* Add all your commits to your feature-branch. Don't push anything to master unless you are in clean and ready state.
* When you are done, open a pull request.
* Wait for that pull request to be approved.
* When you merge your feature-branch to master, make sure you use the "Squash and Commit" option. This will help keeping the master branch history linear and clean.
* Slack Dean if you have need any help with GitHub.

## Template

```
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1529.robot;
import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	
	@Override
	public void robotInit() {
		
	}

	@Override
	public void autonomousInit() {
		
	}

	@Override
	public void autonomousPeriodic() {
		
	}

	@Override
	public void teleopInit(){
		
	}
	
	@Override
	public void teleopPeriodic() {
	
	}

	@Override
	public void testInit() {
	
	}

	@Override
	public void testPeriodic() {
	
	}
}
```

## Useful resources

### IterativeRobot Class
http://first.wpi.edu/FRC/roborio/release2015/docs/java/classedu_1_1wpi_1_1first_1_1wpilibj_1_1IterativeRobot.html

#### Public Methods
```
IterativeRobot() 				// Constructor for RobotIterativeBase

void startCompetition() 		// Provide an alternate "main loop" via startCompetition(). 
 
void robotInit() 				// Robot-wide initialization code should go here.
 
void disabledInit() 			// Initialization code for disabled mode should go here.
 
void autonomousInit() 			// Initialization code for autonomous mode should go here.
 
void teleopInit() 				// Initialization code for teleop mode should go here.
 
void testInit() 				// Initialization code for test mode should go here.
 
void disabledPeriodic()		 	// Periodic code for disabled mode should go here.
 
void autonomousPeriodic() 		// Periodic code for autonomous mode should go here.
 
void teleopPeriodic() 			// Periodic code for teleop mode should go here.
 
void testPeriodic() 			// Periodic code for test mode should go here.
```

### Talon Class
http://first.wpi.edu/FRC/roborio/beta/docs/java/edu/wpi/first/wpilibj/Talon.html


### ADXRS450_Gyro Class
http://first.wpi.edu/FRC/roborio/release/docs/java/edu/wpi/first/wpilibj/ADXRS450_Gyro.html

#### Public Methods
```
ADXRS450_Gyro() 				// Constructor.

ADXRS450_Gyro(SPI.Port port) 	// Constructor with port parameter.

void	calibrate() 			// Calibrate the gyro by running for a number of samples and computing the center value.

void	free() 					// Delete (free) the spi port used for the gyro and stop accumulating.

double	getAngle() 				// Return the actual angle in degrees that the robot is currently facing.

double	getRate() 				// Return the rate of rotation of the gyro.

void	reset() 				// Reset the gyro.
```

### Encoder Class
http://first.wpi.edu/FRC/roborio/release2015/docs/java/classedu_1_1wpi_1_1first_1_1wpilibj_1_1Encoder.html
https://wpilib.screenstepslive.com/s/currentCS/m/java/l/599717-encoders-measuring-rotation-of-a-wheel-or-other-shaft

#### The following values can be retrieved from the encoder:

* Count 	- The current count. May be reset by calling reset().
* Raw Count - The count without compensation for decoding scale factor.
* Distance 	- The current distance reading from the counter. This is the count multiplied by the Distance Per Count scale factor.
* Period 	- The current period of the counter in seconds. If the counter is stopped this value may return 0. This is deprecated, it is recommended to use rate instead.
* Rate 		- The current rate of the counter in units/sec. It is calculated using the DistancePerPulse divided by the period. If the counter is stopped this value may return Inf or NaN, depending on language.
* Direction - The direction of the last value change (true for Up, false for Down)
* Stopped 	- If the counter is currently stopped (period has exceeded Max Period)
