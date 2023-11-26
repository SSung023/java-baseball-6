package baseball.constants;

import static baseball.constants.GameRule.EXIT_GAME;
import static baseball.constants.GameRule.RESTART_GAME;
import static baseball.constants.GameRule.WIN_CONDITION;

public enum Message {
    START_GAME("숫자 야구 게임을 시작합니다."),
    ASK_NUMBER("숫자를 입력해주세요 : "),
    NOTHING("낫싱"),
    STRIKE("%d스트라이크"),
    BALL("%d볼 "),
    ROUND_END(
            String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", WIN_CONDITION.getValue())
    ),
    ASK_CONTINUE(
            String.format("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.",
                    RESTART_GAME.getValue(), EXIT_GAME.getValue())
    );

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
