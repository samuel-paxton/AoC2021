package day2;

import java.util.List;
import utils.utils;

public class day2 {
    public static int part1(List<MovementCommand> commands) {
        int horizontalLocation = 0;
        int depth = 0;

        for (MovementCommand command : commands) {
            switch (command.direction) {
                case "forward" -> horizontalLocation += command.amount;
                case "down" -> depth += command.amount;
                case "up" -> depth -= command.amount;
            }
        }

        return horizontalLocation * depth;
    }

    public static int part2(List<MovementCommand> commands) {
        int horizontalLocation = 0;
        int depth = 0;
        int aim = 0;

        for (MovementCommand command : commands) {
            switch (command.direction) {
                case "forward" -> {
                    horizontalLocation += command.amount;
                    depth += (aim * command.amount);
                }
                case "down" -> aim += command.amount;
                case "up" -> aim -= command.amount;
            }
        }

        return horizontalLocation * depth;
    }

    public static void main(String[] args) {
        List<MovementCommand> commands = utils.readListOfMovementCommands("inputs/day2/day2.txt");

        System.out.println("Final horizontal position by final depth (Part 1): " + part1(commands));
        System.out.println("Final horizontal position by final depth (Part 2): " + part2(commands));
    }
}
