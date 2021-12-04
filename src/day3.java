import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class day3 {
    public static int part1(List<String> binaryNums) {
        final int binaryNumberLength = binaryNums.get(0).length();
        HashMap<Integer, Integer> mostCommonBitMap = buildMostCommonBitMap(binaryNums);

        StringBuilder gammaRateSB = new StringBuilder();
        StringBuilder epsilonRateSB = new StringBuilder();
        for (int i = 0; i < binaryNumberLength; i++) {
            int mostCommonBit = mostCommonBitMap.get(i);
            if (mostCommonBit == 1) {
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
        String oxygenGeneratorString = getOxygenGeneratorString(binaryNums);
        String co2ScrubberString = getCO2ScrubberString(binaryNums);

        System.out.println(oxygenGeneratorString + ", " + co2ScrubberString);
        int oxygenGeneratorRating = Integer.parseInt(oxygenGeneratorString, 2);
        int co2ScrubberRating = Integer.parseInt(co2ScrubberString, 2);

        return oxygenGeneratorRating * co2ScrubberRating;
    }

    private static String getOxygenGeneratorString(List<String> originalBinaryNums) {
        List<String> binaryNums = new ArrayList<>(originalBinaryNums);
        final int binaryNumberLength = binaryNums.get(0).length();

        for (int i = 0; i < binaryNumberLength; i++) {
            if (binaryNums.size() == 1) {
                break;
            }

            Map<Integer, Integer> mostCommonBitMap = buildMostCommonBitMap(binaryNums);
            List<String> toBeRemoved = new ArrayList<>();

            for (String binaryNum : binaryNums) {
                int bit = Character.getNumericValue(binaryNum.charAt(i));
                int mostCommonBit = mostCommonBitMap.get(i);

                if (equallyCommon(mostCommonBit)) {
                    mostCommonBit = 1;
                }

                if (bit != mostCommonBit) {
                    toBeRemoved.add(binaryNum);
                }
            }

            binaryNums.removeAll(toBeRemoved);
        }

        String oxygenGeneratorString = binaryNums.get(0);
        return oxygenGeneratorString;
    }

    private static String getCO2ScrubberString(List<String> originalBinaryNums) {
        List<String> binaryNums = new ArrayList<>(originalBinaryNums);
        final int binaryNumberLength = binaryNums.get(0).length();

        for (int i = 0; i < binaryNumberLength; i++) {
            if (binaryNums.size() == 1) {
                break;
            }

            Map<Integer, Integer> mostCommonBitMap = buildMostCommonBitMap(binaryNums);
            List<String> toBeRemoved = new ArrayList<>();

            for (String binaryNum : binaryNums) {
                int bit = Character.getNumericValue(binaryNum.charAt(i));
                int mostCommonBit = mostCommonBitMap.get(i);
                int leastCommonBit;

                if (equallyCommon(mostCommonBit)) {
                    leastCommonBit = 0;
                } else {
                    leastCommonBit = mostCommonBit ^ 1;
                }

                if (bit != leastCommonBit) {
                    toBeRemoved.add(binaryNum);
                }
            }

            binaryNums.removeAll(toBeRemoved);
        }

        String co2ScrubberString = binaryNums.get(0);
        return co2ScrubberString;
    }

    private static HashMap<Integer, Integer> buildMostCommonBitMap(List<String> binaryNums) {
        HashMap<Integer, Integer> mostCommonBitByIndex = new HashMap<>();
        final int binaryNumLength = binaryNums.get(0).length();

        for (int i = 0; i < binaryNumLength; i++) {
            int numOnes = 0;

            for (String binaryNum : binaryNums) {
                int bit = Character.getNumericValue(binaryNum.charAt(i));
                if (bit == 1) {
                    numOnes++;
                }
            }

            int numZeroes = binaryNums.size() - numOnes;

            if (numOnes > numZeroes) {
                mostCommonBitByIndex.put(i, 1);
            } else if (numZeroes > numOnes) {
                mostCommonBitByIndex.put(i, 0);
            } else { //equal
                mostCommonBitByIndex.put(i, -1);
            }
        }

        return mostCommonBitByIndex;
    }

    private static boolean equallyCommon(int mostCommonBit) {
        return mostCommonBit == -1 ? true : false;
    }

    public static void main(String[] args) {
        List<String> binaryNums = utils.readListOfStringsFromFile("inputs/day3.txt");

        System.out.println("Power consumption of the submarine (Part 1): " + part1(binaryNums));
        System.out.println("Final blah (Part 2): " + part2(binaryNums));
    }
}
