import java.text.DecimalFormat;
import java.util.Scanner;

public class ProblemaE {
    public static void main(String[] args) {
        DecimalFormat format = new DecimalFormat("0.00");
        Scanner input = new Scanner(System.in);

        String line;
        String[] splitted;
        int n, m;
        int it;
        int x1, y1, x2, y2;

        line = input.nextLine();
        splitted = line.split(" ");

        n = Integer.parseInt(splitted[0]);
        m = Integer.parseInt(splitted[1]);
        Board board = new Board(n, m);

        line = input.nextLine();
        it = Integer.parseInt(line);

        for (int i = 0; i < it; i++) {
            line = input.nextLine();
            splitted = line.split(" ");

            x1 = Integer.parseInt(splitted[0]) - 1;
            y1 = Integer.parseInt(splitted[1]) - 1;
            x2 = Integer.parseInt(splitted[2]) - 1;
            y2 = Integer.parseInt(splitted[3]) - 1;

            board.removePawns(x1, y1, x2, y2);
        }

        input.close();

        double removed = 100.0*(board.size() - board.nPawns()) / board.size();
        System.out.printf("%s%%\n", format.format(removed));
    }

    /*
     * Essa classe representa um tabuleiro genérico NxM com todas as casas ocupadas por peões.
     * 
     */
    private static class Board {
        // False indica que o peão não foi removido.
        // True indica que o peão foi removido.
        private boolean[][] board;

        // Total de peões atualmente no tabuleiro.
        private int nPawns;

        public Board(int n, int m) {
            this.board = new boolean[n][m];
            this.nPawns = n * m;
        }

        /*
         * Remove todos os peões (x, y) tais que x está em [x1, x2] e y está em [y1, y2].
         * 
         */
        public void removePawns(int x1, int y1, int x2, int y2) {
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    if (!this.board[x][y]) {
                        this.board[x][y] = true;
                        this.nPawns -= 1;
                    }
                }
            }
        }

        public int size() {
            return this.board.length * this.board[0].length;
        }

        public int nPawns() {
            return this.nPawns;
        }
    }
}
