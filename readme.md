# Mower

A Java program that simulates the movement of mowers on a square lawn.

## Description

The program reads an input file that specifies the dimensions of the lawn and the starting positions and instructions
for the mowers. It then processes the instructions for each mower and updates their positions and orientations according
to the instructions. The final positions and orientations of the mowers are printed to the console.

## Input File Format

The input file is a text file with the following format:

- The first line contains the dimensions of the lawn as two integers separated by a space, representing the maximum X
  and Y coordinates of the lawn. The bottom left corner is assumed to be (0,0).
- The rest of the file contains information about the mowers, one mower per block of two lines. Each block consists of:
    - The first line contains the starting position and orientation of the mower as three integers separated by spaces,
      representing the X and Y coordinates and the orientation (N, E, S, W).
    - The second line contains the instructions for the mower as a string of characters without spaces. The possible
      instructions are G (turn left), D (turn right), and A (move forward).

## Example

Input file:

```
5 5
1 2 N
GAGAGAGAA
3 3 E
AAGDAADDD
```

Output:

```
1 3 N
5 1 E
```

## How to Run

To run the program, you will need to have [Java](https://www.java.com/en/download/) 1.8+
and [Maven](https://maven.apache.org/download.cgi) installed on your machine.

1. Clone or download the repository.
2. Navigate to the root directory of the project.
3. Build the program using the following command:
   `mvn clean install`
4. Run the program using the following command, replacing `input.txt` with the path to the input file:
   `java -jar .\target\mowitnow-1.0-SNAPSHOT.jar input.txt`
   - I have left an example "input.txt" file at the root of the repository, feel free to replace the content with your own.
5. If you encounter a "NoClassDefFoundError", use this command instead : 
    `java -jar .\target\mowitnow-1.0-SNAPSHOT-jar-with-dependencies.jar input.txt`
    - The initial JAR needs some dependencies that may not be correctly available on the classpath.

## Notes

- If a mower moves outside the bounds of the lawn, it retains its position and orientation and continues to the next
  instruction.
