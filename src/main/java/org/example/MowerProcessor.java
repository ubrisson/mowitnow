package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MowerProcessor {

    /**
     * Processes the instructions for the mowers in the given input file.
     * Returns a list of mowers with their updated positions and orientations.
     *
     * @param inputFilePath the path to the input file
     * @throws IOException if an error occurs while reading the input file
     */
    public void processInstructions(String inputFilePath) throws IOException {
        List<Mower> mowers = new ArrayList<>();

        // open a stream for the input file
        InputStream inputStream = new FileInputStream(inputFilePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        // read the dimensions of the lawn
        String[] dimensions = reader.readLine().split(" ");
        int maxX = Integer.parseInt(dimensions[0]);
        int maxY = Integer.parseInt(dimensions[1]);

        // read the mowers and their instructions
        String line;
        while ((line = reader.readLine()) != null) {
            // read the mower's starting position and orientation
            String[] position = line.split(" ");
            int x = Integer.parseInt(position[0]);
            int y = Integer.parseInt(position[1]);
            Orientation orientation = Orientation.fromString(position[2]);

            // read the mower's instructions
            String instructions = reader.readLine();

            // create a mower and process its instructions
            Mower mower = new Mower(x, y, orientation, instructions);
            mower.processInstructions(maxX, maxY);

            mowers.add(mower);
        }

        reader.close();

       // return mowers;
    }
}

