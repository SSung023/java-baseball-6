package baseball.constants;

public enum GameRule {
    MIN_BASEBALL_NUMBER(1),
    MAX_BASEBALL_NUMBER(9),
    BASEBALL_MAX_SIZE(3),
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
