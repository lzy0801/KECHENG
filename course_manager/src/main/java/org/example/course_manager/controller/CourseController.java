package org.example.course_manager.controller;


import org.example.course_manager.entity.Course;
import org.example.course_manager.entity.Curelation;
import org.example.course_manager.mapper.CourseMapper;
import org.example.course_manager.req.CourseReq;
import org.example.course_manager.resp.Result;
import org.example.course_manager.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lzy
 * @since 2024-11-24
 */
@RestController
public class CourseController {
    @Autowired
    ICourseService courseService;
    @Autowired
    private CourseMapper courseMapper;

    //查询所有课程
    @RequestMapping("/queryCourse")
    public Result queryCourse(){
        List<Course> courses = courseService.queryCourse();
        return Result.success(courses);
}

    //查询所有课程
    @RequestMapping("/saveCourse")
    public Result savaCourse(@RequestBody Course course){
        courseService.saveCourse(course);
        return Result.success();

    }


    //删除课程
    @RequestMapping("/delCourse/{id}")
    public Result delCourse(@PathVariable String id){
        courseService.delCourse(id);
        return Result.success();

    }

    //排课
    @RequestMapping("/arranging")
    public Result arranging(@RequestBody CourseReq req ){
        System.out.println(req);
        courseService.arranging(req);
        return Result.success();
    }

    //查询所有听课记录
    @GetMapping("/queryCurelation")
    public Result queryCurelation(){
        List<Curelation> list =  courseService.queryCurelation();
        return Result.success(list);
    }

    //设置听课安排
    @PostMapping("/listening")
    public Result listening(@RequestBody Curelation curelation ){
        courseService.listening(curelation);
        return Result.success();
    }

    // 删除听课安排
    @DeleteMapping("/delCurelation/{id}")
    public Result delCurelation(@PathVariable  String id){
        courseService.delCurelation(id);
        return Result.success();
    }

}
