package Actividades;
public interface TDAListaGenerica<T> {
    boolean isEmptyList();
    int length();
    void destroyList();
    int search(T elemento);
    void insertFirst(T elemento);
    void insertLast(T elemento);
    void removeNode(T elemento);
}
