package org.usfirst.frc.team2212.robot;

import org.usfirst.frc.team2212.robot.commands.Move;
import org.usfirst.frc.team2212.robot.commands.macro.Play;
import org.usfirst.frc.team2212.robot.commands.macro.Record;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI extends JoystickMap {

	public OI() {
		PLAY_BUTTON.whenPressed(new Play("test"));
		RECORD_BUTTON.whileHeld(new Record("test"));
		MOVE_BUTTON.whileHeld(new Move());
	}

	public double getDriverY() {
		return driverJoystick.getOverrideableY();
	}

	public double getDriverX() {
		return driverJoystick.getOverrideableX();
	}

	public double getDriverTwist() {
		return driverJoystick.getOverrideableTwist();
	}

	public double getNavY() {
		return navJoystick.getOverrideableY();
	}

	public double getNavX() {
		return navJoystick.getOverrideableX();
	}

	public boolean getDriverButton(int button) {
		return driverJoystick.getRawButton(button);
	}

	public void setOverride(boolean override) {
		driverJoystick.setOverride(override);
		navJoystick.setOverride(override);
	}

	public void setDriverButton(int button, boolean state) {
		driverJoystick.setButton(button, state);
	}

	public void setDriverX(double value) {
		driverJoystick.setX(value);
	}

	public void setDriverY(double value) {
		driverJoystick.setY(value);
	}

	public void setDriverTwist(double value) {
		driverJoystick.setTwist(value);
	}
}
