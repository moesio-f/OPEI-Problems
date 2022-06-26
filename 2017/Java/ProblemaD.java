/*
 * Link para questão: https://iudex.io/problem/5b158290f5f48c0001cfcba9/statement
 */


import java.util.Scanner;

public class ProblemaD {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = Integer.parseInt(input.nextLine());
        String original = input.nextLine();
        input.close();

        ROTN rot = new ROTN(N, original);
    }
}


class ROTN {
    static char[] alphabet = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    int N;
    String original, ciphered;
    char[] originalChars, cipheredChars;

    private void printCipher() {
        System.out.println(ciphered);
    }

    private void setCiphered() {
        originalChars = original.toCharArray();
        cipheredChars = new char[originalChars.length];
        ciphered = "";

        for (int i = 0; i < originalChars.length; i++) {
            cipheredChars[i] += getNewChar(originalChars[i]);
        }
        for (char ch : cipheredChars) {
            ciphered += Character.toString(ch);
        }

        printCipher();
    }

    private char getNewChar(char ch) {
        boolean isUpper = Character.isUpperCase(ch);
        char upper = Character.toUpperCase(ch);
        for (int i = 0; i < alphabet.length; i++) {
            if (upper == alphabet[i]) {
                if (isUpper) {
                    return alphabet[(i + N) % alphabet.length];
                } else {
                    return Character.toLowerCase(alphabet[(i + N) % alphabet.length]);
                }
            }
        }
        return ch;
    }

    public ROTN(int N, String original) {
        this.N = N;
        this.original = original;
        setCiphered();
    }
}
