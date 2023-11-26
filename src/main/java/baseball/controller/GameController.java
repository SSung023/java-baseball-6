package baseball.controller;

import baseball.domain.BaseballNumber;
import baseball.domain.Command;
import baseball.dto.GameResult;
import baseball.exception.ExceptionHandler;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {
    private final GameService gameService;
    private final InputView inputView;
    private final OutputView outputView;
    private final ExceptionHandler exceptionHandler;

    public GameController(GameService gameService, InputView inputView, OutputView outputView,
                          ExceptionHandler exceptionHandler) {
        this.gameService = gameService;
        this.inputView = inputView;
        this.outputView = outputView;
        this.exceptionHandler = exceptionHandler;
    }

    public void run() {
        //TODO: 게임 시작 메시지 출력
        printGreeting();

        //TODO: 게임이 완전히 끝났는지 여부 확인
        while (gameService.isGameProceeding()) {
            //TODO: 컴퓨터의 수 설정
            BaseballNumber computerNumber = setComputerNumber();
            playGame(computerNumber);

            //TODO: 사용자로부터 종료 여부 확인 및 종료 X시, 정답 생성 로직부터 다시 시작
            getCommand();
        }
    }

    private void printGreeting() {

    }

    private BaseballNumber setComputerNumber() {

        return BaseballNumber.create(List.of(1, 2, 3));
    }

    private void playGame(BaseballNumber answer) {
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
        Command userCommand = Command.create(inputView.getCommand());
        gameService.checkCommand(userCommand);
    }
}
