package frc.robot.robotChecks;

public class RobotEncoderVelocityCheck extends RobotCheck{
    private boolean greater;
    private int port; 
    public void setInequality(String s)
    {
        switch(s)
        {
            case "<":
            {
                greater=false;
            }
            case ">":
            {
                greater=true;
            }
        }
    }
    private void setPort(int p)
    {
        port=p;


    }

    @Override
    public boolean getData() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
