/*
Link para questão: https://iudex.io/problem/5b8886443f792000014acf1d/statement
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String firstLine = input.nextLine();
        Matriz a = createrNew(Integer.parseInt(firstLine.split(" ")[0]), Integer.parseInt(firstLine.split(" ")[1]), input);

        String secondLine = input.nextLine();
        Matriz b = createrNew(Integer.parseInt(secondLine.split(" ")[0]), Integer.parseInt(secondLine.split(" ")[1]), input);

        input.close();

        if (a.isPossibleMultiplyBy(b)) {
            a.multiplicationBy(b).printMatriz();
        } else {
            System.out.println("-1");
        }
    }

    public static Matriz createrNew(int nRows, int nColumns, Scanner input) {
        Matriz a = new Matriz(nRows, nColumns);
        for (int i = 0; i < nRows; i++) {
            String[] values = input.nextLine().split(" ");
            for (int j = 0; j < values.length; j++) {
                a.setElement(i, j, Integer.parseInt(values[j]));
            }
        }
        return a;
    }
}

class Matriz {
    int numberRows, numberColumns;
    int[][] elements;

    void printMatriz() {
        for (int row = 0; row < numberRows; row++) {
            for (int column = 0; column < numberColumns; column++) {
                System.out.print(elements[row][column]);
                if (column < numberColumns - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

    boolean isPossibleMultiplyBy(Matriz b) {
        if (numberColumns == b.numberRows) {
            return true;
        }

        return false;
    }

    void setElement(int row, int column, int element) {
        elements[row][column] = element;
    }

    private int multiplicatedCollumnBy(Matriz b, int row, int collumn) {
        int sum = 0;
        for (int i = 0; i < numberColumns; i++) {
            sum += elements[row][i] * b.elements[i][collumn];
        }
        return sum;
    }

    Matriz multiplicationBy(Matriz b) {
        if (isPossibleMultiplyBy(b)) {
            Matriz result = new Matriz(numberRows, b.numberColumns);
            for (int row = 0; row < result.numberRows; row++) {
                for (int column = 0; column < result.numberColumns; column++) {
                    int element = multiplicatedCollumnBy(b, row, column);
                    result.setElement(row, column, element);
                }
            }

            return result;
        }

        return null;
    }

    Matriz(int numberRows, int numberColumns) {
        this.numberRows = numberRows;
        this.numberColumns = numberColumns;
        elements = new int[numberRows][numberColumns];
    }
}
