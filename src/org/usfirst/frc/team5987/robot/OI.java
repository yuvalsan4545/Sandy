package org.usfirst.frc.team5987.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team5987.robot.commands.Degrees90Command;
import org.usfirst.frc.team5987.robot.commands.DriveToPointCommand;
import org.usfirst.frc.team5987.robot.commands.EatCubeByHoldCommand;
import org.usfirst.frc.team5987.robot.commands.EatCubeByTimeCommand;
import org.usfirst.frc.team5987.robot.commands.ThrowUpCubeCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public Joystick left = new Joystick(0);
	public Joystick right = new Joystick(1);
	public XboxController xbox = new XboxController(2);
	
	
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
	
    
	Button a = new JoystickButton(xbox, 1);
	Button b = new JoystickButton(xbox, 2);
	Button x = new JoystickButton(xbox, 3);
	Button y = new JoystickButton(xbox, 4);
	
	
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	public OI(){
		
		a.whenPressed(new Degrees90Command()); // in meters
		b.whenPressed(new EatCubeByTimeCommand(3.5)); //time in seconds
		x.whenPressed(new ThrowUpCubeCommand(0.75)); //time in seconds
		y.whileHeld(new EatCubeByHoldCommand()); 
		
	}
}

