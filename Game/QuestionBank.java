import java.io.*;
import java.util.*;

public class QuestionBank
{
	public static final int NUMBER_OF_QUESTIONS = 4;
	private Question[] questionBankArr;
	
	private String tempText;
	private String[] tempAnswerChoices;
	
	private int tempPositionOfCorrectAnswer;
	private int tempDifficulty;    
    
	public QuestionBank()
	{
		questionBankArr = new Question[NUMBER_OF_QUESTIONS];
		
		//File inFile = new File("P:\\java\\questions.txt");
		File inFile = new File("questions.txt");
		try
		{
			Scanner in = new Scanner(inFile);
			
			int i=0;
			while(in.hasNext() && i<NUMBER_OF_QUESTIONS)
			{
				tempText = in.nextLine();
				tempDifficulty = Integer.parseInt(in.nextLine());
				tempPositionOfCorrectAnswer = Integer.parseInt(in.nextLine());
				tempAnswerChoices = new String[4];
				for(int j=0; j<4; j++)
					tempAnswerChoices[j] = in.nextLine();
					
				questionBankArr[i++] = new Question(tempText, tempAnswerChoices, tempPositionOfCorrectAnswer, tempDifficulty);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error Loading Questions");
			System.exit(-1);
		}
	}
	
	public int getNumberOfQuestions()
	{
		return questionBankArr.length;
	}
	
	public Question getQuestionAtPosition(int i)
	{
		if( i >= 0 && i < NUMBER_OF_QUESTIONS )
			return questionBankArr[i];
		else
			return questionBankArr[0];
	}
}