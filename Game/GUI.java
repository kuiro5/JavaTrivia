/**
* Name:    Joshua Kuiros
* Name:    Pasquale Domanico
* Section: 2
* Program: Final Project Phase 2
* Date: 11/15/12
*
*/

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.JApplet;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.util.*;
import java.awt.*;
import java.awt.Dialog;
import java.io.*;

/**
* This class contains various methods for setting up the applet with all necessary
* GUI components and running game play	
*
* @author Joshua Kuiros
* @author Pasquale Domanico
* @version 1.0 11/15/2012
*
*/
public class GUI extends JApplet implements ActionListener, ItemListener
{
	
	private Player gamePlayer;					// player of the game
	private QuestionBank gameQuestionBank;		// all available questions
	private int questionIndex;					// location of question in array
	private int positionOfFinalAnswer;			// position of correct answer
	private static final int NO_ANSWER = -1;	// constant to determine no answer
	private boolean isPlaying;					// control for game play
	
	private JPanel questionPanel;				// panel for answerChoices
	private JPanel infoPanel;					// panel for name and score
	private JPanel titlePanel;					// panel for welcome message and question
	private JPanel fanswerPanel;					// panel for finalAnswer button
	private JPanel endScreen;
	
	private BorderLayout frameLayout; 			// layout for entire frame
	private GridBagLayout questionLayout;		// layout to display questions
	private GridBagConstraints constraints;		// constraints for questionLayout
	private JLabel title;						// welcome title
	private Font titleFont;						// font for welcome message
	private FlowLayout titleLayout;				// layout for welcome message
	private FlowLayout fanswerLayout;			// layout for final answer button
	private GridLayout scoreLayout;				// layout for score
	private FlowLayout endLayout;
	
	private JRadioButton choiceA;				// answers choices for questions
	private JRadioButton choiceB;
	private JRadioButton choiceC;
	private JRadioButton choiceD;
	
	private ButtonGroup answerChoices;			// group for answer choices
	private JButton finalAnswer;				// button to submit question
	private JLabel playerName;					// player name taken from dialog
	private JLabel score;						// label for score
	private JLabel scoreOne;
	private JLabel scoreTwo;
	private JLabel scoreThree;
	private JLabel scoreFour;
	private JLabel scoreFive;
	private JLabel scoreSix;
	private JLabel scoreSeven;
	private JLabel scoreEight;
	private JLabel scoreNine;
	private JLabel gameOver;
	private JTextArea questionText;				// text area to display question
	private JLabel nameIn;
	private int counter;
	
	

	/**	
	* Initialize the GUI applet and updates each question
	*/
	@Override
	public void init()
	 {	
		// Mechanics
		gameQuestionBank = new QuestionBank();
		gamePlayer = new Player();
		gamePlayer.setPlayerName( (String)JOptionPane.showInputDialog("Enter your name") );
		questionIndex = 0;
		positionOfFinalAnswer = NO_ANSWER;
		isPlaying = true;
		counter = 0;
		
		questionPanel = new JPanel();						// create panels
		infoPanel = new JPanel();
		titlePanel = new JPanel();
		fanswerPanel = new JPanel();
		frameLayout = new BorderLayout();
		
		endScreen = new JPanel();
		endScreen.setBackground( Color.BLACK );
		endLayout = new FlowLayout();
		endLayout.setAlignment( FlowLayout.CENTER );
		endScreen.setLayout( endLayout );
		gameOver = new JLabel( "Game Over" );
		gameOver.setForeground( Color.GREEN );
		gameOver.setBackground( Color.BLACK );
		gameOver.setFont( new Font( "Sanserif", Font.PLAIN, 48) );
		endScreen.add( gameOver );
		

		fanswerPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		
		
		titleLayout = new FlowLayout();						// create layouts
		fanswerLayout = new FlowLayout();
		scoreLayout = new GridLayout(11, 1);
		questionLayout = new GridBagLayout();
		constraints = new GridBagConstraints();
		
		questionPanel.setLayout( questionLayout );
		infoPanel.setLayout( scoreLayout );
		
		constraints.fill = GridBagConstraints.BOTH;			// set constraints
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		
		// get name and score
		playerName = new JLabel( "Player: ");	
		nameIn = new JLabel( gamePlayer.getName() );
		score = new JLabel( "Score: " + gamePlayer.getScore() );
		
		nameIn.setForeground( Color.RED );
		nameIn.setFont(new Font("Monospaced", Font.BOLD, 14));
		playerName.setForeground( Color.RED );
		playerName.setFont(new Font("Monospaced", Font.BOLD, 14));
		score.setForeground( Color.GREEN );
				
		choiceA = new JRadioButton( "A" );				// create answer radio buttons
		choiceA.addItemListener(this);
		choiceB = new JRadioButton( "B" );
		choiceB.addItemListener(this);
		choiceC = new JRadioButton( "C" );
		choiceC.addItemListener(this);
		choiceD = new JRadioButton( "D" );
		choiceD.addItemListener(this);
		answerChoices = new ButtonGroup();
		
		choiceA.setForeground( Color.GREEN );			// set button text to green
		choiceB.setForeground( Color.GREEN );
		choiceC.setForeground( Color.GREEN );
		choiceD.setForeground( Color.GREEN );
		
		choiceA.setBackground( Color.BLACK );			// set background to black
		choiceB.setBackground( Color.BLACK );
		choiceC.setBackground( Color.BLACK );
		choiceD.setBackground( Color.BLACK );
		
		
		scoreOne = new JLabel( "100" );
		scoreTwo = new JLabel( "1,000" );
		scoreThree = new JLabel( "10,000" );
		scoreFour = new JLabel( "50,000" );
		scoreFive = new JLabel( "100,000" );
		scoreSix = new JLabel( "250,000" );
		scoreSeven = new JLabel( "500,000" );
		scoreEight = new JLabel( "750,000" );
		scoreNine = new JLabel( "1,000,000" );
		
		
		finalAnswer = new JButton( "Final Answer" );	// create final answer button
		finalAnswer.addActionListener(this);
		
		constraints.gridx = 0;   						// add answer choices to layout
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
		
		answerChoices.add( choiceA );			// add answer choices to button group
		answerChoices.add( choiceB );
		answerChoices.add( choiceC );
		answerChoices.add( choiceD );
		
		scoreOne.setForeground( Color.GREEN );			// set button text to green
		scoreTwo.setForeground( Color.GREEN );
		scoreThree.setForeground( Color.GREEN );
		scoreFour.setForeground( Color.GREEN );
		scoreFive.setForeground( Color.GREEN );			// set button text to green
		scoreSix.setForeground( Color.GREEN );
		scoreSeven.setForeground( Color.GREEN );
		scoreEight.setForeground( Color.GREEN );
		scoreNine.setForeground( Color.GREEN );
		
		scoreOne.setFont(new Font("Monospaced", Font.BOLD, 14));
		scoreTwo.setFont(new Font("Monospaced", Font.BOLD, 14));
		scoreThree.setFont(new Font("Monospaced", Font.BOLD, 14));
		scoreFour.setFont(new Font("Monospaced", Font.BOLD, 14));
		scoreFive.setFont(new Font("Monospaced", Font.BOLD, 14));
		scoreSix.setFont(new Font("Monospaced", Font.BOLD, 14));
		scoreSeven.setFont(new Font("Monospaced", Font.BOLD, 14));
		scoreEight.setFont(new Font("Monospaced", Font.BOLD, 14));
		scoreNine.setFont(new Font("Monospaced", Font.BOLD, 14));
		
		infoPanel.add( playerName );			// add name and score to panel
		infoPanel.add( nameIn );
		infoPanel.add( scoreNine );
		infoPanel.add( scoreEight );
		infoPanel.add( scoreSeven );
		infoPanel.add( scoreSix );
		infoPanel.add( scoreFive );
		infoPanel.add( scoreFour );
		infoPanel.add( scoreThree );
		infoPanel.add( scoreTwo );
		infoPanel.add( scoreOne );
		
		
		// set background of all panels to black
		questionPanel.setBackground( Color.BLACK );		
		infoPanel.setBackground( Color.BLACK );
		titlePanel.setBackground( Color.BLACK );
		fanswerPanel.setBackground( Color.BLACK );
		
		
		title = new JLabel( "TechnoTrivia!" );	// create welcome
		
		try
		{
		InputStream is = this.getClass().getResourceAsStream("consola.ttf");
		
		titleFont = Font.createFont(Font.TRUETYPE_FONT, is );		// create welcome font
		titleFont = titleFont.deriveFont( Font.PLAIN, 24 );
		}
		catch(Exception e)
		{
			System.out.println("Error Loading TTF Font");
			System.exit(-1);
		}
		

		titleLayout.setAlignment( FlowLayout.CENTER );			// set up titlePanel
		titlePanel.setLayout( titleLayout );
		title.setForeground( Color.GREEN );
		title.setFont( titleFont );
		titlePanel.add( title );
		
		// set up question and add it to panel
		questionText = new JTextArea( "This is a question", 5, 50 );	
		questionText.setFont( new Font( "Sanserif", Font.PLAIN, 14) );
		questionText.setEditable( false );
		questionText.setBackground( Color.BLACK );
		questionText.setForeground( Color.WHITE );
		titlePanel.add( questionText );
		
		
		fanswerLayout.setAlignment( FlowLayout.CENTER );		// set up fanswerPanel
		fanswerPanel.setLayout( fanswerLayout );
		fanswerPanel.add( finalAnswer );
	
		setLayout( frameLayout );							
	
		add( questionPanel, frameLayout.CENTER );		// add Panels to appropriate area		
		add( infoPanel, frameLayout.EAST );
		add( titlePanel, frameLayout.NORTH );
		add( fanswerPanel, frameLayout.SOUTH );
		
		updateQuestion();							
	}
	
	/**
	* Updates each question with appropriate answer choices
	*/
	public void updateQuestion()
	{
		Question temp = gameQuestionBank.getQuestionAtPosition(questionIndex);
		questionText.setText( temp.getQuestionText() );
		choiceA.setText( "A. " + temp.getAnswerChoices()[0] );
		choiceB.setText( "B. " + temp.getAnswerChoices()[1] );
		choiceC.setText( "C. " + temp.getAnswerChoices()[2] );
		choiceD.setText( "D. " + temp.getAnswerChoices()[3] );
	}
	
	/**
	* Resets game play once the game has ended.
	*/
	public void resetGame()
	{
		// Reset Mechanics
		counter = 0;
		gameQuestionBank = new QuestionBank();
		gamePlayer = new Player();
		gamePlayer.setPlayerName( (String)JOptionPane.showInputDialog("Enter your name") );
		questionIndex = 0;
		positionOfFinalAnswer = NO_ANSWER;
		playerName.setText("Player: ");
		nameIn.setText( gamePlayer.getName() );
		updateQuestion();
		repaint();
	}
	
	/**
	* Overridden paint function to paint the applet and used to update score
	*
	* @param g object of the Graphics class
	*/
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		
		score.setText("Score: " + gamePlayer.getScore() );
		
		
		if( counter == 0 )
		{
			scoreOne.setForeground( Color.GREEN );			
			scoreTwo.setForeground( Color.GREEN );
			scoreThree.setForeground( Color.GREEN );
			scoreFour.setForeground( Color.GREEN );
			scoreFive.setForeground( Color.GREEN );			
			scoreSix.setForeground( Color.GREEN );
			scoreSeven.setForeground( Color.GREEN );
			scoreEight.setForeground( Color.GREEN );
			scoreNine.setForeground( Color.GREEN );
			
			scoreOne.setBackground( Color.BLACK );			
			scoreTwo.setBackground( Color.BLACK );
			scoreThree.setBackground( Color.BLACK );
			scoreFour.setBackground( Color.BLACK );
			scoreFive.setBackground( Color.BLACK );			
			scoreSix.setBackground( Color.BLACK );
			scoreSeven.setBackground( Color.BLACK );
			scoreEight.setBackground( Color.BLACK );
			scoreNine.setBackground( Color.BLACK );
		
		}
		if( counter == 1)
		{			
			scoreOne.setForeground( Color.BLACK );
			scoreOne.setOpaque(true);
			scoreOne.setBackground( Color.GREEN );
		}
		 if( counter == 2)
		{
			scoreTwo.setForeground( Color.BLACK );
			scoreTwo.setOpaque(true);
			scoreTwo.setBackground( Color.GREEN );
		}
		 if( counter == 3)			
		{
			scoreThree.setForeground( Color.BLACK );
			scoreThree.setOpaque(true);
			scoreThree.setBackground( Color.GREEN );
		}
		 if( counter == 4)		
		{
			scoreFour.setForeground( Color.BLACK );
			scoreFour.setOpaque(true);
			scoreFour.setBackground( Color.GREEN );
		}
		 if( counter == 5)			
		{
			scoreFive.setForeground( Color.BLACK );
			scoreFive.setOpaque(true);
			scoreFive.setBackground( Color.GREEN );
		}
		 if( counter == 6)			
		{
			scoreSix.setForeground( Color.BLACK );
			scoreSix.setOpaque(true);
			scoreSix.setBackground( Color.GREEN );
		}
		 if( counter == 7)			
		{
			scoreSeven.setForeground( Color.BLACK );
			scoreSeven.setOpaque(true);
			scoreSeven.setBackground( Color.GREEN );
		}
		 if( counter == 8)			
		{
			scoreEight.setForeground( Color.BLACK );
			scoreEight.setOpaque(true);
			scoreEight.setBackground( Color.GREEN );
		}
		 if( counter == 9)			
		{
			scoreNine.setForeground( Color.BLACK );
			scoreNine.setOpaque(true);
			scoreNine.setBackground( Color.GREEN );
		}			
			
	}
	
	public void endGame ()
	{
		isPlaying = false;
		questionPanel.setVisible( false );
		infoPanel.setVisible( false );
		titlePanel.setVisible( false );
		fanswerPanel.setVisible( false );
		add( endScreen, FlowLayout.CENTER );
		endScreen.setVisible( true );
	}
	
	/**	
	* Event handling once player submits questions. Checks if the answer if correct or
	* incorrect and if the game has exceeded the maximum number of questions.
	*
	* @param e object of the ActionEvent class used for event handling of buttons
	*/
	public void actionPerformed(ActionEvent e)
	{
		if( e.getSource() == finalAnswer && isPlaying)     // check answer choice
		{
			if( positionOfFinalAnswer != NO_ANSWER )
			{
				if( positionOfFinalAnswer == gameQuestionBank.getQuestionAtPosition(questionIndex).getPositionOfCorrectAnswer() )
				{
					gamePlayer.modifyScore( gameQuestionBank.getQuestionAtPosition(questionIndex).getQuestionPointWorth() );
					counter++;
					JOptionPane.showMessageDialog(null, "Correct!");  // correct answer
					repaint();
				}
				else
				{
					int choice = JOptionPane.showConfirmDialog(null, "Wrong Answer, Game Over.", "Restart?", JOptionPane.YES_NO_OPTION);
					if (choice == JOptionPane.OK_OPTION)
					{
						resetGame();
					}
					else
					{
						endGame();
					}
				}
				
				if( questionIndex < gameQuestionBank.NUMBER_OF_QUESTIONS-1 )  // check max number of questions
				{
					questionIndex++;
					updateQuestion();
				}
				else
				{
					int choice = JOptionPane.showConfirmDialog(null, "Game Over.", "Restart?", JOptionPane.YES_NO_OPTION);
					if (choice == JOptionPane.OK_OPTION)
					{
						resetGame();
					}
					else
					{
						endGame();	
					}
				}
				// Reset answer radio buttons and the corresponding choice
				answerChoices.clearSelection();
				positionOfFinalAnswer = NO_ANSWER;
			}
			else // no answer was chosen
			{
				JOptionPane.showMessageDialog(null, "You must choose an answer.");
			}
		}
	}
	
	/**
	* Event handling to determine which answer has been selected
	*
	* @param e object of the ItemEvent class for event handling of radio buttons
	*/
	public void itemStateChanged(ItemEvent e)
	{
		if( e.getSource() == choiceA && e.getStateChange() == ItemEvent.SELECTED )
		{
			positionOfFinalAnswer = 0;
		}
		
		if( e.getSource() == choiceB && e.getStateChange() == ItemEvent.SELECTED )
		{
			positionOfFinalAnswer = 1;
		}
		
		if( e.getSource() == choiceC && e.getStateChange() == ItemEvent.SELECTED )
		{
			positionOfFinalAnswer = 2;
		}
		
		if( e.getSource() == choiceD && e.getStateChange() == ItemEvent.SELECTED )
		{
			positionOfFinalAnswer = 3;
		}
	}
}