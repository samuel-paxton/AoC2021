import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day1 {
    public static void main(String[] args) {
        List<Integer> depths = utils.readListOfNumbersFromFile("inputs/day1.txt");

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
