package frc.robot.linkedList;

import frc.robot.commands.ButtonControl;
import frc.robot.commands.RobotCommand;
import frc.robot.gui.ButtonInfo;
import frc.robot.gui.GuiMain;
import frc.robot.gui.Commands.GUICommand;

public class ButtonLink {
    private String button;
    private Command  command;
    public ButtonLink(String b,Command com)
    {
        button=b;
        command=com;
    }
    
    public GUICommand GUIType() {
        // TODO Auto-generated method stub
        ButtonInfo button = new ButtonInfo(this.button, GuiMain.main.frame, GuiMain.main.rectangles);
        if(command!=null)
            button.setNext(command.GUIType());
        return button;
    }

    public ButtonControl RobotType() {
        // TODO Auto-generated method stub
        return new ButtonControl(button,command.RobotType());
    }

    public String getButton() {
        return button;
    }
    public String toString()
    {
        String out =button;
        if(command!=null)
        {
            button+=command.toString();
        }
        else{
            button+=null;
        }
        return out;
    }  
}
