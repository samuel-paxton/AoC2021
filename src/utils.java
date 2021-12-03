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

    public static List<String> readListOfStringsFromFile(String filename) {
        List<String> strings = new ArrayList<String>();

        try {
            File file = new File(filename);
            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                strings.add(data);
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't read from file: ");
            e.printStackTrace();
        }

        return strings;
    }

    public static List<MovementCommand> readListOfMovementCommands(String filename) {
        List<MovementCommand> commands = new ArrayList<MovementCommand>();

        try {
            File file = new File(filename);
            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] values = data.split(" ");
                String direction = values[0];
                int amount = Integer.parseInt(values[1]);

                commands.add(new MovementCommand(direction, amount));
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't read from file: ");
            e.printStackTrace();
        }

        return commands;
    }
}
