package cs1302.list;

import cs1302.listadt.StringList;

/**
 * Represents an {@code Array} implementation of a {@code StringList}.
 */
public class ArrayStringList implements cs1302.listadt.StringList {
    private int size;
    private String [] arr;

    /**
     * Constructs a {@code ArrayStringList} of size zero and instantiates the
     * underlying array data structure which is initially empty.
     */
    public ArrayStringList() {
        size = 0;
        arr = new String[20];
    }

    /**
     * Constructs a {@code ArrayStringList} by copying the specified StringList.
     * @param other the specified StringList
     */
    public ArrayStringList(StringList other) {
        //Check if other is null
        if (other == null) {
            throw new NullPointerException();
        }
        //Initialize size and copy over elements from other
        size = other.size();
        arr = new String[size + 20];
        for (int i = 0; i < size; i++) {
            arr[i] = other.get(i);
        }
    }

    /**
     * Constructs a {@code ArrayStringList} filled with contents from the specified array and of
     * specified size.
     *
     * @param a the specified {@code String} array
     * @param size the specified size.
     */
    private ArrayStringList(String [] a, int size) {
        this.size = size;
        this.arr = a;
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
        //Create new array and copy over elements until target index
        String[] temp = new String[arr.length + 1];
        for (int i = 0; i < index; i++) {
            temp[i] = arr[i];
        }
        //Set the element at target index to s
        temp[index] = s;
        //Increase size and copy over rest of elements
        size++;
        for (int i = index + 1; i < size; i++) {
            temp[i] = arr[i - 1];
        }
        arr = temp;

        return true;
    }

    /**
     * {@inheritDoc}
     */
    public boolean add(int index, StringList sl) {
        //Check for valid index
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        //Check for valid StringList
        if (sl == null) {
            throw new NullPointerException();
        }
        //Check if sl is empty
        if (sl.size() == 0) {
            return false;
        }
        //If specified index is at the end add it using add(StringList sl)
        if (index == size) {
            return add(sl);
        }
        //Create new array and copy over elements until target
        String[] temp = new String[arr.length + sl.size()];
        for (int i = 0; i < index; i++) {
            temp[i] = arr[i];
        }
        //Once target is reached copy over elements from sl
        for (int i = 0; i < sl.size(); i++) {
            temp[i + index] = sl.get(i);
        }
        //Increase size and copy over the rest of the elements in the list
        size += sl.size();
        for (int i = sl.size() + index; i < size; i++) {
            temp[i] = arr[i - sl.size()];
        }
        //set the array to temp
        arr = temp;

        return true;
    }

    /**
     * {@inheritDoc}
     */
    public boolean add(String s) {
        //Check for valid String
        if (s.equals("")) {
            throw new IllegalArgumentException();
        }
        //Check if array needs to be resized
        if (size + 1 > arr.length) {
            //Create new array and add s
            String[] temp = new String[arr.length + 20];
            for (int i = 0; i < size; i++) {
                temp[i] = arr[i];
            }
            temp[size] = s;
            size++;
            arr = temp;
        } else {
            //add s and increase size
            arr[size] = s;
            size++;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    public boolean add(StringList sl) {
        //Check for valid StringList
        if (sl == null) {
            throw new NullPointerException();
        }
        //Check if StringList is empty
        if (sl.size() == 0) {
            return false;
        }
        //Check if array needs to be resized
        if (size + sl.size() > arr.length) {
            //Create new array and add sl
            String[] temp = new String[arr.length + sl.size() + 20];
            for (int i = 0; i < size; i++) {
                temp[i] = arr[i];
            }
            for (int i = 0; i < sl.size(); i++) {
                temp[i + size] = sl.get(i);
            }
            size += sl.size();
            arr = temp;
        } else {
            //add sl
            for (int i = 0; i < sl.size(); i++) {
                arr[size + i] = sl.get(i);
            }
            //increase size of StringList
            size += sl.size();
        }

        return true;
    }

    /**
     * {@inheritDoc}
     */
    public void clear() {
        //Set size to 0 and set the array to an array of null values
        size = 0;
        arr = new String[20];
    }

    /**
     * {@inheritDoc}
     */
    public boolean contains(String o) {
        //Check for valid String
        if (o.equals("")) {
            throw new IllegalArgumentException();
        }
        //Check if String is in array
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(o)) {
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
        //Check if String exists in array regardless of case
        for (int i = 0; i < size; i++) {
            if (arr[i].equalsIgnoreCase(o)) {
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
        //Loop through array and search for substring
        for (int i = 0; i < size; i++) {
            if (arr[i].contains(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public StringList distinct() {
        //Create a new array to store distinct Strings
        String[] distArr = new String[arr.length];
        int distListSize = 0;
        boolean hasDup = false;
        //Loop through StringList array
        for (int i = 0; i < size; i++) {
            //Check if each element already exists in the new array
            for (int j = 0; j < distListSize; j++) {
                if (arr[i].equals(distArr[j])) {
                    hasDup = true;
                    break;
                }
            }
            //Add element to new array only if it does not exist in the StringList array
            if (!hasDup) {
                distArr[distListSize] = arr[i];
                distListSize++;
            }
            hasDup = false;
        }
        return new ArrayStringList(distArr, distListSize);
    }

    /**
     * {@inheritDoc}
     */
    public String get(int index) {
        //Check for valid index
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        //Return string at index
        return arr[index];
    }

    /**
     * {@inheritDoc}
     */
    public int indexOf(String s) {
        //Check for valid String
        if (s.equals("")) {
            throw new IllegalArgumentException();
        }
        //Find the index of string and return the index
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(s)) {
                return i;
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
        //Find the index of the string, ignoring case, and return the index
        for (int i = 0; i < size; i++) {
            if (arr[i].equalsIgnoreCase(s)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isEmpty() {
        //Check for size of StringList
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public String makeString(String sep) {
        //Check for size of string
        if (size == 0) {
            return "";
        }
        //Add all of the elements to the string except for the last element
        String str = "";
        for (int i = 0; i < size - 1; i++) {
            str += arr[i] + sep;
        }
        //Add last element to the string
        return str + arr[size - 1];
    }

    /**
     * {@inheritDoc}
     */
    public String makeString(String start, String sep, String end) {
        //Check for size of string
        if (size  == 0) {
            return "";
        }
        //Set the string equal to start and add the rest of the elements followed by the sep
        String str = start;
        for (int i = 0; i < size - 1; i++) {
            str += arr[i] + sep;
        }
        //Add the last element and end to the string so that it is not fllowed by the sep
        return str + arr[size - 1] + end;
    }

    /**
     * {@inheritDoc}
     */
    public String remove(int index) {
        //Check for valid index
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        //Store string at specified index
        String str = arr[index];
        //Create new array and copy everything until target index
        String[] temp = new String[arr.length];
        for (int i = 0; i < index; i++) {
            temp[i] = arr[i];
        }
        size--;
        //Skip the target index and copy the rest
        for (int i = index; i < size; i++) {
            temp[i] = arr[i + 1];
        }
        arr = temp;
        return str;
    }

    /**
     * {@inheritDoc}
     */
    public StringList reverse() {
        //Create new array to store reversed strings
        String[] reversed = new String[arr.length];
        //Loop over in reverse order and copy to new array
        for (int i = 0; i < size; i++) {
            reversed[i] = arr[size - 1 - i];
        }
        return new ArrayStringList(reversed, size);
    }

    /**
     * {@inheritDoc}
     */
    public String set(int index, String s) {
        //Check for valid index
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        //Check for valid string
        if (s.equals("")) {
            throw new IllegalArgumentException();
        }
        //Store string in specified index to be returned
        String str = arr[index];
        //Set the string at the specified index
        arr[index] = s;
        return str;
    }

    /**
     * {@inheritDoc}
     */
    public int size() {
        //Returns the size instance variable
        return size;
    }

    /**
     * {@inheritDoc}
     */
    public StringList splice(int fromIndex, int toIndex) {
        //Check if a valid index was provided
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }

        //Create new array which represents spliced string
        String[] spliced = new String[toIndex - fromIndex + 10];
        int splicedSize = toIndex - fromIndex;
        //Copy over spliced portion to new array
        for (int i = fromIndex; i < toIndex; i++) {
            spliced[i - fromIndex] = arr[i];
        }
        return new ArrayStringList(spliced, splicedSize);
    }

    /**
     * {@inheritDoc}
     */
    public String[] toArray() {
        //Create new array which is to be returned
        String[] listArr = new String[size];
        //Loop over the StringList array and copy to new array
        for (int i = 0; i < size; i++) {
            listArr[i] = arr[i];
        }
        return listArr;
    }
}
