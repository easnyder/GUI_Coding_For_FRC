package frc.robot.linkedList;

import frc.robot.commands.RobotCommand;
import frc.robot.gui.Commands.GUICommand;

//the overatching abstract class around which the file system is built.
//reates a linked list of its subclasses that it provides the stukture for.
// has get and set methods for the next item, a method to add an onbject to the end, and the toString.
public abstract class Command
{
    private Command next;
    public abstract String getName();
    // get method for the next item in the list
    public Command()
    {

    }
    public Command getNext()
    {
        return next;
    }
    public void setNext(Command c)
    {
        next=c;
    }
    public String toString()
    {
        if(next!=null)
            return getName()+"-"+next.toString();
        else
            return getName();
    }
    // Constructer, you know em you love em.
    public Command(Command n)
    {
        next=n;
    }

    //methods needed in robot
    public abstract GUICommand GUIType(); 
    public abstract RobotCommand RobotType();
   
   

    //methos needed in GUI
}