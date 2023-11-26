package baseball.constants;

public enum GameRule {
    WIN_CONDITION(3),
    RESTART_GAME(1),
    EXIT_GAME(2);

    private final int value;

    GameRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
