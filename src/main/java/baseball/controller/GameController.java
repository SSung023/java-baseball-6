package baseball.controller;

import baseball.domain.BaseballNumber;
import baseball.domain.Command;
import baseball.dto.GameResult;
import baseball.exception.ExceptionHandler;
import baseball.service.GameService;
import baseball.service.generator.Generator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {
    private final GameService gameService;
    private final InputView inputView;
    private final OutputView outputView;
    private final ExceptionHandler exceptionHandler;
    private final Generator generator;

    public GameController(GameService gameService, InputView inputView, OutputView outputView,
                          ExceptionHandler exceptionHandler, Generator generator) {
        this.gameService = gameService;
        this.inputView = inputView;
        this.outputView = outputView;
        this.exceptionHandler = exceptionHandler;
        this.generator = generator;
    }

    public void run() {
        printGreeting();

        while (gameService.isGameProceeding()) {
            BaseballNumber computerNumber = setComputerNumber();
            playGame(computerNumber);
            getCommand();
        }
    }

    private void printGreeting() {
        outputView.printGameStart();
    }

    private BaseballNumber setComputerNumber() {
        return BaseballNumber.create(generator.generate());
    }

    private void playGame(BaseballNumber answer) {
        System.out.println(answer.toString());
        while (gameService.isRoundProceeding()) {
            outputView.printAskNumber();

            BaseballNumber userNumber = exceptionHandler.execute(() -> {
                List<Integer> userInput = inputView.getBaseballNumbers();
                return BaseballNumber.create(userInput);
            }, IllegalArgumentException.class);

            GameResult roundResult = gameService.getRoundResult(answer, userNumber);
            outputView.printRoundResult(roundResult);
        }
        outputView.printRoundEnd();
    }

    private void getCommand() {
        outputView.printAskCommand();
        Command userCommand = exceptionHandler.execute(
                () -> Command.create(inputView.getCommand()), IllegalArgumentException.class);
        gameService.checkCommand(userCommand);
    }
}
