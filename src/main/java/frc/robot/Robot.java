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

  

  //private final VictorSPX mUpMaster = new VictorSPX(4);
  //private final VictorSPX mUpSlave = new VictorSPX(5);

 private final Joystick m_stick = new Joystick(0);
 
// private final XboxController m_stick = new XboxController(0);

  @Override
  public void robotInit() { 
    CameraServer.getInstance().startAutomaticCapture();
  }
  @Override
  public void robotPeriodic() {}
  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() { }

  @Override
  public void teleopPeriodic() {
    if(Math.abs(m_stick.getX()) >= 0.1 || Math.abs(m_stick.getY()) >= 0.1) {
      RightMotors(Math.pow(m_stick.getX() - m_stick.getY(), 3));
      LeftMotors(Math.pow(m_stick.getX() + m_stick.getY(), 3));

      /*if(m_stick.getX() > 0 || m_stick.getY() > 0) {
        RightMotors(Math.exp(m_stick.getX() + m_stick.getY()));
        LeftMotors(Math.exp(m_stick.getX() + m_stick.getY()));

      else if(m_stick.getX() < 0 || m_stick.getY() < 0) {
        RightMotors(Math.exp(m_stick.getX() + m_stick.getY()));
        LeftMotors(Math.exp(m_stick.getX() + m_stick.getY())); 

      }*/
    }
  }

  @Override
  public void testPeriodic() {
  }
  public void RightMotors(double x) {

    mRightMaster.set(ControlMode.PercentOutput, x);
    mRightSlave.set(ControlMode.PercentOutput,x);
  }
  public void LeftMotors(double x){
    mLeftMaster.set(ControlMode.PercentOutput, x); 
    mLeftSlave.set(ControlMode.PercentOutput,x);
  }

}
