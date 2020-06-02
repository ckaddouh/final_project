import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Words {
    private ArrayList<String> list = new ArrayList<>();
    public Words(String filename) throws java.io.FileNotFoundException {
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
        String random = list.get(randomizer);
        return random;
    }

    public void remove(String word) {
        list.remove(word);
    }
}