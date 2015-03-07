/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands.macro;

import static org.usfirst.frc.team2212.robot.Robot.oi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import macro.Macro;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author AtidSpikes
 */
public class Record extends Command {

	String macroName;
	Macro macro;

	public Record(String macroName) {
		this.macroName = macroName;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		ArrayList<Boolean> buttonsArray = new ArrayList<>();
		ArrayList<Double> axisArray = new ArrayList<>();
		for (int i = 1; i <= 12; i++) {
			buttonsArray.add(i, oi.getDriverButton(i));
		}
		axisArray.add(0, oi.getDriverX());
		axisArray.add(1, oi.getDriverY());
		axisArray.add(2, oi.getDriverTwist());
		macro = new Macro(buttonsArray, axisArray);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		ArrayList<Boolean> buttonsArray = new ArrayList<>();
		ArrayList<Double> axisArray = new ArrayList<>();
		for (int i = 1; i <= 12; i++) {
			buttonsArray.add(i, oi.getDriverButton(i));
		}
		axisArray.add(0, oi.getDriverX());
		axisArray.add(1, oi.getDriverY());
		axisArray.add(2, oi.getDriverTwist());
		macro.addData(buttonsArray, axisArray);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream("/home/admin/Macros/" + macroName
					+ ".ser");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(macro);
			oos.close();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Record.class.getName())
					.log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Record.class.getName())
					.log(Level.SEVERE, null, ex);
		} finally {
			try {
				fout.close();
			} catch (IOException ex) {
				Logger.getLogger(Record.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
