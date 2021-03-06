package org.usfirst.frc.team5987.robot.commands;

import org.usfirst.frc.team5987.robot.Constants;
import org.usfirst.frc.team5987.robot.Robot;
import org.usfirst.frc.team5987.robot.RobotMap;
import org.usfirst.frc.team5987.robot.subsystems.driveSubsystem;



import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
/**
 *
 */
public class DriveToPointCommand extends Command {
	
	double startDistance = 0;
	
	double distanceToDrive = 0;
	
	private static NetworkTable driveTable = Robot.driveSubsystem.driveTable;
	
    public DriveToPointCommand(double distance) {
    	Robot.driveSubsystem.driveSpeedInAuto.setDouble(Robot.driveSubsystem.driveSpeedInAuto.getDouble(Constants.driveSpeedInAuto));
    	requires(Robot.driveSubsystem);
    	distanceToDrive = distance;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	startDistance = Robot.driveSubsystem.getDistance();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Constants.driveSpeedInAuto = Robot.driveSubsystem.driveSpeedInAuto.getDouble(Constants.driveSpeedInAuto);
    	Robot.driveSubsystem.setSpeed(Constants.driveSpeedInAuto, Constants.driveSpeedInAuto);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
        return ((Robot.driveSubsystem.getDistance() - startDistance) >= distanceToDrive);
    }

    // Called once after isFinished returns true
    protected void end() {

    	Robot.driveSubsystem.setSpeed(0, 0);
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
