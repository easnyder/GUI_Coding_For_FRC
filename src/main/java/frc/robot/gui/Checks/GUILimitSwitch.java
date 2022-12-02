package frc.robot.gui.Checks;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import frc.robot.gui.RectComponent;

public class GUILimitSwitch extends GUICheck {
    public GUILimitSwitch(RectComponent r) {
        super(r);
        //TODO Auto-generated constructor stub
    }
    public GUILimitSwitch() {
        super();
    }
    private JLabel label = new JLabel("LimitSwitch Port:");
    private JTextField port = new JTextField();
    @Override
    public int size() {
        
        return 200;
    }
    @Override
    public void draw(JFrame f, int x, int y) {
        label.setBounds(x, y+2, 100, 20);
        port.setBounds(x+100, y+2, 50, 30);
        f.add(label);
        f.add(port);
        rect.setValues(x, y+2, 200, 25, Color.white, index, true);
    }
    @Override
    public void clear(JFrame f) {
        System.out.println("LimitSwitchClearing");
        f.remove(label);
        f.remove(port);
    }
    public void setPort(int port2) {
        port.setText(""+port2);
    }
    @Override
    public String getSave() {
        // TODO Auto-genera"ted method stub
        return "LimitSwitch,"+port.getText();
    }

}
