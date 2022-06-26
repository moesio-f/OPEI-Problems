/*
Link para questão: https://iudex.io/problem/5b887d473f792000014acefe/statement
*/

import java.util.Scanner;

public class Corrida {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String firstLine = input.nextLine(); //Lê a primeira linha de entrada

        int numberRunners = Integer.parseInt(firstLine.split(" ")[0]); //Obtém o 1 número da 1a linha
        int numberLaps = Integer.parseInt(firstLine.split(" ")[1]); //Obtém o 2 número da 1a linha
        Runner[] runners = new Runner[numberRunners];

        for (int i = 0; i < numberRunners; i++) {
            String info = input.nextLine();
            int[] laps = new int[numberLaps];
            for (int j = 0; j < numberLaps; j++) {
                laps[j] = Integer.parseInt(info.split(" ")[j]);
            }
            runners[i] = new Runner(laps);
        }

        input.close();
        System.out.println(Runner.fastestOf(runners).Identifier());
    }
}

class Runner { //Classe responsável por guardar a informação do aluno que está correndo
    private static int numberOfRunners = 0; //Responsável por identificar o número de corredores
    private int identifier; //Identificação individual de cada aluno (i. e. aluno 1, aluno 2....)
    int[] lapTimes; //Array de inteiro armazenando a velocidade de cada volta
    float averageLap; //O tempo médio para uma volta

    public int Identifier() {
        return identifier;
    }

    private void calculateAverage() { //Método para calcular a média de voltas
        float sum = 0;
        for (int n : lapTimes) {
            sum += n;
        }

        averageLap = sum / lapTimes.length;
    }

    public static Runner fastestOf(Runner[] runners) { //Metódo que retorna o (objeto) corredor mais rápido em uma Array de Corredores
        Runner fastest = runners[0];
        for (int i = 0; i < runners.length; i++) {
            if (runners[i].averageLap < fastest.averageLap) {
                fastest = runners[i];
            }
        }
        return fastest;
    }

    public Runner(int[] lapTimes) { //Construtor da classe
        this.lapTimes = lapTimes;
        numberOfRunners++;
        identifier = numberOfRunners;
        calculateAverage();
    }
}


