/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands.macro;

import static org.usfirst.frc.team2212.robot.Robot.oi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import macro.Macro;

import org.usfirst.frc.team2212.robot.OI;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author ThinkRedstone
 */
public class Play extends Command {

    private Macro macro;
    private Iterator<List[]> driverIt;
    private Iterator<List[]> navigatorIt;
    private List[] driverList;
    private List[] navigatorList;

    String macroName;

    public Play(String macroName) {
        this.macroName = macroName;
        // requires(lock);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        FileInputStream fin = null;
        try {
            fin = new FileInputStream("/home/lvuser/Macros/" + macroName
                    + ".ser");
            ObjectInputStream ois = new ObjectInputStream(fin);
            macro = (Macro) ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fin.close();
            } catch (IOException ex) {
                Logger.getLogger(OI.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
			// Use requires() here to declare subsystem dependencies
            // eg. requires(chassis);
        }
        if (macro == null) {
            SmartDashboard.putBoolean("macro is null", true);
        } else {
            SmartDashboard.putBoolean("macro is null", false);
            driverIt = macro.getDataDriving().iterator();
            navigatorIt = macro.getDataNavigating().iterator();
            oi.setOverride(true);
            SmartDashboard.putData(this);
        }
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        if (driverIt.hasNext()) {
            driverList = driverIt.next();
            oi.setDriverX((double) driverList[1].get(0));
            oi.setDriverY((double) driverList[1].get(1));
            oi.setDriverTwist((double) driverList[1].get(2));
            for (int i = 1; i <= 10; i++) {

                oi.setDriverButton(i, (boolean) driverList[0].get(i));
            }

            driverIt.remove(); // avoids a ConcurrentModificationExceptio
        }
        if (navigatorIt.hasNext()) {
            navigatorList = navigatorIt.next();
            oi.setNavigatorX((double) navigatorList[1].get(0));
            oi.setNavigatorY((double) navigatorList[1].get(1));
            oi.setNavigatorTwist((double) navigatorList[1].get(2));
            if (navigatorList[0].size() < 13) {
                throw new RuntimeException("barak-noga-yonatan");
            }
            for (int i = 1; i <= 12; i++) {
                oi.setNavigatorButton(i, (boolean) navigatorList[0].get(i));
            }

            navigatorIt.remove();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return !driverIt.hasNext() && !navigatorIt.hasNext();
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        oi.setOverride(false);
    }

	// Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
