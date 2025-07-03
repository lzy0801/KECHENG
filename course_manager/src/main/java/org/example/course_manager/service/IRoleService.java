package org.example.course_manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.course_manager.entity.Role;
import org.example.course_manager.req.RoleReq;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lzy
 * @since 2024-11-24
 */
public interface IRoleService extends IService<Role> {

    List<RoleReq> queryRole();

    void editRole(RoleReq roleReq);
}
