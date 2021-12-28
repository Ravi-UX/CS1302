package cs1302.genlist;

import cs1302.genlistadt.GenList;
import java.util.*;
import java.util.function.*;

/**
 * Represents  a {@code LinkedGenList<T>}.
 */
public class LinkedGenList<T> implements GenList<T> {

    private Node<T> head = null;
    private int size;

    /**
     * Constructs a {@code LinkedGenList} of size 0.
     */
    public LinkedGenList() {
        size = 0;
    }

    /**
     * Constructs a linked {@code GenList} with identical elements to the provided GenList.
     * @param <U> the type of the other GenList
     * @param other the provided GenList
     *
     */
    public <U extends T> LinkedGenList(GenList<U> other) {
        //Check if other is null
        if (other == null) {
            throw new NullPointerException();
        }
        //Check if other is empty
        if (other.size() != 0) {
            //Create a temporary LinkedList and copy over elements from other
            Node<T> tempHead = new Node<T>(other.get(0));
            Node<T> tempCurr = tempHead;
            for (int i = 1; i < other.size(); i++) {
                tempCurr.setNext(new Node<T>(other.get(i)));
                tempCurr = tempCurr.getNext();
            }
            //Set the head to the the temporary list
            head = tempHead;
            size += other.size();
        }
    }

    /**
     * Constructs a linked {@code LinkedGenList} and sets the head and size to the specified
     * head and size.
     * @param head the specified head of a linked list
     * @param size the size of the specified linked list
     */
    private LinkedGenList(Node<T> head, int size) {
        this.head = head;
        this.size = size;
    }

    /**
     * {@inheritDoc}
     */
    public boolean add(int index, T obj) {
        //Check for valid index
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        //Check if size of the GenList is 0 and set the head to a the new Node<T>
        if (size == 0) {
            head = new Node<T>(obj);
            size++;

            return true;
        }
        //Create a new node with the given obj
        Node<T> n = new Node<T>(obj);
        //If the index is zero add the node to the beginning
        if (index == 0) {
            n.setNext(head);
            head = n;
            size++;

            return true;
        }
        //Loop over the linked list until the target index
        Node<T> curr = head;
        for (int i = 1; i < index; i++) {
            curr = curr.getNext();
        }
        //insert element at the target index
        n.setNext(curr.getNext());
        curr.setNext(n);
        size++;

        return true;
    }

    /**
     * Returns the last element of a node in a linked list.
     * @param n the specified node
     * @return the last element
     */
    private Node<T> getLast(Node<T> n) {
        //Loop until last element is reached
        while (n.getNext() != null) {
            n = n.getNext();
        }
        return n;
    }

    /**
     * {@inheritDoc}
     */
    public <U extends T> boolean add(int index, GenList<U> list) {
        //Check for valid index
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        //Check for valid sl
        if (list == null) {
            throw new NullPointerException();
        }
        //Check if sl is empty
        if (list.size() == 0) {
            return false;
        }
        //Copy over elements in list to a temporary linked list
        Node<T> tempHead = new Node<T>(list.get(0));
        Node<T> tempCurr = tempHead;
        for (int i = 1; i < list.size(); i++) {
            tempCurr.setNext(new Node<T>(list.get(i)));
            tempCurr = tempCurr.getNext();
        }
        //If the size is zero set the head to the new list
        if (size == 0) {
            head = tempHead;
            size += list.size();
            return true;
        }
        //If the index is 0 add list after the head
        if (index == 0) {
            getLast(tempHead).setNext(head);
            head = tempHead;
            size += list.size();

            return true;
        }
        //Loop over the linked list until target index
        Node<T> curr = head;
        for (int i = 1; i < index; i++) {
            curr = curr.getNext();
        }
        //Insert the sl at the target index
        getLast(tempHead).setNext(curr.getNext());
        curr.setNext(tempHead);
        size += list.size();

        return true;
    }

    /**
     * {@inheritDoc}
     */
    public boolean add(T obj) {
        //If size is 0 set the head to the new Node<T>
        if (size == 0) {
            head = new Node<T>(obj);
            size++;
            return true;
        }
        //Get the last element of the Linked List and set the next to the new Node<T>
        Node<T> temp = head;
        getLast(temp).setNext(new Node<T>(obj));
        size++;

        return true;
    }

    /**
     * {@inheritDoc}
     */
    public <U extends T> boolean add(GenList<U> list) {
        //Check for valid list
        if (list == null) {
            throw new NullPointerException();
        }
        //Check if list is empty
        if (list.size() == 0) {
            return false;
        }
        //Copy the elements of list to temporary Linked List
        Node<T> tempHead = new Node<T>(list.get(0));
        Node<T> tempCurr = tempHead;
        for (int i = 1; i < list.size(); i++) {
            tempCurr.setNext(new Node<T>(list.get(i)));
            tempCurr = tempCurr.getNext();
        }
        //If the size is 0 set the head to the new Node<T>
        if (size == 0) {
            head = tempHead;
            size += list.size();
            return true;
        }
        //Insert the new node at the end
        getLast(head).setNext(tempHead);
        size += list.size();

        return true;
    }

    /**
     * {@inheritDoc}
     */
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * {@inheritDoc}
     */
    public boolean contains(T o) {
        //Check if head is equal to the object
        if (head.getObj().equals(o)) {
            return true;
        }
        //Loop over Linked List to check if it contains o
        Node<T> temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            if (temp.getObj().equals(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public GenList<T> distinct() {
        //Check if the linked list is empty
        if (size == 0) {
            return new LinkedGenList<T>();
        }
        //Create a new Linked List to store distinct elements
        Node<T> tempHead = new Node<T>(get(0));
        Node<T> tempCurr = tempHead;
        int tempSize = 1;
        Node<T> curr = head;
        boolean hasDup = false;
        //Loop through main Linked List
        while (curr.getNext() != null) {
            curr = curr.getNext();
            //Check if the curent element is equal to the head in the new List
            if (curr.getObj().equals(tempHead.getObj())) {
                hasDup = true;
            } else {
                //Loop through the new list to see if it already contains the element
                while (tempCurr.getNext() != null) {
                    tempCurr = tempCurr.getNext();
                    if (curr.getObj().equals(tempCurr.getObj())) {
                        hasDup = true;
                        break;
                    }
                }
            }
            //Add the element to the new list if it is not a duplicate
            if (!hasDup) {
                getLast(tempHead).setNext(new Node<T>(curr.getObj()));
                tempSize++;
            }
            tempCurr = tempHead;
            hasDup = false;
        }
        return new LinkedGenList<T>(tempHead, tempSize);
    }

    /**
     * {@inheritDoc}
     */
    public T get(int index) {
        //Check for valid index
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        //Loop through Linked List until target
        Node<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.getNext();
        }
        //return the String at target
        return curr.getObj();
    }

    /**
     * {@inheritDoc}
     */
    public int indexOf(T obj) {
        //Check if the head contains the object
        if (head.getObj().equals(obj)) {
            return 0;
        }
        //Loop through the linked list to find the object
        int currIndex = 0;
        Node<T> curr = head;
        while (curr.getNext() != null) {
            curr = curr.getNext();
            currIndex++;
            if (curr.getObj().equals(obj)) {
                return currIndex;
            }
        }
        return -1;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public String makeString(String sep) {
        //Check if size is 0
        if (size == 0) {
            return "";
        }
        //Loops through the linked list and adds the Strings to str
        String str = "";
        Node<T> temp = head;
        for (int i = 0; i < size - 1; i++) {
            str += temp.getObj() + sep;
            temp = temp.getNext();
        }

        //add the last element to str and return
        return str + temp.getObj();
    }

    /**
     * {@inheritDoc}
     */
    public String makeString(String start, String sep, String end) {
        //Check if the size is 0
        if (size == 0) {
            return "";
        }
        //Sets str to start and loops through the linked list and add the Strings
        String str = start;
        Node<T> temp = head;
        for (int i = 0; i < size - 1; i++) {
            str += temp.getObj() + sep;
            temp = temp.getNext();
        }

        //Add the last element to str and add end
        return str + temp.getObj() + end;
    }

    /**
     * {@inheritDoc}
     */
    public T remove(int index) {
        //Check for valid index
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        //Check if the index is 0 and removes the node attached to head
        if (index == 0) {
            T obj = head.getObj();
            head = head.getNext();
            size--;
            return obj;
        }
        //Loop through linked list until target index
        Node<T> temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.getNext();
        }
        //Remove the node at target index
        T o = temp.getNext().getObj();
        temp.setNext(temp.getNext().getNext());
        size--;

        return o;
    }

    /**
     * {@inheritDoc}
     */
    public GenList<T> reverse() {
        //Check if size is 0
        if (size == 0) {
            return new LinkedGenList<T>();
        }
        //Create new Linked List and set the head to the last element
        Node<T> reversedHead = new Node<T>(getLast(head).getObj());
        Node<T> reversedCurr = reversedHead;
        //Loop through the linked list and add the elements to the new list in reverse order
        for (int i = size - 2; i > -1; i--) {
            reversedCurr.setNext(new Node<T>(get(i)));
            reversedCurr = reversedCurr.getNext();
        }
        return new LinkedGenList<T>(reversedHead, size);
    }

    /**
     * {@inheritDoc}
     */
    public T set(int index, T obj) {
        //Check if index is valid
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        //Loop to target index
        T o;
        Node<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.getNext();
        }
        //Change the object at target index
        o = curr.getObj();
        curr.setObj(obj);

        return o;
    }

    /**
     * {@inheritDoc}
     */
    public int size() {
        return size;
    }

    /**
     * {@inheritDoc}
     */
    public GenList<T> splice(int fromIndex, int toIndex) {
        //Check for valid index
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }
        //Create a new Linked List which will contain spliced portion
        Node<T> splicedHead = new Node<T>(get(fromIndex));
        Node<T> splicedCurr = splicedHead;
        int splicedSize = toIndex - fromIndex;
        //Loop through Linked List and copy elements to the Spliced List
        for (int i = fromIndex + 1; i < splicedSize; i++) {
            splicedCurr.setNext(new Node<T>(get(i)));
            splicedCurr = splicedCurr.getNext();
        }
        return new LinkedGenList<T>(splicedHead, splicedSize);
    }

    /**
     * {@inheritDoc}
     */
    public T[] toArray(IntFunction<T[]> gen) {
        //Loop through Linked List and add the elements to an array
        Node<T> curr = head;
        T[] a = gen.apply(size);
        for (int i = 0; i < size; i++) {
            a[i] = curr.getObj();
            curr = curr.getNext();
        }

        return a;
    }

    /**
     * {@inheritDoc}
     */
    public boolean allMatch(Predicate<T> p) {
        //Create temporary iterator
        Node<T> curr = head;
        //Loop through list to see if any fail the predicate
        for (int i = 0; i < size; i++) {
            if (!p.test(curr.getObj())) {
                return false;
            }
            curr = curr.getNext();
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    public boolean anyMatch(Predicate<T> p) {
        //Create temporary iterator
        Node<T> curr = head;
        //Loop through list to see if at least 1 element passes the predicate
        for (int i = 0; i < size; i++) {
            if (p.test(curr.getObj())) {
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public GenList<T> filter(Predicate<T> p) {
        //Create iterator for main list
        Node<T> curr = head;
        //Create new list
        Node<T> filteredHead = null;
        int filteredSize = 0;
        int ind = 0;
        //Loop through main list to assign a node to the filteredHead
        for (int i = 0; i < size; i++) {
            if (p.test(curr.getObj())) {
                filteredHead = new Node<T>(curr.getObj());
                curr = curr.getNext();
                filteredSize++;
                ind++;
                break;
            }
            curr = curr.getNext();
            ind++;
        }

        //Resume the loop and add any values which pass the predicate
        for (int i = ind; i < size; i++) {
            if (p.test(curr.getObj())) {
                getLast(filteredHead).setNext(new Node<T>(curr.getObj()));
                filteredSize++;
            }
            curr = curr.getNext();
        }

        return new LinkedGenList<T>(filteredHead, filteredSize);
    }

    /**
     * {@inheritDoc}
     */
    public T max(Comparator<T> c) {
        //Assign the max
        T m = head.getObj();
        //Loop through list to see if any elements are greater
        Node<T> curr = head.getNext();
        for (int i = 1; i < size; i++) {
            if (c.compare(m, curr.getObj()) < 0) {
                m = curr.getObj();
            }
            curr = curr.getNext();
        }

        return m;
    }

    /**
     * {@inheritDoc}
     */
    public T min(Comparator<T> c) {
        //Assign min
        T m = head.getObj();
        //Loop through list to see if any elements are lesser
        Node<T> curr = head.getNext();
        for (int i = 1; i < size; i++) {
            if (c.compare(m, curr.getObj()) > 0) {
                m = curr.getObj();
            }
            curr = curr.getNext();
        }

        return m;
    }

    /**
     * {@inheritDoc}
     */
    public T reduce(T start, BinaryOperator<T> f) {
        T result = start;
        //Repeatedly do the operation on the elements
        Node<T> curr = head;
        for (int i = 0; i < size; i++) {
            result = f.apply(result, curr.getObj());
            curr = curr.getNext();
        }

        return result;
    }

    /**
     * {@inheritDoc}
     */
    public <R> GenList<R> map(Function<T,R> f) {
        //Create new linked list
        Node<R> mappedHead = new Node<R>(f.apply(head.getObj()));
        Node<R> mappedCurr = mappedHead;
        int mappedSize = 0;
        //Loop through list add transform the elements in the list and add to new list
        Node<T> curr = head.getNext();
        for (int i = 0; i < size; i++) {
            mappedCurr.setNext(new Node<R>(f.apply(get(i))));
            mappedCurr = mappedCurr.getNext();
            mappedSize++;
        }

        return new LinkedGenList<R>(mappedHead, mappedSize);
    }

    /**
     * {@inheritDoc}
     */
    public Iterator<T> iterator() {
        //return the iterator
        return new LinkedGenListIterator<T>(this);
    }
}
