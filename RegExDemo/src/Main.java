import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("Mahmoud");
        Matcher matcher = pattern.matcher("Mahmoud Mansour");
        System.out.println(matcher.matches());
        System.out.println(matcher.find());
        pattern = Pattern.compile("e.+d");
        matcher = pattern.matcher("extend cup end table");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        pattern = Pattern.compile("e.+?d");
        matcher = pattern.matcher("extend cup end table");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        pattern = Pattern.compile("e.?+d");
        matcher = pattern.matcher("extend cup end table");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        pattern = Pattern.compile("[a-z]");
        matcher = pattern.matcher("Extend Cup End Table");
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
        System.out.println();
        pattern = Pattern.compile("Jon.*?");
        matcher = pattern.matcher("Jon Jonathan Ken Fold Jonny");
        System.out.println(matcher.replaceAll("Eric"));

        pattern = Pattern.compile("[ .,!]");    //finds all tokens seperated by space dot comma or !
        String[] chars = pattern.split("Jon Jonathan,Ken!Fold.Jonny $Haidy");
        for (String str : chars
        ) {
            System.out.println(str);
        }
        System.out.println(DateFormat.getDateInstance(DateFormat.SHORT, Locale.US));
        System.out.println(new SimpleDateFormat("dd/MM/yyyy a hh:mm:ss").format(new Date()));
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("dd yyyy")));
        System.out.println(LocalTime.now());

    }
}
