package frc.robot.gui.Commands;
import java.awt.event.*;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import frc.robot.gui.GuiMain;
import frc.robot.gui.RectComponent;

public class CommandSelector extends GUICommand{
    private JComboBox<String> selector = new JComboBox<String>();
    private GUICommand previous;
    public CommandSelector(GUICommand previous,RectComponent r)
    {
        super(r);
        this.previous=previous;
        GuiMain.commandSelectSetUp(selector);
        addListeners();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(selector.getSelectedIndex()!=0)
       {
        GUICommand newCom= GuiMain.createNewCommand((String)selector.getSelectedItem());
        newCom.setNext(this);
        previous.setNext(newCom);
        previous=newCom;
        selector.setSelectedIndex(0);
        System.out.println("command selector fired");
        GuiMain.main.reDraw();
        //System.out.println();
       }
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int draw(JFrame f, int x, int y) {
        // TODO Auto-generated method stub
       // System.out.println("drawing");
        selector.setBounds(x,y,1000,30);
        f.add(selector);
       // System.out.println(""+x+y);
        return 0;
    }

    @Override
    public void clear(JFrame f) {
        // TODO Auto-generated method stub
        f.remove(selector);
        
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
        selector.addActionListener(this);
    }
    @Override
    public void setNext(GUICommand com){}
    
}
