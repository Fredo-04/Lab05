public class ListLinked<T extends Comparable<T>> implements TDAList<T> {
    protected Node<T> first;

    public ListLinked(){
        this.first = null;
    }

    public boolean isEmptyList(){
        return true;
    }

    public int length(){
        return 0;
    }

    public void destroyList(){

    }

    public int search(T searchItem){
        return 0;
    }

    public void insertFirst(T newItem){

    }

    public void insertLast(T newItem){

    }

    public void removeNode(T deleteItem){

    }

    public String toString(){
        return "";
    }

    public void deleteDuplicates(){
        if (first == null || first.getNext() == null) { //si la lista está vacia o solo tiene un elemento, no habrian duplicados
            return;
        }
        Node<T> current = first; //creamos un anexo o variable temporal para poder recorrer y no perder datos
        while (current != null) {
            Node<T> runner = current; //recorremos con una nueva variable 
            while (runner.getNext() != null) {
                if (current.getData().compareTo(runner.getNext().getData()) == 0) {
                    // Se encontró un nodo duplicado
                    runner.setNext(runner.getNext().getNext());
                } else {
                    runner = runner.getNext();
                }
            }
            current = current.getNext();
        }
    }
}
