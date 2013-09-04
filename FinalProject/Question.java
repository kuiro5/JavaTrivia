/**
* Group Members: Pasquale Domanico, Josh Kuiros
* Section:       2
* Program:       Project Phase 1
* Date:          10/8/2012
*/

/**
* The question class represents a single question within our game. It stores all the information needed
* for one particular question: the question text, 4 answers, difficulty, point value, and the position
* of the correct answer within the answer choice array. A question needs to be initailized with all of
* these values. Also contains a function for displaying the question for the user to read.
* 
* @author Pasquale Domanico
* @author Josh Kuiros
* @version 1.0 10/8/2012
*/
public class Question
{
	private static final int POINTS_PER_QUESTION = 100; // const to define the amount of points worth
	private String text;                                // actual text data for the question
	private String[] answerChoices;                     // text of the answer choices
	private int positionOfCorrectAnswer;                // the array position in answerChoices[]
	private int difficulty;                             // on a level of 1 to (TBA) difficulty scale
	private int pointWorth;                             // point worth based on difficulty
	
	/**
	* Init constructor intialized the question with everything it needs. And calculates the point worth
	* based on difficulty
	* @param text is the actual text of the question
	* @param answerChoices is an array of size 4 that holds the choices to the question
	* @param positionOfCorrectAnswer is index (in answerChoices array) of the correct answer 
	* @param difficulty is the level of difficulty (used for calculating the point worth)
	*/
	public Question(String text, String[] answerChoices, int positionOfCorrectAnswer, int difficulty)
	{
		this.text = text;
		this.answerChoices = answerChoices;
		this.positionOfCorrectAnswer = positionOfCorrectAnswer;
		this.difficulty = difficulty;
		pointWorth = difficulty*POINTS_PER_QUESTION;
	}
	
	/**
	* Displays the question and its choices for the player to read
	*/
	public void displayQuestion()
	{
		System.out.println(text);
		for(String curr : answerChoices)
			System.out.println(" " + curr);
	}
	
	/**
	* Question text getter function
	* @return String containing the text of the question
	*/
	public String getQuestionText()
	{
		return text;
	}
	
	/**
	* Answer choices getter function
	* @return array of strings containing the possible answers to the question
	*/
	public String[] getAnswerChoices()
	{
		return answerChoices;
	}
	
	/**
	* Correct Answer getter function
	* @return the index (in the answer choices array) of which contains the correct answer
	*/
	public int getPositionOfCorrectAnswer()
	{
		return positionOfCorrectAnswer;
	}
	
	/**
	* Difficulty getter function
	* @return level of difficulty of the question
	*/
	public int getQuestionDifficulty()
	{
		return difficulty;
	}
	
	/**
	* Point worth getter function
	* @return the point value of the question
	*/
	public int getQuestionPointWorth()
	{
		return pointWorth;
	}
}