package com.example.server.service;

import java.util.concurrent.TimeUnit;

/**
 * 执行预算：用 ThreadLocal 把任务截止时间传递到同步编排线程，
 * 模型调用以剩余时间为自身超时，阶段间检查预算是否耗尽（防止慢模型拖穿任务预算）。
 */
public final class AgentExecutionBudget {

    private static final ThreadLocal<Long> DEADLINE_NANOS = new ThreadLocal<>();

    private AgentExecutionBudget() {
    }

    public static Scope open(long maxDurationMs) {
        if (maxDurationMs < 1) throw new IllegalArgumentException("Agent 执行时长预算必须大于 0");
        Long previous = DEADLINE_NANOS.get();
        long requested = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(maxDurationMs);
        DEADLINE_NANOS.set(previous == null ? requested : Math.min(previous, requested));
        return () -> {
            if (previous == null) {
                DEADLINE_NANOS.remove();
            } else {
                DEADLINE_NANOS.set(previous);
            }
        };
    }

    public static long remainingMillis() {
        Long deadline = DEADLINE_NANOS.get();
        if (deadline == null) return Long.MAX_VALUE;
        long remainingNanos = deadline - System.nanoTime();
        if (remainingNanos <= 0) throw new DeadlineExceededException("Agent 已耗尽执行时长预算");
        return Math.max(1, TimeUnit.NANOSECONDS.toMillis(remainingNanos));
    }

    public static void check(String stage) {
        try {
            remainingMillis();
        } catch (DeadlineExceededException e) {
            throw new DeadlineExceededException(stage + " 后终止：" + e.getMessage());
        }
    }

    @FunctionalInterface
    public interface Scope extends AutoCloseable {
        @Override
        void close();
    }

    public static class DeadlineExceededException extends IllegalStateException {
        public DeadlineExceededException(String message) {
            super(message);
        }
    }
}
