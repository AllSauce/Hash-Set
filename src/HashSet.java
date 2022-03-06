import java.util.LinkedList;
import java.util.List;

/**
 * A hash table-based implementation of the Set interface.
 *
 * @author YOUR NAME HERE
 * @version DATE
 */
public class HashSet<T> implements Set<T> {
    private List<T>[] table;
    private int size;

    /**
     * Creates a hash table with the given capacity (amount of buckets).
     *
     * @throws IllegalArgumentException if capacity <= 0.
     */
    public HashSet(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(
                "capacity must be a positive, non-zero value! Provided: " + capacity);
        }

        size = 0;

        @SuppressWarnings("unchecked") // for this declaration only
        List<T>[] t = new LinkedList[capacity];

        table = t;
    }

    /**
     * Adds the given element to the set.
     *
     * Complexity: O(1) expected time.
     *
     * @param elem An element to add to the set.
     * @return true if the set did not contain the element, otherwise false.
     */
    public boolean add(T elem) {
        //Get Hashcode of element
        int index = compress(elem.hashCode());

        if(table[index] == null) table[index] = new LinkedList<T>();

        if(!table[index].contains(elem)){
            table[index].add(elem);
            size++;
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Removes the given element from the dictionary, if it is present.
     *
     * Complexity: O(1) expected time.
     *
     * @param elem An element to remove from the set.
     * @return true if the set contained the element, false otherwise.
     */
    public boolean remove(T elem) {

        int index = compress(elem.hashCode());

        if(table[index] == null) table[index] = new LinkedList<T>();

        if(table[index].contains(elem)){
            table[index].remove(elem);
            size--;
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Check if an element is in the Set.
     *
     * Complexity: O(1) expected time.
     *
     * @param elem An element to look for.
     * @return true if the element is in the set, false otherwise.
     */
    public boolean contains(T elem) {

        int index = compress(elem.hashCode());

        if(table[index] == null) table[index] = new LinkedList<T>();

        if(table[index].contains(elem)){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Returns the number of elements in this set.
     *
     * Complexity: O(1) expected time.
     *
     * @return The amount of elements in this set.
     */
    public int size() {
        return size;
    }

    //Returns a hashcode for the element.
    public int compress(int hashCode){
        return (hashCode % table.length + table.length) % table.length;
    }
}
