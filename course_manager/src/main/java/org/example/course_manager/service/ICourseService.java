package org.example.course_manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.course_manager.entity.Course;
import org.example.course_manager.entity.Curelation;
import org.example.course_manager.req.CourseReq;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lzy
 * @since 2024-11-24
 */
public interface ICourseService extends IService<Course> {

    List<Course> queryCourse();

    void saveCourse(Course course);

    void delCourse(String id);

    void arranging(CourseReq req);

    List<Curelation> queryCurelation();

    void listening(Curelation curelation);

    void delCurelation(String id);
}
