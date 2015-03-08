package org.usfirst.frc.team2212.robot;

import org.usfirst.frc.team2212.robot.subsystems.OneEngine;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	// public static final DriveTrain driveTrain = new DriveTrain(
	// RobotMap.LEFT_FORWARD_VICTOR_PORT,
	// RobotMap.LEFT_BACKWARDS_VICTOR_PORT,
	// RobotMap.RIGHT_FORWARD_VICTOR_PORT,
	// RobotMap.RIGHT_BACKWARDS_VICTOR_PORT,
	// RobotMap.MIDDLE_FRONT_VICTOR_PORT,
	// RobotMap.MIDDLE_BACKWARDS_VICTOR_PORT,
	// RobotMap.LEFT_ENCODER_1_PORT, RobotMap.LEFT_ENCODER_2_PORT,
	// RobotMap.RIGHT_ENCODER_1_PORT, RobotMap.RIGHT_ENCODER_2_PORT,
	// RobotMap.FRONT_ENCODER_1_PORT, RobotMap.FRONT_ENCODER_2_PORT,
	// RobotMap.REAR_ENCODER_1_PORT, RobotMap.REAR_ENCODER_2_PORT,
	// RobotMap.WHEEL_DIAMETER);
	public static OneEngine engine = new OneEngine(9);
	public static OneEngine e = new OneEngine(8);
	// public static Subsystem lock = new Subsystem() {
	//
	// @Override
	// protected void initDefaultCommand() {
	// // TODO Auto-generated method stub
	//
	// }
	// };
	public static OI oi = new OI();

	/**
     *
     */
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		// instantiate the command used for the autonomous period
		// driveTrain.reset();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		// schedule the autonomous command (example)
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	@Override
	public void disabledInit() {
		// driveTrain.reset();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		// SmartDashboard.putBoolean("Overriding: ",
		// oi.driverJoystick.getOverride());
		// SmartDashboard.putNumber("Driver Y:", oi.getDriverY());
		// for (int i = 1; i <= 12; i++) {
		// SmartDashboard.putBoolean("Driver Button " + i + ":",
		// oi.getDriverButton(i));
		// }
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();

	}
}
