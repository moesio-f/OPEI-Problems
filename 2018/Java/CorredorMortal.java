/*
 * Link para questão: https://iudex.io/problem/5b887b5a3f792000014aceed/statement
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CorredorMortal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int shield = Integer.parseInt(input.nextLine().split(" ")[0]);
        String path = input.nextLine();
        Path way = new Path(path, shield);
        input.close();
        way.canSheGo();
    }
}


class Path { // Clase que armazena o caminho a ser percorrido
    private String path; // String com o próprio caminho
    private char[] pathPositions; // Cada caracter e sua posição
    private int simonePos, objectPos, shields, barriersOnWay = 0; // Posição de simone, posição do
                                                                  // objeto, quantidade de escudos e
                                                                  // quantidade de obstáculos no
                                                                  // caminho
    private List<Integer> barrierPos = new ArrayList<>(); // Array que armazena as posições dos
                                                          // obstáculos

    public void canSheGo() { // Metódo que imprime na tela se ela consegue ou não
        if (shields >= barriersOnWay) {
            System.out.println("S");
        } else {
            System.out.println("N");
        }
    }

    private void findOnWay() { // Metódo que define quantas barreiras estão no caminho
        if (objectPos > simonePos) { // Primeiro caso, a simone tem que ir pra "frente"
            for (int pos : barrierPos) {
                if (pos > simonePos && pos < objectPos) {
                    barriersOnWay++;
                }
            }
        } else { // Segundo caso, a simone tem que ir pra "trás"
            for (int pos : barrierPos) {
                if (pos < simonePos && pos > objectPos) {
                    barriersOnWay++;
                }
            }
        }
    }

    private void findPositions() { // Metódo que obtém as posições de cada um
        for (int i = 0; i < pathPositions.length; i++) {
            if (pathPositions[i] == 'S') {
                simonePos = i;
            } else if (pathPositions[i] == 'B') {
                objectPos = i;
            } else if (pathPositions[i] == '/') {
                barrierPos.add(i);
            }
        }
    }

    public Path(String path, int shields) { // Construtor da classe
        this.path = path;
        this.shields = shields;
        this.pathPositions = this.path.toCharArray();
        findPositions();
        findOnWay();
    }

}
