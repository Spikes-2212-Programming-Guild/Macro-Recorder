package org.usfirst.frc.team2212.robot;

import static com.oracle.jrockit.jfr.ContentType.Address;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import macro.Macro;
import org.usfirst.frc.team2212.robot.commands.driving.Forward;
import org.usfirst.frc.team2212.robot.commands.driving.Sideways;
import org.usfirst.frc.team2212.robot.commands.driving.Turn;
import org.usfirst.frc.team2212.robot.commands.macro.Record;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI extends JoystickMap {

    public OI() {
//        FileInputStream fin = null;
//        try {
//            fin = new FileInputStream("~/Macros/test.ser");
//            ObjectInputStream ois = new ObjectInputStream(fin);
//            Macro macro = (Macro) ois.readObject();
//            ois.close();
            FORWARD_BUTTON.whileHeld(new Forward());
            SIDEWAYS_BUTTON.whileHeld(new Sideways());
            TURN_BUTTON.whileHeld(new Turn());
            RECORD_BUTTON.whenPressed(new Record("test"));
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(OI.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(OI.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(OI.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                fin.close();
//            } catch (IOException ex) {
//                Logger.getLogger(OI.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
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
