package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants;

public class ButtonControl extends CommandBase
{
    private RobotCommand command;
    public String button;
    public ButtonControl(String b, RobotCommand com)
    {
        command=com;
        button=b;
        int val;
        System.out.println(b);
        switch (button)
        {
            case "A":
            {
                val=XboxController.Button.kA.value;
                break;
            }
            case "B":
            {
                val=XboxController.Button.kB.value;
                break;
            }
            case "X":
            {
                val=XboxController.Button.kX.value;
                break;
            }
            case "Y":
            {
                val=XboxController.Button.kY.value;
                break;
            }
            case "Left_Bumber":
            {
                val=XboxController.Button.kLeftBumper.value;
                break;
            }
            case "Right_Bumber":
            {
                val=XboxController.Button.kRightBumper.value;
                break;
            }
            default:
            {
                val=XboxController.Button.kStart.value;
                break;
            }
        }  
        System.out.println(val);    
        new JoystickButton(Constants.controller, val).whileHeld(this);
      
    }
    @Override
    public void initialize()
    {
        System.out.println("starting");
        command.start();
    }
    @Override 
    public void end(boolean interupted)
    {
        System.out.println("finishing"+button);
        command.finish();
    }
    @Override
    public void execute()
    {
        System.out.println(button+" is running");
    }
}