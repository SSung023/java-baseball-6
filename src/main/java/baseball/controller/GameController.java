package baseball.controller;

public class GameController {

    public void run() {
        //TODO: 게임 시작 메시지 출력
        printGreeting();

        //TODO: 게임이 완전히 끝났는지 여부 확인
        while (true) {
            //TODO: 컴퓨터의 수 설정
            setComputerNumber();

            //TODO: 야구 게임 로직 반복 실행
            playGame();

            //TODO: 사용자로부터 종료 여부 확인 및 종료 X시, 정답 생성 로직부터 다시 시작
        }
    }

    private void printGreeting() {

    }

    private void setComputerNumber() {

    }

    private void playGame() {
        //TODO: gameService로부터 게임 종료 여부 확인 후, 종료가 아니라면 반복문 실행
        while (true) {
            //TODO: 사용자로부터 입력받기 -> excetionHandler

            //TODO: scoreService로부터 결과 받기

            //TODO: outputView를 통해 결과 출력

        }
    }
}
