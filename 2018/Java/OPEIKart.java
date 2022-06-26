/*
Link para questão: https://iudex.io/problem/5b8895723f792000014acf4e/statement
*/

import java.util.ArrayList;
import java.util.Scanner;

public class OPEIKart {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] firstLine = input.nextLine().split(" ");

		ArrayList<Player> myPlayers = new ArrayList<>();
		for (String str : firstLine) {
			myPlayers.add(new Player(str));
		}

		String[] scoreByPlacing = input.nextLine().split(" ");
		Player.scorePerPlacing = new int[] {Integer.parseInt(scoreByPlacing[0]), Integer.parseInt(scoreByPlacing[1]), Integer.parseInt(scoreByPlacing[2]), Integer.parseInt(scoreByPlacing[3])};

		for (int i = 0; i < 4; i++) {
			String[] nextValues = input.nextLine().split(" ");
			for (int j = 0; j < myPlayers.size(); j++) {
				myPlayers.get(j).addPlacing(Integer.parseInt(nextValues[j]));
			}
		}
		input.close();
		Player.setScores();
		Player.printAll();
	}
}
class Player {
	static private ArrayList<Player> allInstances = new ArrayList<>();
	static int[] scorePerPlacing;
	String name;
	int score = 0;
	ArrayList<Integer> placing = new ArrayList<>();

	public void addPlacing(int place) {
		placing.add(place - 1);
	}

	private void setScore() {
		for (int i = 0; i < placing.size(); i ++) {
			score += scorePerPlacing[placing.get(i)];
		}
	}

	private void print() {
		System.out.println(name + " - " + score);
	}

	public static void setScores() {
		for (Player a : allInstances) {
			a.setScore();
		}
	}

	public static void printAll() {
		for (Player a : allInstances) {
			a.print();
		}
	}

	Player(String name) {
		this.name = name;
		allInstances.add(this);
	}
}