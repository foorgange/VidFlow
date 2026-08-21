package com.example.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/** 失败分析任务台账实体（failed_analysis_tasks 表），供管理台查询与重放。 */
@Data
@TableName("failed_analysis_tasks")
public class FailedAnalysisTask {

    @TableId(type = IdType.AUTO)
    private Long id;
    private Long mediaId;
    private String action;
    private String mode;
    private String contentHash;
    private String userGoal;
    private Integer attemptCount;
    private String errorType;
    private String errorMessage;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
