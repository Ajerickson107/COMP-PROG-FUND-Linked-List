//Name: Andrew Erickson

public class Node {
    //Instance Variables
    private HurricaneRowData value;
    private Node next;
    private Node prev;

    //Constructor
    public Node(HurricaneRowData value, Node prev, Node next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    //Getter
    public HurricaneRowData getValue() {
        return value;
    }

    //Checks for next node
    public boolean hasNext() {
        if (next != null) return true;
        return false;
    }

    //Setter
    public void setNext(Node next) {
        this.next = next;
    }

    //Getter
    public Node getNext() {
        return next;
    }

    //Checks for previous node
    public boolean hasPrevious() {
        if (prev != null) return true;
        return false;
    }

    //Setter
    public void setPrevious(Node prev) {
        this.prev = prev;
    }

    //Getter
    public Node getPrevious() {
        return prev;
    }

    //To String Method
    @Override
    public String toString() {
        return value.toString();
    }
}
