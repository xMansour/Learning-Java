import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(5);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(6);
        arrayList.add(9);
        Stream<Integer> stream = arrayList.stream();
        Optional<Integer> min = stream.min(Integer::compare);
        min.ifPresent(System.out::println);
        stream = arrayList.stream();
        Optional<Integer> max = stream.max((Integer::compare));
        max.ifPresent(System.out::println);

        Stream<Integer> sortedStream = arrayList.stream().sorted();
        sortedStream.forEach(System.out::print);

        System.out.println();
        Stream<Integer> oddValues = arrayList.stream().filter(element -> element % 2 == 1);
        oddValues.forEach(System.out::print);

        System.out.println();
        Stream<Integer> greaterThanFive = arrayList.stream().filter(element -> element > 5);
        greaterThanFive.forEach(System.out::print);

        System.out.println();
        Optional<Integer> product = arrayList.stream().reduce((a, b) -> a * b);
        product.ifPresent(System.out::println);
        Stream<Integer> sqrRoots = arrayList.stream().map(a -> a * a);
        double sqrRootsProduct = sqrRoots.reduce(1, (a,b)->a*b);
        System.out.println(sqrRootsProduct);

        
    }
}
