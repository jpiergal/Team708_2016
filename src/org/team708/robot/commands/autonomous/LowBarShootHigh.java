package org.team708.robot.commands.autonomous;

import org.team708.robot.AutoConstants;
import org.team708.robot.commands.arm.ArmDown;
import org.team708.robot.commands.drivetrain.DriveStraightForTime;
import org.team708.robot.commands.drivetrain.DriveStraightToEncoderDistance;
import org.team708.robot.commands.drivetrain.RotateAndDriveToTarget;
import org.team708.robot.commands.drivetrain.TurnToDegrees;
import org.team708.robot.commands.shooter.AutoLoaderSpin;
import org.team708.robot.commands.shooter.AutoShooterSpin;
import org.team708.robot.commands.shooter.AutoStopSL;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class LowBarShootHigh extends CommandGroup {
	
	public  LowBarShootHigh() {
		
		//addSequential(new DriveStraightToEncoderDistance(172));
		addSequential(new ArmDown());
		addSequential(new DriveStraightToEncoderDistance(AutoConstants.ROBOT_THROUGH_LOW_BAR, AutoConstants.ROBOT_ENCODER_DRIVE_SPEED));
		addSequential(new TurnToDegrees(-AutoConstants.TURN_SPEED, 50.0));
		addSequential(new DriveStraightToEncoderDistance(18, AutoConstants.ROBOT_ENCODER_DRIVE_SPEED));

		addSequential(new RotateAndDriveToTarget(42));
		//Shooting Sequence
		addSequential(new AutoShooterSpin());
		addSequential(new WaitCommand(AutoConstants.SHOOTER_MOTOR_SPINUP_TIME));
		addParallel(new AutoLoaderSpin());
		addSequential(new WaitCommand(AutoConstants.LOADER_MOTOR_LOADING_TIME));
		addSequential(new AutoStopSL());
		
		
    	//addSequential(new TurnToDegrees(AutoConstants.TURN_SPEED, AutoConstants.NINETY_DEGREE_TURN));

   
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
