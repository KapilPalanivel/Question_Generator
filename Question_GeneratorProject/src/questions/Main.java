package questions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import questions.Question;
import questions.QuestionInterface;
import questions.HtmlGenerator;

@SuppressWarnings("unused")
public class Main {
	protected static QuestionInterface Ques;

	Main() {
		Ques = new QuestionInterface();
	}

	static boolean check = false;
	static String currQuestion = "";
	static String Option1 = "";
	static String Option2 = "";
	static String Option3 = "";
	static String Option4 = "";
	static String Answer = "";

	static JTextField questionField;
	static JTextField option1, option2, option3, option4;
	static JTextField answerField;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Question Interface");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		// Question Panel
		JPanel questionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel questionLabel = new JLabel("Enter The Question:");
		questionField = new JTextField(currQuestion, 20);
		questionPanel.add(questionLabel);
		questionPanel.add(questionField);

		// Options Panel
		JPanel optionsPanel = new JPanel(new GridLayout(4, 1));
		option1 = new JTextField(Option1);
		option2 = new JTextField(Option2);
		option3 = new JTextField(Option3);
		option4 = new JTextField(Option4);
		optionsPanel.add(option1);
		optionsPanel.add(option2);
		optionsPanel.add(option3);
		optionsPanel.add(option4);

		// Answer Panel
		JPanel answerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel answerLabel = new JLabel("Enter The Answer:");
		answerField = new JTextField(Answer, 10);
		answerPanel.add(answerLabel);
		answerPanel.add(answerField);

		// Buttons
		JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton previousButton = new JButton("Previous");
		JButton nextButton = new JButton("Next");
		JButton generateButton = new JButton("Generate HTML");

		buttonsPanel.add(previousButton);
		buttonsPanel.add(nextButton);
		buttonsPanel.add(generateButton);

		// Adding components to the Main
		mainPanel.add(questionPanel);
		mainPanel.add(optionsPanel);
		mainPanel.add(answerPanel);
		mainPanel.add(buttonsPanel);
		frame.getContentPane().add(mainPanel);
		frame.setSize(400, 300);
		frame.setVisible(true);

		// Functions For Button Clicks
		generateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HtmlGenerator.generateHtml("questions.html", Ques);
			}
		});
		previousButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Ques.cuurentIndex > 0) {
					--Ques.cuurentIndex;
					System.out.println(Ques.cuurentIndex);
					displayQuestion();
					check = true;
					if (Ques.cuurentIndex < 0)
						Ques.cuurentIndex = 0;
				} else
					System.out.println(0);

			}
		});
		nextButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Ques.cuurentIndex < Ques.qList.size() - 1) {
					Ques.cuurentIndex++;
					System.out.println(Ques.cuurentIndex);
					displayQuestion();
					System.out.println("Previous Question Retrived");
				} else {
					String Quest = questionField.getText();
					if (!Quest.equals("") && !check) {
						String Answer = answerField.getText();
						String[] opt = { option1.getText(), option2.getText(), option3.getText(), option4.getText() };
						Ques.addQuestion(Quest, Answer, opt);
						System.out.println("New Question Added");
					} else
						System.out.println("Not Added");
					check = false;
					questionField.setText("");
					answerField.setText("");
					option1.setText("");
					option2.setText("");
					option3.setText("");
					option4.setText("");
				}
			}
		});
	}

	private static void displayQuestion() {
		Question dis = Ques.getQuestion();
		questionField.setText(dis.Question);
		option1.setText(dis.Options.get(0));
		option2.setText(dis.Options.get(1));
		option3.setText(dis.Options.get(2));
		option4.setText(dis.Options.get(3));
		answerField.setText(dis.Answer);
	}
}
