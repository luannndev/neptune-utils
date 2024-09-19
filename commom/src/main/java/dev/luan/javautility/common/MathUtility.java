package dev.luan.javautility.common;

import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;

@UtilityClass
public class MathUtility {

    @FunctionalInterface
    public interface ThrowableRunnable {
        void run() throws Throwable;
    }

    /**
     * Calculates the amount of time it takes to execute the provided {@link ThrowableRunnable} and returns it as a {@link Duration}.
     *
     * @param runnable The {@link ThrowableRunnable} to execute and measure the time it takes.
     * @return The duration of time it takes to execute the {@link ThrowableRunnable}.
     * @throws Throwable If an error occurs while executing the {@link ThrowableRunnable}.
     */
    public Duration computeTimeTaking(@NotNull ThrowableRunnable runnable) throws Throwable {
        long start = System.currentTimeMillis();
        runnable.run();
        return Duration.ofMillis(System.currentTimeMillis() - start);
    }
}
