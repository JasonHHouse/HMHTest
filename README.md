# HMHTest

Current version 1.0-SNAPSHOT

## Prerequisites 

    JDK 1.8
        * Normal install, used for building
    Maven
        * Normal install, used for building

## Solutions
### Solution 1
Solution 1 is a simple iterative solution going through each of the possible words, 
adding that word to a list and then looping on the words being sure to not duplicate 
a word used. This isn't ideal because of the nested loops for performance and this 
solution is hard coding the loops. However, it is a quick solution and for small 
data sets it shows the outcome quickly.

### Solution 2
Solution 2 is more dynamic but also requires more complex code. Solution 2 works in 
multiple stages. The first stage is find all of the subsets of the list of words to 
find the permutations of. Once those subsets are found, the permutations on those 
subsets are created. Lastly, I loop through the results and print out the values 
that are actually palindromes. 

## Build 

    mvn clean install

## Execution

Running Solution 1

    java -jar Solution1/Solution1-1.0-SNAPSHOT-jar-with-dependencies.jar
    
Running Solution 2

    java -jar Solution2/Solution2-1.0-SNAPSHOT-jar-with-dependencies.jar