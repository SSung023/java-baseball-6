package baseball.service;

import static baseball.constants.GameRule.WIN_CONDITION;

import baseball.domain.BaseballNumber;
import baseball.domain.ScoreCalculator;
import baseball.dto.GameResult;

public class GameService {
    private final ScoreCalculator scoreCalculator;
    private boolean isRoundProceeding;

    public GameService(ScoreCalculator scoreCalculator) {
        this.scoreCalculator = scoreCalculator;
        this.isRoundProceeding = true;
    }

    public GameResult getRoundResult(BaseballNumber answer, BaseballNumber user) {
        GameResult gameResult = scoreCalculator.getGameResult(answer, user);
        if (gameResult.strike() == WIN_CONDITION.getValue()) {
            setRoundEnd();
        }
        return gameResult;
    }

    private void setRoundEnd() {
        isRoundProceeding = false;
    }

    public boolean isRoundProceeding() {
        return isRoundProceeding;
    }
}
