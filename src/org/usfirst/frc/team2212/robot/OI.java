package org.usfirst.frc.team2212.robot;

import org.usfirst.frc.team2212.robot.commands.driving.Forward;
import org.usfirst.frc.team2212.robot.commands.driving.Sideways;
import org.usfirst.frc.team2212.robot.commands.driving.Turn;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI extends JoystickMap {

    public OI() {
        FORWARD_BUTTON.whileHeld(new Forward());
        SIDEWAYS_BUTTON.whileHeld(new Sideways());
        TURN_BUTTON.whileHeld(new Turn());
    }

    public double getDriverY() {
        return driverJoystick.getY();
    }

    public double getDriverX() {
        return driverJoystick.getX();
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
