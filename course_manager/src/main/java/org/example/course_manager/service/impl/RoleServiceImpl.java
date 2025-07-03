package org.example.course_manager.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.course_manager.entity.Power;
import org.example.course_manager.entity.Role;
import org.example.course_manager.mapper.PowerMapper;
import org.example.course_manager.mapper.RoleMapper;
import org.example.course_manager.req.RoleReq;
import org.example.course_manager.service.IRoleService;
import org.example.course_manager.util.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    PowerMapper powerMapper;

    //查询角色权限
    @Override
    public List<RoleReq> queryRole() {
        return roleMapper.queryRoleAndPower();
    }


    //编辑角色权限
    @Override
    public void editRole(RoleReq roleReq) {
        Role role = CopyUtil.copy(roleReq, Role.class);
        Power power = new Power();

        power.setPower(roleReq.getPower());
        power.setRoleid(roleReq.getPowerid());
        System.out.println(power.getPower());

        UpdateWrapper<Role> updateWrapper = new UpdateWrapper<>();

        updateWrapper.eq("roleid", roleReq.getRoleid());
        roleMapper.update(role, updateWrapper);

        UpdateWrapper<Power> wrapper = new UpdateWrapper<>();
        wrapper.eq("roleid", power.getRoleid());

        powerMapper.update(power, wrapper);

    }


}
