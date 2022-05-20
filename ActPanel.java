import javax.swing.*;

public class ActPanel extends JPanel
{
    String name;
    int time;
    int duration;
    int priority;

    public ActPanel(String name, int time, int duration, int priority)
    {
        this.name = name;
        this.time = time;
        this.duration = duration;
        this.priority = priority;

        JLabel eventLabel1 = new JLabel();
        JLabel timeLabel1 = new JLabel();
        JLabel durJLabel1 = new JLabel();
        JLabel prioityLabel1 = new JLabel();

    }
}