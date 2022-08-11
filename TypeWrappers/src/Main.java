public class Main {
    private static int returnInt (Integer x){
        return x;
    }
    public static void main(String[] args) {
        Character charWrapper = Character.valueOf('c');
        Integer intWrapper = Integer.valueOf(100);
        Boolean boolWrapper = Boolean.getBoolean("true");
        Boolean boolWrapper2 = Boolean.valueOf(true);
        Boolean boolWrapper3 = Boolean.parseBoolean("true");
        System.out.println("charWrapper: "+charWrapper);
        System.out.println("intWrapper: "+intWrapper);
        System.out.println("boolWrapper: "+boolWrapper);
        System.out.println("boolWrapper2: "+boolWrapper2);
        System.out.println("boolWrapper3: "+boolWrapper3);
        System.out.println("intWrapper toString: "+intWrapper.toString());
        Integer intWrapper2 = 100; //Auto Boxing    Primitives -> Objects
        int intNumber = intWrapper2;    //Auto Un-Boxing    Objects -> Primitives\
        System.out.println(returnInt(intNumber));   //Auto Boxing

    }
}
