package cs1302.genlist;

import cs1302.genlistadt.GenList;
import java.util.*;

/**
 * Represents an Iterator of type T for the LinkedGenList.
 */
public class LinkedGenListIterator<T> implements Iterator<T> {
    private GenList<T> iterator;
    private int counter = 0;

    /**
     * Create a new Iterator and set the iterator to the given list.
     * @param li the specified list
     */
    public LinkedGenListIterator(GenList<T> li) {
        iterator = li;
    }

    /**
     * Checks if the list has another element.
     * @return true if there is another element
     */
    public boolean hasNext() {
        //Ceck if there is another element
        if (counter < iterator.size()) {
            return true;
        }
        return false;
    }

    /**
     * Gets the next element of the list.
     * @return the next element
     */
    public T next() {
        //Check if there is another element
        if (counter >= iterator.size()) {
            throw new NoSuchElementException();
        }
        T elem = iterator.get(counter);
        counter++;

        return elem;
    }
}
