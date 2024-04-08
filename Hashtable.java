import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author Alex Taylor CS321-002 
 * @date 3/10/24
 * Defines an abstract hash table class using an array of
 * HashObjects, including all of the common HashTable 
 * functionality (insert, search, delete).
 */

public abstract class Hashtable {
    
    protected int size;
    protected int capacity;
    protected double loadFactor;
    protected HashObject[] table;
    protected int totalInserts;
    protected int totalProbes;

    /**
     * Defines an abstract hashing method to be implemented uniquely
     * in the LinearProbing class and in the DoubleHashing class.
     * @param element - Object to be hashed
     * @param probe - number of times we search the array for an open space, i in the hashing equation
     * @return - The index in the HashObject array for which the key is to be inserted into.
     */
    protected abstract int h(Object element, int probe);

    /**
     * Initializes a new Hashtable.
     * @param capacity - initial capacity (max size)
     * @param loadFactor - n/m is the load factor of the table (how full it is allowed to get)
     */
    protected Hashtable(int capacity, double loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.table = new HashObject[capacity];
        this.size = 0;
    }

    /**
     * Inserts a new HashObject with it's given key into the array.
     * @param key - the new HashObject's key value
     */
    protected void insert(Object key) {
        HashObject newObj = new HashObject(key);
        int i = 0;
        int j = 0;
        while (i < capacity) {
            j = h(key, newObj.getProbeCount());
            if (table[j] == null) {
                table[j] = newObj;
                size++; // Increment size when inserting
                table[j].incrementProbeCount();
                totalInserts++;
                totalProbes += (i + 1);
                return;
            } else if (table[j].equals(key)) {
                // Means we have duplicate
                table[j].incrementFrequency();
                return;
            } else {
                // Continue probing
                newObj.incrementProbeCount();
                i++;
            }
        }
        System.out.println("Error: Hash table overflow");
    }

    /**
     * Searches the array of HashObjects for a HashObject with the given key.
     * @param key - key we are searching for
     * @return index of HashObject if found, -1 otherwise
     */
    protected int search(Object key) {
        int i = 0;
        int j = 0;
        while (i != capacity) {
            j = h(key, i);
            if (table[j].getKey().equals(key)) { // Compare using equals method
                return j;
            } else {
                i++;
            }
        }
        return -1;
    }

    /**
     * Searches for the specified HashObject and removes it.
     * @param key - key of HashObject we are looking for
     */
    protected void delete(Object key) {
        int index = search(key); // Find index of the key
        if (index != -1) {
            table[index] = null; // Mark the entry as deleted
            size--; // Decrement size when deleting
        }
    }

    /**
     * Helper method to ensure positive mod operation.
     * @param dividend - dividend
     * @param divisor - divisor
     * @return - the resulting positive modulus of the operation
     */
    protected int positiveMod(int dividend, int divisor) {
        int quotient = dividend % divisor;
        if (quotient < 0)
            quotient += divisor;
        return quotient;
    }

    /**
     * Loops through the hash table, and prints non-null entries
     * to a dump file using toString() method in the HashObject class.
     * @param fileName - file to be written to
     * @throws FileNotFoundException
     */
    public void dumpToFile(String fileName) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(fileName);
        int index = 0; 
        for (HashObject obj : table) {
            if (obj != null) {
                out.println("table[" + index + "]: " + obj.toString()); // Write non-null entries to the file
            }
            index++;
        }
        out.close();
    }

    /**
     * Returns size of table
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns average probe count
     * @return totalProbes / totalInserts
     */
    public double avgProbes() {
        return (double) totalProbes / totalInserts;
    }

}
