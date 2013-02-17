/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.templates.commands.*;
/** This file connects Joystick inputs (Buttons) into commands.
 * 
 * @author Team 2035 Programmers
 */
public class OI {

    private static Button shiftLowGear;
    private static Button pidShooter;
    private static Button manualShooter;
    private static Button reloadLeft;
    private static Button reloadRight;
    private static Button rotate;
    private static Button climbPyramid;
    private static Button armExtend;
    private static Button armRetract;
    
    private static Button shoot;
    private static Button keepAtRange;
    private static Button lockTop;
    private static Button lockLMid;
    private static Button lockRMid;
    private static Button lockLBot;
    private static Button lockRBot;
    
    public static void initialize() {
        
        // Joystick 1 Button (Driving Joystick)
        shiftLowGear = RobotMap.dTrigger;
        pidShooter = RobotMap.dButton2;
        manualShooter = RobotMap.dButton3;
        reloadLeft = RobotMap.dButton4;
        reloadRight = RobotMap.dButton5;
        rotate = RobotMap.dButton6;
        climbPyramid = RobotMap.dButton9;
        armRetract = RobotMap.dButton10;
        armExtend = RobotMap.dButton11;
        
        // Joystick 1 Actions
        shiftLowGear.whileHeld(new ShiftLowGear());
        pidShooter.whileHeld(new PIDShoot(RobotMap.maxRPM));
        manualShooter.whileHeld(new Shoot());
        reloadLeft.whileHeld(new Reload(1));
        reloadRight.whileHeld(new Reload(-1));
        rotate.whileHeld(new RotateRobot());
        climbPyramid.whenPressed(new ClimbLevelOne());
        armRetract.whileHeld(new ArmsRetract());
        armExtend.whileHeld(new ArmsExtend(2)); 
        
        // Joystick 2 Buttons (Shooting Joystick)
        shoot = RobotMap.shootTrigger;
        keepAtRange = RobotMap.shootButton2;
        lockTop = RobotMap.shootButton3;
        lockLMid = RobotMap.shootButton4;
        lockRMid = RobotMap.shootButton5;
        lockLBot = RobotMap.shootButton8;
        lockRBot = RobotMap.shootButton9;
        
        // Joystick 2 Actions
        shoot.whileHeld(new PIDShoot(RobotMap.maxRPM));
        
        keepAtRange.whileHeld(new DriveTrainLateral(RobotMap.DTLKp, RobotMap.DTLKi, RobotMap.DTLKd));
        keepAtRange.whenReleased(new StandardDrive(ScraperBike.getDriveTrain().getDrive(), RobotMap.dStick));
        
        lockTop.whileHeld(new DriveTrainTargeting(RobotMap.DTLKp, RobotMap.DTLKi, RobotMap.DTLKd, RobotMap.Top));
        lockTop.whenReleased(new StandardDrive(ScraperBike.getDriveTrain().getDrive(), RobotMap.dStick));
        
        lockLMid.whileHeld(new DriveTrainTargeting(RobotMap.DTLKp, RobotMap.DTLKi, RobotMap.DTLKd, RobotMap.LMid));
        lockLMid.whenReleased(new StandardDrive(ScraperBike.getDriveTrain().getDrive(), RobotMap.dStick));
        
        lockRMid.whileHeld(new DriveTrainTargeting(RobotMap.DTLKp, RobotMap.DTLKi, RobotMap.DTLKd, RobotMap.RMid));
        lockRMid.whenReleased(new StandardDrive(ScraperBike.getDriveTrain().getDrive(), RobotMap.dStick));
        
        lockLBot.whileHeld(new DriveTrainTargeting(RobotMap.DTLKp, RobotMap.DTLKi, RobotMap.DTLKd, RobotMap.LBot));
        lockLBot.whenReleased(new StandardDrive(ScraperBike.getDriveTrain().getDrive(), RobotMap.dStick));
        
        lockRBot.whileHeld(new DriveTrainTargeting(RobotMap.DTLKp, RobotMap.DTLKi, RobotMap.DTLKd, RobotMap.RBot));
        lockRBot.whenReleased(new StandardDrive(ScraperBike.getDriveTrain().getDrive(), RobotMap.dStick));
        
    }
    
    public static Joystick getDriveStick(){
        return RobotMap.dStick;
    }
    
    public static Joystick getShootStick(){
        return RobotMap.shootStick;
    }
    
    public static double getAdjustedThrottle(){
        
        double speed;
        speed = (RobotMap.shootStick.getZ()+1)/2;
        return speed;
    }
    
}