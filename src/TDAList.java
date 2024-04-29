
import java.util.LinkedList;

public interface TDAList<T extends Comparable<T>> {
    boolean isEmptyList();
    int length();
    void destroyList();
    int search(T x);
    void insertFirst(T x);
    void insertLast(T x);
    void removeNode(T x);

    //Ejercicio 01
    void deleteDuplicates();

    //Ejercicio 02
    void insertNth(T x, int i);

    //Ejercicio 03
    void deleteNth(int pos);

}
