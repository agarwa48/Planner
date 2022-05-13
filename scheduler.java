import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.plaf.DimensionUIResource;

public class scheduler
{
    JLabel nameLabel[];
    JTextField textField[];
    String labels[] = {"Event name:", "Event date:", "Event priority:", "Event duration:", "Event time:"};
    JButton submit;
    int i;

    public scheduler()
    {
        JFrame frame = new JFrame();
   
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("OUR SCHEDULE PLANNER");
        frame.setSize(500,1000);
        frame.setLayout(new GridLayout(4,10));
        frame.setVisible(true);
    
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9,1,10,10));
    

        JLabel header = new JLabel("Enter Head Liner event:");
        panel.add(header);

        JTextField headLiner = new JTextField();
        panel.add(headLiner);

        JLabel header1 = new JLabel("Enter Head Liner time:");
        panel.add(header1);

        JTextField headLiner1 = new JTextField();
        panel.add(headLiner1);

        textField = new JTextField[5]; 
        nameLabel = new JLabel[5];
        for( i = 0; i< 5; i++)
        {
            nameLabel[i] = new JLabel(labels[i]);
            panel.add(nameLabel[i]);
            
            textField[i] = new JTextField(); 
            panel.add(textField[i]); 
            //textField.setPreferredSize(new Dimension(250, 40));
        }
       

        JButton submit = new JButton("Submit");
        submit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()==submit)
                {
                    System.out.println(headLiner.getText());
                    System.out.println(headLiner1.getText());
                 
                    for (i=0; i<5; i++)
                    {
                        System.out.println(textField[i].getText());
                    }
                }
                for(i=0; i<5; i++)
                {
                    textField[i].setText("");
                    headLiner.setText("");
                    headLiner1.setText("");
                }
            }
        });

        submit.setPreferredSize(new Dimension(1000, 100));
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
