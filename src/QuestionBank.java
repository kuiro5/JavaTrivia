import java.io.*;
import java.util.*;
import java.sql.*;

public class QuestionBank
{
	public static final int NUMBER_OF_QUESTIONS = 9;
	private Question[] questionBankArr;
	
	private String tempText;
	private String[] tempAnswerChoices;
	
	private int tempPositionOfCorrectAnswer;
	private int tempDifficulty;    
        
        Statement stmt;
        String sql;
        ResultSet results;
        
    
	public QuestionBank()
	{
		questionBankArr = new Question[NUMBER_OF_QUESTIONS];
		

		try
		{
                        stmt = DatabaseConnection.dbConn.createStatement();
			sql = "select * from question_bank";
                        results = stmt.executeQuery(sql);
			
			int i=0;
			while(results.next() && i<NUMBER_OF_QUESTIONS)
			{
				tempText = results.getString( "text" );
				tempDifficulty = results.getInt( "difficulty" );
				tempPositionOfCorrectAnswer = results.getInt("correct_answer");
				tempAnswerChoices = new String[4];
                            	tempAnswerChoices[0] = results.getString("answer_a");
                                tempAnswerChoices[1] = results.getString("answer_b");
                                tempAnswerChoices[2] = results.getString("answer_c");
                                tempAnswerChoices[3] = results.getString("answer_d");
                                        
					
				questionBankArr[i++] = new Question(tempText, tempAnswerChoices, tempPositionOfCorrectAnswer, tempDifficulty);
			}
                        
                        //System.out.println("i is: " + Integer.toString(i));
                        results.close();
                        stmt.close();
         
		}
		catch(SQLException e)
		{
                    e.printStackTrace();
                    //System.exit(-1);
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