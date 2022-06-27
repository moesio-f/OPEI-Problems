import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemaG {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String line;
        String[] splitted;
        int n;
        int queries;
        int day, beginDay, endDay;

        line = input.nextLine();
        splitted = line.split(" ");

        n = Integer.parseInt(splitted[0]);
        queries = Integer.parseInt(splitted[1]);
        Calendar starCalendar = new Calendar(n);

        line = input.nextLine();
        splitted = line.split(" ");
        day = 1;

        for (String v : splitted) {
            starCalendar.addStar(day, Integer.parseInt(v));
            day += 1;
        }

        for (int i = 0; i < queries; i++) {
            line = input.nextLine();
            splitted = line.split(" ");

            if (splitted[0].equals("1")) {
                day = Integer.parseInt(splitted[1]);
                starCalendar.addStar(day);
            } else {
                beginDay = Integer.parseInt(splitted[1]);
                endDay = Integer.parseInt(splitted[2]);
                System.out.println(starCalendar.nStars(beginDay, endDay));
            }
        }

        input.close();
    }

    private static class Calendar {
        private final int[] stars;

        public Calendar(int n) {
            this.stars = new int[n];
        }

        public void addStar(int day) {
            this.stars[day - 1] += 1;
        }

        public void addStar(int day, int amount) {
            this.stars[day - 1] += amount;
        }

        public int nStars() {
            return Arrays.stream(this.stars).sum();
        }

        public int nStars(int begin, int end) {
            return IntStream.range(begin - 1, end).map(i -> this.stars[i]).sum();
        }
    }
}
