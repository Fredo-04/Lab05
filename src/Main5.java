public class Main5 {
    public static void main(String[] args) {
    	//insertar elementos lista 1
        LinkedList list1 = new LinkedList();
        list1.insert(1);
        list1.insert(3);
        list1.insert(5);
        list1.insert(7);
        //insertar elementos lista 2
        LinkedList list2 = new LinkedList();
        list2.insert(2);
        list2.insert(4);
        list2.insert(6);
        list2.insert(8);
        //mostrar elementos listas 1 y 2
        System.out.println("Primera lista:");
        list1.showList();
        System.out.println("Segunda lista:");
        list2.showList();
        //crear otra lista, en la cual se juntan la 1 y 2
        LinkedList mergedList = LinkedList.mergeSortedLists(list1, list2);
        System.out.println("Lista fusionada:");
        mergedList.showList();
    }
}
