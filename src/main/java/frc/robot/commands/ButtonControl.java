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
        switch (button)
        {
            case "A":
            {
                val=XboxController.Button.kA.value;
            }
            case "B":
            {
                val=XboxController.Button.kB.value;
            }
            case "X":
            {
                val=XboxController.Button.kX.value;
            }
            case "Y":
            {
                val=XboxController.Button.kY.value;
            }
            case "Left_Bumper":
            {
                val=XboxController.Button.kLeftBumper.value;
            }
            case "Right_Bumper":
            {
                val=XboxController.Button.kRightBumper.value;
            }
            default:
            {
                val=XboxController.Button.kStart.value;
            }
        }      
      new JoystickButton(Constants.controller, val).whileHeld(this);
    }
}