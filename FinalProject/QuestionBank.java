import java.io.*;
/**
* Group Members: Pasquale Domanico, Josh Kuiros
* Section:       2
* Program:       Project Phase 1
* Date:          10/8/2012
*/

import java.util.*;

/**
* The question bank class contains all the questions that will be asked in our game. It has-a 
* relationship with Question through the questionBankArray. QuestionBank is also resonsible for
* reading the question from a file (eventually from a database in the future), and creating each
* question object from that file.
*
* @author Pasquale Domanico
* @author Josh Kuiros
* @version 1.0 10/8/2012 
*/
public class QuestionBank
{
	private static final int NUMBER_OF_QUESTIONS = 3; // the total number of questions to ask the player
	private Question[] questionBankArr;               // the array of Question objects
	
	// Temporary member variables used for reading information from the file and writing into the 
	//  question class
	private String tempText;
	private String[] tempAnswerChoices;
	private int tempPositionOfCorrectAnswer;
	private int tempDifficulty;    
    
	/**
	* Constructor creates and array or questions, reads the lines from a file and finally creates the
	* question based on the file data.
	* POST: questionBankArr is full of populated questions
	*/
	public QuestionBank()
	{
		// Create the array
		questionBankArr = new Question[NUMBER_OF_QUESTIONS];
		
		// Open a file for reading (IST 220)
		File inFile = new File("/Users/JoshuaKuiros/Documents/CMPSC221/FinalProject/questions.txt");
		//File inFile = new File("questions.txt");
		
		try
		{
			Scanner in = new Scanner(inFile);
			
			int i=0;
			// Read from the file
			while(in.hasNext() && i<NUMBER_OF_QUESTIONS)
			{
				tempText = in.nextLine();
				tempDifficulty = Integer.parseInt(in.nextLine());
				tempPositionOfCorrectAnswer = Integer.parseInt(in.nextLine());
				tempAnswerChoices = new String[4];
				// Read the array of answers
				for(int j=0; j<4; j++)
					tempAnswerChoices[j] = in.nextLine();
				
				// Create the question based on all the temporary read ins
				questionBankArr[i++] = new Question(tempText, tempAnswerChoices, tempPositionOfCorrectAnswer, tempDifficulty);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error Loading Questions");
			// End the program if you cannot open the question file
			System.exit(-1);
		}
	}
	
	/**
	* Number of questions getter function
	* @return the number of questions to be asked to the player
	*/
	public int getNumberOfQuestions()
	{
		return questionBankArr.length;
	}
	
	/**
	* This function will retrieve a single question from the question bank array, if the array index i
	* is out of bounds, the defualt is to return the first question
	* @param i is the index of the question that you want to retrieve
	* @return question at position i if i is in the bounds of the array and the first question if not
	*/
	public Question getQuestionAtPosition(int i)
	{
		if( i >= 0 && i < NUMBER_OF_QUESTIONS )
			return questionBankArr[i];
		else
			return questionBankArr[0];
	}
}