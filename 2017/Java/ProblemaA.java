/*
 * Link para questão: https://iudex.io/problem/5b157b73f5f48c0001cfcb6d/statement
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class ProblemaA {

	public static void main(String[] args) {
		DecimalFormat a = new DecimalFormat("0.00");
		float[] notasAlunos;
		float media;
		int numAlunos;
		Scanner input = new Scanner(System.in);
		numAlunos = CheckNumAlunos(1, (int) Math.pow(10, 6), input);
		input.nextLine();
		notasAlunos = NotasAlunos(input);
		media = Media(notasAlunos);
		System.out.println(a.format(PercentAprovados(notasAlunos, media)) + "%");

	}

	public static int CheckNumAlunos(int minValue, int maxValue, Scanner input) {
		int result;
		result = input.nextInt();
		if (result > maxValue || result < minValue) {
			result = CheckNumAlunos(minValue, maxValue, input);
		}
		return result;
	}

	public static float[] NotasAlunos(Scanner input) {
		String inputNotas;
		String[] resulString;
		float[] result;
		inputNotas = input.nextLine();
		resulString = inputNotas.split(" ");
		result = new float[resulString.length];

		for (int i = 0; i < resulString.length; i++) {
			result[i] = Float.parseFloat(resulString[i]);
		}

		return result;
	}

	public static float Media(float[] notas) {
		float media = 0;
		for (int i = 0; i < notas.length; i++) {
			media += notas[i];
		}

		return (media / notas.length);
	}

	public static float PercentAprovados(float[] notas, float media) {
		float percent = 0;
		for (int i = 0; i < notas.length; i++) {
			if (notas[i] >= media) {
				percent += 1;
			}
		}
		return ((percent / notas.length) * 100f);
	}


}
