public class OrderListLinked<T extends Comparable<T>> extends ListLinked<T> {
    @Override
    public void insert(T data) {
        if (isEmptyList() || data.compareTo(first.getData()) < 0) {         //Comprobacion si la lista esta vacia
            insertFirst(data); //Utiliza el metodo de insertar primero      //O si el elemento a insertar es menor que el first
            return;
        }

        Node<T> current = first;    //Nodo Auxiliar.
        while (current.getNext() != null && data.compareTo(current.getNext().getData()) > 0) {
            current = current.getNext();
        }   //El while verifica si el nodo actual tiene un nodo siguiente.
            //O si el dato que vamos a ingresar es mayor al dato de nodo siguiente no termina el bucle
            //si una de estas condiciones deja de cumplirse se detiene el while
        Node<T> newNode = new Node<>(data);
        //insercion del nodo.
        newNode.setNext(current.getNext());
        current.setNext(newNode);
    }

    @Override
    public void removeNode(T data) {
        if (isEmptyList()) {    //si la lista esta vacia, no se puede eliminar nada
            return;
        }

        if (data.compareTo(first.getData()) == 0) { //si el dato que queremos eliminar es igual al first, eliminamos el first
            first = first.getNext();                //solo que el first pase a ser el siguiente.
            return;
        }

        Node<T> current = first;        //auxiliar
        while (current.getNext() != null && data.compareTo(current.getNext().getData()) != 0) {
            current = current.getNext();    //El while verifica si el nodo actual tiene un nodo siguiente.
        }                                   //compara el dato con el dato del siguiente nodo, 
        //Si el resultado de la comparación es diferente de cero, significa que los datos no son iguales 
        //y aún no se ha encontrado el nodo que contiene el dato data que se desea eliminar.
        
        if (current.getNext() != null) {    //el siguiente nodo no es nulo 
            current.setNext(current.getNext().getNext());
        }
    }

    @Override
    public int search(T data) {
        Node<T> current = first;    //auxiliar
        int index = 0;  //Indice
        //auxiliar es no es nulo.
        while (current != null && data.compareTo(current.getData()) != 0) { //se comprueba si el dato del nodo actual es diferente al dato que se está buscando
            current = current.getNext();    //si no son iguales sigue adelante el bucle
            index++;
        }
        return (current != null) ? index : -1;  //ternaria, donde si el nodo aux no es nulo, se encontro el elemento, devuelve el indice.
        //si el nodo aux o current es nulo se devuelve -1.
    }
}
