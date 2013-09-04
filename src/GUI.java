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
import java.sql.*;


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
        private static final int MAX_HI_SCORE_LIST = 10;
        
	private JPanel questionPanel;				// panel for answerChoices
	private JPanel infoPanel;					// panel for name and score
	private JPanel titlePanel;					// panel for welcome message and question
	private JPanel fanswerPanel;					// panel for finalAnswer button
	private JPanel endScreen;
        private JPanel gameOver;
        private JPanel hiScores;
        private JPanel resetPanel;
	
	private BorderLayout frameLayout; 			// layout for entire frame
        private BorderLayout endScreenLayout;
	private GridBagLayout questionLayout;		// layout to display questions
	private GridBagConstraints constraints;		// constraints for questionLayout
        private GridLayout hiScoreLayout;
	private JLabel title;						// welcome title
	private Font titleFont;						// font for welcome message
	private FlowLayout titleLayout;				// layout for welcome message
	private FlowLayout resetLayout;
        private FlowLayout fanswerLayout;			// layout for final answer button
	private GridLayout scoreLayout;				// layout for score
	private FlowLayout gameOverLayout;
	
	private JRadioButton choiceA;				// answers choices for questions
	private JRadioButton choiceB;
	private JRadioButton choiceC;
	private JRadioButton choiceD;
	
	private ButtonGroup answerChoices;			// group for answer choices
	private JButton finalAnswer;				// button to submit question
	private JButton resetButton;
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
	private JLabel gameOverLabel;
        private JLabel hiScoreOne;
        private JLabel hiScoreTwo;
        private JLabel hiScoreThree;
        private JLabel hiScoreFour;
        private JLabel hiScoreFive;
        private JLabel hiScoreSix;
        private JLabel hiScoreSeven;
        private JLabel hiScoreEight;
        private JLabel hiScoreNine;
        private JLabel tempHiScoreName;
        private JLabel tempNumber;
        private String tempString;
        private String tempScore;
        private JLabel tempHiScore;
        
        
	private JTextArea questionText;				// text area to display question
	//private JLabel nameIn;
	//private int counter;
	private DatabaseConnection myConnection;
        private JLabel[] highScores;
        
        Statement stmt;
        String sql;
        ResultSet results;
	

	/**	
	* Initialize the GUI applet and updates each question
	*/
	@Override
	public void init()
	 {	
		// Mechanics
                DatabaseConnection.establishConnection();
		gameQuestionBank = new QuestionBank();
		gamePlayer = new Player();
		gamePlayer.setPlayerName( (String)JOptionPane.showInputDialog("Enter your name") );
		questionIndex = 0;
		positionOfFinalAnswer = NO_ANSWER;
		isPlaying = true;
                highScores = new JLabel[10];
		
		questionPanel = new JPanel();						// create panels
		infoPanel = new JPanel();
		titlePanel = new JPanel();
		fanswerPanel = new JPanel();
		frameLayout = new BorderLayout();
                resetLayout = new FlowLayout();
                resetButton = new JButton( "Reset Game?");
                resetButton.addActionListener(this);
                tempHiScoreName = new JLabel("");
                tempHiScoreName.setForeground( Color.GREEN );
                tempHiScoreName.setBackground( Color.BLACK );
                tempHiScore = new JLabel("");
                tempHiScore.setForeground( Color.GREEN );
                tempHiScore.setBackground( Color.BLACK );
                tempNumber = new JLabel("");
                
		
		endScreen = new JPanel();
                gameOver = new JPanel();
                resetPanel = new JPanel();
                resetLayout.setAlignment( FlowLayout.CENTER );
                resetPanel.setLayout( resetLayout );
                gameOver.setBackground( Color.BLACK );               
                hiScores = new JPanel();
                hiScores.setBackground( Color.BLACK );
		endScreen.setBackground( Color.BLACK );
                resetPanel.setBackground( Color.BLACK );
		endScreenLayout = new BorderLayout();
                gameOverLayout = new FlowLayout();
                gameOverLayout.setAlignment( FlowLayout.CENTER );
                hiScoreLayout = new GridLayout( 10, 3 );
                endScreen.setLayout( endScreenLayout );
                gameOver.setLayout( gameOverLayout );
                hiScores.setLayout (hiScoreLayout );
		gameOverLayout.setAlignment( FlowLayout.CENTER );
		gameOverLabel = new JLabel( "Game Over" );
		gameOverLabel.setForeground( Color.GREEN );
		gameOverLabel.setBackground( Color.BLACK );
		gameOverLabel.setFont( new Font( "Sanserif", Font.PLAIN, 48) );
                gameOver.add( gameOverLabel );
                resetPanel.add( resetButton );
                
		//add( gameOver, endScreenLayout.NORTH );
                //add( hiScores, endScreenLayout.CENTER );
                //add( rese)
               

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
		playerName = new JLabel( "Player: " + gamePlayer.getName() );	
		//nameIn = new JLabel( gamePlayer.getName() );
		score = new JLabel( "Score: " + gamePlayer.getScore() );
		
		//nameIn.setForeground( Color.RED );
		//nameIn.setFont(new Font("Monospaced", Font.BOLD, 14));
		playerName.setForeground( Color.RED );
		playerName.setFont(new Font("Monospaced", Font.BOLD, 14));
		score.setForeground( Color.RED );
				
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
		
		scoreOne = new JLabel( Integer.toString(gameQuestionBank.getQuestionAtPosition(0).getQuestionPointWorth()) );
		scoreTwo = new JLabel( Integer.toString(gameQuestionBank.getQuestionAtPosition(1).getQuestionPointWorth()) );
		scoreThree = new JLabel( Integer.toString(gameQuestionBank.getQuestionAtPosition(2).getQuestionPointWorth()) );
		scoreFour = new JLabel( Integer.toString(gameQuestionBank.getQuestionAtPosition(3).getQuestionPointWorth()) );
		scoreFive = new JLabel( Integer.toString(gameQuestionBank.getQuestionAtPosition(4).getQuestionPointWorth()) );
		scoreSix = new JLabel( Integer.toString(gameQuestionBank.getQuestionAtPosition(5).getQuestionPointWorth()) );
		scoreSeven = new JLabel( Integer.toString(gameQuestionBank.getQuestionAtPosition(6).getQuestionPointWorth()) );
		scoreEight = new JLabel( Integer.toString(gameQuestionBank.getQuestionAtPosition(7).getQuestionPointWorth()) );
		scoreNine = new JLabel( Integer.toString(gameQuestionBank.getQuestionAtPosition(8).getQuestionPointWorth()) );
		
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
                infoPanel.add( score );
		//infoPanel.add( nameIn );
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
			//System.exit(-1);
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
        
        public void highScoreCalculator()
        {
            try
            {
                  stmt = DatabaseConnection.dbConn.createStatement();
		  sql = "INSERT INTO HIGH_SCORES (PLAYER_NUMBER, PLAYER_NAME, PLAYER_SCORE) " +
                        "VALUES (1, '"+gamePlayer.getName()+"', "+gamePlayer.getScore()+")";
                  stmt.execute(sql);
                  
                  sql = "select * from high_scores";
                  results = stmt.executeQuery(sql);
                  
                  int j = 0;
                  while( results.next() && j < MAX_HI_SCORE_LIST)
                  {
                  tempString = results.getString("player_name");
                  tempScore = results.getString("player_score");
                  tempHiScoreName.setText(tempString);
                  tempHiScore.setText( tempScore );
                  hiScores.add(tempHiScoreName);
                  //hiScores.add(tempHiScore);
                  j++;
                     
                  }
            }
            catch( SQLException e)
            {
                e.printStackTrace();
            }
            
        }
	
	/**
	* Resets game play once the game has ended. 
	*/
	public void resetGame()
	{
		// Reset Mechanics
		//counter = 0;
		gameQuestionBank = new QuestionBank();
		gamePlayer = new Player();
                gameOver.setVisible( false );
                hiScores.setVisible( false );
                resetPanel.setVisible( false );
                questionPanel.setVisible( true );
		infoPanel.setVisible( true );
		titlePanel.setVisible( true );
		fanswerPanel.setVisible( true );
		gamePlayer.setPlayerName( (String)JOptionPane.showInputDialog("Enter your name") );
		questionIndex = 0;
		positionOfFinalAnswer = NO_ANSWER;
		playerName.setText("Player: ");
		//nameIn.setText( gamePlayer.getName() );
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
	}
	
        public void colorScore()
        {
            if( questionIndex == 0 )
            {			
                scoreOne.setForeground( Color.BLACK );
                scoreOne.setOpaque(true);
                scoreOne.setBackground( Color.GREEN );
            }
            if( questionIndex == 1 )
            {
                scoreTwo.setForeground( Color.BLACK );
                scoreTwo.setOpaque(true);
                scoreTwo.setBackground( Color.GREEN );
            }
            if( questionIndex == 2 )			
            {
                scoreThree.setForeground( Color.BLACK );
                scoreThree.setOpaque(true);
                scoreThree.setBackground( Color.GREEN );
            }
            if( questionIndex == 3 )		
            {
                scoreFour.setForeground( Color.BLACK );
                scoreFour.setOpaque(true);
                scoreFour.setBackground( Color.GREEN );
            }
            if( questionIndex == 4 )			
            {
                scoreFive.setForeground( Color.BLACK );
                scoreFive.setOpaque(true);
                scoreFive.setBackground( Color.GREEN );
            }
            if( questionIndex == 5 )			
            {
                scoreSix.setForeground( Color.BLACK );
                scoreSix.setOpaque(true);
                scoreSix.setBackground( Color.GREEN );
            }
            if( questionIndex == 6 )			
            {
                scoreSeven.setForeground( Color.BLACK );
                scoreSeven.setOpaque(true);
                scoreSeven.setBackground( Color.GREEN );
            }
            if( questionIndex == 7 )			
            {
                scoreEight.setForeground( Color.BLACK );
                scoreEight.setOpaque(true);
                scoreEight.setBackground( Color.GREEN );
            }
            if( questionIndex == 8 )			
            {
                scoreNine.setForeground( Color.BLACK );
                scoreNine.setOpaque(true);
                scoreNine.setBackground( Color.GREEN );
            }
        }
        
	public void endGame ()
	{
                highScoreCalculator();
		isPlaying = false;
		questionPanel.setVisible( false );
		infoPanel.setVisible( false );
		titlePanel.setVisible( false );
		fanswerPanel.setVisible( false );
		//add( endScreen, FlowLayout.CENTER );
		//endScreen.setVisible( true );
                add( gameOver, frameLayout.NORTH );
                add( hiScores, frameLayout.CENTER );
                add( resetPanel, frameLayout.SOUTH );
                gameOver.setVisible( true );
                hiScores.setVisible( true );
                resetPanel.setVisible( true );
                // Update Highscores
                myConnection.closeConnection();
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
					//counter++;
                                        colorScore();
					JOptionPane.showMessageDialog(null, "Correct!");  // correct answer
					repaint();
				}
				else
				{
                                    //counter++;
                                    JOptionPane.showMessageDialog(null, "Incorrect.");
                                    //repaint();
					/*int choice = JOptionPane.showConfirmDialog(null, "Wrong Answer, Game Over.", "Restart?", JOptionPane.YES_NO_OPTION);
					if (choice == JOptionPane.OK_OPTION)
					{
						resetGame();
					}
					else
					{
						endGame();
					}*/
				}
				
				if( questionIndex < gameQuestionBank.NUMBER_OF_QUESTIONS-1 )  // check max number of questions
				{
					questionIndex++;
					updateQuestion();
				}
				else
				{
					/*int choice = JOptionPane.showConfirmDialog(null, "Game Over.", "Restart?", JOptionPane.YES_NO_OPTION);
					if (choice == JOptionPane.OK_OPTION)
					{
						resetGame();
					}
					else
					{       */
						endGame();	
					//}
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
                else if ( e.getSource() == resetButton)
                {
                   resetGame();
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