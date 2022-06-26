/*
Link para questão: https://iudex.io/problem/5b15a2eaf5f48c0001cfcbd6/statement
*/

import java.util.Scanner;

public class ProblemaF {
    public static void main(String[] args) {
        String entrada;
        Scanner input = new Scanner(System.in);

        entrada = input.nextLine();
        input.close();
        System.out.println(Resposta(entrada));
    }

    public static long Resposta(String entrada) {
        return valorMaior(entrada) - valorMenor(entrada);
    }

    public static long valorMenor(String value) {
        String res = "";
        char[] edit = value.toCharArray();
        for (int i = 0; i < edit.length; i++) {
            if (edit[i] == '?') {
                if (i == 0) {
                    edit[i] = '1';
                } else {
                    edit[i] = '0';
                }
            }
            res += edit[i];
        }

        return  Long.parseLong(res);
    }

    public static long valorMaior(String value) {
        String res = "";
        char[] edit = value.toCharArray();
        for (int i = 0; i < edit.length; i++) {
            if (edit[i] == '?') {
                edit[i] = '9';
            }
            res += edit[i];
        }
        return  Long.parseLong(res);
    }
}