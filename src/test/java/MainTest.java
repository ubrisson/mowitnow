import org.example.MowerProcessor;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainTest {

    public static void main(String[] args) {
        String inputFile = "src/test/resources/input.txt";
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
