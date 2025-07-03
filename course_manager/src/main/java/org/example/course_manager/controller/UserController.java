package org.example.course_manager.controller;


import com.alibaba.fastjson.JSONObject;
import org.example.course_manager.entity.User;
import org.example.course_manager.req.UserQueryReq;
import org.example.course_manager.resp.PageResp;
import org.example.course_manager.resp.Result;
import org.example.course_manager.resp.UserResp;
import org.example.course_manager.service.IUserService;
import org.example.course_manager.util.Constans;
import org.example.course_manager.util.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class UserController {
    @Autowired
    @Qualifier("userServiceImpl")
    private IUserService userService;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    SnowFlake snowFlake;

    //登录
    @PostMapping("/login")
    public Result login(String userId,String password){
        UserResp user = userService.login(userId,password);
        // 生成token
        Long token = snowFlake.nextId();
        user.setToken(token.toString());
        // 保存到redis中  key 就是token  value 是resp
        redisTemplate.opsForValue().set(token.toString(), JSONObject.toJSONString(user),3600*24, TimeUnit.SECONDS);

        return Result.success(user);
    }

    //退出登录
    @GetMapping("/loginOut/{token}")
    public Result loginOut(@PathVariable String token){
        // 删除redis里面的token
        redisTemplate.delete(token);
        return Result.success();
    }

    //教师分页查询
    @GetMapping("/findTeacher")
    public Result findTeacher(@Valid UserQueryReq req){
        System.out.println(req);
        req.setType(Constans.TEACHER);
        PageResp<User> pageResp = userService.findUser(req);
        return Result.success(pageResp);
    }

    //分页查询主任
    @GetMapping("/findDirector")
    public Result findDirector(@Valid UserQueryReq req){
        System.out.println(req);
        req.setType(Constans.DIRECTOR);
        PageResp<User> pageResp = userService.findUser(req);
        return Result.success(pageResp);
    }

    //保存用户信息
    @PostMapping("/saveUser")
    public Result saveTeacher(@RequestBody @Valid User user){
        userService.saveUser(user);
        return Result.success();
    }

    //删除用户信息
    @DeleteMapping("/delUser/{id}")
    public Result delUser(@PathVariable String id){
        userService.delUser(id);
        return Result.success();

    }

//    课程表单查询所有老师
    @GetMapping("/queryTeacher")
    public Result queryTeacher(){
        List<User> users = userService.queryTeacher();
        return Result.success(users);
    }


    //修改密码
    @PostMapping("/upPwd")
    public Result upPwd(String oldPwd, String newPwd, HttpServletRequest request){
        System.out.println(oldPwd+ "[["+newPwd);

        String token = request.getHeader("token");
        User user = JSONObject.parseObject((String) redisTemplate.opsForValue().get(token),User.class);
        System.out.println("--"+user);
        if (!user.getPassword().equals(oldPwd)){
            return Result.success("旧密码不正确");
        }else {
            user.setPassword(newPwd);
            userService.upPwd(user);
            return Result.success("修改密码成功");
        }
    }

}

