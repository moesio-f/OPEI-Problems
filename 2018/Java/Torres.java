/*
Link para questão: https://iudex.io/problem/5b8899763f792000014acf69/statement
*/

import java.util.Scanner;

public class Torres {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String[] data = input.nextLine().trim().split(" ");
        input.close();

        Tower.buildTime = Integer.parseInt(data[2]);
        Tower ruy = new Tower(Integer.parseInt(data[3]), Integer.parseInt(data[0]));
        Tower leonardo = new Tower(Integer.parseInt(data[4]), Integer.parseInt(data[1]));
        System.out.println(ruy.heightAfterBuild() + " " + leonardo.heightAfterBuild());
    }
}
class Tower {
    static int buildTime;
    int rate, startHeight;

    public int heightAfterBuild() {
        return  startHeight + (buildTime * rate);
    }

    public Tower(int rate, int startHeight) {
        this.rate = rate;
        this.startHeight = startHeight;
    }
}
