package questions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HtmlGenerator {

	public static void generateHtml(String fileName, QuestionInterface questionInterface) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("Questions.html"))) {
			writer.write("<html>");
			writer.newLine();
			writer.write("<head>");
			writer.newLine();
			writer.write("<title>Questions</title>");
			writer.newLine();
			writer.write("</head>");
			writer.newLine();
			writer.write("<body>");
			writer.newLine();

			for (Question question : questionInterface.qList) {
				writer.write("<p>");
				writer.newLine();
				writer.write("Question: " + question.Question);
				writer.newLine();
				writer.write("<br/>");
				writer.write("Options: ");
				writer.write("<br/>");
				for (String option : question.Options) {
					writer.write(option + " ");
				}
				writer.write("<br/>");
				writer.newLine();
				writer.write("Answer: " + question.Answer);
				writer.write("<br/>");
				writer.newLine();
				writer.write("</p>");
				writer.newLine();
			}

			writer.write("</body>");
			writer.newLine();
			writer.write("</html>");
			writer.newLine();

			System.out.println("HTML file generated successfully!");
		} catch (IOException e) {
			System.out.println(e.toString());
			;
		}
	}
}
