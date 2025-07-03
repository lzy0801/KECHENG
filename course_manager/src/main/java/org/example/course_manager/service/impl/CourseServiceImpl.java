package org.example.course_manager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.course_manager.entity.Course;
import org.example.course_manager.entity.Curelation;
import org.example.course_manager.mapper.CourseMapper;
import org.example.course_manager.mapper.CurelationMapper;
import org.example.course_manager.req.CourseReq;
import org.example.course_manager.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lzy
 * @since 2024-11-24
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    CurelationMapper curelationMapper;

    //查询课程
    @Override
    public List<Course> queryCourse() {
        return courseMapper.selectList(null);
    }

    //新增课程
    @Override
    public void saveCourse(Course course) {

        if (ObjectUtils.isEmpty(course.getId())) {
            course.setStatus("1");
            course.setId(String.valueOf(Math.random()).substring(2,9));
            courseMapper.insert(course);
        }else{
            courseMapper.updateById(course);
        }
    }
//删除课程
    @Override
    public void delCourse(String id) {
        courseMapper.deleteById(id);
    }

//排课
    @Override
    public void arranging(CourseReq req) {
        //通过课程ID查询课程信息
        Course course = courseMapper.selectById(req.getId());
        course.setId(req.getId());
        course.setCourseroom(org.apache.commons.lang3.StringUtils.join
                (req.getCourseroom(),","));
        course.setCoursedate(org.apache.commons.lang3.StringUtils.join
                (req.getDate1(), ",")
                +org.apache.commons.lang3.StringUtils.join(req.getDate2(),","));

        //设置课程排课信息
        courseMapper.updateById(course);
    }

    //查询听课
    @Override
    public List<Curelation> queryCurelation() {
        List<Curelation> curelations = curelationMapper.selectList(null);
        return curelations;
    }

    //听课设置
    @Override
    public void listening(Curelation curelation) {
        // 判断课程是否有听课人员
        QueryWrapper<Curelation> wrapper = new QueryWrapper<>();
        wrapper.eq("courseid", curelation.getCourseid());

        List<Curelation> curelations = curelationMapper.selectList(wrapper);
        if (curelations != null && !curelations.isEmpty()) {
            // 课程已经有听课人员
            Curelation curelation1 = curelations.get(0);
            curelation1.setUserid(curelation.getUserid());
            curelationMapper.updateById(curelation1);
        }else {
            Course course = courseMapper.selectById(curelation.getCourseid());
            curelation.setType(course.getCoursename());
            curelation.setId(String.valueOf(Math.random()).substring(2, 10));
            curelationMapper.insert(curelation);
        }
    }

    //删除听课
    @Override
    public void delCurelation(String id) {
        curelationMapper.deleteById(id);
    }

}
