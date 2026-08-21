package com.example.server.dto;

import com.example.server.entity.MediaFile;

import java.time.LocalDateTime;

/** 媒体列表摘要：id/文件名/状态/封面/上传时间。 */
public record MediaSummary(
        Long id,
        String filename,
        String status,
        String coverUrl,
        LocalDateTime uploadTime
) {
    public static MediaSummary from(MediaFile mediaFile) {
        return new MediaSummary(
                mediaFile.getId(),
                mediaFile.getFilename(),
                mediaFile.getStatus(),
                mediaFile.getCoverUrl(),
                mediaFile.getUploadTime());
    }
}
