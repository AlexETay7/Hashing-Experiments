/**
 * @author Alex Taylor CS321-002
 * @date 3/10/24
 * Contains a hash method specific to double hashing.
 */

public class DoubleHashing extends Hashtable {

    /**
     * Initializes a new DoubleHashing object for hashing.
     * @param capacity - max size of the list
     * @param loadFactor - n/m is the load factor of the table (how full it is allowed to get)
     */
    public DoubleHashing(int capacity, double loadFactor) {
        super(capacity, loadFactor);
    }

    /**
     * The Hash function for double hashing.
     * Follows the probe sequence: h(k, i) = (h1(k) + ih2(k)) mod m
     */
    protected int h(Object element, int probe) {

        // Store h1 and h2 in seperate variables and perform mod operations
        int h1 = positiveMod(element.hashCode(), capacity);
        int h2 = 1 + positiveMod(element.hashCode(), capacity - 2);
        // Calculate final mod
        return positiveMod(h1 + (probe * h2), capacity);
    }

}
