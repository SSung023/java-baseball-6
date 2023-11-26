package baseball.convertor;

import java.util.Arrays;
import java.util.List;

public class InputConvertor {

    public static List<Integer> convertStringToList(String input) {
        return Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }

    public static int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }
}
