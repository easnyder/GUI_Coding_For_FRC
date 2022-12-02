package frc.robot.linkedList;

import frc.robot.commands.RobotCommand;
import frc.robot.commands.RobotIf;
import frc.robot.gui.Commands.GUICommand;
import frc.robot.gui.Commands.GUIIf;

public class If extends Conditional
{
    private String timing;
    public If()
    {
        super();
    }
    public void setTiming(String time)
    {
        timing=time;
    }
    public If(Command inside, Command outside,String timing) {
        super(inside, outside);
        this.timing=timing;
    }
    @Override
    public String getName() {
        return "If";
    }
    @Override
    public GUICommand GUIType() {
        
        GUIIf gui = new GUIIf();
        gui.setCondition(para.getGUIType());
        if(getNext()!=null)
            gui.setNext(getNext().GUIType());
        gui.getSplit().setNext(getInside().GUIType());
        gui.setTiming(timing);
        return gui;
    }
    @Override
    public RobotCommand RobotType() {
       
        RobotIf robot = new RobotIf();
        robot.setCheck(para.getRobotType());
        robot.setNext(getNext().RobotType());
        robot.setInside(getInside().RobotType());
        robot.setTiming(timing);
        return robot;
    }
    
}