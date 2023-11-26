package baseball.domain;

import baseball.dto.GameResult;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoreCalculatorTest {
    private final ScoreCalculator scoreCalculator = new ScoreCalculator();

    @Test
    @DisplayName("컴퓨터값과 사용자값을 전달했을 때, 볼의 개수를 계산할 수 있다.")
    public void checkBalls() {
        //given
        BaseballNumber answer = BaseballNumber.create(List.of(1, 2, 3));
        BaseballNumber user = BaseballNumber.create(List.of(3, 1, 2));

        //when
        GameResult gameResult = scoreCalculator.getGameResult(answer, user);

        //then
        Assertions.assertThat(gameResult.ball()).isEqualTo(3);
        Assertions.assertThat(gameResult.strike()).isEqualTo(0);
    }

    @Test
    @DisplayName("컴퓨터값과 사용자값을 전달했을 때, 스트라이크의 개수를 계산할 수 있다.")
    public void checkStrikes() {
        //given
        BaseballNumber answer = BaseballNumber.create(List.of(1, 2, 3));
        BaseballNumber user = BaseballNumber.create(List.of(1, 2, 3));

        //when
        GameResult gameResult = scoreCalculator.getGameResult(answer, user);

        //then
        Assertions.assertThat(gameResult.ball()).isEqualTo(0);
        Assertions.assertThat(gameResult.strike()).isEqualTo(3);
    }
}