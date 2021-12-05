package day3;

import java.util.ArrayList;
import java.util.List;
import utils.utils;

public class day3 {
    public static int part1(List<String> binaryNums) {
        final int binaryNumberLength = binaryNums.get(0).length();

        StringBuilder gammaRateSB = new StringBuilder();
        StringBuilder epsilonRateSB = new StringBuilder();

        for (int i = 0; i < binaryNumberLength; i++) {
            int numOnes = countOnesAtIndexN(binaryNums, i);
            int numZeroes = binaryNums.size() - numOnes;

            if (numOnes > numZeroes) {
                gammaRateSB.append("1");
                epsilonRateSB.append("0");
            } else {
                gammaRateSB.append("0");
                epsilonRateSB.append("1");
            }
        }

        int gammaRate = Integer.parseInt(gammaRateSB.toString(), 2);
        int epsilonRate = Integer.parseInt(epsilonRateSB.toString(), 2);

        return gammaRate * epsilonRate;
    }

    public static int part2(List<String> binaryNums) {
        int oxygenGeneratorRating = getOxygenGeneratorRating(new ArrayList<>(binaryNums));
        int co2ScrubberRating = getCO2ScrubberRating(new ArrayList<>(binaryNums));

        return oxygenGeneratorRating * co2ScrubberRating;
    }

    private static int getOxygenGeneratorRating(List<String> binaryNums) {
        return getRating(binaryNums, "oxygen");
    }

    private static int getCO2ScrubberRating(List<String> binaryNums) {
        return getRating(binaryNums, "co2");
    }

    private static int getRating(List<String> binaryNums, String type) {
        final int binaryNumberLength = binaryNums.get(0).length();

        for (int i = 0; i < binaryNumberLength; i++) {
            int numOnes = countOnesAtIndexN(binaryNums, i);
            int numZeroes = binaryNums.size() - numOnes;

            char desiredBit;
            if (type.equals("oxygen")) {
                if (numOnes >= numZeroes) {
                    desiredBit = '1';
                } else {
                    desiredBit = '0';
                }
            } else { //co2
                if (numOnes < numZeroes) {
                    desiredBit = '1';
                } else {
                    desiredBit = '0';
                }
            }

            List<String> toBeRemoved = new ArrayList<>();
            for (String binaryNum : binaryNums) {
                if (binaryNum.charAt(i) != desiredBit) {
                    toBeRemoved.add(binaryNum);
                }
            }

            binaryNums.removeAll(toBeRemoved);

            if (binaryNums.size() == 1) {
                break;
            }
        }

        return Integer.parseInt(binaryNums.get(0), 2);
    }

    private static int countOnesAtIndexN(List<String> binaryNums, int i) {
        int numOnes = 0;
        for (String binaryNum : binaryNums) {
            if (binaryNum.charAt(i) == '1') {
                numOnes++;
            }
        }

        return numOnes;
    }

    public static void main(String[] args) {
        List<String> binaryNums = utils.readListOfStringsFromFile("inputs/day3/day3.txt");

        System.out.println("Power consumption of the submarine (Part 1): " + part1(binaryNums));
        System.out.println("Life support rating of the submarine (Part 2): " + part2(binaryNums));
    }
}
