import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author Alex Taylor CS321-002
 * @date 3/10/24
 * 
 * The driver program that takes 3 command line arguments.
 * Performs experiments using the LinearProbing, DoubleHashing, HashObject, and TwinPrimeGenerator classes.
 */

public class HashtableExperiment {

    public static void main(String[] args) {
        // Check if the correct number of arguments is provided
        if (args.length < 2 || args.length > 3) {
            System.err.println("Usage: java HashtableExperiment <dataSource> <loadFactor> [<debugLevel>]");
            System.err.println("<dataSource>: 1 ==> random numbers, 2 ==> date value as a long, 3 ==> word list");
            System.err.println("<loadFactor>: The ratio of objects to table size, denoted by alpha = n/m");
            System.err.println("<debugLevel>: 0 ==> print summary of experiment, 1 ==> save the two hash tables to a file at the end, 2 ==> print debugging output for each insert");
            return;
        }

        // Parse command-line arguments
        int dataSource = Integer.parseInt(args[0]);
        double loadFactor = Double.parseDouble(args[1]);
        int debugLevel = args.length == 3 ? Integer.parseInt(args[2]) : 0;

        // Initialize hash tables with capacity from TwinPrimeGenerator class
        int tableCapacity = (int) Math.ceil(TwinPrimeGenerator.generateTwinPrime(95500, 96000));
        LinearProbing linearProbingOne = new LinearProbing(tableCapacity, loadFactor);
        DoubleHashing doubleHashOne = new DoubleHashing(tableCapacity, loadFactor);
        
        // Initialize tracking and naming variables
        String source = "";
        int counter = 0;
        int counter2 = 0;
        int index = 0;

        if (dataSource == 1) {
            source = "random numbers";
            // Create a Random object
            Random random = new Random();
            // Insert objects for linear probing and double hashing
            while (((double)linearProbingOne.getSize() / linearProbingOne.capacity) < loadFactor || ((double)doubleHashOne.getSize() / doubleHashOne.capacity) < loadFactor) {
                int randomNumber = random.nextInt();
                // Condition check before we insert
                if (((double) doubleHashOne.getSize() / doubleHashOne.capacity) < loadFactor) {
                    doubleHashOne.insert(randomNumber);
                    counter2++;
                }
                // Condition check before we insert
                if (((double) linearProbingOne.getSize() / linearProbingOne.capacity) < loadFactor) {
                    linearProbingOne.insert(randomNumber);
                    counter++;
                }
            }
            
        } else if (dataSource == 2) {

            source = "date value";
            // Create new date instance
            long current = new Date().getTime();
            // Insert dates into linear and double hashing
            while (((double)linearProbingOne.size / (double)linearProbingOne.capacity) < loadFactor || ((double)doubleHashOne.getSize() / doubleHashOne.capacity) < loadFactor) {
                current += 1000;
                Date date = new Date(current);
                // Condition check before we insert
                if (((double) linearProbingOne.getSize() / linearProbingOne.capacity) < loadFactor) {
                    linearProbingOne.insert(date);
                    counter++;
                }
                // Condition check before we insert
                if (((double) doubleHashOne.getSize() / doubleHashOne.capacity) < loadFactor) {
                    doubleHashOne.insert(date);
                    counter2++;
                }
            }

        } else {
            source = "word list";
            // Store all words in a list, then insert words into both tables
            List<String> words = new ArrayList<>();

            // Read word-list.txt file
            try (BufferedReader reader = new BufferedReader(new FileReader("word-list.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    words.add(line.trim());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Insert words into both hash tables
            for (String word : words) {
                // Condition check before we insert
                if (((double) linearProbingOne.getSize() / linearProbingOne.capacity) < loadFactor) {
                    linearProbingOne.insert(word);
                    counter++;
                }
                // Condition check before we insert
                if (((double) doubleHashOne.getSize() / doubleHashOne.capacity) < loadFactor) {
                    doubleHashOne.insert(word);
                    counter2++;
                }
            }
        }


        // Handle debug levels
        if (debugLevel == 0) {
            System.out.println("\nHashtableExperiment: Found a twin prime table capacity: " + TwinPrimeGenerator.generateTwinPrime(95500,96000));
            System.out.println("HashtableExperiment: Input: " + source + "   Load Factor: " + loadFactor);
            System.out.println("    Using Linear Probing");
            System.out.println("HashtableExperiment: size of hash table is " + (int)Math.ceil(TwinPrimeGenerator.generateTwinPrime(95500, 96000) * loadFactor));
            System.out.println("Inserted " + counter + " elements, of which " + (counter - linearProbingOne.size) + " were duplicates");
            System.out.println("Avg. no. of probes = " + String.format("%.2f", linearProbingOne.avgProbes()));
            System.out.println("\n    Using Double Hashing");
            System.out.println("HashtableExperiment: size of hash table is " + (int)Math.ceil(TwinPrimeGenerator.generateTwinPrime(95500, 96000) * loadFactor));
            System.out.println("Inserted " + counter2 + " elements, of which " + (counter2 - doubleHashOne.size) + " were duplicates");
            System.out.println("Avg. no. of probes = " + String.format("%.2f", doubleHashOne.avgProbes()));

        } else if (debugLevel == 1) {
            // Save hash tables to files and print console info
            try {
                linearProbingOne.dumpToFile("linear-dump.txt");
                doubleHashOne.dumpToFile("double-dump.txt");
                System.out.println("\nHashtableExperiment: Found a twin prime table capacity: " + TwinPrimeGenerator.generateTwinPrime(95500,96000));
                System.out.println("HashtableExperiment: Input: " + source + "   Load Factor: " + loadFactor);
                System.out.println("    Using Linear Probing");
                System.out.println("HashtableExperiment: size of hash table is " + (int)Math.ceil(TwinPrimeGenerator.generateTwinPrime(95500, 96000) * loadFactor));
                System.out.println("Inserted " + counter + " elements, of which " + (counter - linearProbingOne.size) + " were duplicates");
                System.out.println("Avg. no. of probes = " + String.format("%.2f", linearProbingOne.avgProbes()));
                System.out.println("HashtableExperiment: Saved dump of hash table");
                System.out.println("\n    Using Double Hashing");
                System.out.println("HashtableExperiment: size of hash table is " + (int)Math.ceil(TwinPrimeGenerator.generateTwinPrime(95500, 96000) * loadFactor));
                System.out.println("Inserted " + counter2 + " elements, of which " + (counter2 - doubleHashOne.size) + " were duplicates");
                System.out.println("Avg. no. of probes = " + String.format("%.2f", doubleHashOne.avgProbes()));
                System.out.println("HashtableExperiment: Saved dump of hash table");
            } catch (FileNotFoundException e) {
                System.err.println("Error: File not found.");
                e.printStackTrace();
            }
        } else if (debugLevel == 2) {
            // Print each element and it's info to the console
            for (HashObject obj : linearProbingOne.table) {
                if (obj != null) {
                    System.out.println("table[" + index + "]: " + obj.toString());
                }
                index++;
            }
            
        }
    }
    
}
