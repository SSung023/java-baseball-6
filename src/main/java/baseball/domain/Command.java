package baseball.domain;

import static baseball.constants.GameRule.EXIT_GAME;
import static baseball.constants.GameRule.RESTART_GAME;
import static baseball.exception.ErrorCode.INVALID_COMMAND;

public class Command {
    private int command;

    public Command(int command) {
        validate(command);
        this.command = command;
    }

    public static Command create(int command) {
        return new Command(command);
    }

    private void validate(int command) {
        if (command != RESTART_GAME.getValue() && command != EXIT_GAME.getValue()) {
            throw new IllegalArgumentException(INVALID_COMMAND.getMessage());
        }
    }

    public boolean isRestart() {
        return command == RESTART_GAME.getValue();
    }

    public boolean isExit() {
        return command == EXIT_GAME.getValue();
    }
}
