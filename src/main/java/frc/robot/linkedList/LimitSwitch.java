package frc.robot.linkedList;

import frc.robot.gui.Checks.GUICheck;
import frc.robot.gui.Checks.GUILimitSwitch;
import frc.robot.robotChecks.RobotCheck;
import frc.robot.robotChecks.RobotLimitSwitch;

public class LimitSwitch extends Check{
    private int port;
    public LimitSwitch() {
        super();
        //TODO Auto-generated constructor stub
    }

    public LimitSwitch(int port2) {
        port=port2;
    }

    @Override
    public GUICheck getGUIType() {
        // TODO Auto-generated method stub
        GUILimitSwitch gui = new GUILimitSwitch();
        gui.setPort(port);
        return gui;
    }
    @Override
    public RobotCheck getRobotType() {
        // TODO Auto-generated method stub
        RobotLimitSwitch robot = new RobotLimitSwitch();
        robot.setPort(port);
        return robot;
    }
}