import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class words {
    public static ArrayList<String> list = new ArrayList<>();

    public words(String filename) throws java.io.FileNotFoundException {
        Scanner input = new Scanner(new FileReader(filename));
        while (input.hasNextLine()) {
            String line = input.nextLine().trim();
            list.add(line);
        }
        input.close();
    }

    public String getRandomWord() {
        Random rand = new Random();
        int randomizer = rand.nextInt(list.size());
        String word = list.get(randomizer);
        return word;
    }

    public void remove(String word) {
        list.remove(word);
    }
}