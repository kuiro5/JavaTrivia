import java.util.*;

public class Player
{
	private String name;
	private int score;

	public Player()
	{
		score = 0;
		name = "";
	}
	
	public void setPlayerName(String name)
	{
		this.name = name;
	}
	
	public void modifyScore(int modAmount)
	{
		score += modAmount;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public String getName()
	{
		return name;
	}
}