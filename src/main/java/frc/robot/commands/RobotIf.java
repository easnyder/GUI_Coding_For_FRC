package frc.robot.commands;

import frc.robot.Robot;

public class RobotIf extends RobotConditional{
    boolean intial=false;
    boolean continunous = false;

    public void setTiming(String timing) {
        switch(timing)
        {
            case "Only on start":
            {
                continunous= false;
                intial= true;
            }
            case "Contiunously":
            {
                continunous=true;
                intial=false;
            }

        }
    }
    @Override
    public void start()
    {
        if(finished)
            {
            this.schedule();
            finished=false;
            if(getCheck().getData())
            {
                getInside().start();
            }
            getNext().start();
        }
    }
    @Override
    public void execute()
    {
        if(continunous)
        {
            if(getCheck().getData())
            {
                getInside().start();
            }
            else{
                getInside().finish();
            }
        }
    }
}
