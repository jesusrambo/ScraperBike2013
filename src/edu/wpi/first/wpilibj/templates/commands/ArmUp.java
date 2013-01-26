/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates.commands;

//import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.templates.ScraperBike;
import edu.wpi.first.wpilibj.templates.subsystems.RampController;

/**
 *Once the ramp is down, this command will be called to reset the arm to its original position. 
 * 
 * @author plevinson
 */
public class ArmUp extends CommandBase {
    private RampController Ramp;
    
    public ArmUp() {
        
        super("Arm Reset");
        Ramp = ScraperBike.getRamp();
        requires(Ramp);
    }

    /* 
     * This method makes the motor reverse before anything else happens. 
     */
    protected void initialize() {
        //RampController.setDir();
        //RampController.getArmRelay().set(Relay.Value.kReverse);
        RampController.rampUp();
    }

    /* 
     * The arm will move back to its original position and stop when it gets there.
     */
    protected void execute() {
        //Ramp.push();
    }

    /**
     * When the arm is at its original position.
     * 
     * @return true to stop command, false to continue execute()
     */
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        //RampController.getArmRelay().set(Relay.Value.kOff);
        RampController.rampNeutral();
    }
}
