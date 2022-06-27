import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class ProblemaJ {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    String line;
    String[] splitted;
    String stop = "0 0 0 0";
    LocalDateTime begin = LocalDateTime.now().withSecond(0).withNano(0);
    LocalDateTime end = LocalDateTime.now().withSecond(0).withNano(0);

    int h1, m1, h2, m2;

    while (true) {
      line = input.nextLine();
      splitted = line.split(" ");

      if (line.equals(stop)) {
        break;
      }

      h1 = Integer.parseInt(splitted[0]);
      m1 = Integer.parseInt(splitted[1]);
      begin = begin.withHour(h1);
      begin = begin.withMinute(m1);

      h2 = Integer.parseInt(splitted[2]);
      m2 = Integer.parseInt(splitted[3]);
      end = end.withHour(h2);
      end = end.withMinute(m2);

      if (h2 < h1 || (h1 == h2 && m2 < m1)) {
        // O despertador vai tocar no outro dia
        end = end.plusDays(1);
      }

      System.out.println(ChronoUnit.MINUTES.between(begin, end));

      // Reiniciar início e fim
      begin = LocalDateTime.now().withSecond(0).withNano(0);
      end = LocalDateTime.now().withSecond(0).withNano(0);
    }

    input.close();
  }

}
