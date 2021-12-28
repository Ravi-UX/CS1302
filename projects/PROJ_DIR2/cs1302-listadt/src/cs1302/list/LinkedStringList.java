package cs1302.list;

import cs1302.listadt.StringList;

/**
 * Represents a {@code Linked} version of a {@code StringList}.
 */
public class LinkedStringList implements cs1302.listadt.StringList {
    private StringList.Node head = null;
    private int size;

    /**
     * Constructs a {@code LinkedStringList} of size 0.
     */
    public LinkedStringList() {
        size = 0;
    }

    /**
     * Constructs a linked {@code StringList} with identical elements to the provided StringList.
     * @param other the provided StringList
     */
    public LinkedStringList(StringList other) {
        //Check if other is null
        if (other == null) {
            throw new NullPointerException();
        }
        //Check if other is empty
        if (other.size() != 0) {
            //Create a temporary LinkedList and copy over elements from other
            StringList.Node tempHead = new StringList.Node(other.get(0));
            StringList.Node tempCurr = tempHead;
            for (int i = 1; i < other.size(); i++) {
                tempCurr.setNext(new StringList.Node(other.get(i)));
                tempCurr = tempCurr.getNext();
            }
            //Set the head to the the temporary list
            head = tempHead;
            size += other.size();
        }
    }

    /**
     * Constructs a linked {@code StringList} and sets the head and size to the specified head and
     * size.
     * @param head the specified head of a linked list
     * @param size the size of the specified linked list
     */
    private LinkedStringList(StringList.Node head, int size) {
        this.head = head;
        this.size = size;
    }

    /**
     * {@inheritDoc}
     */
    public boolean add(int index, String s) {
        //Check for valid index
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        //Check for valid String
        if (s.equals("")) {
            throw new IllegalArgumentException();
        }
        //Check if size of the StringList is 0 and set the head to a the new Node
        if (size == 0) {
            head = new StringList.Node(s);
            size++;
            return true;
        }
        //Create a new node with the String value s
        StringList.Node n = new StringList.Node(s);
        //If the index is zero add the String to the beginning
        if (index == 0) {
            n.setNext(head);
            head = n;
            size++;

            return true;
        }
        //Loop over the linked list until the target index
        StringList.Node curr = head;
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
    private StringList.Node getLast(StringList.Node n) {
        //Loop until last element is reached
        while (n.getNext() != null) {
            n = n.getNext();
        }
        return n;
    }

    /**
     * {@inheritDoc}
     */
    public boolean add(int index, StringList sl) {
        //Check for valid index
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        //Check for valid sl
        if (sl == null) {
            throw new NullPointerException();
        }
        //Check if sl is empty
        if (sl.size() == 0) {
            return false;
        }
        //Copy over elements in sl to a temporary linked list
        StringList.Node tempHead = new StringList.Node(sl.get(0));
        StringList.Node tempCurr = tempHead;
        for (int i = 1; i < sl.size(); i++) {
            tempCurr.setNext(new StringList.Node(sl.get(i)));
            tempCurr = tempCurr.getNext();
        }
        //If the size is zero set the head to the new sl
        if (size == 0) {
            head = tempHead;
            size += sl.size();
            return true;
        }
        //If the index is 0 add sl after the head
        if (index == 0) {
            getLast(tempHead).setNext(head);
            head = tempHead;
            size += sl.size();

            return true;
        }
        //Loop over the linked list until target index
        StringList.Node curr = head;
        for (int i = 1; i < index; i++) {
            curr = curr.getNext();
        }
        //Insert the sl at the target index
        getLast(tempHead).setNext(curr.getNext());
        curr.setNext(tempHead);
        size += sl.size();

        return true;
    }

    /**
     * {@inheritDoc}
     */
    public boolean add(String s) {
        //Check for valid s
        if (s.equals("")) {
            throw new IllegalArgumentException();
        }
        //If size is 0 set the head to the new Node
        if (size == 0) {
            head = new StringList.Node(s);
            size++;
            return true;
        }
        //Get the last element of the Linked List and set the next to the new Node
        StringList.Node temp = head;
        getLast(temp).setNext(new StringList.Node(s));
        size++;

        return true;
    }

    /**
     * {@inheritDoc}
     */
    public boolean add(StringList sl) {
        //Check for valid sl
        if (sl == null) {
            throw new NullPointerException();
        }
        //Check if sl is empty
        if (sl.size() == 0) {
            return false;
        }
        //Copy the elements of sl to temporary Linked List
        StringList.Node tempHead = new StringList.Node(sl.get(0));
        StringList.Node tempCurr = tempHead;
        for (int i = 1; i < sl.size(); i++) {
            tempCurr.setNext(new StringList.Node(sl.get(i)));
            tempCurr = tempCurr.getNext();
        }
        //If the size is 0 set the head to the new Node
        if (size == 0) {
            head = tempHead;
            size += sl.size();
            return true;
        }
        //Insert the new node at the end
        getLast(head).setNext(tempHead);
        size += sl.size();

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
    public boolean contains(String o) {
        //Check for valid String
        if (o.equals("")) {
            throw new IllegalArgumentException();
        }
        //Check if head is equal to the string
        if (head.getStr().equals(o)) {
            return true;
        }
        //Loop over Linked List to check if it contains o
        StringList.Node temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            if (temp.getStr().equals(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public boolean containsIgnoreCase(String o) {
        //Check for valid String
        if (o.equals("")) {
            throw new IllegalArgumentException();
        }
        //Check if the head contains the string
        if (head.getStr().equalsIgnoreCase(o)) {
            return true;
        }
        //Loop over Linked List to check if it contains o
        StringList.Node temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            if (temp.getStr().equalsIgnoreCase(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public boolean containsSubstring(String o) {
        //Check for valid String
        if (o.equals("")) {
            throw new IllegalArgumentException();
        }
        //Check if the head contains the substring
        if (head.getStr().contains(o)) {
            return true;
        }
        //Loop through Linked List to check if it contains o
        StringList.Node temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            if (temp.getStr().contains(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public StringList distinct() {
        //Check if the linked list is empty
        if (size == 0) {
            return new LinkedStringList();
        }
        //Create a new Linked List to store distinct elements
        StringList.Node tempHead = new StringList.Node(get(0));
        StringList.Node tempCurr = tempHead;
        int tempSize = 1;
        StringList.Node curr = head;
        boolean hasDup = false;
        //Loop through main Linked List
        while (curr.getNext() != null) {
            curr = curr.getNext();
            //Check if the curent element is equal to the head in the new List
            if (curr.getStr().equals(tempHead.getStr())) {
                hasDup = true;
            } else {
                //Loop through the new list to see if it already contains the element
                while (tempCurr.getNext() != null) {
                    tempCurr = tempCurr.getNext();
                    if (curr.getStr().equals(tempCurr.getStr())) {
                        hasDup = true;
                        break;
                    }
                }
            }
            //Add the element to the new list if it is not a duplicate
            if (!hasDup) {
                getLast(tempHead).setNext(new StringList.Node(curr.getStr()));
                tempSize++;
            }
            tempCurr = tempHead;
            hasDup = false;
        }
        return new LinkedStringList(tempHead, tempSize);
    }

    /**
     * {@inheritDoc}
     */
    public String get(int index) {
        //Check for valid index
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        //Loop through Linked List until target
        StringList.Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.getNext();
        }
        //return the String at target
        return curr.getStr();
    }

    /**
     * {@inheritDoc}
     */
    public int indexOf(String s) {
        //Check for valid String
        if (s.equals("")) {
            throw new IllegalArgumentException();
        }
        //Check if the head contains the String
        if (head.getStr().equals(s)) {
            return 0;
        }
        //Loop through the linked list to find the String
        int currIndex = 0;
        StringList.Node curr = head;
        while (curr.getNext() != null) {
            curr = curr.getNext();
            currIndex++;
            if (curr.getStr().equals(s)) {
                return currIndex;
            }
        }
        return -1;
    }

    /**
     * {@inheritDoc}
     */
    public int indexOfIgnoreCase(String s) {
        //Check for valid String
        if (s.equals("")) {
            throw new IllegalArgumentException();
        }
        //Check if head contains the String
        if (head.getStr().equalsIgnoreCase(s)) {
            return 0;
        }
        //Loop through the linked list to find String
        int currIndex = 0;
        StringList.Node curr = head;
        while (curr.getNext() != null) {
            curr = curr.getNext();
            currIndex++;
            if (curr.getStr().equalsIgnoreCase(s)) {
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
        StringList.Node temp = head;
        for (int i = 0; i < size - 1; i++) {
            str += temp.getStr() + sep;
            temp = temp.getNext();
        }

        //add the last element to str and return
        return str + temp.getStr();
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
        StringList.Node temp = head;
        for (int i = 0; i < size - 1; i++) {
            str += temp.getStr() + sep;
            temp = temp.getNext();
        }

        //Add the last element to str and add end
        return str + temp.getStr() + end;
    }

    /**
     * {@inheritDoc}
     */
    public String remove(int index) {
        //Check for valid index
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        //Check if the index is 0 and removes the node attached to head
        if (index == 0) {
            String str = head.getStr();
            head = head.getNext();
            size--;
            return str;
        }
        //Loop through linked list until target index
        StringList.Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.getNext();
        }
        //Remove the node at target index
        String str = temp.getNext().getStr();
        temp.setNext(temp.getNext().getNext());
        size--;

        return str;
    }

    /**
     * {@inheritDoc}
     */
    public StringList reverse() {
        //Check if size is 0
        if (size == 0) {
            return new LinkedStringList();
        }
        //Create new Linked List and set the head to the last element
        StringList.Node reversedHead = new StringList.Node(getLast(head).getStr());
        StringList.Node reversedCurr = reversedHead;
        //Loop through the linked list and add the elements to the new list in reverse order
        for (int i = size - 2; i > -1; i--) {
            reversedCurr.setNext(new StringList.Node(get(i)));
            reversedCurr = reversedCurr.getNext();
        }
        return new LinkedStringList(reversedHead, size);
    }

    /**
     * {@inheritDoc}
     */
    public String set(int index, String s) {
        //Check if index is valid
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        //Check if string is valid
        if (s.equals("")) {
            throw new IllegalArgumentException();
        }
        //Loop to target index
        String str;
        StringList.Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.getNext();
        }
        //Change the str at target index
        str = curr.getStr();
        curr.setStr(s);

        return str;
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
    public StringList splice(int fromIndex, int toIndex) {
        //Check for valid index
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }
        //Create a new Linked List which will contain spliced portino
        StringList.Node splicedHead = new StringList.Node(get(fromIndex));
        StringList.Node splicedCurr = splicedHead;
        int splicedSize = toIndex - fromIndex;
        //Loop through Linked List and copy elements to the Spliced List
        for (int i = fromIndex + 1; i < splicedSize; i++) {
            splicedCurr.setNext(new StringList.Node(get(i)));
            splicedCurr = splicedCurr.getNext();
        }
        return new LinkedStringList(splicedHead, splicedSize);
    }

    /**
     * {@inheritDoc}
     */
    public String[] toArray() {
        //Loop through Linked List and add the elements to an array
        StringList.Node curr = head;
        String[] str = new String[size];
        for (int i = 0; i < size; i++) {
            str[i] = curr.getStr();
            curr = curr.getNext();
        }

        return str;
    }
}
