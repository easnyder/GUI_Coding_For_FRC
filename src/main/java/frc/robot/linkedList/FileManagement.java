package frc.robot.linkedList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JComboBox;

import frc.robot.commands.ButtonControl;
import frc.robot.gui.ButtonInfo;

public class FileManagement
{
  private static final String save =":null/A:RunMotor,CAN,Spark Max,13,50-null/B:IF,Contiunously,LimitSwitch,0-RunMotor,CAN,Spark Max,13,50-null-end-null/X:IF,Only on start,LimitSwitch,0-RunMotor,CAN,Spark Max,13,50-null-end-null/Y:RunMotor,CAN,Spark Max,13,50-null/Left_Bumber:null/Right_Bumber:null";
  private static Stack<Conditional> loops;
  public static Command toList(String in)
  {
   
    String[] list=in.split("-");

    Queue<String> coms=new ArrayDeque<String>();
    Command returner=null;
    for(String com:list)
    {
      coms.add(com);
    }
    loops = new Stack<Conditional>();
    Command last=null;
    while(!coms.isEmpty())
    {
      String next=coms.poll();
      
      if(next.equals("end"))
      {
        if(!coms.isEmpty())
        {
          if(!coms.peek().equals("end"))
          {
            next=coms.poll();
            Command nextcom= instatiate(next);
           
            loops.pop().setNext(nextcom);
            last=nextcom;         
          }
          else
          {
            loops.pop();
          }
        }
      }
      else
      {
        Command nextcom=instatiate(next);
        if(returner==null)
          returner=nextcom;
        else 
          if(last instanceof Conditional)
          {
            ((Conditional)last).setInside(nextcom);
          }
          else 
          {
            last.setNext(nextcom);
          }
        last=nextcom;
      }
    }
    return returner;
  }
  public static Command instatiate(String com)
  {
    Command newCom=null;
    String[] comDat= com.split(",");
    switch(comDat[0])
    {
      case "IF":
      {
        newCom= new If();
        ((If)newCom).setTiming(comDat[1]);
        Check c=null;
        switch(comDat[2])
        {
          case "LimitSwitch":
          {
            c=new LimitSwitch(Integer.parseInt(comDat[3]));
            ((If)newCom).setPara(c);
          }
          default:{}
        }
        loops.push((Conditional)newCom);
        return newCom;
      }
      case "RunMotor":
      {
        newCom= new RunMotor();
        ((RunMotor)newCom).setComType(comDat[1]);
        ((RunMotor)newCom).setESC(comDat[2]);
        ((RunMotor)newCom).setID(Integer.parseInt(comDat[3]));
        ((RunMotor)newCom).setPower(Integer.parseInt(comDat[4]));
        return newCom;
      }
      default:{}
    }
    return null;
  }
    public static void save(String text,ButtonInfo[] data) {
    
      try {
        PrintWriter file = new PrintWriter(new FileWriter(text+".txt"));
        PrintWriter robot = new PrintWriter(new FileWriter("save.txt"));
        for(ButtonInfo i:data)
        {
          file.println(i.getSave()); 
          robot.println(i.getSave()); 
         
        }
        file.close();
        robot.close();
      } catch (IOException e) {
      }
    }
    public static JComboBox<ButtonInfo> fromImport(String filename)
    {
      try {
        Scanner reader = new Scanner(new File(filename+".txt"));
        String file= "";
        while(reader.hasNext())
        {
          file+=reader.nextLine()+"/";
        }
      
        String[] set = file.split("/");
        ButtonLink[] buttons= new ButtonLink[set.length];
        for(int i =0; i<set.length;i++)
        {
          String[] button = set[i].split(":");
          buttons[i]= new ButtonLink(button[0],toList(button[1])); 
          
        }
        ButtonInfo[] info= new ButtonInfo[set.length];
        for(int i= 0; i<set.length;i++)
        {
          info[i]=(ButtonInfo)buttons[i].GUIType();
          
        }
        return new JComboBox<ButtonInfo>(info);
      } catch (FileNotFoundException e) {
        e.printStackTrace();
        return null;
      }

    }
    public static void getRobotCode()
    {
      /*PrintWriter waldo;
      try {
        waldo = new PrintWriter(new FileWriter("waldo.txt"));
        waldo.println("here");
        waldo.close();
      } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
      System.out.println(System.getProperty("user.dir"));
      System.out.println(new File("C:\\Users\\BearBots Inc\\Documents\\GUI_Coding_For_FRC-main\\src\\main\\java\\frc\\robot\\save.txtsave.txt").getAbsolutePath());*/
    //  try {
        Scanner reader = new Scanner(save);
        String file= "";
        while(reader.hasNext())
        {
          file+=reader.nextLine()+"/";
        }
        System.out.println(file);
        String[] set = file.split("/");
        ButtonLink[] buttons= new ButtonLink[set.length];
        for(int i =0; i<set.length;i++)
        {
          String[] button = set[i].split(":");
          buttons[i]= new ButtonLink(button[0],toList(button[1])); 
        }
        ButtonControl[] info= new ButtonControl[set.length];
        for(int i= 0; i<set.length;i++)
        {
          info[i]=(ButtonControl)buttons[i].RobotType();
        }
      //} catch (FileNotFoundException e) {     
     //   e.printStackTrace();
     // }
    }
}