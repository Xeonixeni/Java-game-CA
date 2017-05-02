/**
 * Created by Andrew Prince on 02/05/2017.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main
{
    public JFrame window;
    public JButton One;
    public JButton Two;
    public JButton Three;
    public JButton Four;
    public JButton Five;
    public JButton Six;
    public JButton Seven;
    public JButton Eight;
    public JButton Nine;
    public JButton Ten;
    public JButton Eleven;
    public JButton Twelve;
    public JButton Thirteen;
    public JButton Fourteen;
    public JButton Fifteen;


        public void create()
        {
        window = new JFrame();
        window.setVisible(true);
        window.setTitle("game");
        window.setSize(400 , 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        One = new JButton();
        Two = new JButton();
        Three = new JButton();
        Five  = new JButton();
        Four = new JButton();
            Six = new JButton();
            Seven = new JButton();
            Eight = new JButton();
            Nine = new JButton();
            Ten = new JButton();
            Eleven = new JButton();
            Twelve = new JButton();
            Thirteen = new JButton();
            Fourteen = new JButton();
            Fifteen = new JButton();

        panel.add(One);
        panel.add(Two);
        panel.add(Three);
        panel.add(Four);
        panel.add(Five);
        panel.add(Six);
            panel.add(Seven);
            panel.add(Eight);
            panel.add(Nine);
            panel.add(Ten);
            panel.add(Eleven);
            panel.add(Twelve);
            panel.add(Thirteen);
            panel.add(Fourteen);
            panel.add(Fifteen);

            window.setContentPane(panel);
        window.setLayout(new GridLayout(5, 3));
        //window.pack();



    }


    public static void main(String[] args)
    {

    }
}
