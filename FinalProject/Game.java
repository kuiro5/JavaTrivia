/**
* Group Members: Pasquale Domanico, Josh Kuiros
* Section:       2
* Program:       Project Phase 1
* Date:          10/8/2012
*/

/**
* The Game class represents an instance of our game. It is initialized with a player and question 
* created in our main function. Its only function (run) is resposible to executing our game loop.
*
* @author Pasquale Domanico
* @author Josh Kuiros
* @version 1.0 10/8/2012
*/
public class Game
{
	private Player gamePlayer;               // our game's current player
	private QuestionBank gameQuestionBank;   // our game's current questions
	
	/**
	* Init-Constructor, initializes player and questions
	*/
	public Game(Player gamePlayer, QuestionBank gameQuestionBank)
	{
		this.gamePlayer = gamePlayer;
		this.gameQuestionBank = gameQuestionBank;
	}
	
	/**
	* The run function is the heart of our game loop. For every question, it will Display it, seek 
	* player input, and adjust players score accordingly.
	*/
	public void run()
	{		
		// GameLoop
		for(int i=0; i<gameQuestionBank.getNumberOfQuestions(); i++)
		{
			// Display Question
			System.out.println("Question " + (i+1) + ":");
			gameQuestionBank.getQuestionAtPosition(i).displayQuestion();
			
			// Get player input
			if( gamePlayer.getPlayerAnswer() == 
			    gameQuestionBank.getQuestionAtPosition(i).getPositionOfCorrectAnswer() )
			{
				gamePlayer.modifyScore( 
				                  gameQuestionBank.getQuestionAtPosition(i).getQuestionPointWorth() );
				System.out.println( "Correct! Current Score: " + gamePlayer.getScore() + "\n" );
			}
			else
			{
				System.out.println( "Incorrect. Current Score: " + gamePlayer.getScore() + "\n");
			}
		}
	}
}