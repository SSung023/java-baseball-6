package baseball;

import baseball.controller.GameController;
import baseball.domain.ScoreCalculator;
import baseball.exception.RetryHandler;
import baseball.service.GameService;
import baseball.service.generator.RandomGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(
                new GameService(new ScoreCalculator()),
                new InputView(), new OutputView(),
                new RetryHandler(), new RandomGenerator()
        );
        gameController.run();
    }
}
