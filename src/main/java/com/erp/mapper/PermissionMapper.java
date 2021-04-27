package com.erp.mapper;

import com.erp.util.TreeResultUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionMapper {
    /**
     *
     * @param username
     * @return
     */
    List<TreeResultUtil> getPerms(@Param("username") String username);

    /**
     *
     * @param roleId
     */
    void deleteRolePermByRoleId(@Param("roleId") Integer roleId);

    /**
     *
     * @param roleId
     * @param permIds
     */
    void addRolePerm(@Param("roleId") Integer roleId,@Param("permIds") int[] permIds);

    /**
     *
     * @param roleId
     * @return
     */
    List<Integer> findPermissionIdsByRoleId(@Param("roleId") int roleId);

    /**
     *查找所有权限--封装成Tree对象
     * @return
     */
    List<TreeResultUtil> list();
}
