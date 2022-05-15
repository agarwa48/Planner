import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.plaf.DimensionUIResource;
import javax.xml.validation.Validator;

public class scheduler implements ActionListener
{
    // initialising outside constructor
    JLabel headerLabel[];
    JTextField headField[];
    String headString[] = {"HeadLiner event:", "Staring time"};

    JLabel nameLabel[];
    JTextField eventField[];
    String eventString[] = {"Event name:", "Event priority:", "Event time:"};

    JButton submit;
    JButton submit2;
    JButton back;
    JButton show;

    JFrame frame;

    JPanel headPanel;
    JPanel eventPanel;
    JPanel finalPanel;
    JPanel finalPanel2;
    JPanel finalPanel3;

    JComboBox priorityBox;
    String[] priority = {"1", "2", "3", "4", "5"};
    int i;
    int j;


    // main constructor
    public scheduler()
    {
        frame = new JFrame();
        
        headPanel= new JPanel();                            // panel for the headliner
        headPanel.setLayout(new GridLayout(9,1,10,10));

        
        eventPanel = new JPanel();                               // panel for other events
        eventPanel.setLayout(new GridLayout(9,1,10,10));

        headField = new JTextField[2];                  // array for the 2 textfields in the head panel
        headerLabel = new JLabel[2];                    // array for the 2 text labels in the head panel

        eventField = new JTextField[3];                 // array for the 3 textfields in the event panel
        nameLabel = new JLabel[3];                      // array for the 3 text labels in the event panel

        finalPanel = new JPanel();                      // making a 3rd page panel
        finalPanel.setLayout(new GridLayout(2,1));

        finalPanel2 = new JPanel();                     // panel(1) inside the 3rd page panel

        finalPanel3 = new JPanel();                     // panel (2) insid the 3rd page pane;

        for(j = 0; j<2; j++)                             // for loop for printing out the 2 text fields and labels in the headpanel
        {
            headerLabel[j] = new JLabel(headString[j]);
            headPanel.add(headerLabel[j]);

            headField[j] = new JTextField(); 
            headPanel.add(headField[j]); 
        }
       
        for( i = 0; i< 3; i++)                            // for loop for printing out the 2 text fields and labels in the headpanel
        {
            nameLabel[i] = new JLabel(eventString[i]);
            eventPanel.add(nameLabel[i]);
            
            if (i == 1) {
                priorityBox = new JComboBox(priority);
                eventPanel.add(priorityBox);
            }
            else {
                eventField[i] = new JTextField(); 
                eventPanel.add(eventField[i]); 
            }
        }

       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("OUR SCHEDULE PLANNER");
        frame.setSize(500,1000);
        frame.setLayout(new GridLayout(4,10));
        frame.setVisible(true);


        // initiallising the buttons 
        submit = new JButton("Submit");
        submit2 = new JButton("Submit");
        show = new JButton("Show Plan");
        back = new JButton("Back");


        // adding the buttons to the action listener 
        submit.addActionListener(this);
        submit2.addActionListener(this);
        back.addActionListener(this);
        show.addActionListener(this);
        priorityBox.addActionListener(this);


        // adding the buttons to the panels
        headPanel.add(submit);
        
        eventPanel.add(submit2);
        eventPanel.add(show);
        //eventPanel.add(priorityBox);

        finalPanel3.add(back);

        finalPanel.add(finalPanel2);
        finalPanel.add(finalPanel3);


        // changing the looks of the panels caz material gorl
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


          // making a new method for action listener outside the constructor
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==submit || e.getSource()==submit2 )
        {
            System.out.println(headField[0].getText());
            System.out.println(headField[1].getText());
            
            frame.setContentPane(eventPanel);               // when the submit button is clicked, the panel changes from head page to event page
            frame.setVisible(true);

            for (i=0; i<3; i++)
            {
                System.out.println(eventField[i].getText());            // prints the content of head page
            }
        }

        else if(e.getSource() == back)                     
        {
            frame.setContentPane(eventPanel);               // when back is clicked we are taken back from final page to the event page
            frame.setVisible(true);
        }
        
        else if(e.getSource() == show)                      
        {
            frame.setContentPane(finalPanel);               // when show is clicked, the panel changes from event page to final page
            frame.setVisible(true);
        }
        
        else if(e.getSource() == priorityBox)
        {

        }

        for(i=0; i<3; i++)
        {
            eventField[i].setText("");   // empties the text boxes once submit is clicked
            // Will not run the code underneath if i is 2 because headField only has 2 indicies
            if (i == 2) { break; }
            headField[i].setText("");    
        }
    }

    public static void main(String[] args)
    {
        new scheduler();
    }

}
