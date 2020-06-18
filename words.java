// A class that turns a file of words into a list object

import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Words {
    public static ArrayList<String> list = new ArrayList<>();

    // Take in a file name and read that file
    public Words(String filename) throws java.io.FileNotFoundException {
        Scanner input = new Scanner(new FileReader(filename));
        while (input.hasNextLine()) {
            String line = input.nextLine().trim();
            list.add(line);
        }
        // Once every line in the file is added to a list, close the input
        input.close();
    }

    // Define a method that gets a random word from the list
    public String getRandomWord() {
        Random rand = new Random();
        int randomizer = rand.nextInt(list.size());
        String word = list.get(randomizer);
        return word;
    }

    // Define a method that removes words from the list
    public void remove(String word) {
        list.remove(word);
    }
}