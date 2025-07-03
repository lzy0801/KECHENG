package org.example.course_manager.controller;


import org.example.course_manager.req.RoleReq;
import org.example.course_manager.resp.Result;
import org.example.course_manager.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class RoleController {

    @Autowired
    IRoleService roleService;

    //查询角色权限
    @RequestMapping("/queryRole")
    public Result queryRole(){
        List<RoleReq> roles = roleService.queryRole();

        return Result.success(roles);

    }
    //编辑角色权限
    @RequestMapping("/editRole")
    public Result editRole(@RequestBody RoleReq roleReq){

        roleService.editRole(roleReq);

        return Result.success();

    }

}
