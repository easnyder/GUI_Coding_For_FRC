package frc.robot.gui;

import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
// content pane doesn't like graphics
public class RectComponent extends JComponent{
    private ArrayList<RectDat> rectangles= new ArrayList<RectDat>();
    private ArrayList<Boolean> usage = new ArrayList<Boolean>();
    public void paintComponent(Graphics g)
    {
        //System.out.println(rectangles.size());
        super.paintComponent(g);
        for(int i=0; i<rectangles.size();i++)
        {
          //  System.out.println("|");
            if(usage.get(i))
            {
                RectDat dat= rectangles.get(i);
                g.setColor(dat.c);
                g.fillRect(dat.x, dat.y, dat.w, dat.h);
                //System.out.println(dat.x+" "+dat.y+"h:"+dat.h+dat.w);
            }
        }
    }
    public int addValues(int x,int y,int w,int h, Color c,boolean used)
    {
       rectangles.add(new RectDat(x, y, w, h, c));
       usage.add(used);
       return rectangles.size()-1;
    }
    public void setValues(int x,int y,int w,int h, Color c, int index, boolean used)
    {
       // System.out.println(used+""+index);
        rectangles.set(index, new RectDat(x, y, w, h, c));
       // System.out.println(h);
        usage.set(index,used);
    }
    public RectComponent()
    {
        super();
        this.setBounds(0, 0, 1000, 800);
    }
    public String toString()
    {
        return rectangles.toString();
    }
}
