package frc.robot.linkedList;

import frc.robot.commands.RobotCommand;
import frc.robot.commands.RobotRunMotor;
import frc.robot.gui.Commands.GUICommand;
import frc.robot.gui.Commands.GUIRunMotor;

public class RunMotor extends Command
{
    private String comType;
    private int power;
    private int ID;
    private String ESC;
    public void setComType(String com)
    {
        comType=com;
       
    }
    public void setPower(int pow)
    {
        power=pow;
    }
    public void setID(int id)
    {
        ID=id;
    }
    public void setESC(String esc)
    {
        ESC=esc;
    }
    @Override
    public String getName() {
        return "RunMotor";
    }
    @Override
    public GUICommand GUIType() {
        // TODO Auto-generated method stub
        GUIRunMotor gui = new GUIRunMotor();
        if(getNext()!=null)
            gui.setNext(getNext().GUIType());
        gui.setPower(power);
        gui.setComType(comType);
        gui.setID(ID);
        gui.setESC(ESC);
        return gui;
    }

    @Override
    public RobotCommand RobotType() {
        // TODO Auto-generated method stub
        RobotRunMotor robot = new RobotRunMotor();
        if(getNext()!=null)
           robot.setNext(getNext().RobotType());
        robot.setPower(power);
        robot.setComType(comType);
        robot.setID(ID);
        robot.setESC(ESC);
        robot.setUp();
        return robot;
    }
}