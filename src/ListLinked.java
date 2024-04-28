public class ListLinked<T> implements TDAList<T>{
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
}
