/**
* Group Members: Pasquale Domanico, Josh Kuiros
* Section:       2
* Program:       Project Phase 1
* Date:          10/8/2012
*/

import java.util.*;

/**
* The player class represents the person who is answering the questions. It has member variables 
* to record the players name and score. Additionally this class is the interface in which the user will
* interact with the program, by the getPlayerAnswer function.
*
* @author Pasquale Domanico
* @author Josh Kuiros
* @version 1.0 10/8/2012
*/
public class Player
{
	private String name; // string storing the user entered name for identification
	private int score;   // current score of the player

	/**
	* Constructor calls for the user to enter a name
	*/
	public Player()
	{
		score = 0;
		setPlayerName();
	}
	
	/**
	* Setter function for player name, creates a scanner and prompts user for input
	*/
	public void setPlayerName()
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your name: ");
		name = in.nextLine();
	}
	
	/**
	* getPlayerAnswer calls for the user input and returns the chosen answer position
	* @return next integer entered by the user
	*/
	public int getPlayerAnswer()
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your answer (0-3): ");
		return in.nextInt();
	}
	
	/**
	* modifier function that allows us to adjust the score when a player chooses the correct answer
	* or deduct if they choose incorrectly
	*/
	public void modifyScore(int modAmount)
	{
		score += modAmount;
	}
	
	/**
	* Getter function for score
	*/
	public int getScore()
	{
		return score;
	}
}