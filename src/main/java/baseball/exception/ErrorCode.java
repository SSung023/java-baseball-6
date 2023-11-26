package baseball.exception;

public enum ErrorCode {
    PREFIX("[ERROR] "),
    NOT_INTEGER("입력한 값이 정수가 아닙니다."),
    INVALID_NUMBER_SIZE("숫자 야구의 길이는 3이어야 합니다"),
    INVALID_RANGE("숫자 야구 수의 범위는 1에서 9여야 합니다."),
    INVALID_BASEBALL_NUMBER("입력한 숫자의 값이 유효하지 않습니다."),
    INVALID_COMMAND("입력한 명령어의 값이 유효하지 않습니다.");
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX.message + this.message;
    }
}
