package questions;

import java.util.ArrayList;

public class QuestionInterface {
	protected static ArrayList<Question> qList = new ArrayList<>();;
	public static int cuurentIndex = 0;

	/*
	 * Constructor public QuestionInterface() { qList = new ArrayList<>(); }
	 */
	static String op[] = { "Options1", "Options2", "Options3", "Options4" };
	protected static Question qstn = new Question("Qstion", "Answer", op);

	// Add Question
	public static void addQuestion(String Qstion, String Answer, String[] opt) {

		Question qstn = new Question(Qstion, Answer, opt);
		qList.add(qstn);
		System.out.println("Addition Executed,Size of List : " + qList.size());
		++cuurentIndex;
		System.out.println("Current Index : " + cuurentIndex);

	}

	// Retriving Question
	protected static Question getQuestion() {
		try {
			System.out.println("GetQuestion Executed ");
			System.out.println("Current Index : " + cuurentIndex);
			return qList.get(cuurentIndex);
		} catch (NullPointerException e) {
			System.out.println("No Questions In the List To Display");
		}
		return qstn;
	}
}
