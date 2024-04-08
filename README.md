# Project #3: Experiments with Hashing

* Author: Alex Taylor
* University Project

## Overview

In this project I implemented a non-generic Hashtable class with open addressing.
This project studies how the load factor affects the average number of probes 
required using linear probing and double hashing for various types of inputs.


## Reflection

This project was pretty challenging at first becuase I did not feel like
I got a super good grip on the concept in lecture. What worked well for
me was going through the lecture notes and the textbook and familiarizing
myself with the problem this code was solving and WHY this method is
worth using. Once I understood how classes were supposed to interact with
one another, I was able to implement most of them without too much trouble.

I enjoyed making the HashtableExperiment class for the most part, however 
some of the condition checking was a little confusing. It was a lot of fun 
running the project on AWS! The only thing I struggled with was realizing 
I needed a personal access token in order to clone my github repo to my EC2
instance. Overall I definitely have a better grasp on linear probing
and double hashing, and enjoyed this project!

## Compiling and Using

Experiments are done via the HashtableExperiment.java file.

Compile this class by doing:

<pre>
javac HashtableExperiment.java
</pre>

Run this command to get a prompt of how to use the class:

<pre>
java HashtableExperiment
</pre>

*Note that doing "java HashtableExperiment.java" here will cause an error* 

Console output will give results once the program finishes.

## Results 

### Data Source 1 - Integer Objects

| Load Factor | Collision Strategy | Hash Table Size | Inserted Elements | Duplicates | Average Probes |
|-------------|--------------------|-----------------|-------------------|------------|----------------|
| 0.5         | Linear Probing     | 47896           | 47896             | 0          | 1.51           |
| 0.5         | Double Hashing     | 47896           | 47896             | 0          | 1.39           |
| 0.6         | Linear Probing     | 57475           | 57475             | 0          | 1.75           |
| 0.6         | Double Hashing     | 57475           | 57475             | 0          | 1.53           |
| 0.7         | Linear Probing     | 67054           | 67055             | 1          | 2.17           |
| 0.7         | Double Hashing     | 67054           | 67055             | 1          | 1.72           |
| 0.8         | Linear Probing     | 76633           | 76634             | 1          | 2.98           |
| 0.8         | Double Hashing     | 76633           | 76634             | 1          | 2.01           |
| 0.9         | Linear Probing     | 86212           | 86214             | 2          | 5.46           |
| 0.9         | Double Hashing     | 86212           | 86214             | 2          | 2.57           |
| 0.95        | Linear Probing     | 91002           | 91002             | 0          | 10.52          |
| 0.95        | Double Hashing     | 91002           | 91002             | 0          | 3.13           |
| 0.99        | Linear Probing     | 94834           | 94835             | 1          | 50.02          |
| 0.99        | Double Hashing     | 94834           | 94835             | 1          | 4.66           |


### Data Source 2 - Dates as longs

| Load Factor | Collision Strategy | Hash Table Size | Inserted Elements | Duplicates | Average Probes |
|-------------|--------------------|-----------------|-------------------|------------|----------------|
| 0.5         | Linear Probing     | 47896           | 47896             | 0          | 1.08           |
| 0.5         | Double Hashing     | 47896           | 47896             | 0          | 1.11           |
| 0.6         | Linear Probing     | 57475           | 57475             | 0          | 1.08           |
| 0.6         | Double Hashing     | 57475           | 57475             | 0          | 1.14           |
| 0.7         | Linear Probing     | 67054           | 67054             | 0          | 1.10           |
| 0.7         | Double Hashing     | 67054           | 67054             | 0          | 1.20           |
| 0.8         | Linear Probing     | 76633           | 76633             | 0          | 1.22           |
| 0.8         | Double Hashing     | 76633           | 76633             | 0          | 1.37           |
| 0.9         | Linear Probing     | 86212           | 86212             | 0          | 1.76           |
| 0.9         | Double Hashing     | 86212           | 86212             | 0          | 2.21           |
| 0.95        | Linear Probing     | 91002           | 91002             | 0          | 2.18           |
| 0.95        | Double Hashing     | 91002           | 91002             | 0          | 2.87           |
| 0.99        | Linear Probing     | 94834           | 94834             | 0          | 3.71           |
| 0.99        | Double Hashing     | 94834           | 94834             | 0          | 4.31           |


### Data Source 3 - String Objects

| Load Factor | Collision Strategy | Hash Table Size | Inserted Elements | Duplicates | Average Probes |
|-------------|--------------------|-----------------|-------------------|------------|----------------|
| 0.5         | Linear Probing     | 47896           | 1305930           | 1258034    | 1.60           |
| 0.5         | Double Hashing     | 47896           | 1305930           | 1258034    | 1.39           |
| 0.6         | Linear Probing     | 57475           | 1587659           | 1530184    | 2.15           |
| 0.6         | Double Hashing     | 57475           | 1587659           | 1530184    | 1.53           |
| 0.7         | Linear Probing     | 67054           | 1869206           | 1802152    | 3.60           |
| 0.7         | Double Hashing     | 67054           | 1869206           | 1802152    | 1.72           |
| 0.8         | Linear Probing     | 76633           | 2147748           | 2071115    | 6.71           |
| 0.8         | Double Hashing     | 76633           | 2147748           | 2071115    | 2.02           |
| 0.9         | Linear Probing     | 86212           | 2840050           | 2753838    | 19.81          |
| 0.9         | Double Hashing     | 86212           | 2840050           | 2753838    | 2.57           |
| 0.95        | Linear Probing     | 91002           | 3013622           | 2922620    | 110.59         |
| 0.95        | Double Hashing     | 91002           | 3013622           | 2922620    | 3.19           |
| 0.99        | Linear Probing     | 94834           | 3024134           | 2929300    | 471.67         |
| 0.99        | Double Hashing     | 94834           | 3024134           | 2929300    | 4.70           |


## Sources used

- Algorithms Class Notes
- Algorithms Textbook
- Tutoring Center

----------
