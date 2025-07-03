package org.example.course_manager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.course_manager.entity.Notice;
import org.example.course_manager.mapper.NoticeMapper;
import org.example.course_manager.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
@Primary
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements INoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> findNotice() {
        QueryWrapper<Notice> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("creatdate");
        return noticeMapper.selectList(wrapper);
//        return noticeMapper.selectList(null);
    }




    @Override
    public void saveNotice(Notice notice) {
        //判断公告ID是否为null或空字符串。如果ID不存在就新增数据，否则就修改数据
        if (StringUtils.isEmpty(notice.getId())){
            //生成ID，并赋值给公告ID属性。
            notice.setId(String.valueOf(Math.random()).substring(2, 8));
            //设置公告创建时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            notice.setCreatdate(sdf.format(new Date()));
            noticeMapper.insert(notice);
        }else {
            noticeMapper.updateById(notice);
        }

//        Notice notice1 = noticeMapper.selectById(notice.getId());
//        if (ObjectUtils.isEmpty(notice1)){
//            noticeMapper.insert(notice);
//        }else {
//            noticeMapper.updateById(notice);
//        }
    }

    @Override
    public void delNotice(String id) {
        noticeMapper.deleteById(id);
    }



}
