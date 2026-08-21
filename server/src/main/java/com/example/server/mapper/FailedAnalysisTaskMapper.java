package com.example.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.server.entity.FailedAnalysisTask;
import org.apache.ibatis.annotations.Mapper;

@Mapper
/** failed_analysis_tasks 表数据访问接口（MyBatis-Plus 基础 CRUD）。 */
public interface FailedAnalysisTaskMapper extends BaseMapper<FailedAnalysisTask> {
}
