package org.example.course_manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.course_manager.entity.User;
import org.example.course_manager.req.UserQueryReq;
import org.example.course_manager.resp.PageResp;
import org.example.course_manager.resp.UserResp;

import javax.validation.Valid;
import java.util.List;


public interface IUserService extends IService<User> {
    //    PageInfo<User> findUser(UserQueryReq req);
    UserResp login(String userId, String password);

    //分页查询
    PageResp<User> findUserByPage(UserQueryReq req);

    //保存用户信息
    void saveUser(User user);

    //删除用户信息
    void delUser(String id);

    //查询用户信息
    PageResp<User> findUser(@Valid UserQueryReq req);

//    //查询所有教师（表单）
    List<User> queryTeacher();

    void upPwd(User user);

//    PageInfo<User> findUser(UserQueryReq req);
}


