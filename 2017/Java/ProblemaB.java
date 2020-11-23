/*
Link para questão: https://iudex.io/problem/5b157dc3f5f48c0001cfcb7d/statement
*/


import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DecimalFormat decimal =  new DecimalFormat("0.00");
        double lado;
        double sqrt3 = Math.sqrt(3);
        double sqrt6 = Math.sqrt(6);
        double sqrt2 = Math.sqrt(2);

        Scanner input = new Scanner(System.in);
        lado = Double.parseDouble(input.nextLine());
        input.close();

        System.out.println(decimal.format((lado * sqrt6) / 3) + " " + decimal.format(lado * lado * sqrt3) + " " + decimal.format((lado * lado * lado * sqrt2) / 12));
    }

}