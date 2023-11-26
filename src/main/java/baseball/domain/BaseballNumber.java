package baseball.domain;

import static baseball.constants.GameRule.BASEBALL_MAX_SIZE;
import static baseball.constants.GameRule.MAX_BASEBALL_NUMBER;
import static baseball.constants.GameRule.MIN_BASEBALL_NUMBER;
import static baseball.exception.ErrorCode.INVALID_BASEBALL_NUMBER;
import static baseball.exception.ErrorCode.INVALID_NUMBER_SIZE;

import java.util.Collections;
import java.util.List;

public class BaseballNumber {
    private final List<Integer> baseballNumber;

    private BaseballNumber(List<Integer> baseballNumber) {
        validate(baseballNumber);
        this.baseballNumber = baseballNumber;
    }

    public static BaseballNumber create(List<Integer> baseballNumber) {
        return new BaseballNumber(baseballNumber);
    }

    private void validate(List<Integer> baseballNumber) {
        validateSize(baseballNumber);
        validateRange(baseballNumber);
        validateDuplicate(baseballNumber);
    }

    private void validateSize(List<Integer> baseballNumber) {
        if (baseballNumber.size() != BASEBALL_MAX_SIZE.getValue()) {
            throw new IllegalArgumentException(INVALID_NUMBER_SIZE.getMessage());
        }
    }

    private void validateRange(List<Integer> baseballNumber) {
        boolean outOfRange = baseballNumber.stream()
                .anyMatch(num -> num < MIN_BASEBALL_NUMBER.getValue() || MAX_BASEBALL_NUMBER.getValue() < num);
        if (outOfRange) {
            throw new IllegalArgumentException(INVALID_BASEBALL_NUMBER.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> baseballNumber) {
        int distinctCount = (int) baseballNumber.stream()
                .distinct()
                .count();
        if (baseballNumber.size() != distinctCount) {
            throw new IllegalArgumentException(INVALID_BASEBALL_NUMBER.getMessage());
        }
    }

    public List<Integer> getBaseballNumber() {
        return Collections.unmodifiableList(baseballNumber);
    }

    @Override
    public String toString() {
        return baseballNumber.toString();
    }
}
