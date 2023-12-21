package questions;

import java.util.ArrayList;

public class Question 
{
	@SuppressWarnings("unused")
	protected String Question,Answer;
	ArrayList<String> Options=new ArrayList<>();
	Question(String Question,String Answer,String[] opt)
	{
		this.Question=Question;
		this.Answer=Answer;
		Options.add(opt[0]);
		Options.add(opt[1]);
		Options.add(opt[2]);
		Options.add(opt[3]);
	}
	public void getOptions()
	{
		for(String j:Options)
		{
			System.out.println(j);
		}
	}
}
