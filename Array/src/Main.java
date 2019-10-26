public class Main {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<Integer>(10);
        for (int i = 0; i < 15; i += 1) {
            arr.addLast(i);
            System.out.println(arr);
        }

        System.out.print("\n");

        for (int i = 0; i < 10; i += 1) {
            arr.removeLast();
            System.out.println(arr);
        }

//        System.out.println(String.format("\nsize = %d", arr.getSize()));
//
//        System.out.println(String.format("\ncapacity = %d", arr.getCapacity()));
//
//        System.out.println(String.format("\nempty = %b", arr.isEmpty()));
//
//        System.out.println(String.format("\n[1] = %d", arr.get(1)));

//        arr.add(1, 100);
//        System.out.println(arr);
//        arr.addLast(100);
//        System.out.println(arr);
//        arr.add(4, 100);
//        System.out.println(arr);
//        arr.add(3, 100);
//        System.out.println(arr);
//        arr.add(9, 100);
//        System.out.println(arr);
//        arr.add(8, 100);
//        System.out.println(arr);
//        arr.removeElement(100, 7);
//        System.out.println(arr);
//        arr.removeElement(100, 9);
//        System.out.println(arr);
//        arr.removeLastElement(100);
//        System.out.println(arr);
//        arr.removeFirstElement(0);
//        System.out.println(arr);
//        arr.removeAllElement(100);
//        System.out.println(arr);
//        arr.removeFirst();
//        System.out.println(arr);
//        arr.removeLast();
//        System.out.println(arr);
//        arr.remove(2);
//        System.out.println(arr);
//        arr.set(2, 100);
//        System.out.println(arr);
//        System.out.println(arr.get(2));
//        arr.add(4, 100);
//        arr.add(6, 100);
//        arr.add(8, 100);
//        System.out.println(arr);
//        arr.add(1, 100);
//        System.out.println(arr);
//        System.out.println(arr.find(1));
//        System.out.println(arr.find(3));
//        System.out.println(arr.findCount(100));
//        System.out.println(arr.findLast(100));
//        System.out.println(arr.findFirst(100));
//        System.out.println(arr.find(1, 2));
//        System.out.println(arr.find(100, 2));
//        System.out.println(arr.findAll(100));
//        arr.removeAll();
//        System.out.println(arr);
    }
}
