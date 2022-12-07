package frc.robot.gui.Commands;

import javax.swing.JComboBox;

import frc.robot.gui.GuiMain;
import frc.robot.gui.RectComponent;
import frc.robot.gui.Checks.GUICheck;

public abstract class GUIConditional extends GUICommand{
    protected GUICheck condition;
    protected GUICommand inside;
    private JComboBox<String> checkSelector= new JComboBox<String>();
    public GUIConditional(RectComponent r)
    {
        super(r);
        inside=new GUISplit(r);
    }
    public GUIConditional()
    {
        super();
        inside=new GUISplit(GuiMain.main.rectangles);
    }
    public void setCondition(GUICheck c)
    {
        condition=c;
    }
    public GUICheck getCondition()
    {
        return condition;
    }  
    public int getCount()
    {
        return getNext().getCount()+inside.getCount();
    } 
    public GUICommand getSplit()
    {
        return inside;
    } 
}
