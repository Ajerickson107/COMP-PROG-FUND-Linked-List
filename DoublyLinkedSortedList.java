//Name: Andrew Erickson

public class DoublyLinkedSortedList implements DoublyLinkedSortedListInterface {
    private Node first;
    private Node last;

    public DoublyLinkedSortedList() {
        this.first = null;
        this.last = null;
    }

    //Return a reference to the first Node in the list
	public Node getFirst() {
        return first;
    }
	
	//Return a reference to the last Node in the list
	public Node getLast() {
        return last;
    }
	
	//Remove the Node that has toRemove as its value
    public Node remove(HurricaneRowData toRemove) {
        Node current = first;
        while (current != null) {
            if (current.getValue().equals(toRemove)) {
                if (current == first) {
                    first = current.getNext();
                    if (first != null) {
                        first.setPrevious(null);
                    } else {
                        last = null;
                    }
                } 
                else if (current == last) {
                    last = current.getPrevious();
                    if (last != null) {
                        last.setNext(null);
                    } else {
                        first = null;
                    }
                }
                else {
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());
                }
                return current;
            }
            current = current.getNext();
        }
        return null;
    }
	
	//Insert a new Node with the given newValue into the list in order.
    public void insert(HurricaneRowData newValue) {
        Node newNode = new Node(newValue, null, null);
        if (first == null) {
            first = newNode;
            last = newNode;
            return;
        }
        if (newValue.getAceIndex() > first.getValue().getAceIndex()) {
            newNode.setNext(first);
            first.setPrevious(newNode);
            first = newNode;
            return;
        }
        Node current = first;
        while (current.getNext() != null && current.getNext().getValue().getAceIndex() >= newValue.getAceIndex()) {
            current = current.getNext();
        }
        newNode.setNext(current.getNext());
        newNode.setPrevious(current);
        if (current.getNext() != null) {
            current.getNext().setPrevious(newNode);
        } else {
            last = newNode;
        }
        current.setNext(newNode);
    }
	
	//Return the entire list as a multi-line String
    public String toString() {
        String result = "";
        Node current = first;
        while (current != null) {
            result += current.getValue().toString() + "\n";
            current = current.getNext();
        }
        return result;
    }
}
