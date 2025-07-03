package org.example.course_manager.mapper;

import org.example.course_manager.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lzy
 * @since 2024-11-24
 */
public interface CourseMapper extends BaseMapper<Course> {

    List<Course> selectByExample(Object o);

    void update(Course course);
}
