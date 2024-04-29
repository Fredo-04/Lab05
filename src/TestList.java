public class TestList {
    public static void main(String[] args) {
        // Crear una lista ordenada de enteros
        OrderListLinked<Integer> integerList = new OrderListLinked<>();
        integerList.insert(5);  //Insertamos, el metodo insert como recordamos 
        integerList.insert(3);  //ingresa estos datos de forma ordenada
        integerList.insert(7);
        integerList.insert(1);
        integerList.insert(9);  

        // Mostrar la lista de enteros
        System.out.println("Lista de enteros:");
        integerList.display();
        
        // Crear una lista ordenada de caracteres
        OrderListLinked<Character> charList = new OrderListLinked<>();
        charList.insert('c');
        charList.insert('a');
        charList.insert('f');
        charList.insert('b');
        charList.insert('e');
        
        // Mostrar la lista de caracteres
        System.out.println("\nLista de caracteres:");
        charList.display();
        System.out.println();
        // Crear una lista ordenada de Strings
        OrderListLinked<String> stringList = new OrderListLinked<>();
        stringList.insert("banana");
        stringList.insert("apple");
        stringList.insert("orange");
        stringList.insert("grape");
        stringList.insert("pear");

        // Mostrar la lista de Strings
        System.out.println("Lista de Strings:");
        stringList.display();
        
        System.out.println();
        OrderListLinked<Person> listaPersonas = new OrderListLinked<>();
        listaPersonas.insert(new Person("Juan", "Veliz", 25));
        listaPersonas.insert(new Person("María", "Martinez", 30));
        listaPersonas.insert(new Person("Pedro", "Marmol",20));
        System.out.println("Lista de personas ordenadas por edad");
        listaPersonas.display();
    }
}
