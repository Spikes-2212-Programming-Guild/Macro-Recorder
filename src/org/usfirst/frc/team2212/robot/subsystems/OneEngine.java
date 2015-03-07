package org.usfirst.frc.team2212.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class OneEngine extends Subsystem {

	private VictorSP engine;

	public OneEngine(int port) {
		this.engine = new VictorSP(port);
	}

	public void set(double speed) {
		engine.set(speed);
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
