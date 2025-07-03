package org.example.course_manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.course_manager.entity.Notice;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lzy
 * @since 2024-11-24
 */
public interface INoticeService extends IService<Notice> {

//    List<Notice> queryNotice();
    List<Notice> findNotice();

    void saveNotice(Notice notice);

    void delNotice(String id);


}
