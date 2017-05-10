/**
 * Created by Andrew Prince on 02/05/2017.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.util.Random;

public class Main implements ActionListener
{
    public JFrame window;				 
	public final int Rows = 13;
	public final int Colums = 9;
	public JButton Buttons[][] = new JButton[Rows][Colums];
	public JPanel panel;
	private int s = 0;
	public int Xloc = 0;
	public int Yloc = 0;
	public String[][] buttonIcons = new String [Rows][Colums];
	public String[] inv = new string [10]
        public void create()
        {
        window = new JFrame();
        window.setVisible(true);
        window.setTitle("game");
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
		//Add 13 rows and 9 colums of buttons to create the basic GUI.
		for(int i=0;i<Rows;i++)
		{
			for(int j = 0; j<Colums; j++)
			{
				
				if(i == 0)
				{
					Buttons[i][j] = new JButton(new ImageIcon("bank2.jpg"));
					buttonIcons[i][j] = "bank2.jpg";
				}
				else if(i == 12)
				{
					Buttons[i][j] = new JButton(new ImageIcon("bank1.jpg"));
					buttonIcons[i][j] = "bank1.jpg";
					
				}
				else
				{
					Buttons[i][j] = new JButton(new ImageIcon("water1.jpg"));
					buttonIcons[i][j] = "water1.jpg";
				
				}					
				Buttons[i][j].setPreferredSize(new Dimension(32, 32));
				Buttons[i][j].addActionListener(this);
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
	public void level1()
	{
		Buttons[12][2].setIcon(new ImageIcon("stump2_man.jpg"));
		buttonIcons[12][2] = "stump2_man.jpg";
		Xloc = 2;
		Yloc = 12;
		Buttons[11][2].setIcon(new ImageIcon("plank2.jpg"));
		buttonIcons[11][2] = "plank2.jpg";
		Buttons[10][2].setIcon(new ImageIcon("plank2.jpg"));
		buttonIcons[10][2] = "plank2.jpg";
		Buttons[9][2].setIcon(new ImageIcon("stump1.jpg"));
		buttonIcons[9][2] = "stump1.jpg";
		Buttons[6][2].setIcon(new ImageIcon("stump1.jpg"));
		buttonIcons[6][2] = "stump1.jpg";
		Buttons[3][2].setIcon(new ImageIcon("stump1.jpg"));
		buttonIcons[3][2] = "stump1.jpg";
		Buttons[0][2].setIcon(new ImageIcon("stump3.jpg"));
		buttonIcons[0][2] = "stump3.jpg";
		
	}
	
	public void check()
	{
		int limCheck = 12;
		boolean stumpFound = false;
		for(int j = 0; j<Colums; j++)
		{
		  String stumpCheck = Buttons[limCheck][j].getIcon().toString();
			if(stumpCheck == "stump2_man.jpg")
			{
				stumpFound = true;
			}
			
		}
		if(stumpFound = false)
		{
			level1(); 
		}
		
	}
	public void actionPerformed(ActionEvent e) 
	{
		String btnType = "";
		String btnType2 = "";
		
		for(int i=0;i<Rows;i++)
		{
			for(int j = 0; j<Colums; j++)
			{
				if (e.getSource() == Buttons[i][j])
				{
					if(buttonIcons[i][j] == "water1.jpg")
					{
						System.out.println("Cannot move into water"); 
					}
					
					else if(Yloc == i + 1)
					{
						if(Xloc == j)
						{
							buttonIcons[i][j] = buttonIcons[i][j].replace(".jpg", "");
							buttonIcons[i][j] = buttonIcons[i][j] + "_man.jpg";
							Buttons[i][j].setIcon(new ImageIcon(buttonIcons[i][j]));
							buttonIcons[Yloc][Xloc] = buttonIcons[Yloc][Xloc].replace("_man.jpg", "");
							buttonIcons[Yloc][Xloc] = buttonIcons[Yloc][Xloc] + ".jpg";
							
							Buttons[Yloc][Xloc].setIcon(new ImageIcon(buttonIcons[Yloc][Xloc])); 
							Xloc = j;
							Yloc = i;
						}
					}
					else if(Yloc == i - 1)
					{
						if(Xloc == j)
						{
							buttonIcons[i][j] = buttonIcons[i][j].replace(".jpg", "");
							buttonIcons[i][j] = buttonIcons[i][j] + "_man.jpg";
							Buttons[i][j].setIcon(new ImageIcon(buttonIcons[i][j]));
							buttonIcons[Yloc][Xloc] = buttonIcons[Yloc][Xloc].replace("_man.jpg", "");
							buttonIcons[Yloc][Xloc] = buttonIcons[Yloc][Xloc] + ".jpg";
							
							Buttons[Yloc][Xloc].setIcon(new ImageIcon(buttonIcons[Yloc][Xloc])); 
							Xloc = j;
							Yloc = i;
						}
					}
					else if(Xloc == j + 1)
					{
						if(Yloc == i)
						{
							buttonIcons[i][j] = buttonIcons[i][j].replace(".jpg", "");
							buttonIcons[i][j] = buttonIcons[i][j] + "_man.jpg";
							Buttons[i][j].setIcon(new ImageIcon(buttonIcons[i][j]));
							buttonIcons[Yloc][Xloc] =buttonIcons[Yloc][Xloc].replace("_man.jpg", "");
							buttonIcons[Yloc][Xloc] = buttonIcons[Yloc][Xloc] + ".jpg";
							
							Buttons[Yloc][Xloc].setIcon(new ImageIcon(buttonIcons[Yloc][Xloc])); 
							Xloc = j;
							Yloc = i;
						}
					}
					else if(Xloc == j - 1)
					{
						if(Yloc == i)
						{
							buttonIcons[i][j] = buttonIcons[i][j].replace(".jpg", "");
							buttonIcons[i][j] = buttonIcons[i][j] + "_man.jpg";
							Buttons[i][j].setIcon(new ImageIcon(buttonIcons[i][j]));
							buttonIcons[Yloc][Xloc] = buttonIcons[Yloc][Xloc].replace("_man.jpg", "");
							buttonIcons[Yloc][Xloc] = buttonIcons[Yloc][Xloc] + ".jpg";
							
							Buttons[Yloc][Xloc].setIcon(new ImageIcon(buttonIcons[Yloc][Xloc])); 
							Xloc = j;
							Yloc = i;
						}
					}
				}	
			}
		
		}
	}

	

    public static void main(String[] args)
    {

    }
}
