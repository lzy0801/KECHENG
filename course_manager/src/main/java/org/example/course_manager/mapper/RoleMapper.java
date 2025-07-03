package org.example.course_manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.example.course_manager.entity.Role;
import org.example.course_manager.req.RoleReq;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lzy
 * @since 2024-11-24
 */
public interface RoleMapper extends BaseMapper<Role> {

    @Select("SELECT r.*,P.power FROM role r ,power p WHERE r.powerid=p.roleid")
    List<RoleReq> queryRoleAndPower();
}
