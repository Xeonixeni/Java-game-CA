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
					Buttons[i][j].addActionListener(this);
				}
				else if(i == 12)
				{
					Buttons[i][j] = new JButton(new ImageIcon("bank1.jpg"));
					Buttons[i][j].addActionListener(this);
				}
				else
				{
					Buttons[i][j] = new JButton(new ImageIcon("water1.jpg"));
					Buttons[i][j].addActionListener(this);
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
	public void level1()
	{
		panel.removeAll();
		Random rand = new Random();
		int n = rand.nextInt(11 - 8 + 1) + 8;
		s = rand.nextInt(9);
		int stumpLim = 0;		
		for(int i=0;i<Rows;i++)
		{
			int q = rand.nextInt(9); 
			for(int j = 0; j<Colums; j++)
			{
				int stumpLoc1 = rand.nextInt(15);
				int stumpLoc2 = rand.nextInt(15);
				if(i == 0)
				{
					if(j == s)
					{
						Buttons[i][j] = new JButton(new ImageIcon("stump3.jpg"));
						buttonIcons[i][j] = "stump3.jpg";
					}
					else
					{
						Buttons[i][j] = new JButton(new ImageIcon("bank2.jpg"));
						buttonIcons[i][j] = "bank2.jpg";
					}
					
				}
				else if(i == 12)
				{
					if(j == s)
					{
						Buttons[i][j] = new JButton(new ImageIcon("stump2_man.jpg"));
						Xloc = j;
						Yloc = i;
						buttonIcons[i][j] = "stump2_man.jpg";
					}
					else
					{
						Buttons[i][j] = new JButton(new ImageIcon("bank1.jpg"));
						buttonIcons[i][j] = "bank1.jpg";
					}
				}
				else 
				{	
					if (i == n)
					{
						if(j == s)
						{
							Buttons[i][j] = new JButton(new ImageIcon("stump1.jpg"));
							buttonIcons[i][j] = "stump1.jpg";
						}
				
					}
					else if( i > n)
					{
						if (j == s)
						{
							Buttons[i][j] = new JButton(new ImageIcon("Plank2.jpg"));
							buttonIcons[i][j] = "Plank2.jpg";
						}
						
					}
					else
					{
						{
						if( j == stumpLoc1)
						{
							Buttons[i][j] = new JButton(new ImageIcon("stump1.jpg"));
							stumpLim++;
							buttonIcons[i][j] = "stump1.jpg";
						}
						else if(j == stumpLoc2)	
						{
							Buttons[i][j] = new JButton(new ImageIcon("stump1.jpg"));
							stumpLim++;
							buttonIcons[i][j] = "stump1.jpg";
						}
						else 
						{
							Buttons[i][j] = new JButton(new ImageIcon("water1.jpg"));
							buttonIcons[i][j] = "water1.jpg";
						}
						}
					}
				}
			
					
				
				Buttons[i][j].addActionListener(this);
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
		System.out.println(Xloc + "  " + Yloc);
		check();
		
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
		
		
		for(int i=0;i<Rows;i++)
		{
			for(int j = 0; j<Colums; j++)
			{
				if (e.getSource() == Buttons[i][j])
				{
					btnType = buttonIcons[i][j];	//Needs more work to be 100% - also to do with other areas
					buttonIcons[i][j] = buttonIcons[Yloc][Xloc];
					buttonIcons[Yloc][Xloc] = btnType;
					animate();
				}	
			}
		
		}
	}
	public void animate()
	{
		panel.removeAll();
		for(int i=0;i<Rows;i++)
		{
			for(int j = 0; j<Colums; j++)
			{
				Buttons[i][j] = new JButton(new ImageIcon(buttonIcons[i][j]));
				Buttons[i][j].addActionListener(this);
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
