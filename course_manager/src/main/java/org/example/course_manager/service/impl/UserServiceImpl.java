package org.example.course_manager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.course_manager.entity.Power;
import org.example.course_manager.entity.User;
import org.example.course_manager.mapper.PowerMapper;
import org.example.course_manager.mapper.UserMapper;
import org.example.course_manager.req.UserLoginReq;
import org.example.course_manager.req.UserQueryReq;
import org.example.course_manager.resp.PageResp;
import org.example.course_manager.resp.UserResp;
import org.example.course_manager.service.IUserService;
import org.example.course_manager.util.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private PowerMapper powerMapper;
    @Autowired
    private UserMapper userMapper;

    //查询用户
    @Override
    public PageResp<User> findUser(UserQueryReq req) { //设置查询参数
        Page<User> page = new Page<>(req.getPageNum(),req.getPageSize());
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("type",req.getType());
        if (!ObjectUtils.isEmpty(req.getName())){
            wrapper.eq("name",req.getName());
        }
        page=this.page(page,wrapper);
        List<User> list = page.getRecords();

        PageResp<User> pageResp= new PageResp<>();

        pageResp.setTotal(page.getTotal());
        pageResp.setList(list);
        return pageResp;
    }

    //查询课程里面教师表单
    @Override
    public List<User> queryTeacher() {
        return userMapper.selectList(null);
    }


    //登录
    @Override
    public UserResp login(String userId, String password) {
        UserLoginReq userLoginReq = new UserLoginReq();
        userLoginReq.setUserId(userId);
        userLoginReq.setPassword(password);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id",userLoginReq.getUserId());
        User user = this.getOne(wrapper);
        if (ObjectUtils.isEmpty(user)){
            return null;
        } else {
            if (user.getPassword().equals(userLoginReq.getPassword())){
                UserResp userResp = CopyUtil.copy(user, UserResp.class);
                Power power=powerMapper.selectById(user.getType());
                userResp.setPower(power.getPower());
                return userResp;
            } else{
                return null;
            }
        }
    }

    //分页查询用户
    @Override
    public PageResp<User> findUserByPage(UserQueryReq req) {
        return null;
    }

    //更新保存用户
    @Override
    public void saveUser(User user) {
        User user1 = userMapper.selectById(user.getId());
        if (ObjectUtils.isEmpty(user1)){
            userMapper.insert(user);
        }else {
            userMapper.updateById(user);
        }
    }

    //删除用户
    @Override
    public void delUser(String id) {
        userMapper.deleteById(id);
    }



    //修改密码
    @Override
    public void upPwd(User user) {
        userMapper.updateById(user);
    }
}
