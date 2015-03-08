/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot;

import macro.MacroJoystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 *
 * @author ThinkRedstone
 */
public class JoystickMap {

	public MacroJoystick driverJoystick = new MacroJoystick(0);
	protected MacroJoystick navJoystick = new MacroJoystick(1);

	// protected Button UP_BUTTON = new JoystickButton(navJoystick, 3);
	// protected Button DOWN_BUTTON = new JoystickButton(navJoystick, 2);
	// protected Button OPEN_BUTTON = new JoystickButton(navJoystick, 5);
	// protected Button CLOSE_BUTTON = new JoystickButton(navJoystick, 4);
	protected Button MOVE_BUTTON = new JoystickButton(driverJoystick, 1);

	// protected Button FORWARD_BUTTON = new JoystickButton(driverJoystick, 1);
	// protected Button SIDEWAYS_BUTTON = new JoystickButton(driverJoystick, 2);
	// protected Button TURN_BUTTON = new JoystickButton(driverJoystick, 3);

	public Button RECORD_BUTTON = new JoystickButton(driverJoystick, 12);
	public Button PLAY_BUTTON = new JoystickButton(driverJoystick, 11);

}
