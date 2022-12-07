package frc.robot.gui.Commands;
import javax.swing.*;

import frc.robot.gui.GuiMain;
import frc.robot.gui.RectComponent;

import java.awt.event.*;
//the overatching abstract class around which the file system is built.
//reates a linked list of its subclasses that it provides the stukture for.
// has get and set methods for the next item, a method to add an onbject to the end, and the toString.
public abstract class GUICommand implements ActionListener
{
    private GUICommand next;
    protected int index;
    protected RectComponent rect;
    public abstract String getName();
    // get method for the next item in the list
    public GUICommand(RectComponent r)
    {
        rect=r;
        index=rect.addValues(0, 0, 0, 0, null, false);

    }
    public GUICommand getNext()
    {
        return next;
    }
    public void setNext(GUICommand com)
    {
        if(com!=null)
        {
            if(com.getNext()==null)
            {
                com.setNext(new CommandSelector(com, rect));
            }  
            next=com;   
        }
        else{
            next=new CommandSelector(this,rect);
        }
        
    }
    // toString is set up to return the string for the save file.
    public String toString()
    {
        if(next!=null)
            return getName()+"|"+next.toString();
        else
            return getName();
    }
    // Constructer, you know em you love em.
    public GUICommand(GUICommand n)
    {
        next=n;
    }
    public GUICommand() {
        rect=GuiMain.main.rectangles;
        index=rect.addValues(0, 0, 0, 0, null, false);
    }
    public int getCount()
    {
        if(next!=null)
            return next.getCount()+1;
        return 1;
    }

    //methods needed in robot
   
   

    //methos needed in GUI
    public abstract int draw(JFrame f, int x, int y);
    public abstract void clear(JFrame f);
    public abstract String getSave();
    public abstract boolean savable();
    public abstract void addListeners();

}