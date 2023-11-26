package baseball.domain;

import baseball.dto.GameResult;
import java.util.List;

public class ScoreCalculator {

    public GameResult getGameResult(BaseballNumber answer, BaseballNumber user) {
        List<Integer> answerNums = answer.getBaseballNumber();
        List<Integer> userNums = user.getBaseballNumber();

        int balls = getBalls(answerNums, userNums);
        int strikes = getStrikes(answerNums, userNums);
        boolean isNothing = balls == 0 && strikes == 0;

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
