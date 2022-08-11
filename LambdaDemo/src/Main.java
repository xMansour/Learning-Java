public class Main {

    public static void main(String[] args) {
        FunctionalInterface fi = (n -> n % 2 == 0);
        System.out.println("4 is even: " + fi.test(4));
        System.out.println("3 is even: " + fi.test(3));

        FunctionalInterface2 fi2 = (n -> {
            if (n == 1)
                return 1;
            int result = 1;
            for (int i = 1; i <= n; i++)
                result *= i;
            return result;
        });
        System.out.println("The factorial: " + fi2.fact(5));
        char quotes = '\'';
        GenericFunctionalInterface<String> gfi = (str -> {
            return quotes + str + quotes;
        });

        System.out.println("Generic Functional Interface: " + gfi.Quot("Bla Bla"));

        String str = "Java is great!";
        StringOps stringOps = new StringOps();
        System.out.println(stringFunction(stringOps::reverse, str));
    }

    static String stringFunction(StringFunc sf, String str) {
        return sf.func(str);
    }


}
