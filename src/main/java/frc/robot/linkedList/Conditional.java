package frc.robot.linkedList;
public abstract class Conditional extends Command
{
    private Command inside;
    protected Check para;
    public Conditional(Command inside, Command outside)
    {
        super(outside);
        this.inside=inside;        
    }
    public Conditional() {
    }
    public Command getInside(){return inside;}
    public void setInside(Command outside){inside=outside;}
    public Check getPara(){return para;}
    public void setPara(Check para){this.para=para;}
    //methods needed in robot
    public String toString()
    {
        String returner =getName();
        if(inside!=null)
            returner+="-"+inside.toString();
        returner+="-end";
        if(getNext()!=null)
            returner +="-"+getNext().toString();
        return returner;
    }
    //methos needed in GUI
}