package com.example.server.dto;

/** SSE 事件载荷：state + result + message + stage。 */
public record TaskEvent(TaskStatus.State state, String result, String message, TaskStage stage) {

    public static TaskEvent of(TaskStatus status, TaskStage stage) {
        return new TaskEvent(status.state(), status.result(), status.message(), stage);
    }

    public boolean terminal() {
        return state == TaskStatus.State.COMPLETED || state == TaskStatus.State.FAILED;
    }
}
