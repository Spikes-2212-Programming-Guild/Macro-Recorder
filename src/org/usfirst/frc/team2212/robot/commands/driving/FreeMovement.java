/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands.driving;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team2212.robot.Robot.driveTrain;
import static org.usfirst.frc.team2212.robot.Robot.oi;
import org.usfirst.frc.team2212.robot.RobotMap;

/**
 *
 * @author ThinkRedstone
 */
public class FreeMovement extends Command {

    private double currentSpeedSideways;
    private double currentSpeedForward;

    public FreeMovement() {
        requires(driveTrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        currentSpeedForward = 0;
        currentSpeedSideways = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (Math.abs(oi.getDriverY() - currentSpeedForward) < RobotMap.SPEED_CHANGE_PER_TICK) {
            currentSpeedForward = oi.getDriverY();
        } else {
            currentSpeedForward = currentSpeedForward + Math.signum(oi.getDriverY() - currentSpeedForward) * RobotMap.SPEED_CHANGE_PER_TICK;
        }
        if (Math.abs(oi.getDriverX() - currentSpeedSideways) < RobotMap.SPEED_CHANGE_PER_TICK) {
            currentSpeedSideways = oi.getDriverX();
        } else {
            currentSpeedSideways = currentSpeedSideways + Math.signum(oi.getDriverX() - currentSpeedSideways) * RobotMap.SPEED_CHANGE_PER_TICK;
        }
        driveTrain.freeMovement(currentSpeedForward, currentSpeedSideways);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        driveTrain.freeMovement(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
