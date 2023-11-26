package baseball.exception;

import java.util.function.Supplier;

public interface ExceptionHandler {
    <T> T execute(Supplier<T> action, Class<? extends Exception>... exceptions);

    void execute(Runnable action, Class<? extends Exception>... exceptions);
}
