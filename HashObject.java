/**
 * @author Alex Taylor CS321-002
 * @date 3/10/24
 * Creates a HashObject class where each
 * HashObject has a frequency (duplicates), probeCount, and key.
 */

public class HashObject {
    
    private Object key;
    private int frequency;
    private int probeCount;

    /**
     * Initializes a new HashObject.
     * @param key - key value for the HashObject
     */
    public HashObject(Object key) {
        this.key = key;
        this.frequency= 1;
        this.probeCount = 0;
    }

    /**
     * Get's the key for the given HashObject.
     * @return - key
     */
    public Object getKey() {
        return key;
    }

    /**
     * Returns frequency.
     * @return - frequency
     */
    public int getFrequency() {
        return frequency;
    }

    /**
     * Increments the frequency for the given HashObject.
     */
    public void incrementFrequency() {
        frequency++;
    }

    /**
     * Returns probeCount.
     * @return - probeCount
     */
    public int getProbeCount() {
        return probeCount;
    }

    /**
     * Increments the probeCount for the given HashObject.
     */
    public void incrementProbeCount() {
        probeCount++;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getKey().equals(obj);
    }

    @Override
    public String toString() {
        return key + " " + frequency + " " + probeCount;
    }

}
