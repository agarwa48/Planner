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

        JLabel label1 = new Jlabel();

    }
}