/*
Link para questão: https://iudex.io/problem/5b15a2eaf5f48c0001cfcbd6/statement
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String palavra;
        Scanner input = new Scanner(System.in);
        palavra = input.nextLine();
        input.close();
        System.out.println(Palindromo(palavra));
    }

    public static String Palindromo(String palavra) {
        int correct = 0;

        if (palavra.length() % 2 == 0) {
            for (int i = 0; i < palavra.length(); i++) {
                if (palavra.charAt(i) == palavra.charAt((palavra.length() - 1) - i)) {
                    correct++;
                }
            }
            if (correct == palavra.length()) {
                return "S";
            } else {
                return "N";
            }
        } else {
            for (int i = 0; i < palavra.length(); i++) {
                if (palavra.charAt(i) == palavra.charAt((palavra.length() - 1) - i)) {
                    correct++;
                }
            }
            if (correct == palavra.length()) {
                return "S";
            } else {
                return "N";
            }
        }
    }

}