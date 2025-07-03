package org.example.course_manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.course_manager.entity.Notice;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lzy
 * @since 2024-11-24
 */
public interface NoticeMapper extends BaseMapper<Notice> {
//    List<Notice> selectByExample(@Param("example") NoticeExample example);
//    List<Notice> selectByExample(NoticeExample example);

    void updateByPrimaryKey(Notice notice);

    void deleteByPrimaryKey(String id);
}
