import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Duration> durations = Arrays.asList(Duration.ofSeconds(60), Duration.ofSeconds(120), Duration.ofSeconds(180));
        Duration runningTotal = Duration.ZERO;
        Duration max = Duration.ofSeconds(Long.MIN_VALUE);
        for (Duration duration :
                durations) {
            runningTotal = runningTotal.plus(duration);
            max = max.compareTo(duration) > 0 ? max : duration;
        }
        System.out.printf("Total time: %s, Max time: %s\n", runningTotal, max);
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(Duration.ofSeconds(120).toMinutesPart());

        LocalDate localDate = LocalDate.of(1996, 6, 15);
        String date = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(localDate);
        String dateOfFormat = DateTimeFormatter.ofPattern("dd.MM.yy").format(localDate);
        System.out.println(dateOfFormat);
        System.out.println(date);
        System.out.println(Period.between(localDate, LocalDate.now()));

        LocalDate futureDate = LocalDate.of(2022, 12, 19);
        System.out.println(Period.between(LocalDate.now(), futureDate).isNegative());
        System.out.println(Period.between(LocalDate.now(), futureDate).equals(Period.of(0, 0, 2)));
        System.out.println(Period.between(LocalDate.now(), futureDate).equals(Period.of(1, 0, 2)));
        System.out.println(Period.between(LocalDate.now(), futureDate).equals(Period.of(1, 0, 2)));

    }
}