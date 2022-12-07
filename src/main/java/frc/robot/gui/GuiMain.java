package frc.robot.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import frc.robot.gui.Commands.GUICommand;
import frc.robot.gui.Commands.GUIIf;
import frc.robot.gui.Commands.GUIRunMotor;
import frc.robot.linkedList.FileManagement;

public class GuiMain implements ActionListener{
    public JFrame frame = new JFrame();
    private JFrame fileFrame = new JFrame();
    private JTextField fileName = new JTextField();
    private JButton saveInput = new JButton();
    private JButton importer = new JButton("import from file");
    public static RectComponent rectangles = new RectComponent();
    private JComboBox<ButtonInfo> buttonSelect;
    private JButton save = new JButton("save to file");
    private ButtonInfo last;
    public static GuiMain main;
    private ButtonInfo[] info= new ButtonInfo[7];
    private boolean importing=false;
    public void componentsSetUp()
    {

    }
    public void frameSetUp()
    {
        frame.setSize(1300, 775);
        frame.setLayout(null);
        frame.add(GuiMain.rectangles);
        buttonSelect.setBounds(0,0,1000,20);
        save.setBounds(0,700,1000,50);
        importer.setBounds(0,650,1000,50);
        saveInput.setText("Save to File");
        frame.add(save);
        frame.add(buttonSelect);
        frame.add(importer);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(255,255,255));
        frame.setVisible(true);
    }
    public void listenerSetUp()
    {
        save.addActionListener(this);
        buttonSelect.addActionListener(this);
        importer.addActionListener(this);
    }
    public void saveToFile()
    {
        importing=false;
        fileFrame.setSize(500, 100);
        fileFrame.setLayout(null);
        fileName.setBounds(0, 25, 300, 50);
        fileName.setText("Enter the name of the file to be saved to.");
        fileFrame.add(fileName);
        saveInput.setBounds(325,25,150,50);
        saveInput.setText("Save");
        saveInput.addActionListener(this);
        fileFrame.add(saveInput);
        fileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fileFrame.setVisible(true);
    }
    public void importFromFile()
    {
        importing=true;
        fileFrame.setSize(500, 100);
        fileFrame.setLayout(null);
        fileName.setBounds(0, 25, 300, 50);
        fileName.setText("Enter the name of the file to import.");
        fileFrame.add(fileName);
        saveInput.setBounds(325,25,150,50);
        saveInput.setText("Import");
        saveInput.addActionListener(this);
        fileFrame.add(saveInput);
        fileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fileFrame.setVisible(true);
    }
    public static void main(String[] args)
    {
        main=new GuiMain();
    }
    public GuiMain()
    {
        info[0]=new ButtonInfo("",frame,rectangles);
        info[1]=new ButtonInfo("A", frame,rectangles);
        info[2]=new ButtonInfo("B", frame,rectangles);
        info[3]=new ButtonInfo("X", frame,rectangles);
        info[4]=new ButtonInfo("Y", frame,rectangles);
        info[5]=new ButtonInfo("Left_Bumber", frame,rectangles);
        info[6]=new ButtonInfo("Right_Bumber", frame,rectangles);
        buttonSelect = new JComboBox<ButtonInfo>(info);
        last=buttonSelect.getItemAt(0);
        componentsSetUp();
        frameSetUp();
        listenerSetUp();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==save)
        {
            saveToFile();
        }
        else if(e.getSource()==buttonSelect)
        {
            if(buttonSelect.getSelectedIndex()!=0)
            { 
                System.out.println("selectlistenerfired");
                last.deactivate();
                last=((ButtonInfo)buttonSelect.getSelectedItem());
                reDraw();
            }
        }
        else if(e.getSource()==saveInput)
        {
            if(!importing)
                FileManagement.save(fileName.getText(),info);
            else
            {
                frame.remove(buttonSelect);
                buttonSelect= FileManagement.fromImport(fileName.getText());
                buttonSelect.setBounds(0,0,1000,20);
                frame.add(buttonSelect);
                buttonSelect.addActionListener(this);
                reDraw();
            }
            fileFrame.setVisible(false);
        }
        else if(e.getSource()==importer)
        {
            importFromFile();
        }
    }
    public static void commandSelectSetUp(JComboBox<String> commandSelect) {
        commandSelect.addItem("");
        commandSelect.addItem("Run Motor");
        commandSelect.addItem("If");
    }
    public static GUICommand createNewCommand(String selectedItem) {
        System.out.println("new Command");
        switch(selectedItem){
            case "Run Motor":
                return new GUIRunMotor(rectangles);
            case "If":
                return new GUIIf(rectangles);
        }
        return null;
    }
    public void reDraw() {
        System.out.println("redrawing");
        frame.remove(rectangles);
        
        frame.setVisible(false);
        ((ButtonInfo)(buttonSelect.getSelectedItem())).redraw();
        
       // System.out.println(((ButtonInfo)buttonSelect.getSelectedItem()).getSave());
        frame.add(rectangles);

        frame.setVisible(true);
        //System.out.println(rectangles);
    }
}