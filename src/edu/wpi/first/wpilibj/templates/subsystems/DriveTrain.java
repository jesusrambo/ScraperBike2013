/*----------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates.subsystems;

//import edu.team2035.meta.MetaGyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.templates.commands.StandardDrive;
//import edu.team2035.meta.MetaCommandLog;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 * 
 * Handles drive motors, transmission, gyros for autonomous balancing, and
 * joystick input
 *
 * @author jrusso
 */
public class DriveTrain extends Subsystem {
    
    private Solenoid powerTakeOff;
    private Solenoid shifter;
    private static RobotDrive drive;
    private Encoder transmission1;
    private DigitalInput sensor1;
    private DigitalInput sensor2;
    private Talon FrontLeftTalon;
    private Talon FrontRightTalon;
    private Talon RearLeftTalon;
    private Talon RearRightTalon;
    private double motorSpeeds;
    private static Gyro gyro1;
    //private static MetaCommandLog Log;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public DriveTrain(){
        super("Drive Train");
//        Log = new MetaCommandLog("DriveTrain", "Gyro" , "Left Jaguars,Right Jaguars");
        //gyro1 = new Gyro(RobotMap.AnalogSideCar , RobotMap.DriveTrainGyroInput);
        shifter = RobotMap.shifter; // Solenoid 1
        powerTakeOff = RobotMap.powerTakeoff; // Solenoid 2
        //shifter.setDirection(Relay.Direction.kBoth);
        
        FrontLeftTalon = new Talon(RobotMap.frontLeftMotor);
        RearLeftTalon = new Talon(RobotMap.rearLeftMotor);
        FrontRightTalon = new Talon(RobotMap.frontRightMotor);
        RearRightTalon = new Talon(RobotMap.rearRightMotor);
        drive = new RobotDrive(FrontLeftTalon, RearLeftTalon, FrontRightTalon, RearRightTalon);
        //drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        //drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        //drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        //drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        
        //lfFrontJag = new Jaguar (3);
        //rtFrontJag = new Jaguar (4);
        
        //joystick2 = new Joystick(2);
        //sensor1 = new DigitalInput(1);
        //sensor2 = new DigitalInput (2);

    }
      
    public void initDefaultCommand() {  
        super.setDefaultCommand(new StandardDrive(drive, OI.getDriveStick()));
    }
    
//    public double getLeftOutput(){
//       return truncate(drive.getLeftOutputs());
//    }
    
//    public double getRightOutput(){
//       return truncate(drive.getRightOutputs());
//    }
    
    public void drive(double speed) {
        powerDriveTrain();
        drive.drive(speed, 0.0);
    }
    
    public void drive(double speed, double rot) {
        powerDriveTrain();
        drive.drive(speed, rot);
    }
    
    public void arcadeDrive(Joystick j){
        powerDriveTrain();
        drive.arcadeDrive(j);
    }
    
    public void rotate(double rot) {
        powerDriveTrain();
        drive.arcadeDrive(0, rot);
    }
    
    public void climb(double speed) {
        shiftLowGear();
        powerArms();
        drive.drive(speed, 0.0);
    }
    
    public void shiftLowGear() {
        shifter.set(RobotMap.shifterLowGear);
    }
    
    public void shiftHighGear() {
        shifter.set(RobotMap.shifterHighGear);
        System.out.println("Shifting high");
    }
    
    public void powerDriveTrain() {
        powerTakeOff.set(RobotMap.shifterDriveTrainDirection);
    }
    
    public void powerArms() {
        powerTakeOff.set(RobotMap.shifterArmsDirection);
    }

    public static Gyro getGyro1(){
        return gyro1;
    }
    
    public RobotDrive getDrive(){
        return drive;
    }
    
    
    
//    public static MetaCommandLog getCommandLog(){
//        return Log;//
//    }
    
//    public static void setMetaCommandOutputs(){
//        Log.setOutputs("" + drive.getLeftOutputs() + "," + drive.getRightOutputs());
        
//    }
    
    public void disableSafety(){
        drive.setSafetyEnabled(false);
    }
    
    public void enableSafety(){
        drive.setSafetyEnabled(true);
    }
    
    public double truncate(double d){
        
        int temp = (int)(d*1000);
        double result = (double)temp/1000;
        return result;
    }
    

}
