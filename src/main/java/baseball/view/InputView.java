package baseball.view;

import baseball.convertor.InputConvertor;
import baseball.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    public List<Integer> getBaseballNumbers() {
        String input = readLine();
        InputValidator.isInteger(input);
        return InputConvertor.convertStringToList(input);
    }

    public int getCommand() {
        String input = readLine();
        InputValidator.isInteger(input);
        return InputConvertor.convertStringToInt(input);
    }

    private String readLine() {
        return Console.readLine();
    }
}
