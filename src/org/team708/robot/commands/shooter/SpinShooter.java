package org.team708.robot.commands.shooter;

import org.team708.robot.Constants;
import org.team708.robot.OI;
import org.team708.robot.Robot;
import org.team708.robot.subsystems.Loader;
import org.team708.robot.util.Gamepad;
import org.team708.robot.commands.shooter.Fire;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpinShooter extends Command {


    public SpinShooter() {
    	requires(Robot.shooter);
    }
    
    boolean Lpressed;
    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
   
//    	Lpressed = OI.operatorGamepad.getButton(OI.SPIN_LOADER_BUTTON);
    	
//    	double distance = Loader.irGetDistance();

    	
//    	if (distance < 3 && Lpressed == true) {
    		Robot.shooter.manualSpeed(Constants.SHOOTER_MOTOR_FORWARD);
//    			
//    	}
//    	else {
//    		Robot.shooter.manualSpeed(Constants.MOTOR_OFF);
//    	}
//    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    		if (Fire.fire_pressed)
    			return(true);
    		else
    			return(false);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.manualSpeed(Constants.MOTOR_OFF);
    }

    // Called when another command which requires one or more of the same
    // subsystems are scheduled to run
    protected void interrupted() {
    	end();
    }
}
