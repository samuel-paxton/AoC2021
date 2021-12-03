import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day1 {
    public static List<Integer> readListOfNumbersFromFile(String filename) {
        List<Integer> nums = new ArrayList<Integer>();

        try {
            File file = new File(filename);
            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                nums.add(Integer.parseInt(data));
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't read from file: ");
            e.printStackTrace();
        }

        return nums;
    }

    public static void main(String[] args) {
        List<Integer> depths = readListOfNumbersFromFile("inputs/day1.txt");

        int previousDepth = Integer.MAX_VALUE;
        int numDepthIncreases = 0;

        for (int currentDepth : depths) {
            if (currentDepth > previousDepth) {
                numDepthIncreases++;
            }

            previousDepth = currentDepth;
        }

        System.out.println("Number of times depth increased from previous measurement: " + numDepthIncreases);
    }
}
