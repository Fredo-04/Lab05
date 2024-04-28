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
}
