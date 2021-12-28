package cs1302.genlist;

/**
 * Represents a Node class of type T for a linked data structure.
 */
public class Node<T> {
    private T obj;
    private Node<T> next;

    /**
     * Constructs a new node.
     */
    public Node() {
        this.obj = null;
        this.next = null;
    }

    /**
     * Constructs a new node and sets the obj.
     * @param obj the provided object
     */
    public Node(T obj) {
        this.obj = obj;
        this.next = null;
    }

    /**
     * Sets the next value of the current Node.
     * @param next the value to set the next value
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Sets the object of the current Node with the specified object.
     * @param obj the provided object
     */
    public void setObj(T obj) {
        this.obj = obj;
    }

    /**
     * Returns the next value of the Node.
     * @return the next value
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Returns the value of obj.
     * @return the value of obj
     */
    public T getObj() {
        return obj;
    }
}
