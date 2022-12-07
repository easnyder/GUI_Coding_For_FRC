package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Motor;

public class RobotRunMotor extends RobotCommand{
    private int power;
    private int ID;
    private String ESC;
    private String comType;
    private Motor motor;

    public void setPower(int power) {
        this.power=power;
    }

    public void setComType(String comType) {
        this.comType=comType;
    }

    public void setID(int id) {
        this.ID=id;
    }

    public void setESC(String esc) {
        this.ESC=esc;
    }

    public void setUp() {
        motor=RobotContainer.getMotor(ESC,comType,ID);

    }
    @Override
    public void initialize()
    {
        motor.start(power);
    }
    public void end(boolean interrupted)
    {
        System.out.println("RunMotorFinishing");
        motor.stop();
    }
    public void execute()
    {
        System.out.println("RunMotor is Running"+ID);
    }

}
