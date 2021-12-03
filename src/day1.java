import java.util.List;

public class day1 {
    public static int part1(List<Integer> depths) {
        int previousDepth = depths.get(0);
        int numDepthIncreases = 0;

        for (int i = 1; i < depths.size(); i++) {
            int currentDepth = depths.get(i);
            if (currentDepth > previousDepth) {
                numDepthIncreases++;
            }

            previousDepth = currentDepth;
        }

        return numDepthIncreases;
    }

    public static int part2(List<Integer> depths, int slidingWindow) {
        int previousWindowSum = 0;

        for (int i = 0; i < slidingWindow; i++) {
            previousWindowSum += depths.get(i);
        }

        int numSumIncreases = 0;
        for (int i = 1; i <= depths.size() - slidingWindow; i++) {
            int currentWindowSum = 0;
            for (int j = i; j < i + slidingWindow; j++) {
                currentWindowSum += depths.get(j);
            }

            if (currentWindowSum > previousWindowSum) {
                numSumIncreases++;
            }

            previousWindowSum = currentWindowSum;
        }

        return numSumIncreases;
    }

    public static void main(String[] args) {
        List<Integer> depths = utils.readListOfNumbersFromFile("inputs/day1.txt");

        System.out.println("Number of times depth increased: " + part1(depths));
        System.out.println("Number of times three-measurement sliding window increased: " + part2(depths, 3));
    }
}
