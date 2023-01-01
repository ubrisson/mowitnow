package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main input_file");
            return;
        }

        String inputFile = args[0];
        MowerProcessor processor = new MowerProcessor();
        try {
            processor.processInstructions(inputFile);
        } catch (FileNotFoundException e) {
            System.out.println("Error: input file not found : " + inputFile);
        } catch (IOException e) {
            System.out.println("Error: input file could not be read : " + inputFile);
        }
    }
}
