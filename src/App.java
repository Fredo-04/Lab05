package Actividades;

public class App {
    public static void main(String[] args) {
        ListLinked list1 = new ListLinked();
        list1.insert(1);
        list1.insert(3);
        list1.insert(5);
        list1.insert(7);

        ListLinked list2 = new ListLinked();
        list2.insert(2);
        list2.insert(4);
        list2.insert(6);
        list2.insert(8);

        System.out.println("Primera lista:");
        list1.display();
        System.out.println("Segunda lista:");
        list2.display();

        ListLinked<Integer> mergedList = new ListLinked<>();
        mergedList = list1.mergeSortedLists(list1, list2);
        System.out.println("Lista fusionada:");
        mergedList.display();
    }
}
