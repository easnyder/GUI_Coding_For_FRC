package frc.robot.gui.Commands;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.concurrent.locks.Condition;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import frc.robot.gui.GuiMain;
import frc.robot.gui.RectComponent;
import frc.robot.gui.Checks.GUIEncoderVelocityCheck;
import frc.robot.gui.Checks.GUILimitSwitch;


public class GUIIf extends GUIConditional{
    JComboBox<String> check = new JComboBox<String>();
    JComboBox<String> timing = new JComboBox<String>();
    JLabel name = new JLabel("If");

    public GUIIf(RectComponent rect)
    {
        super(rect);
        timing.addItem("Select timing");
        timing.addItem("Only on start");
        timing.addItem("Contiunously");
        check.addItem("select condition");
        check.addItem("Limit Switch");
        //check.addItem("Encoder Velocity");
        addListeners();
    }
    public GUIIf()
    {
        super();
        timing.addItem("Select timing");
        timing.addItem("Only on start");
        timing.addItem("Contiunously");
        check.addItem("select condition");
        check.addItem("Limit Switch");
        //check.addItem("Encoder Velocity");
        addListeners();
        System.out.println(rect);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("GUIIf fired");
        if(e.getSource()==check)
        {
            
            if(check.getSelectedIndex()!=0)
            {
                switch((String)check.getSelectedItem())
                {
                    case "Limit Switch":
                    {
                        condition=new GUILimitSwitch(rect);
                        break;
                    }
                  /*   case "Encoder Velocity":
                    {
                        condition = new GUIEncoderVelocityCheck(rect);
                        break;
                    }*/
                    default:
                    {
                        System.out.println("if condition case mathing is wrong");
                        break;
                    }
                }
                GuiMain.main.reDraw();
            }
        }  
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int draw(JFrame f, int x, int y) {
        // TODO Auto-generated method stub
        if(condition==null)
        {
            check.setBounds(x+20,y,100,20);
            f.add(check);
            timing.setBounds(x+45,y,100,20);
            rect.setValues(x,y,230,30,new Color(0,0,200),index,true);
        }
        else{
            condition.draw(f,x+20,y);
            timing.setBounds(x+condition.size()+45,y,100,20);
            rect.setValues(x,y,condition.size()+130,30,new Color(50,50,255),index,true);
        }
        name.setBounds(x,y,20,20);
        f.add(name);
        f.add(timing);
        if(getNext()!=null)
        {
            getNext().draw(f,x,y+31*inside.getCount());
        }
        inside.draw(f,x+30,y+30);
        return 0;
    }

    @Override  //written
    public void clear(JFrame f) {
        if(getNext()!=null)
        {
            getNext().clear(f);
        }
        if(condition!=null)
        {
            condition.clear(f);
        }
        f.remove(name);
        f.remove(check);
        f.remove(timing); 
        rect.setValues(0,0,0,0,null,index,false);
        inside.clear(f); 
    }

    @Override
    public String getSave() {
        // TODO Auto-generated method stub
        String returner = "IF,"+timing.getSelectedItem()+","+getCondition().getSave()+"-"+getSplit().getSave()+"-end";
        if(getNext()!=null)
        {
            returner+="-"+getNext().getSave();
        }
        return returner;
    }

    @Override
    public boolean savable() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void addListeners() {
        check.addActionListener(this);
        
        
    }
    public void setTiming(String timing2) {
        timing.setSelectedItem(timing2);
    }
    
}
