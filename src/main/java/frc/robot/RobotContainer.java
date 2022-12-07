// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.linkedList.FileManagement;
import frc.robot.robotChecks.RobotLimitSwitch;
import frc.robot.subsystems.Motor;


public class RobotContainer {
  private static ArrayList<Motor> motors= new ArrayList<Motor>();
  private static ArrayList<RobotLimitSwitch> Switchs= new ArrayList<RobotLimitSwitch>();
  private static ArrayList<Integer> switchIds= new ArrayList<Integer>(); 
  // The robot's subsystems and commands are defined here...

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    FileManagement.getRobotCode();
  }

  
  private void configureButtonBindings() {}


public static Motor getMotor( String esc, String comType,int ID) {
  //Motor motor= new Motor(esc,comType,ID);
  for(int i=0; i<motors.size();i++)
  {
    if(motors.get(i).exists(esc,comType,ID))
    {
      return motors.get(i);
    }
  } 
  Motor motor= new Motor(esc,comType,ID);
  motors.add(motor);
  return motor;
}

public static RobotLimitSwitch getLimitSwitch(int ID) {
  //Motor motor= new Motor(esc,comType,ID);
  if(switchIds.indexOf(ID)>-1)
  {
    return Switchs.get(switchIds.indexOf(ID));
  }
  RobotLimitSwitch newSwitch= new RobotLimitSwitch();
  newSwitch.setPort(ID);
  Switchs.add(newSwitch);
  switchIds.add(ID);
  return newSwitch;
}
}
