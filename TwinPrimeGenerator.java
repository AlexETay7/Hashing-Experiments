/**
 * @author Alex Taylor CS321-002 Sp24
 * @date 3/10/24
 * Provides a method(generateTwinPrime) to find the smallest
 * set of twin primes both in the given 
 * range and then return the larger of the two.
 */

public class TwinPrimeGenerator {

    /**
     * Helper function to check if a number is prime.
     * @param num - num to check
     * @return - true if prime, false otherwise
     */
    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            // If num is divisible by i, it's not prime
            if (num % i == 0) {
                return false;
            }
        }
        // If no divisor was found, num is prime
        return true;
    }

    /**
     * Generates twin primes in the given range and returns the larger one.
     * @param min - minimum bound
     * @param max - maximum bound
     * @return - larger of twin primes if there are any, -1 if none found
     */
    public static int generateTwinPrime(int min, int max) {
        for (int i = min; i <= max - 2; i++) {
            if (isPrime(i) && isPrime(i + 2)) {
                return i + 2; // Return the larger twin prime
            }
        }
        return -1; // Indicates no twin primes found in the range
    }

}