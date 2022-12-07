package frc.robot.gui.Checks;
import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import frc.robot.gui.RectComponent;
//not used
public class GUIEncoderVelocityCheck extends GUICheck{
    public JTextField port = new JTextField("port/ID");
    public JComboBox<String> inequality= new JComboBox<String>();
    private JLabel name= new JLabel("Encoder Velocity");
    public GUIEncoderVelocityCheck(RectComponent r)
    {
        super(r);
        inequality.addItem("Less Than");
        inequality.addItem("Greater Than");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 220;
    }

    @Override
    public void draw(JFrame f, int x, int y) {
        name.setBounds(x,y,100,20);
        inequality.setBounds(x+100,y,100,20);
        port.setBounds(x+200,y,20,20);
        rect.setValues(x, y, 220, 30, Color.white, index, true);
        f.add(name);
        f.add(inequality);
        f.add(port);
    }
    @Override
    public void clear(JFrame f) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getSave() {
        // TODO Auto-generated method stub
        return "VelocityCheck,"+inequality.getSelectedItem()+","+port.getText();
    }  
}