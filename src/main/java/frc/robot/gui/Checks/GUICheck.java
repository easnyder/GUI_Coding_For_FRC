package frc.robot.gui.Checks;

import javax.swing.JFrame;

import frc.robot.gui.GuiMain;
import frc.robot.gui.RectComponent;

public abstract class GUICheck {
    protected RectComponent rect;
    protected int index;
    public GUICheck(RectComponent r)
    {
        rect=r;
        index=rect.addValues(0, 0, 0, 0, null, false);
    }
    public GUICheck() {
        rect=GuiMain.main.rectangles;
        index=rect.addValues(0, 0, 0, 0, null, false);
    }
    public abstract int size();
    public abstract void draw(JFrame f, int x, int y);
    public abstract void clear(JFrame f);
    public abstract String getSave();
    
}
