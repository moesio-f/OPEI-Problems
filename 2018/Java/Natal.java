/*
Link para questão: https://iudex.io/problem/5b8889a83f792000014acf2e/statement
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.nextLine();
        String target = input.nextLine().trim();
        input.close();

        int nN = 0, nA = 0, nT = 0, nL = 0; //Quantidade de cada uma das letras
        int numberOfWords = 0;

        char[] chars = target.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
            case 'n':
                nN++;
                break;
            case 'a':
                nA++;
                break;
            case  't':
                nT++;
                break;
            case 'l':
                nL++;
                break;
            }
        }
        //Contador da quantidade de palavras possíveis de formar
        while (nN > 0 && nA > 1 && nT > 0 && nL > 0) {
            nN--;
            nA -= 2;
            nT--;
            nL--;
            numberOfWords++;
        }

        System.out.println(numberOfWords);
    }
}
