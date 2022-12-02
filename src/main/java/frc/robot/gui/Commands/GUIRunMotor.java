package frc.robot.gui.Commands;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import frc.robot.gui.GuiMain;
import frc.robot.gui.RectComponent;

import java.awt.Color;
import java.awt.event.ActionEvent;

public class GUIRunMotor extends GUICommand
{
    private JComboBox<String> comType =new JComboBox<String>();
    private JComboBox<String> escType= new JComboBox<String>();
    private JComboBox<String> velpow= new JComboBox<String>();
    private JLabel control= new JLabel("Select control type");
    private JTextField ID = new JTextField("Enter ID");
    private JTextField power = new JTextField("Enter power");
    private JLabel port = new JLabel("port:");
    private JLabel name = new JLabel("RunMotor");
    public GUIRunMotor(RectComponent r)
    {
        super(r);
        comType.addItem("Select communication method");
        comType.addItem("PWM");
        comType.addItem("CAN");
        comType.setSelectedIndex(0);
        escType.addItem("Select ESC type");
        escType.addItem("Spark Max");
        //many more to add
        escType.setSelectedIndex(0);
        velpow.addItem("Velocity");
        velpow.addItem("Power");
        velpow.setSelectedIndex(0);
        addListeners();
    }
    public GUIRunMotor() {
        super();
        comType.addItem("Select communication method");
        comType.addItem("PWM");
        comType.addItem("CAN");
        comType.setSelectedIndex(0);
        escType.addItem("Select ESC type");
        escType.addItem("Spark Max");
        //many more to add
        escType.setSelectedIndex(0);
        velpow.addItem("Velocity");
        velpow.addItem("Power");
        velpow.setSelectedIndex(0);
        addListeners();
    }
    //@me id/port switch
    public void addListeners()
    {
        comType.addActionListener(this);
        velpow.addActionListener(this);
    }
    @Override
    public String getName() {
        return "RunMotor";
    }
    @Override
    public int draw(JFrame f, int x, int y) {  
        //System.out.println("run draw");
        name.setBounds(x, y, 90, 20);
        comType.setBounds(x+100, y, 90, 20);
        escType.setBounds(x+200, y, 90, 20);
        control.setBounds(x+300, y, 90, 20);
        velpow.setBounds(x+400, y, 90, 20);
        port.setBounds(x+500, y, 90, 20);
        power.setBounds(x+700,y,90,20);
        ID.setBounds(x+600, y, 90, 20);
        rect.setValues(x,y,800,30,Color.blue,index, true);
        f.add(name);
        f.add(comType);
        f.add(escType);
        f.add(control);
        f.add(velpow);
        f.add(port);
        f.add(ID);
        f.add(power); 
        if(getNext()!=null)
            getNext().draw(f, x, y+31);
        else
        {
            return x+700;
        }
        return -1;
    }
    @Override
    public void clear(JFrame f) {
        // TODO Auto-generated method stub
        f.remove(comType);
        f.remove(escType);
        f.remove(control);
        f.remove(velpow);
        f.remove(ID);
        f.remove(port);
        f.remove(name);
        f.remove(power);
        rect.setValues(0, 0, 0, 0, null, index, false);
        getNext().clear(f);
    }
    @Override
    public String getSave() {
        // TODO Auto-generated method stub
        String returner=getName()+","+comType.getSelectedItem()+","+escType.getSelectedItem()+","+ID.getText()+","+power.getText();
        if(getNext()!=null)
        {
            returner+="-"+getNext().getSave();
        }
        return returner;
    }
    @Override
    public boolean savable() {
        // TODO Auto-generated method stub
        return !(comType.getSelectedIndex()==0||escType.getSelectedIndex()==0||port.getText().isEmpty()||badChars())&&getNext().savable();
    }
    private boolean badChars() {
        String IDinfo =ID.getText();
        if(IDinfo.length()==0)
        {
            return true;
        }
        for(int i=0;i<IDinfo.length();i++)
        {
            if(!(IDinfo.charAt(i)<59&&IDinfo.charAt(i)>47))
            {
                return true;
            }
        }
        String powInfo = power.getText();
        if(powInfo.length()==0)
        {
            return true;
        }
        for(int i = 0; i<powInfo.length();i++)
        {
            if(!(IDinfo.charAt(i)<59&&IDinfo.charAt(i)>47))
            {
                return true;
            }
        }
        return false;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==comType)
        {
            if(comType.getSelectedIndex()==0)
            {
                ID.setText("Enter Port");
            }
            else
            {
                ID.setText("Enter ID");
            }
        }
        if(e.getSource()==velpow)
        {
            if(velpow.getSelectedIndex()==0)
            {
                power.setText("Enter Velocity");
            }
            else
            {
                power.setText("Enter Power");
            }
        }
        GuiMain.main.reDraw();
        
    }
    public void setComType(String comType2) {
        comType.setSelectedItem(comType2);
    }
    public void setPower(int power2) {
        power.setText(""+power2);
    }
    public void setID(int iD2) {
        ID.setText(""+iD2);
    }
    public void setESC(String eSC) {
        escType.setSelectedItem(eSC);
    }
}