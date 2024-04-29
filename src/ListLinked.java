public class ListLinked<T extends Comparable<T>> implements TDAList<T> {
    protected Node<T> first;

    public ListLinked(){
        this.first = null;
    }

    public boolean isEmptyList(){
        return first == null;
    }

    public int length(){
        int count = 0;
        Node<T> actual = first;
        while (actual != null) {
            count++;
            actual = actual.getNext();
        }
        return count;
    }

    public void destroyList(){
        first = null;
    }

    public int search(T searchItem){
        Node<T> actual = first;
        int indice = 0;
        while (actual != null) {
            if (actual.getData().equals(searchItem)) {
                return indice;
            }
            actual = actual.getNext();
            indice++;
        }
        return -1;
    }

    public void insertFirst(T newItem){
        Node<T> nuevoNodo = new Node<>(newItem);
        nuevoNodo.setNext(first);
        first = nuevoNodo;
    }

    public void insertLast(T newItem){
        Node<T> nuevoNodo = new Node<>(newItem);
        if (first == null) {
            first = nuevoNodo;
        } else {
            Node<T> actual = first;
            while (actual.getNext() != null) {
                actual = actual.getNext();
            }
            actual.setNext(nuevoNodo);
        }
    }

    public void removeNode(T deleteItem){
        if (first == null) {
            return;
        }
        if (first.getData().equals(deleteItem)) {
            first = first.getNext();
            return;
        }
        Node<T> actual = first;
        while (actual.getNext() != null) {
            if (actual.getNext().getData().equals(deleteItem)) {
                actual.setNext(actual.getNext().getNext());
                return;
            }
            actual = actual.getNext();
        }
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        Node<T> current = first;
        while (current != null) {
            stringBuilder.append(current.getData()).append(" ");
            current = current.getNext();
        }
        return stringBuilder.toString();
    }

    //Ejercicio 01
    public void deleteDuplicates(){
        if (first == null || first.getNext() == null) { //si la lista está vacia o solo tiene un deleteItem, no habrian duplicados
            return;
        }
        Node<T> current = first; //creamos un anexo o variable temporal para poder recorrer y no perder datos
        while (current != null) {
            Node<T> runner = current; //creamos una nueva variable para comparar con el resto y recorrer
            while (runner.getNext() != null) { //recorremos 
                if (current.getData().compareTo(runner.getNext().getData()) == 0) { //comparamos si el nodo actual no tiene duplicados
                    //se encontró un nodo duplicado
                    runner.setNext(runner.getNext().getNext());
                } else {
                    runner = runner.getNext();
                }
            }
            current = current.getNext();
        }
    }

    //Ejercicio 02
    public void insertNth(T data, int position){
        if (position < 0 || position > length()) { //si el length de la lista es menor que la posicion o es negativo está fuera del rango
            System.out.println("Fuera de rango.");
            return;
        }

        Node<T> newNode = new Node<>(data); //nodo a agregar a la lista

        if (position == 0) { //en caso sea 0 se ingresa al inicio
            insertFirst(data);
        } else {
            Node<T> current = first; //variable temporal para recorrer y no perder datos
            for (int i = 0; i < position - 1; i++) { //recorremos hasta encontrar la posición
                current = current.getNext();
            }
            //insertamos nodo
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
    }
    
    /* metodos pal ejercicio 3*/
    public void insert(int data) {
        Node newNode = new Node(data);
        //si es una lista vacia
        if (first == null) {
        	first = newNode;
        } else {//si tiene elementos, usamos un indice auxiliar
            Node current = first;
            //si la referencia al siguiente nodo no es null, recorrer
            while (current.getNext() != null) {
                current = current.getNext();
            }
            //cuando la sgte referencia sea null, agrega el nodo al final
            current.setNext(newNode);
        }
    }
    //borrar posicion n
    public void deleteNth(int position) {
    	//si la posicion a borrar es menor a 0 o mas del tamaño de la lista
        if (position < 0 || position >= length()) {
            System.out.println("Error: Posición fuera de rango.");
            return;
        }
        //si es el primer elemento el q se borra
        if (position == 0) {
        	//el indice pasa al segundo elemento, perdiendo asi la informacion del primero.
        	first = first.getNext();
            return;
        }
        //nodo auxiliar
        Node current = first;
        // recorre la lista hasta el elemento enterior a borrar
        for (int i = 0; current != null && i < position - 1; i++) {
            current = current.getNext();
        }
        //si es lista vacia, o el nodo actual o sgte es nulo
        if (current == null || current.getNext() == null) {
            return;
        }
        //actualiza para que el siguiente (que es el q se va borrar), pase a ser el siguiente de ese. Ej. 1 a 3, ya no 1 a 2.
        current.setNext(current.getNext().getNext());
    }
    
    /*aqui acaban los metodos pal ejercicio 3*/
    
    /*metodos pal ejercicio 5*/
    //merge sort, se especifica el tipo de dato a emplear (integer)
    public static ListLinked mergeSortedLists(ListLinked<Integer> list1, ListLinked<Integer> list2) {
        //crea nueva lista del mismo tipo de dato
    	ListLinked<Integer> mergedList = new ListLinked();
    	//nodos auxiliares para cada lista enlazada
        Node<Integer> current1 = list1.first;
        Node<Integer> current2 = list2.first;
        //mientras ambas listas tengan elementos
        while (current1 != null && current2 != null) {
        	//compara y el menor lo agrega a la nueva lista
            if (current1.getData() < current2.getData()) {
                mergedList.insert(current1.getData());
                current1 = current1.getNext();
            } else {
                mergedList.insert(current2.getData());
                current2 = current2.getNext();
            }
        }
        //si la segunda lista llega a su fin
        while (current1 != null) {
        	//agrega los restantes de la primera lista
            mergedList.insert(current1.getData());
            current1 = current1.getNext();
        }
        
        //si la primera lista llega a su fin
        while (current2 != null) {
        	//agrega los de la segunda lista
            mergedList.insert(current2.getData());
            current2 = current2.getNext();
        }

        return mergedList;
    }
    // aqui acaban los metodos pal ejercicio 5

    //display, insert
    public void display() {
        Node current = first;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
    public void insert(T data) {
        Node newNode = new Node(data);
        if (first == null) {
            first = newNode;
        } else {
            Node current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }
    
}
