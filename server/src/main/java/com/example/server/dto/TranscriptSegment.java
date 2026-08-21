package com.example.server.dto;

/** 60 秒转写片段：起止毫秒 + 文本。 */
public record TranscriptSegment(long startMs, long endMs, String text) {

    public TranscriptSegment {
        if (startMs < 0 || endMs <= startMs) throw new IllegalArgumentException("invalid transcript range");
        text = text == null ? "" : text.trim();
    }
}
