package baseball.domain;

import baseball.dto.GameResult;
import java.util.List;

public class ScoreCalculator {

    private final int INVALID_VALUE = 0;

    public GameResult getGameResult(BaseballNumber answer, BaseballNumber user) {
        List<Integer> answerNums = answer.getBaseballNumber();
        List<Integer> userNums = user.getBaseballNumber();

        int balls = getBalls(answerNums, userNums);
        int strikes = getStrikes(answerNums, userNums);
        boolean isNothing = balls == INVALID_VALUE && strikes == INVALID_VALUE;

        return new GameResult(balls, strikes, isNothing);
    }

    private int getBalls(List<Integer> answers, List<Integer> users) {
        return (int) answers.stream()
                .filter(nums -> users.contains(nums) && (users.indexOf(nums) != answers.indexOf(nums)))
                .count();
    }

    private int getStrikes(List<Integer> answers, List<Integer> users) {
        return (int) answers.stream()
                .filter(nums -> users.contains(nums) && (users.indexOf(nums) == answers.indexOf(nums)))
                .count();
    }
}
