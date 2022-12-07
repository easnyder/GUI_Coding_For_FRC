package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public abstract class RobotCommand extends CommandBase {
    private RobotCommand next;
    public boolean finished = true;
    @Override
    public boolean isFinished()
    {
        System.out.println(finished);
        return finished;

    }
    public void finish()
    {
        finished=true;
        if(next!=null)
            next.finish();
        System.out.println("finished");
    }
    public void start()
    {
        if(finished)
        {
            System.out.println("/t/t/t/t runmotor scedualing");
            this.schedule();
            finished=false;
            if(next!=null)
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