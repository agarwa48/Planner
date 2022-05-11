import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.plaf.DimensionUIResource;

public class scheduler
{
    int name, time, duration, priority;
    JLabel nameLabel;
    JButton submit;
   
    JTextField textField1;
    JTextField textField2;
    JTextField textField3;
    JTextField textField4;
    JTextField textField5;

    public scheduler()
    {
        JFrame frame = new JFrame();
   
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("OUR SCHEDULE PLANNER");
        frame.setSize(500,1000);
        frame.setLayout(new GridLayout(4,10));
        frame.setVisible(true);
    
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9,1,5,5));
    
        JTextField textField1 = new JTextField("Enter event name:");
        panel.add(textField1);
        JTextField textField2 = new JTextField("Enter event time:");
        panel.add(textField2);
        JTextField textField3 = new JTextField("Enter event duration:");
        panel.add(textField3);
        JTextField textField4 = new JTextField("Enter event priority:");
        panel.add(textField4);
        JTextField textField5 = new JTextField("Enter event date:");
        panel.add(textField5);

        JButton submit = new JButton("Submit");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()==submit)
                {
                System.out.println("Your event name is" + textField1.getText());
                System.out.println("Your event time is" + textField2.getText());
                System.out.println("Your event duration is" + textField3.getText());
                System.out.println("Your event priority is" + textField4.getText());
                System.out.println("Your event date is" + textField5.getText());
                }
            }
        });
        submit.setPreferredSize(new Dimension(100, 100));
        panel.add(submit);
        

        panel.setPreferredSize(new Dimension(250,250));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));

        frame.setContentPane(panel); // adds the panel to the frame
        frame.setVisible(true);
    }

        public static void main(String[] args)
        {
          new scheduler();
        }

    
        

}
        
    

