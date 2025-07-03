package org.example.course_manager.controller;


import org.example.course_manager.entity.Notice;
import org.example.course_manager.resp.Result;
import org.example.course_manager.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lzy
 * @since 2024-11-24
 */
@RestController
public class NoticeController {
    @Autowired
    @Qualifier("noticeServiceImpl")
    private INoticeService noticeService;

    /**
     * 查询所有公告信息
     * @return
     */
    @RequestMapping ("/queryNotice")
    public Result queryNotice(){
//        List<Notice> notices = noticeService.queryNotice();
//        List<Notice> notice = noticeService.findNotice();
//        return Result.success(notice);
//        QueryWrapper<Notice> wrapper = new QueryWrapper<>();
        return Result.success(noticeService.findNotice());
    }


    @RequestMapping("/saveNotice")
    public Result saveUser(@RequestBody @Valid Notice notice){
        noticeService.saveNotice(notice);
        return Result.success();
    }

    @RequestMapping("/delNotice/{id}")
    public Result delUser(@PathVariable String id){
        System.out.println(id);
        noticeService.delNotice(id);
        return Result.success();
    }
}
