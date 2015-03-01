/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.usfirst.frc.team2212.robot.Robot.oi;

/**
 *
 * @author AtidSpikes
 */
public class Record extends Command {

    int iteration;
    FileWriter fileWriter;

    public Record(String macroName) {
        try {
            fileWriter = new FileWriter(macroName + ".log");
        } catch (IOException ex) {
            Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Called just before this Command runs the first time
    protected void initialize() {
        // setTimeout(15);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        try {
            fileWriter.write("iteration : " + iteration);
            for (int i = 1; i <= 12; i++) {
                fileWriter.write("driver button " + i + " : " + oi.getDriverButton(i));
            }
            fileWriter.write("driver x : " + oi.getDriverX());
            fileWriter.write("driver y : " + oi.getDriverY());
            iteration++;
        } catch (IOException ex) {
            Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
