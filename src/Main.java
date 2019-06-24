import java.util.Arrays;

public class Main {
    public static void main(String[] args){

        DoubLinkedList<String> list = new DoubLinkedList();
        list.addLast("a");
        list.addLast("b");
        list.addLast("c");
        list.addLast("d");
        list.add(4, "z");
        System.out.println("first: " + (String)list.getFirst());
        System.out.println("last: " + (String)list.getLast());
        System.out.println("4: " + (String)list.get(4));
        System.out.println(Arrays.toString(list.toArray()));
    }
}