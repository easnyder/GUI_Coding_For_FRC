package frc.robot.commands;

import frc.robot.robotChecks.RobotCheck;

public abstract class RobotConditional extends RobotCommand{
    private RobotCommand inside;
    private RobotCheck check;
    public RobotCommand getInside()
    {
        return inside;
    }
    public void setInside(RobotCommand in)
    {
        inside=in;
    }
    public RobotCheck getCheck()
    {
        return check;
    }
    public void setCheck(RobotCheck c)
    {
        check=c;
    }
    @Override
    public void finish()
    {
        finished=true;
        inside.finish();
        getNext().finish();
    }
}
