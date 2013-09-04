/**
* Group Members: Pasquale Domanico, Josh Kuiros
* Section:       2
* Program:       Project Phase 1
* Date:          10/8/2012
*/

public class ProjectTestDriver
{
	public static void main(String[] args)
	{
		// Create question bank and player
		QuestionBank questions = new QuestionBank();
		Player player1 = new Player();
		
		// Create Game Object
		Game myGame = new Game(player1,questions);
		
		// Execute the Game Loop
		myGame.run();
	}
}