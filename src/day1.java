import java.util.List;

public class day1 {
    public static int part1(List<Integer> depths) {
        int previousDepth = Integer.MAX_VALUE;
        int numDepthIncreases = 0;

        for (int currentDepth : depths) {
            if (currentDepth > previousDepth) {
                numDepthIncreases++;
            }

            previousDepth = currentDepth;
        }

        return numDepthIncreases;
    }

    public static int part2(List<Integer> depths) {
        return 10;
    }

    public static void main(String[] args) {
        List<Integer> depths = utils.readListOfNumbersFromFile("inputs/day1.txt");

        System.out.println("Number of times depth increased: " + part1(depths));
        System.out.println("Number of times three-measurement sliding window increased: " + part2(depths));
    }
}
