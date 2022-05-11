import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

Public class Planner implements ActionListener
{
    int name, time, length, priority;
    JLabel label;
    JLabel nameLabel;

    public Planner()
    {
      
        JFrame frame = new JFrame();
        button.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("OUR PLANNER");
        frame.setSize(500,1000);
        frame.pack();
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
    
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
    }

        public static void main(String[] args)
        {
          new Planner();
        }
    }

