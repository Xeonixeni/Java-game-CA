/**
 * Created by Andrew Prince on 02/05/2017.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class Main
{
    public JFrame window;				 
  
	public final int Rows = 13;
	public final int Colums = 9;
	public JButton Buttons[][] = new JButton[Rows][Colums];
	
        public void create()
        {
        window = new JFrame();
        window.setVisible(true);
        window.setTitle("game");
        window.setSize(400 , 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
		//Add 13 rows and 9 colums of buttons to create the basic GUI.
		for(int i=0;i<Rows;i++)
		{
			for(int j = 0; j<Colums; j++)
			{
				
				if(i == 0)
				{
					Buttons[i][j] = new JButton(new ImageIcon("bank2.jpg"));
				}
				else if(i == 12)
				{
					Buttons[i][j] = new JButton(new ImageIcon("bank1.jpg"));
				}
				else
				{
					Buttons[i][j] = new JButton(new ImageIcon("water1.jpg"));
				}					
				Buttons[i][j].setPreferredSize(new Dimension(32, 32));
			    Buttons[i][j].setMinimumSize(new Dimension(32, 32));
				Buttons[i][j].setMaximumSize(new Dimension(32, 32));
				Buttons[i][j].setSize(32, 32);
				Buttons[i][j].revalidate();
				panel.add(Buttons[i][j]); 
			}

		}
			
			
        window.setContentPane(panel);
		window.setLayout(new GridLayout(13, 9));
        window.pack();



    }


    public static void main(String[] args)
    {

    }
}
