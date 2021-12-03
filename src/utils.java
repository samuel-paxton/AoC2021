import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class utils {
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
}
