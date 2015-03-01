/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import static org.usfirst.frc.team2212.robot.Robot.oi;

/**
 *
 * @author AtidSpikes
 */
public class Record extends Command {

    NetworkTable table = NetworkTable.getTable("record");
    int iteration;
    public Record() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
        // setTimeout(15);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        table.putNumber("iteration", iteration);
        for (int i = 1; i <= 12; i++) {
            table.putBoolean("driver button " + i, oi.getDriverButton(i));
        }
        table.putNumber("driver x", oi.getDriverX());
        table.putNumber("driver y", oi.getDriverY());
        iteration++;
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
