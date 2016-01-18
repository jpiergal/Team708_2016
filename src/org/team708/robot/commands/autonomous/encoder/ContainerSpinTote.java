
package org.team708.robot.commands.autonomous.encoder;

import org.team708.robot.AutoConstants;
import org.team708.robot.commands.claw.CloseClaw;
import org.team708.robot.commands.claw.OpenClaw;
import org.team708.robot.commands.clawElevator.ClawDown;
import org.team708.robot.commands.clawElevator.ClawUp;
import org.team708.robot.commands.drivetrain.DriveStraightToEncoderDistance;
import org.team708.robot.commands.drivetrain.TurnToDegrees;
import org.team708.robot.commands.indexer.IndexerUp;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class ContainerSpinTote extends CommandGroup {
	
//	private double irTolerance = 5;  //inches
        
    public  ContainerSpinTote() {
    	// Picks up one container
    	addSequential(new CloseClaw());
    	addSequential(new ClawUp());
    	
    	// Drops the container on the tote
    	addSequential(new ClawUp());
    	addSequential(new DriveStraightToEncoderDistance(AutoConstants.CONTAINER_TOTE_TO_TOTE_DISTANCE, AutoConstants.ENCODER_SPEED, false));
    	addSequential(new ClawDown());
    	addParallel(new OpenClaw());
//    	addSequential(new ClawDown());
    	addSequential(new CloseClaw());
    	
    	// Go to auto zone
    	addSequential(new TurnToDegrees(AutoConstants.TURN_SPEED, -AutoConstants.NINETY_DEGREE_TURN));
    	addSequential(new DriveStraightToEncoderDistance(AutoConstants.SWAGTONOMOUS_TO_AUTO_DISTANCE, AutoConstants.SWAGTONOMOUS_ENCODER_SPEED, false));
    	
    	//Turn 90 degrees counterclockwise
    	addSequential(new TurnToDegrees(AutoConstants.TURN_SPEED, AutoConstants.NINETY_DEGREE_TURN));
    }
}
