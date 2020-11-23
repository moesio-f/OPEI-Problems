/*
 *Edjair é um aluno que ama praticar esportes. A sua professora de educação física sempre promove diversas atividades para os alunos e uma delas é verificar qual é o atleta mais rápido da turma de Edjair.
 * Para isso, a professora separou uma aula para que todos os alunos percorressem um circuito com várias voltas e ela cronometraria os tempos de cada volta. No final, o aluno que tiver percorrido no menor tempo será o vencedor.
 * Todos alunos possuem tempo total de corrida distintos, logo garante-se que há um único vencedor.
 *
 * A primeira linha da entrada consiste em dois inteiros N e M representando o número de alunos e o número de voltas que eles darão, respectivamente.
 * Seguem N linhas, cada uma representando um competidor (i.e. a 1ª linha representa o competidor 1, a 2ª linha representa o competidor 2, e a N-ésima linha representa o competidor N).
 * Cada uma das N linhas contém M inteiros T, representando os tempos obtidos em cada volta da corrida (i.e. o 1º inteiro T é o tempo da 1ª volta, o 2º inteiro T é o tempo da 2ª volta, e o M-ésimo inteiro T é o tempo da M-ésima volta).
 *
 * A saída consiste de um único inteiro, que corresponde ao número do aluno mais rápido.
 */

package com.moesiof.opei2019;

import java.util.Scanner;

public class Corrida
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        String firstLine = input.nextLine(); //Lê a primeira linha de entrada

        int numberRunners = Integer.parseInt(firstLine.split(" ")[0]); //Obtém o 1 número da 1a linha
        int numberLaps = Integer.parseInt(firstLine.split(" ")[1]); //Obtém o 2 número da 1a linha
        Runner[] runners = new Runner[numberRunners];

        for(int i = 0; i < numberRunners; i++)
        {
            String info = input.nextLine();
            int[] laps = new int[numberLaps];
            for(int j = 0; j < numberLaps; j++)
            {
               laps[j] = Integer.parseInt(info.split(" ")[j]);
            }
            runners[i] = new Runner(laps);
        }

        input.close();
        System.out.println(Runner.fastestOf(runners).Identifier());
    }
}

class Runner //Classe responsável por guardar a informação do aluno que está correndo
{
    private static int numberOfRunners = 0; //Responsável por identificar o número de corredores
    private int identifier; //Identificação individual de cada aluno (i. e. aluno 1, aluno 2....)
    int[] lapTimes; //Array de inteiro armazenando a velocidade de cada volta
    float averageLap; //O tempo médio para uma volta

    public int Identifier()
    {
        return identifier;
    }

    private void calculateAverage() //Método para calcular a média de voltas
    {
        float sum = 0;
        for(int n : lapTimes)
        {
            sum += n;
        }

        averageLap = sum/lapTimes.length;
    }

    public static Runner fastestOf(Runner[] runners) //Metódo que retorna o (objeto) corredor mais rápido em uma Array de Corredores
    {
        Runner fastest = runners[0];
        for(int i = 0; i < runners.length; i++)
        {
            if(runners[i].averageLap < fastest.averageLap)
            {
                fastest = runners[i];
            }
        }
        return fastest;
    }

    public Runner(int[] lapTimes) //Construtor da classe
    {
        this.lapTimes = lapTimes;
        numberOfRunners++;
        identifier = numberOfRunners;
        calculateAverage();
    }
}


