package frc.robot.linkedList;

import frc.robot.gui.Checks.GUICheck;
import frc.robot.robotChecks.RobotCheck;

// Abstract class for objects sevivings as the boolean operators in IF anf loop statments. 
public abstract class Check
{

    public Check()
    {
    }
    public abstract GUICheck getGUIType();
    public abstract RobotCheck getRobotType();
    //methods needed in robot
    //public abstract boolean getCheck();
   

    //methos needed in GUI
    
   
}