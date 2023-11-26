package baseball.domain;

import java.util.Collections;
import java.util.List;

public class BaseballNumber {
    private final List<Integer> baseballNumber;

    private BaseballNumber(List<Integer> baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    public static BaseballNumber create(List<Integer> baseballNumber) {
        return new BaseballNumber(baseballNumber);
    }

    public List<Integer> getBaseballNumber() {
        return Collections.unmodifiableList(baseballNumber);
    }
}
