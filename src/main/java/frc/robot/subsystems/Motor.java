package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
public class Motor extends SubsystemBase{
    private MotorController motor;
    public int ID;
    public String comType;
    public String escType;

    @Override
    public boolean equals(Object o) {
        // TODO Auto-generated method stub
        if(((Motor)o).ID==this.ID && ((Motor)o).comType.equals(comType))
        {
            return true;
        }
        return false;
    }
    public Motor(String escType,String com, int iD)
    {
        ID=iD;
        comType=com;
        this.escType=escType;
        //switch cases
        switch(comType)
        {
            case "PWM":
            {
                switch(escType)
                {
                    case "Spark Max":
                    {
                        motor=new PWMSparkMax(ID);
                    }
                }

            }
            case "CAN":
            {
                switch(escType)
                {
                    case "Spark Max":
                    {
                        motor=new CANSparkMax(ID,MotorType.kBrushless);
                    }
                }
            }

        }

    }
    public void stop() {
        motor.set(0);
    }
    public void start(int power)
    {
        motor.set(power/100.);
    }
}
