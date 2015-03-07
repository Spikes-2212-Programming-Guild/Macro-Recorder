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
import macro.Pair;

import org.usfirst.frc.team2212.robot.OI;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author ThinkRedstone
 */
public class Play extends Command {

	private Macro macro;
	Iterator<Pair<Long, List[]>> it;
	Pair<Long, List[]> pair;
	String macroName;

	public Play(String macroName) {
		this.macroName = macroName;
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
			it = macro.getData().iterator();
			pair = it.next();
			oi.setOverride(true);
			SmartDashboard.putData(this);
		}
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if (it.hasNext()) {
			oi.setDriverX((double) pair.getSecondValue()[1].get(0));
			oi.setDriverY((double) pair.getSecondValue()[1].get(1));
			oi.setDriverTwist((double) pair.getSecondValue()[1].get(2));
			for (int i = 1; i <= 12; i++) {
				oi.setDriverButton(i, (boolean) pair.getSecondValue()[0].get(i));
			}
			it.remove(); // avoids a ConcurrentModificationException
			pair = it.next();
			try {
				Thread.sleep(pair.getFirstValue());
			} catch (InterruptedException ex) {
				Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null,
						ex);
			}

		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return !it.hasNext();
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
