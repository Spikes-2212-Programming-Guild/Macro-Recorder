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
		PLAY_BUTTON.whenPressed(new Play("test2"));
		RECORD_BUTTON.whileHeld(new Record("test2"));
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
	
	public double getNavTwist(){
		return navJoystick.getOverrideableTwist();
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
	public void setNavigatorButton(int button, boolean state) {
		navJoystick.setButton(button, state);
	}

	public void setNavigatorX(double value) {
		navJoystick.setX(value);
	}

	public void setNavigatorY(double value) {
		navJoystick.setY(value);
	}

	public void setNavigatorTwist(double value) {
		navJoystick.setTwist(value);
	}

	public boolean getNavigatorButton(int i) {
		return navJoystick.getRawButton(i);
	}
}
