import java.util.HashMap;
import java.util.List;

public class day3 {
    public static int part1(List<String> binaryNums) {
        final int binaryStringLength = binaryNums.get(0).length();

        HashMap<Integer, Integer> num1Occurrences = new HashMap<Integer, Integer>();

        for (String binaryNum : binaryNums) {
            for (int i = 0; i < binaryNum.length(); i++) {
                int num = Character.getNumericValue(binaryNum.charAt(i));

                if (num == 1) {
                    int count = num1Occurrences.containsKey(i) ? num1Occurrences.get(i) : 0;
                    num1Occurrences.put(i, count + 1);
                }
            }
        }

        StringBuilder gammaRateSB = new StringBuilder();
        StringBuilder epsilonRateSB = new StringBuilder();
        for (int i = 0; i < binaryStringLength; i++) {
            if (num1Occurrences.get(i) >= binaryNums.size() / 2) {
                gammaRateSB.append("1");
                epsilonRateSB.append("0");
            } else {
                gammaRateSB.append("0");
                epsilonRateSB.append("1");
            }
        }
        String gammaString = gammaRateSB.toString();
        String epsilonString = epsilonRateSB.toString();

        int gammaRate = Integer.parseInt(gammaString, 2);
        int epsilonRate = Integer.parseInt(epsilonString, 2);

        return gammaRate * epsilonRate;
    }

    public static int part2(List<String> binaryNums) {
        return 0;
    }

    public static void main(String[] args) {
        List<String> binaryNums = utils.readListOfStringsFromFile("inputs/day3.txt");

        System.out.println("Power consumption of the submarine (Part 1): " + part1(binaryNums));
        System.out.println("Final blah (Part 2): " + part2(binaryNums));
    }
}
