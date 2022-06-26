import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProblemaI {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String line;
        String[] splitted;
        int n;

        line = input.nextLine();
        splitted = line.split(" ");

        n = Integer.parseInt(splitted[0]);
        Costumer[] costumers = new Costumer[n];

        for (int i = 0; i < n; i++) {
            line = input.nextLine();
            splitted = line.split(" ");
            costumers[i] = new Costumer(Integer.parseInt(splitted[0]),
                    Integer.parseInt(splitted[1]), Operation.fromString(splitted[2]));
        }

        Arrays.sort(costumers);
        String answer = Arrays.stream(costumers).map(c -> Integer.toString(c.id))
                .collect(Collectors.joining(" "));
        System.out.println(answer);

        input.close();

    }

    private static enum Operation {
        BUY, REPAIR;

        static Operation fromString(String str) {
            if (str.equals("0")) {
                return BUY;
            }

            return REPAIR;
        }
    }

    private static class Costumer implements Comparable<Costumer> {
        private int id;
        private int products;
        private Operation operation;

        public Costumer(int id, int products, Operation operation) {
            this.id = id;
            this.products = products;
            this.operation = operation;
        }

        public int timeUnits() {
            return this.products * (this.operation == Operation.REPAIR ? 2 : 1);
        }

        @Override
        public int compareTo(Costumer other) {
            int diff = this.timeUnits() - other.timeUnits();
            int res = diff;

            if (diff == 0) {
                if (this.id > other.id) {
                    res = 1;
                } else {
                    res = -1;
                }
            }

            return res;
        }
    }
}
