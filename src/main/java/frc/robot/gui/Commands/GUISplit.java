package frc.robot.gui.Commands;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;

import frc.robot.gui.RectComponent;
//done
public class GUISplit extends GUICommand{
    //gets dropdown command selector to work
    public GUISplit(RectComponent r)
    {
        super(r);
        CommandSelector select= new CommandSelector(this,r);
        setNext(select);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "";
    }

    @Override
    public int draw(JFrame f, int x, int y) {
        // TODO Auto-generated method stub
        getNext().draw(f,x,y);
        return 0;
    }

    @Override
    public void clear(JFrame f) {
        // TODO Auto-generated method stub
        getNext().clear(f);
        
    }

    @Override
    public String getSave() {
        // TODO Auto-generated method stub
        return getNext().getSave();
    }

    @Override
    public boolean savable() {
        // TODO Auto-generated method stub
        return getNext().savable();
    }

    @Override
    public void addListeners() {
        // TODO Auto-generated method stub
        
    }
    
}
