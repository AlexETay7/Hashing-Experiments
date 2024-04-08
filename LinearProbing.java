/**
 * @author Alex Taylor CS321-002
 * @date 3/10/24
 * Contains a hash method specific to linear probing.
 */

public class LinearProbing extends Hashtable{

    /**
     * Initilizes a new LinearProbing object for hashing.
     * @param capacity - max size of the list
     * @param loadFactor - n/m is the load factor of the table (how full it is allowed to get)
     */
    public LinearProbing(int capacity, double loadFactor) {
        super(capacity, loadFactor);
    }

    /**
     * The Hash function for linear probing.
     * Follows the probe sequence: h(k, i) = (h′(k) + i) mod m
     */
    protected int h(Object element, int probe) {

        // Important to notice 'probe' and 'i' are equivalent as per the equation
        return positiveMod(positiveMod(element.hashCode(), capacity) + probe, capacity);
    }
}
