public class Main5 {
    public static void main(String[] args) {
    	//insertar elementos lista 1
        ListLinked<Integer> list1 = new ListLinked<Integer>();
        list1.insert(1);
        list1.insert(3);
        list1.insert(5);
        list1.insert(7);
        //insertar elementos lista 2
        ListLinked<Integer> list2 = new ListLinked<Integer>();
        list2.insert(2);
        list2.insert(4);
        list2.insert(6);
        list2.insert(8);
        //mostrar elementos listas 1 y 2
        System.out.println("Primera lista:");
        list1.display();
        System.out.println("Segunda lista:");
        list2.display();
        //crear otra lista, en la cual se juntan la 1 y 2
        ListLinked<Integer> mergedList = new ListLinked<Integer>();
        mergedList = mergedList.mergeSortedLists(list1, list2);
        System.out.println("Lista fusionada:");
        mergedList.display();
    }
}
