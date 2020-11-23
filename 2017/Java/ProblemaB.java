package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        DecimalFormat decimal =  new DecimalFormat("0.00");
        double lado;
        double r3 = Math.sqrt(3);
        double r6 = Math.sqrt(6);
        double r2 = Math.sqrt(2);

        Scanner input = new Scanner(System.in);
        lado = Double.parseDouble(input.nextLine());
        input.close();

        System.out.println( decimal.format((lado*r6)/3) + " " + decimal.format(lado*lado*r3) + " " + decimal.format((lado*lado*lado*r2)/12));
    }

}