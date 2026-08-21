package com.example.server.dto;

/** 任务状态（state + result + message），供状态查询与 SSE 事件复用。 */
public record TaskStatus(State state, String result, String message) {

    public enum State {
        NOT_STARTED,
        QUEUED,
        PROCESSING,
        COMPLETED,
        FAILED
    }

    public static TaskStatus of(State state, String message) {
        return new TaskStatus(state, null, message);
    }

    public static TaskStatus completed(String result) {
        return new TaskStatus(State.COMPLETED, result, "任务完成");
    }

    public static TaskStatus completed(AgentState agentState) {
        String markdown = agentState.result().toMarkdown();
        if (agentState.critique() != null && agentState.critique().passed()) {
            return completed(markdown);
        }
        String warning = "分析已完成，但部分结论未通过 Critic 校验，请结合时间戳证据人工核验。";
        return new TaskStatus(State.COMPLETED, "> **结果提示：** " + warning + "\n\n" + markdown, warning);
    }
}
