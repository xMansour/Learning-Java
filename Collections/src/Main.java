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

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.addFirst(0);
        arrayDeque.addFirst(1);
        arrayDeque.addFirst(5);
        arrayDeque.addFirst(20);
        arrayDeque.addFirst(3);
        arrayDeque.addFirst(2);
        System.out.println(arrayDeque);
        System.out.println(arrayDeque.peek());
        System.out.println(arrayDeque.getFirst());
        System.out.println(arrayDeque.getLast());
        arrayDeque.push(100);
        System.out.println(arrayDeque);
        System.out.println(arrayDeque.peek());
        System.out.println(arrayDeque.getFirst());
        System.out.println(arrayDeque.getLast());
        arrayDeque.pop();
        System.out.println(arrayDeque);
        arrayDeque.poll();
        System.out.println(arrayDeque);


        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("First element");
        arrayList1.add("Second element");
        arrayList1.add("Third element");
        arrayList1.add("Fourth element");
        arrayList1.add("Fifth element");
        ListIterator<String> listIterator = arrayList1.listIterator();
        //print
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + ", ");
        }
        listIterator = arrayList1.listIterator();
        while (listIterator.hasNext()) {
            listIterator.set("'" + listIterator.next() + "'");
        }
        System.out.println();
        listIterator = arrayList1.listIterator();
        //print
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + ", ");
        }
        System.out.println();
        //print reverse order
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + ", ");
        }

        System.out.println();
        //using a for each loop
        for (String element : arrayList1) {
            System.out.print(element + ",, ");
        }

        System.out.println();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Ali", "0100123456");
        hashMap.put("Ahmed", "0120297456");
        hashMap.put("Hossam", "0110123526");
        hashMap.put("Bahaa", "0100121456");
        Set<Map.Entry<String, String>> set = hashMap.entrySet();
        for (Map.Entry<String, String> entry : set) {
            System.out.println("Key: " + entry.getKey() + ", value: " + entry.getValue());
        }

        System.out.println();
        TreeMap<String, String> treeMap = new TreeMap<>();  //sorted
        treeMap.put("Zara", "0199923456");
        treeMap.put("Ali", "0100123456");
        treeMap.put("Ahmed", "0120297456");
        treeMap.put("Hossam", "0110123526");
        treeMap.put("Bahaa", "0100121456");
        treeMap.put("Carin", "01001654456");
        treeMap.put("Samy", "0100698756");
        Set<Map.Entry<String, String>> set2 = treeMap.entrySet();
        for (Map.Entry<String, String> entry : set2) {
            System.out.println("Key: " + entry.getKey() + ", value: " + entry.getValue());
        }

        class myComparator implements Comparator<String> {


            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }

        }
        Comparator<String> newComparator = (aStr, bStr) -> aStr.compareTo(bStr);
        Comparator<String> newComparator2 = String::compareTo;
        Comparator<String> lastNameComparator = (aStr, bStr) -> {
            int i = aStr.lastIndexOf(" ");
            int j = bStr.lastIndexOf(" ");
            return aStr.substring(i).compareToIgnoreCase(bStr.substring(j));
        };
        Comparator<String> comp = Collections.reverseOrder();

        //TreeSet<String> treeSet1 = new TreeSet<>(new myComparator());
        //TreeSet<String> treeSet1 = new TreeSet<>((aStr, bStr) -> bStr.compareTo(aStr)); //reverse order
        //TreeSet<String> treeSet1 = new TreeSet<>((aStr, bStr) -> aStr.compareTo(bStr)); //natural order equals String::compare
        //TreeSet<String> treeSet1 = new TreeSet<>(String::compareTo);
        TreeSet<String> treeSet1 = new TreeSet<>(lastNameComparator);
        //TreeSet<String> treeSet1 = new TreeSet<>(comp);

        treeSet1.add("C Mahmoud");
        treeSet1.add("A Ali");
        treeSet1.add("D Ziad");
        treeSet1.add("E Nor");
        treeSet1.add("G Mansour");
        treeSet1.add("Z Ahmed");
        treeSet1.add("F Youssef");
        System.out.println(treeSet1);

        Vector<Integer> vector = new Vector<>(2, 2);
        System.out.println("Initial Capacity: " + vector.capacity());
        vector.addElement(1);
        vector.addElement(2);
        vector.addElement(3);
        vector.addElement(4);
        vector.addElement(5);
        vector.addElement(6);
        vector.addElement(7);
        vector.addElement(4);

        System.out.println(vector.size());
        System.out.println("Current Capacity: " + vector.capacity());
        System.out.println(vector.lastElement());
        System.out.println(vector.firstElement());
        System.out.println("First index of 4: " + vector.indexOf(4));
        System.out.println("Last index of 4: " + vector.lastIndexOf(4));
        Iterator<Integer> itr = vector.iterator();
        System.out.print("Vector contents are: ");
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        //Dictionary is deprecated and obsolete superseded by Map
        //Dictionary is abstract class, so we can't create objects of it, but we can extend it, and we will have to implement all it's methods
        class myDictionary extends Dictionary<Integer, String> {

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public Enumeration<Integer> keys() {
                return null;
            }

            @Override
            public Enumeration<String> elements() {
                return null;
            }

            @Override
            public String get(Object key) {
                return null;
            }

            @Override
            public String put(Integer key, String value) {
                return null;
            }

            @Override
            public String remove(Object key) {
                return null;
            }
        }

        HashMap<Integer, String> hashMap1 = new HashMap<>();
        hashMap1.put(null, null);
        hashMap1.put(null, "null");
        hashMap1.put(null, "null");
        hashMap1.put(null, "asd");
        System.out.println(hashMap1.get(null));
        System.out.println(hashMap1);
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        //hashtable.put(null, "null");
        hashtable.put(3, "do");
        hashtable.put(2, "you");
        System.out.println(hashMap1.get(null));
        System.out.println(hashtable);

        for (Map.Entry<Object, Object> property : System.getProperties().entrySet()) {
            System.out.println("Key: " + property.getKey() + ", Value: " + property.getValue());
        }

        String keyValueString = "name:Mahmoud, age:26, gender:male, nationality:egyptian";
        StringTokenizer stringTokenizer = new StringTokenizer(keyValueString, ":, ");
        while (stringTokenizer.hasMoreTokens()) {
            System.out.println("Key: " + stringTokenizer.nextToken() + ", Value: " + stringTokenizer.nextToken());
        }

        BitSet bitSet = new BitSet();
        bitSet.set(0, 5);
        bitSet.set(5, 8, false);
        System.out.println(bitSet.length());
        System.out.println(!bitSet.isEmpty());
        System.out.println(bitSet);
        bitSet.flip(2, 4);
        System.out.println(bitSet.get(5));
        System.out.println(bitSet.cardinality());
        BitSet bitSet1 = new BitSet();
        bitSet1.set(1, 10);
        System.out.println(bitSet.intersects(bitSet1));
        bitSet.or(bitSet1);
        System.out.println(bitSet);


        Optional hasValue = Optional.of("Optional Class has no constructor (Singleton)");
        Optional noValue = Optional.empty();
        System.out.println("Has Value: " + hasValue.toString());
        System.out.println("No Value: " + noValue.toString());

        if (noValue.isPresent())
            System.out.println("noValue.isPresent()");
        if (hasValue.isPresent()) {
            System.out.println("hasValue.isPresent()");
            System.out.println(hasValue.get());
        }
        noValue.orElse("Default value from orElse");


    }
}
