package org.usfirst.frc.team500.robot.commands;

import org.usfirst.frc.team500.robot.OI;
import org.usfirst.frc.team500.robot.RobotMap;
import org.usfirst.frc.team500.robot.subsystems.DrivetrainSubsystem;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class ArcadeDriveCommand extends Command {

    public ArcadeDriveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(DrivetrainSubsystem.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (OI.aPressed()){
    		DrivetrainSubsystem.getInstance().backwardsFullVelocity();
    	}
    	else if (OI.bPressed()){
    		DrivetrainSubsystem.getInstance().forwardsFullVelocity();
    	}
    	else {
    		DrivetrainSubsystem.getInstance().arcadeDrive(OI.getLeftYValue(), OI.getLeftXValue(), false);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !DriverStation.getInstance().isOperatorControl();
    }

    // Called once after isFinished returns true
    protected void end() {
    	DrivetrainSubsystem.getInstance().tankDrive(0, 0, false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
