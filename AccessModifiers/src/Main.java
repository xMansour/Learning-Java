public class Main {
    public static void main(String[] args) {
        AccessModifiersDemo amd = new AccessModifiersDemo();
        System.out.println(amd.a);
        amd.a = 10;
        System.out.println(amd.a);

        System.out.println(amd.b);
        amd.b = 5;
        System.out.println(amd.b);

        //System.out.println(amd.c); can't access private variables
        System.out.println(amd.getC());
        amd.setC(20);
        System.out.println(amd.getC());

    }
}

