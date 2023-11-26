package baseball.view;

import static baseball.constants.Message.ASK_NUMBER;
import static baseball.constants.Message.BALL;
import static baseball.constants.Message.NOTHING;
import static baseball.constants.Message.ROUND_END;
import static baseball.constants.Message.STRIKE;

import baseball.dto.GameResult;

public class OutputView {

    public void printRoundResult(GameResult gameResult) {
        if (gameResult.isNothing()) {
            System.out.printf(NOTHING.getMessage());
        }
        if (gameResult.ball() != 0) {
            System.out.printf(BALL.getMessage(), gameResult.ball());
        }
        if (gameResult.strike() != 0) {
            System.out.printf(STRIKE.getMessage(), gameResult.strike());
        }
        System.out.println();
    }

    public void printAskNumber() {
        System.out.print(ASK_NUMBER.getMessage());
    }

    public void printRoundEnd() {
        System.out.println(ROUND_END.getMessage());
    }
}
