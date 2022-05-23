import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import javax.swing.plaf.DimensionUIResource;
import javax.xml.validation.Validator;


/** Schedule is the main public class
 * implements the action listener
 * contains the initializing of the JLabels, JButtons, JPanels, Arrays
 * Contains the constructor
 * Contains the methods
 */
public class schedule implements ActionListener
{
    // initialising outside constructor
    JFrame frame;

    JLabel headerLabel[];
    JTextField headField[];
    String headString[] = {"HeadLiner event:","Duration in hours:", "Staring time:"};

    JLabel nameLabel[];
    JTextField eventField[];

    String eventString[] = {"Event name:", "Event Duration:" , "Event Time" , "Event Priority:" };

    // buttons
    JButton submit;
    JButton submit2;
    JButton back;
    JButton show;
    JButton back2;

    // panels
    JPanel headPanel;
    JPanel eventPanel;
    JPanel finalPanel;
    JPanel finalPanel2;
    
    JComboBox priorityBox;

    String[] priority = {"2", "3", "4", "5"};      // contents of the priority box

    int i;
    int j;
    int a;  

    ArrayList<ArrayList<String> > tableList;       // 2D arrayList

    /** 
     * Initializes the components of the JFrame
     * loops the printing of the textFields on the Panels
     * adds the buttons to the panels
     * adds buttons to the action listener
     */
    public schedule()
    {
        frame = new JFrame();
        
        headPanel= new JPanel();                            // panel for the headliner
        headPanel.setLayout(new GridLayout(9,1,10,10));

        eventPanel = new JPanel();                               // panel for other events
        eventPanel.setLayout(new GridLayout(9,1,10,10));

        headField = new JTextField[3];                  // array for the 2 textfields in the head panel
        headerLabel = new JLabel[3];                    // array for the 2 text labels in the head panel

        eventField = new JTextField[3];                 // array for the 3 textfields in the event panel
        nameLabel = new JLabel[4];                      // array for the 3 text labels in the event panel

        finalPanel = new JPanel();                      // making a 3rd page panel
        finalPanel.setLayout(new GridLayout(2,1));

        finalPanel2 = new JPanel();                     // panel(1) inside the 3rd page panel
        finalPanel2.setLayout(new GridLayout(4,1));           

        tableList = new ArrayList<ArrayList<String> >();

        priorityBox = new JComboBox(priority);


        for(j = 0; j<3; j++)                             // for loop for printing out the 2 text fields and labels in the headpanel
        {
            headerLabel[j] = new JLabel(headString[j]);
            headPanel.add(headerLabel[j]);

            headField[j] = new JTextField(); 
            headPanel.add(headField[j]); 
         
        }
       
        for( i = 0; i< 4; i++)                            // for loop for printing out the 2 text fields and labels in the headpanel
        {
            nameLabel[i] = new JLabel(eventString[i]);
            eventPanel.add(nameLabel[i]);
            
            if (i == 3)             // priority box is at index 3
            {
                eventPanel.add(priorityBox);
            }
            if (i <= 2) {
                eventField[i] = new JTextField();       // creating the text fields 
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
        back = new JButton("Back to Event page");
        back2 = new JButton("Back to Head page");


        // adding the buttons to the action listener 
        submit.addActionListener(this);
        submit2.addActionListener(this);
        back.addActionListener(this);
        back2.addActionListener(this);
        show.addActionListener(this);
        priorityBox.addActionListener(this);


        // adding the buttons to the panels
        headPanel.add(submit);
        
        eventPanel.add(submit2);
        eventPanel.add(show);
        eventPanel.add(back2);

        finalPanel2.add(back);


        // changing the looks of the panels
        headPanel.setPreferredSize(new Dimension(250,250));
        headPanel.setBackground(Color.DARK_GRAY);
        headPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        
        eventPanel.setPreferredSize(new Dimension(250,250));
        eventPanel.setBackground(Color.LIGHT_GRAY);
        eventPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));

        finalPanel.setPreferredSize(new Dimension(250,250));
        finalPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));

        finalPanel2.setPreferredSize(new Dimension(250, 250));

        frame.setLayout(null);
        frame.setContentPane(headPanel); // adds the panel to the frame
        frame.setVisible(true);
    }

    
    JTable table;
    Object[][] data = {};              // initialising the 2d array outside the method to access it elsewhere
 
    /**
     * Method to make a JTable
     * @component removes the scroll pane once its duplicated to avoid duplication
     * loop for getting values from the small array
     */
    public void table()
    {
        //Get the components in the panel
        Component[] componentList = finalPanel.getComponents();

        //Loop through the components
        for(Component c : componentList){

            //Finds ScrollPane to remove it 
            if(c instanceof JScrollPane){

                //Removes the panel
                finalPanel.remove(c);
            }
        }

        int length = tableList.size();    //get the number of elements in the table List

        String[][] temp = new String[length][4];        // rows and cols

        for(i = 0; i<length; i++)
        {
            for(j = 0; j<4; j++)
            {
                temp[i][j] = tableList.get(i).get(j);        // getting valies from main and small array List
            }
        }

        String[] colNames = {"Name", "Duration", "Time", "Priority"};

        table = new JTable(temp, colNames);

        table.setLayout(new GridLayout());

        JScrollPane scrollPane = new JScrollPane(table);
        JScrollPane scrollPane2 = new JScrollPane(table);

        
        finalPanel.add(scrollPane);
        finalPanel.remove(scrollPane);
        finalPanel.add(scrollPane2);

        finalPanel.add(finalPanel2);

        finalPanel.revalidate();
    }

    /** 
    * @override overrides the method in subclass
    * contains the actionListener
    * contains the result of clicking the JButtons
    */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object[][] newData = new Object[data.length+1][4];  // creates a copy of the old array but bigger (+1)
        System.arraycopy(data,0 , newData, 1, data.length);  // still copies the same items before the new row is made
        System.out.println(String.valueOf(newData));
        System.out.println(Arrays.deepToString(newData));

        if(e.getSource()==submit)
        {
            tableList.add(addToList(headField[0].getText(), headField[1].getText(), headField[2].getText(), "1"));

            System.out.println(headField[0].getText());
            System.out.println(headField[1].getText());
            System.out.println(headField[2].getText());

            frame.setContentPane(eventPanel);              
            frame.setVisible(true);

            table();
        }

        else if(e.getSource()==submit2) 
        {
            tableList.add(addToList(eventField[0].getText(), eventField[1].getText(), eventField[2].getText(), priorityBox.getSelectedItem().toString()));

            frame.setContentPane(eventPanel);               // when the submit button is clicked, the panel changes from head page to event page
            frame.setVisible(true);

            for (i=0; i<3; i++)
            {
                System.out.println(eventField[i].getText());            // prints the content of head page
            }
            System.out.println("Priority: " + priorityBox.getSelectedItem());

            for(i=0; i<3; i++)
            {
                eventField[i].setText("");   // empties the text boxes once submit is clicked

                // Will not run the code underneath if i is 2 because headField only has 2 indicies
                if (i == 2) { break; }
                headField[i].setText("");    
            }

            table();
        }

        else if(e.getSource() == back)                     
        {
            frame.setContentPane(eventPanel);               // when back is clicked we are taken back from final page to the event page
            frame.setVisible(true);
        }

        else if(e.getSource() == back2)                     
        {
            frame.setContentPane(headPanel);               // when back is clicked we are taken back from final page to the event page
            frame.setVisible(true);
        }
        
        else if(e.getSource() == show)                      
        {
            frame.setContentPane(finalPanel);               // when show is clicked, the panel changes from event page to final page
            frame.setVisible(true);
        }
    }
/**
 * The main method to call the object table and the schedule
 */
    public static void main(String[] args)
    {           
        schedule obj = new schedule();  // obj is the variable
        obj.table(); 
              
    }
    /** 
     * private method for the 2d array list
     * has a temporary variable which holds the values of event contents
     */
    private ArrayList addToList(String name, String duration, String time, String priority)
    {
        ArrayList temp = new ArrayList<>();
        temp.add(name);
        temp.add(duration);
        temp.add(time);
        temp.add(priority);

        return temp;
    }
}
