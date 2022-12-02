package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public abstract class RobotCommand extends CommandBase {
    private RobotCommand next;
    protected boolean finished = false;
    @Override
    public boolean isFinished()
    {
        return finished;
    }
    public void finish()
    {
        finished=true;
        next.finish();
    }
    public void start()
    {
        if(finished)
        {
            this.schedule();
            finished=false;
            next.start();
        }   
    }
    public RobotCommand getNext()
    {
        return next;
    }
    public void setNext(RobotCommand com)
    {
        next=com;
    }
}