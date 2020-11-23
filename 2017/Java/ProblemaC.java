package com.company;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int N;
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        input.nextLine();
        System.out.println(TipoPermutacao(Valores(input), N));
    }

    public  static int[] Valores(Scanner input)
    {
        String inputValores;
        String[] resulString;
        int[] result;
        inputValores = input.nextLine();
        input.close();
        resulString = inputValores.split(" ");
        result = new int[resulString.length];

        for(int i = 0; i < resulString.length; i++)
        {
            result[i] =  Integer.parseInt(resulString[i]);
        }

        return result;
    }

    public static String TipoPermutacao(int[] valores, int N)
    {
        for (int i = 0; i < valores.length; i++)
        {
            if(valores[i] > N || valores[i] < 1)
            {
                return "ERRO";
            }
            else
            {
                for(int j = 0; j < i; j++)
                {
                    if(valores[j] == valores[i])
                    {
                        return "ERRO";
                    }
                }
            }
        }

        if(valores[0] == N && valores[(valores.length - 1)] == 1)
        {
            return "PERMUTACAO DECRESCENTE";
        }
        else if(valores[(valores.length - 1)] == N && valores[0] == 1)
        {
            return "PERMUTACAO CRESCENTE";
        }
        else
        {
            return "PERMUTACAO COMUM";
        }
    }
}