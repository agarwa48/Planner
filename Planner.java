import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Planner implements ActionListener
{
    int count = 0;
    int name, time, length, priority;
    JLabel label;
    JLabel nameLabel;

    public Planner()
    {
      
        JFrame frame = new JFrame();
        JButton button = new JButton("click");
        button.addActionListener(this);

       // nameLabel = new JLabel( new Date().toString());
        //panel.add(nameLabel);

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

    @Override
    public void actionPerformed(ActionEvent e)
    {
        count++;
        label.setText("Number of clicks: " + count);
    }
}