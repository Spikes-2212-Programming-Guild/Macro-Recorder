package org.usfirst.frc.team2212.robot.subsystems;

import org.usfirst.frc.team2212.robot.commands.Move;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TwoEngine extends Subsystem {

	private VictorSP engine1;
	private VictorSP engine2;

	public TwoEngine(int port1, int port2) {
		this.engine1 = new VictorSP(port1);
		this.engine2 = new VictorSP(port2);
	}

	public void set(double speed1 , double speed2) {
		engine1.set(speed1);
		engine2.set(speed2);
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new Move());
	}
}
