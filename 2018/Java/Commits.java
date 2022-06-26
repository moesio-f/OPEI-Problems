/*
 * Link para questão: https://iudex.io/problem/5b8876ac3f792000014aceb9/statement
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Commits {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int infoPerCommit = 6;

		String firstLine = input.nextLine();
		int numberOfCommits = Integer.parseInt(firstLine);

		for (int i = 0; i < numberOfCommits; i++) {
			String identifier = "", name = "", email = "", date = "", time = "", message = "";
			for (int j = 0; j < infoPerCommit; j++) {
				String nextLine = input.nextLine();
				switch (j) {
					case 0:
						identifier = nextLine;
						break;
					case 1:
						name = nextLine;
						break;
					case 2:
						email = nextLine;
						break;
					case 3:
						date = nextLine;
						break;
					case 4:
						time = nextLine;
						break;
					case 5:
						message = nextLine;
						break;
				}
			}
			new Commit(identifier, name, email, date, time, message);
		}

		String nextLine = input.nextLine();
		int numberOfChecks = Integer.parseInt(nextLine);
		for (int i = 0; i < numberOfChecks; i++) {
			String prefix = input.nextLine();
			Commit.findCommitAndPrint(prefix);
			System.out.println();
		}

		input.close();
	}
}


class Commit { // Classe responsável por armazenar um Commit
	static List<Commit> commits = new ArrayList<>(); // Uma lista estática contendo todos os commits
														// que foram realizados
	private String identifier, name, email, date, time, message; // Componentes de um commit

	public void printCommit() { // Metódo para imprimir um commit na estrutura correta
		String toPrint = "commit " + identifier + "\nAutor: " + name + " <" + email + ">"
				+ "\nData: " + date + " " + time + "\n" + message;
		System.out.println(toPrint);
	}

	public static void findCommitAndPrint(String prefix) { // Metódo responsável por encontrar o
															// commit e imprimir na tela
		Commit target = null; // Inicializando como null pra não der erro mais na frente XD
		int matches = 0;
		for (int i = 0; i < commits.size(); i++) {
			if (commits.get(i).identifier.startsWith(prefix)) { // Percorrendo todos os commits
																// existentes e verificando se o
																// commit em i tem o prefixo
				target = commits.get(i);
				matches++; // Só pra saber quantos commits podem ser identificados com o prefix
			}
		}

		if (matches > 1) {
			System.out.println("!!! CONFLITO !!!");
		} else if (matches == 1) {
			target.printCommit();
		} else {
			System.out.println("??? 404 ???");
		}
	}

	public Commit(String identifier, String name, String email, String date, String time,
			String message) {
		this.identifier = identifier;
		this.name = name;
		this.email = email;
		this.date = date;
		this.time = time;
		this.message = message;

		commits.add(this);
	}
}
