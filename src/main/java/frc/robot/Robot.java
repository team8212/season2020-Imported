package frc.robot;

import java.lang.Math;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Joystick;

//import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
//import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.XboxController;
import com.ctre.phoenix.motorcontrol.can.VictorSPX; 
import com.ctre.phoenix.motorcontrol.ControlMode; 

import frc.robot.Test;

public class Robot extends TimedRobot {

  public static Test test = new Test(); 

  private final VictorSPX mRightMaster = new VictorSPX(1);
  private final VictorSPX mRightSlave = new VictorSPX(2);
  private final VictorSPX mLeftMaster = new VictorSPX(3);
  private final VictorSPX mLeftSlave = new VictorSPX(4);

 private final Joystick m_stick = new Joystick(0);
 
// private final XboxController m_stick = new XboxController(0);

  @Override
  public void robotInit() { 
    CameraServer.getInstance().startAutomaticCapture();
  }
  @Override
  public void robotPeriodic() {

  }
  @Override
  public void autonomousInit() {

  }

  @Override
  public void autonomousPeriodic() { 

  }

  @Override
  public void teleopPeriodic() {
    // control of robot, output=input^3
    if(Math.abs(m_stick.getX()) >= 0.1 || Math.abs(m_stick.getY()) >= 0.1) {
      rightMotors(Math.pow(m_stick.getX() - m_stick.getY(), 3));
      leftMotors(Math.pow(m_stick.getX() + m_stick.getY(), 3));

     
    }
  }

  @Override
  public void testPeriodic() {
  }
  public void rightMotors(double x) {
    mRightMaster.set(ControlMode.PercentOutput, x);
    mRightSlave.set(ControlMode.PercentOutput,x);
  }
  public void leftMotors(double x){
    mLeftMaster.set(ControlMode.PercentOutput, x); 
    mLeftSlave.set(ControlMode.PercentOutput,x);
  }

}
