import java.util.List;

public class day2 {
    public static int part1(List<MovementCommand> commands) {
        int horizontalLocation = 0;
        int depth = 0;

        for (MovementCommand command : commands) {
            if (command.direction.equals("forward")) {
                horizontalLocation += command.amount;
            } else if (command.direction.equals("down")) {
                depth += command.amount;
            } else if (command.direction.equals("up")) {
                depth -= command.amount;
            }
        }

        return horizontalLocation * depth;
    }

    public static int part2(List<MovementCommand> commands) {
        int horizontalLocation = 0;
        int depth = 0;
        int aim = 0;

        for (MovementCommand command : commands) {
            if (command.direction.equals("forward")) {
                horizontalLocation += command.amount;
                depth += (aim * command.amount);
            } else if (command.direction.equals("down")) {
                aim += command.amount;
            } else if (command.direction.equals("up")) {
                aim -= command.amount;
            }
        }

        return horizontalLocation * depth;
    }

    public static void main(String[] args) {
        List<MovementCommand> commands = utils.readListOfMovementCommands("inputs/day2.txt");

        System.out.println("Final horizontal position by final depth (Part 1): " + part1(commands));
        System.out.println("Final horizontal position by final depth (Part 2): " + part2(commands));
    }
}
