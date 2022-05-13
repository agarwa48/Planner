import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.plaf.DimensionUIResource;
import javax.xml.validation.Validator;

public class scheduler implements ActionListener
{
    JLabel nameLabel[];
    JTextField textField[];
    String labels[] = {"Event name:", "Event priority:", "Event time:"};
    JButton submit;
    JButton submit2;
    JButton back;
    JButton show;
    JFrame frame;
    JTextField headLiner;
    JTextField headLiner1;
    JPanel headPanel;
    JPanel eventPanel;
    JPanel finalPanel;
    JPanel finalPanel2;
    JPanel finalPanel3;
    int i;

    public scheduler()
    {
        frame = new JFrame();

        headPanel= new JPanel();            // panel for the headliner
        headPanel.setLayout(new GridLayout(9,1,10,10));

        JLabel header = new JLabel("Enter Head Liner event:");
        headPanel.add(header);

        headLiner = new JTextField();
        headPanel.add(headLiner);

        JLabel header1 = new JLabel("Enter Head Liner time:");
        headPanel.add(header1);

        headLiner1 = new JTextField();
        headPanel.add(headLiner1);

        eventPanel = new JPanel();                // panel for other events
        eventPanel.setLayout(new GridLayout(9,1,10,10));

        textField = new JTextField[3]; 
        nameLabel = new JLabel[3];

        finalPanel = new JPanel();
        finalPanel.setLayout(new GridLayout(2,1));

        finalPanel2 = new JPanel();

        finalPanel3 = new JPanel();


        for( i = 0; i< 3; i++)
        {
            nameLabel[i] = new JLabel(labels[i]);
            eventPanel.add(nameLabel[i]);
            
            textField[i] = new JTextField(); 
            eventPanel.add(textField[i]); 
            //textField.setPreferredSize(new Dimension(250, 40));
        }
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("OUR SCHEDULE PLANNER");
        frame.setSize(500,1000);
        frame.setLayout(new GridLayout(4,10));
        frame.setVisible(true);


        submit = new JButton("Submit");
        submit2 = new JButton("Submit");
        show = new JButton("Show Plan");
        back = new JButton("Back");


        submit.addActionListener(this);
        submit2.addActionListener(this);
        back.addActionListener(this);
        show.addActionListener(this);

    
        headPanel.add(submit);
        
        eventPanel.add(submit2);
        eventPanel.add(show);

        finalPanel3.add(back);

        finalPanel.add(finalPanel2);
        finalPanel.add(finalPanel3);

        headPanel.setPreferredSize(new Dimension(250,250));
        headPanel.setBackground(Color.DARK_GRAY);
        headPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        
        eventPanel.setPreferredSize(new Dimension(250,250));
        eventPanel.setBackground(Color.LIGHT_GRAY);
        eventPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));

        finalPanel.setPreferredSize(new Dimension(250,250));
        finalPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));

        finalPanel2.setPreferredSize(new Dimension(125,125));
        finalPanel2.setBackground(Color.GRAY);

        finalPanel3.setPreferredSize(new Dimension(125,125));
        finalPanel3.setBackground(Color.DARK_GRAY);

        frame.setContentPane(headPanel); // adds the panel to the frame
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==submit || e.getSource()==submit2 )
        {
            System.out.println(headLiner.getText());
            System.out.println(headLiner1.getText());
            
            frame.setContentPane(eventPanel);
            frame.setVisible(true);

            for (i=0; i<3; i++)
            {
                System.out.println(textField[i].getText());
            }
        }

        else if(e.getSource() == back)
        {
            frame.setContentPane(eventPanel);
            frame.setVisible(true);
        }
        
        else if(e.getSource() == show)
        {
            frame.setContentPane(finalPanel);
            frame.setVisible(true);
        }
        for(i=0; i<3; i++)
        {
            textField[i].setText("");   // empties the text boxes once submit is pressed
            headLiner.setText("");     
            headLiner1.setText("");
        }
    }

    public static void main(String[] args)
    {
        new scheduler();
    }

}
