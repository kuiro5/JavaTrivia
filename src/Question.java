public class Question
{
	private final int POINTS_PER_QUESTION = 100;
	protected String text;                 // actual text data for the question
	protected String[] answerChoices;      // text of the answer choices
	protected int positionOfCorrectAnswer; // we can use an for the array position in answerChoices[]
	protected int difficulty;              // on a level of 1 to (TBA) difficulty scale
	private int pointWorth;            // point worth based on difficulty and time (time not
                                         //  implemented yet, but I guess it would have to be passed 
										 //  in this class) protected for BonusQuestion Class
	
	public Question(String text, String[] answerChoices, int positionOfCorrectAnswer, int difficulty)
	{
		this.text = text;
		this.answerChoices = answerChoices;
		this.positionOfCorrectAnswer = positionOfCorrectAnswer;
		this.difficulty = difficulty;
		pointWorth = difficulty*POINTS_PER_QUESTION;
	}
	
	public void displayQuestion()
	{
		System.out.println(text);
		for(String curr : answerChoices)
			System.out.println(" " + curr);
        }
	
	/**
	* GETTER FUNCTIONS
	*/
	// Question text getter
	public String getQuestionText()
	{
		return text;
	}
	
	// Answer getter
	public String[] getAnswerChoices()
	{
		return answerChoices;
	}
	
	// Position of correct answer getter
	public int getPositionOfCorrectAnswer()
	{
		return positionOfCorrectAnswer;
	}
	
	// difficulty getter
	public int getQuestionDifficulty()
	{
		return difficulty;
	}
	
	// point worth getter
	public int getQuestionPointWorth()
	{
		return pointWorth;
	}
}

