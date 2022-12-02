package frc.robot.gui;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

import frc.robot.gui.Commands.CommandSelector;
import frc.robot.gui.Commands.GUICommand;

public class ButtonInfo extends GUICommand{
    private String button;
    private JFrame frame;
    public ButtonInfo(String button,JFrame frame,RectComponent r)
    {
        super(r);
        this.button= button;
        this.frame=frame;
        CommandSelector slector= new CommandSelector(this,r);
        setNext(slector);
    }
    public void activate()
    {
        if(!button.equals("")&&button!=null)
            getNext().draw(frame, 0, 30);
    }
    public void deactivate()
    {
        getNext().clear(frame);
    }
    public String toString()
    {
        return button;
    }
    public String getSave()
    {
        return button+":"+getNext().getSave();
    }
    public boolean savable()
    {
        return getNext().savable();
    }
    public void redraw()
    {
        deactivate();
        activate();
    }
    @Override
    public String getName() {
        // unused
        return null;
    }
    @Override
    public int draw(JFrame f, int x, int y) {
        // unused
        return 0;
    }
    @Override
    public void clear(JFrame f) {
        // unused
    }
    @Override
    public void addListeners() {
        //unused
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
