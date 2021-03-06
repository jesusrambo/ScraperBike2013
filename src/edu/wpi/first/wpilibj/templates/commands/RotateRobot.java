/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2013. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.ScraperBike;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;

/** Turns the robot in place.
 *
 * @author Team 2035 Programmers
 */
public class RotateRobot extends CommandBase {
    private DriveTrain turn;
    
    /**
     *
     */
    public RotateRobot() {
        super("RotateRobot");
        turn = ScraperBike.getDriveTrain();
        requires(turn);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run. Sets how fast the robot rotates
    protected void execute() {
        turn.rotate(0.4);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true. stops the robot rotating by setting the speed to 0.
    protected void end() {
        turn.rotate(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        turn.rotate(0.0);
    }
}
