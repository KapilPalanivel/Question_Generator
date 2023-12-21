package questions;

import java.util.ArrayList;

import questions.Question;

@SuppressWarnings("unused")
public class QuestionList 
{
	ArrayList<Question> questionList;
	
	 public QuestionList() 
	 {
	     this.questionList = new ArrayList<>();
	 }
	public void addQuestion(Question qst)
	{
		questionList.add(qst);
	}
}
