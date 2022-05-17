import javax.swing.*;

public class Act extends JPanel
{
    String name;
    int time;
    int duration;
    int priority;
    ActPanel panel;

    public Act(String name, int time, int duration, int priority)
    {
        this.name = name;
        this.time = time;
        this.duration = duration;
        this.priority = priority;

        panel = new ActPanel();

    }

    public JPanel getPanel()
    {
        return panel;
    }
}