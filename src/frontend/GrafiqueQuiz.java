package frontend;



import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import DAO.Question;

public class GrafiqueQuiz {
	private static int score1;
	public int getScore1() {
		return score1;
	}

	private long timeElapsed;
	private boolean fait = false;
	private int nbreQuestions;
	Scanner clavier = new Scanner(System.in);

	public GrafiqueQuiz(int nbreQuestion) {
		nbreQuestions = nbreQuestion;
	}

	public void start() {
		
		try {
			long startTime = System.currentTimeMillis();
			for (Question question : generate(nbreQuestions)) {
				String userAnswer = JOptionPane.showInputDialog(null, question.getText());

				if (userAnswer.equalsIgnoreCase(question.getReponse())) {
					score1++;
					JOptionPane.showMessageDialog(null, "Bonne Reponse");
				} else {
					JOptionPane.showMessageDialog(null, "Mauvaise Reponse");
					JOptionPane
							.showMessageDialog(null, "la bonne reponse etait: "
									+ question.getReponse());
				}
			}
			fait = true;
			long endTime = System.currentTimeMillis();
			timeElapsed = endTime - startTime;
		} catch (IllegalArgumentException e) {
			fait = false;
			System.out.println(e.getMessage());
		}

	}

	private int getTimeElapsedInSeconds(long timeInMilliSeconds) {
		// TODO Auto-generated method stub
		return (int) (timeInMilliSeconds / 1000);
	}

	public void displayResultats() {
		if (fait) {
			displayScore();
			displayTimeElapsed();
		}
	}

	private void displayTimeElapsed() {
		JOptionPane
				.showMessageDialog(
						null,
						String.format(
								"Il vous a fallu environ %d secondes pour repondre aux questions",
								getTimeElapsedInSeconds(timeElapsed),
								nbreQuestions));

	}

	private void displayScore() {
		JOptionPane.showMessageDialog(null, String.format(
				"votre score final est de: %d/%d\n ", score1, nbreQuestions));

	}
	public static int redisplayScore() {
		return score1;

	}

	public ArrayList<Question> generate(int nbreQuestions) {
		String[][] data = getData();

		if (nbreQuestions > data.length) {
			throw new IllegalArgumentException("On ne peut generer que: "
					+ data.length + " question maximun");
		}
		ArrayList<Question> questions = new ArrayList<Question>();
		int index;
		ArrayList<Integer> indexesAlreadyTaken = new ArrayList<Integer>();
		indexesAlreadyTaken.clear();

		for (int i = 0; i < nbreQuestions; i++) {
			do {
				Random random = new Random();
				index = random.nextInt(data.length);
			} while (indexesAlreadyTaken.contains(index));
			indexesAlreadyTaken.add(index);
			String pays = data[index][0];
			String capitale = data[index][1];
			String questionText = String.format(
					"Quelle est la capitale de ce pays: %s? ", pays);
			questions.add(new Question(questionText, capitale));
		}

		return questions;

	}

	private static String[][] getData() {
		String[][] data = { { "Senegal", "Dakar" }, { "France", "Paris" },
				{ "Maldives", "Male" }, { "Argentine", "Buenos Aires" },
				{ "Brasil", "brasilia" }, { "Itali", "Rome" },
				{ "Perou", "Lima" }, { "Allemagne", "berlin" },
				{ "Canada", "Otawa" },{ "Russie", "Moscou" }
				,{ "Egypte", "le caire" },{ "Australie", "Canberra" },
				{ "Afrique du sud", "Le cap" },{ "Turquie", "Ankara" }};
		return data;
	}
}
