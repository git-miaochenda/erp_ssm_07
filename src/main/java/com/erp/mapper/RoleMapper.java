package com.erp.mapper;

import com.erp.pojo.Role;
import com.erp.util.EasyUiResultUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    /**
     *
     * @param role
     */
    void add(@Param("role") Role role);

    /**
     *
     * @param ids
     */
    void remove(@Param("ids") int[] ids);

    /**
     *
     * @param role
     */
    void update(@Param("role")Role role);

    /**
     *
     * @param role
     * @return
     */
    int count(@Param("role")Role role);

    /**
     *
     * @param role
     * @return
     */
    List<Role> page(@Param("role") Role role,@Param("start")int start,@Param("pageSize")int pageSize);

    /**
     * 数据回显
     * @return
     */
    List<Role> findAll();
}
