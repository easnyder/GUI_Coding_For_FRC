package frc.robot.gui;
import java.awt.Color;
public class RectDat
{
    public int x,y,w,h;
    public Color c;
    public RectDat(int x, int y, int w, int h, Color c)
    {
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
        this.c=c;
    }
    public String toString()
    {
        return x+" "+y+" "+w+" "+h+" "+c;
    }
}