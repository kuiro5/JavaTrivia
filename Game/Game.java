/*
public class Game
{
	private Player gamePlayer;
	private QuestionBank gameQuestionBank;
	
	public Game(Player gamePlayer, QuestionBank gameQuestionBank)
	{
		this.gamePlayer = gamePlayer;
		this.gameQuestionBank = gameQuestionBank;
	}
	
	public void run()
	{		
		// GameLoop
		for(int i=0; i<gameQuestionBank.getNumberOfQuestions(); i++)
		{
			// Display Question
			System.out.println("Question " + (i+1) + ":");
			gameQuestionBank.getQuestionAtPosition(i).displayQuestion();
			
			// Get player input
			if( gamePlayer.getPlayerAnswer() == gameQuestionBank.getQuestionAtPosition(i).getPositionOfCorrectAnswer() )
			{
				gamePlayer.modifyScore( gameQuestionBank.getQuestionAtPosition(i).getQuestionPointWorth() );
				System.out.println( "Correct! Current Score: " + gamePlayer.getScore() + "\n" );
			}
			else
			{
				System.out.println( "Incorrect. CurrentScore: " + gamePlayer.getScore() + "\n");
			}
		}
	}
}
*/