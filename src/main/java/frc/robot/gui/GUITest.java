package frc.robot.gui;
import javax.swing.*;

import frc.robot.gui.Commands.GUICommand;

import java.awt.*;
import java.awt.event.ActionEvent;

public class GUITest extends GUICommand{
    private JTextField input;


    public GUITest(RectComponent rect)
    {
        super(rect);
        input = new JTextField();
    }

    public String getName() {
        // TODO Auto-generated method stub
        return "test";
    }


    public int draw(JFrame f,int x, int y) {
        if(getNext()!=null)
        getNext().draw(f,x,y+31);
        rect.setValues(x, y, 60, 30,Color.blue, index, true);
        input.setBounds(x, y+10, 50, 20); 
        f.add(input);
        f.add(rect);
        return -1;
     
        
       // System.out.println(getNext());
    }

    @Override
    public void clear(JFrame f) {
        f.remove(input);
        rect.setValues(0, 0, 0, 0, Color.blue, index, false);
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getSave() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean savable() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void addListeners() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

    
}
