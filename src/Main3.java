package ACTIVIDAD;


public class Main3 {
    public static void main(String[] args) {
    	//insertar en la lista enlazada
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        //mostrar lista enlazada
        System.out.println("Lista original:");
        list.showList();
        //borrar elemento posicion 1
        list.deleteNth(1);
        //mostrar despues de borrar
        System.out.println("Lista después de eliminar el nodo en la posición 2:");
        list.showList();
        //borrar elemento posicion fuera de rango
        list.deleteNth(10);
    }
}
