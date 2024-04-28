package ACTIVIDAD;

public class ListArray<T> implements TDAListaGenerica<T> {
    private static final int CAPACIDAD_INICIAL = 10;
    private T[] arreglo;
    private int tamaño;

    public ListArray() {
        arreglo = (T[]) new Object[CAPACIDAD_INICIAL];
        tamaño = 0;
    }
    public void showList() {
        for (int i = 0; i < tamaño; i++) {
            System.out.println(arreglo[i] + " ");
        }
    }
    @Override
    public boolean isEmptyList() {
        return tamaño == 0;
    }

    @Override
    public int length() {
        return tamaño;
    }

    @Override
    public void destroyList() {
        arreglo = (T[]) new Object[CAPACIDAD_INICIAL];
        tamaño = 0;
    }

    @Override
    public int search(T elemento) {
        for (int i = 0; i < tamaño; i++) {
            if (arreglo[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void insertFirst(T elemento) {
        if (tamaño == arreglo.length) {
            expandirArreglo();
        }
        for (int i = tamaño - 1; i >= 0; i--) {
            arreglo[i + 1] = arreglo[i];
        }
        arreglo[0] = elemento;
        tamaño++;
    }

    @Override
    public void insertLast(T elemento) {
        if (tamaño == arreglo.length) {
            expandirArreglo();
        }
        arreglo[tamaño++] = elemento;
    }

    @Override
    public void removeNode(T elemento) {
        int indice = search(elemento);
        if (indice != -1) {
            for (int i = indice; i < tamaño - 1; i++) {
                arreglo[i] = arreglo[i + 1];
            }
            tamaño--;
        }
    }

    private void expandirArreglo() {
        T[] nuevoArreglo = (T[]) new Object[arreglo.length * 2];
        for (int i = 0; i < tamaño; i++) {
            nuevoArreglo[i] = arreglo[i];
        }
        arreglo = nuevoArreglo;
    }
}
