package Stabel;

public class Node<T> {

    public T data;
    public Node<T> neste;

    public Node(T data) {
        this.data = data;
        this.neste = null;
    }

    @Override
    public String toString() {
        if (neste == null) {
            return "[ " + data + " | null ] ";
        } else {
            //NB! Rekursivt kall til toString() her!
            return "[ " + data + " | •-]--> " + neste;
        }
    }

}

