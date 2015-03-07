/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands.macro;

import edu.wpi.first.wpilibj.command.Command;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import macro.Macro;
import static org.usfirst.frc.team2212.robot.Robot.oi;

/**
 *
 * @author ThinkRedstone
 */
public class Play extends Command {

    private Macro macro;
    Iterator it;

    public Play(Macro macro) {
        this.macro = macro;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        it = macro.getData().entrySet().iterator();
        oi.setOverride(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Map.Entry<Long, List[]> pair = (Map.Entry<Long, List[]>) it.next();
        oi.setDriverX((double) pair.getValue()[1].get(0));
        oi.setDriverY((double) pair.getValue()[1].get(1));
        oi.setDriverTwist((double) pair.getValue()[1].get(2));
        for (int i = 1; i <= 12; i++) {
            oi.setDriverButton(i, (boolean) pair.getValue()[0].get(i));
        }
        try {
            Thread.sleep(pair.getKey());
        } catch (InterruptedException ex) {
            Logger.getLogger(Play.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        it.remove(); // avoids a ConcurrentModificationException
    }

// Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !it.hasNext();
    }

    // Called once after isFinished returns true
    protected void end() {
        oi.setOverride(false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
