public class Main {

    public static void main(String[] args) {
        Gen<Integer> gen1 = new Gen<>(100); //Auto-Boxing   No Cast is needed, Generics handles implicit casting
        Gen<String> gen2 = new Gen<>("String");
        //System.out.println(gen1.sameObj(gen2)); //Error because not using wildcards in the method sameObj in Gen class
        System.out.println(gen1.sameObj(gen2));
        System.out.println(gen1.getType());
        System.out.println(gen2.getType());

        int num = gen1.getObj();    //Auto-unBoxing No Cast is needed, Generics handles this

        Gen2<Integer, String> gen = new Gen2<>(20, "New String");
        System.out.println(gen.getObj1Type());
        System.out.println(gen.getObj2Type());

        Double[] arr = {1.0, 1.5, 1.5, 2.0, 4.0};
        BoundedGen<Double> boundedGen = new BoundedGen<>(arr);
        System.out.println(boundedGen.getDoubleAvg());
        System.out.println(gen1.isIn(1.0, arr));

    }
}
