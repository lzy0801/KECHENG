package org.example.course_manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.course_manager.entity.User;
import org.example.course_manager.resp.UserResp;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lzy
 * @since 2024-11-24
 */
public interface UserMapper extends BaseMapper<User> {
    UserResp login(String userId, String password);

    User selectByPrimaryKey(String id);

    void updateByPrimaryKey(User user);

    void deleteByPrimaryKey(String id);
}
