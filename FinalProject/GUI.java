import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.JApplet;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.util.*;
import java.awt.*;

public class GUI extends JApplet 
{
	private JPanel questionPanel;
	private JPanel infoPanel;
	private JPanel titlePanel;
	private BorderLayout frameLayout; 
	private GridBagLayout questionLayout;
	private GridBagConstraints constraints;
	private JLabel title;
	private Font titleFont;
	private FlowLayout titleLayout;
	private JRadioButton choiceA;
	private JRadioButton choiceB;
	private JRadioButton choiceC;
	private JRadioButton choiceD;
	private ButtonGroup answerChoices;
	private JButton finalAnswer;
	private JLabel playerName;
	private JLabel score;
	private JPanel fanswerPanel;
	private FlowLayout fanswerLayout;
	private JButton enterButton;
	
		
	@Override
	public void init()
	{	
		questionPanel = new JPanel();
		infoPanel = new JPanel();
		titlePanel = new JPanel();
		fanswerPanel = new JPanel();
		frameLayout = new BorderLayout();
		titleLayout = new FlowLayout();
		fanswerLayout = new FlowLayout();
		questionLayout = new GridBagLayout();
		constraints = new GridBagConstraints();
		
		questionPanel.setLayout( questionLayout );
		
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		
		playerName = new JLabel( "Player: " );
		score = new JLabel( "Score: ");
		
		playerName.setForeground( Color.GREEN );
		score.setForeground( Color.GREEN );
				
		choiceA = new JRadioButton( "A" );
		choiceB = new JRadioButton( "B" );
		choiceC = new JRadioButton( "C" );
		choiceD = new JRadioButton( "D" );
		answerChoices = new ButtonGroup();
		
		choiceA.setForeground( Color.GREEN );
		choiceB.setForeground( Color.GREEN );
		choiceC.setForeground( Color.GREEN );
		choiceD.setForeground( Color.GREEN );
		
		finalAnswer = new JButton( "Final Answer" );
		
		constraints.gridx = 0;   
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		questionLayout.setConstraints(choiceA, constraints);
		questionPanel.add( choiceA );
		
		constraints.gridx = 0;   
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		questionLayout.setConstraints(choiceB, constraints);
		questionPanel.add( choiceB );	
		
		constraints.gridx = 0;   
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		questionLayout.setConstraints(choiceC, constraints);
		questionPanel.add( choiceC );
		
		constraints.gridx = 0;   
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		questionLayout.setConstraints(choiceD, constraints);
		questionPanel.add( choiceD );
		
		answerChoices.add( choiceA );
		answerChoices.add( choiceB );
		answerChoices.add( choiceC );
		answerChoices.add( choiceD );
		
		infoPanel.add( playerName );
		infoPanel.add( score );
		
		questionPanel.setBackground( Color.BLACK );
		infoPanel.setBackground( Color.BLACK );
		titlePanel.setBackground( Color.BLACK );
		fanswerPanel.setBackground( Color.BLACK );
		
		
		title = new JLabel( "Welcome to Computer Science Trivia!!" );
		titleFont = new Font( "Serif" , Font.BOLD, 48 );
		
		titleLayout.setAlignment( FlowLayout.CENTER );
		titlePanel.setLayout( titleLayout );
		title.setForeground( Color.GREEN );
		title.setFont( titleFont );
		titlePanel.add( title );
			
		fanswerLayout.setAlignment( FlowLayout.CENTER );
		fanswerPanel.setLayout( fanswerLayout );
		fanswerPanel.add( finalAnswer );
	
		setLayout( frameLayout );
	
		add( titlePanel, frameLayout.NORTH );
		add( questionPanel, frameLayout.CENTER );
		add( infoPanel, frameLayout.EAST );
		add( fanswerPanel, frameLayout.SOUTH );
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
	}
	

}