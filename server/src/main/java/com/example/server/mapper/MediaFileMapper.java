package com.example.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.server.entity.MediaFile;
import org.apache.ibatis.annotations.Mapper;

@Mapper
/** media_files 表数据访问接口（MyBatis-Plus 基础 CRUD）。 */
public interface MediaFileMapper extends BaseMapper<MediaFile> {

}