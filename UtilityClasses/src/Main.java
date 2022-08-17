import java.util.*;

public class Main {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.toString());
        System.out.println("MS since 1/1/1970: " + date.getTime());

        String[] months = {"jan,", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};
        Calendar calendar = Calendar.getInstance();
        System.out.println("Months: " + calendar.get(Calendar.MONTH));
        System.out.println("DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("DATE: " + calendar.get(Calendar.DATE));
        System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
        System.out.println("HOUR: " + calendar.get(Calendar.HOUR));
        System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));
        System.out.println("SECOND: " + calendar.get(Calendar.SECOND));

        System.out.println("Current Date: " + months[calendar.get(Calendar.MONTH)] + " " +
                calendar.get(Calendar.DAY_OF_MONTH) + " " + calendar.get((Calendar.YEAR)) +
                " " + calendar.get(Calendar.HOUR_OF_DAY) + " " + calendar.get(Calendar.MINUTE) +
                " " + calendar.get(Calendar.SECOND));

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        System.out.println(gregorianCalendar.getTime());
        System.out.println(GregorianCalendar.AD);
        System.out.println(GregorianCalendar.BC);


        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Scheduled run...");
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask, 1000, 500);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();


        Currency currency = Currency.getInstance(Locale.US);
        System.out.println(currency.getCurrencyCode());
        System.out.println(currency.toString());
        System.out.println(currency.getDisplayName());
        System.out.println(currency.getSymbol());


        Formatter formatter = new Formatter();
        formatter.format("Formatter is %s with %d and %.2f", "working", 10, 20.5);
        System.out.println(formatter.toString());
        formatter.close();

        try (Formatter formatter1 = new Formatter()) {
            formatter1.format("Formatter within a %s", "try with resources");
            System.out.println(formatter1.toString());
        }
    }
}
