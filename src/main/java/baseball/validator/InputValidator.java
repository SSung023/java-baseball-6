package baseball.validator;

import static baseball.exception.ErrorCode.NOT_INTEGER;

public class InputValidator {
    public static void isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER.getMessage());
        }
    }
}
