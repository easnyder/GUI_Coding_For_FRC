package frc.robot.robotChecks;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.linkedList.LimitSwitch;

public class RobotLimitSwitch extends RobotCheck {
    private int port;
    private DigitalInput limit;

    public void setPort(int p) {
        port=p;
        limit=new DigitalInput(port);
    }

    @Override
    public boolean getData() {
        // TODO Auto-generated method stub
        return limit.get();
    }

}
