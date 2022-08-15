import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("First");
        arrayList.add("Second");
        arrayList.add("Third");
        arrayList.add("Fourth");
        arrayList.add("Fifth");
        System.out.println(arrayList);
        System.out.println(arrayList.size());
        arrayList.remove("Fifth");
        System.out.println(arrayList);
        System.out.println(arrayList.size());
        arrayList.remove(3);
        System.out.println(arrayList);
        System.out.println(arrayList.size());

        String[] array = new String[arrayList.size()];
        //array = arrayList.toArray(array);

        for (String element : arrayList) {
            System.out.print(element + "\t");
        }

        System.out.println();
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        System.out.println(linkedList);
        linkedList.remove();    //removes first index
        System.out.println(linkedList);
        linkedList.remove(3);
        System.out.println(linkedList);
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());

        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(4);
        System.out.println(hashSet);
        //hashSet.removeAll(hashSet);
        System.out.println(hashSet);

        TreeSet<Integer> treeSet = new TreeSet<>(); //ordered ascending and no duplicates
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(4);
        treeSet.add(5);
        //treeSet.add(5); error duplicate values
        treeSet.add(3);
        treeSet.add(0);
        treeSet.add(6);

        System.out.println(treeSet);
        System.out.println(treeSet.subSet(0, 2));
        System.out.println(treeSet.ceiling(2));
        System.out.println(treeSet.pollFirst());
        System.out.println(treeSet.pollLast());
        System.out.println(treeSet);


        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(5);
        priorityQueue.add(9);
        priorityQueue.add(0);
        System.out.println(priorityQueue);
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue);

    }
}
