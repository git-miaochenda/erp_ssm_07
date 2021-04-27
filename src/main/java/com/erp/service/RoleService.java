package com.erp.service;

import com.erp.pojo.Role;
import com.erp.util.EasyUiResultUtil;
import com.erp.util.TreeResultUtil;

import java.util.List;

public interface RoleService {
    /**
     * 增加
     * @param role
     */
    void add(Role role);

    /**
     * 删除
     * @param ids
     */
    void remove(int[] ids);

    /**
     * 修改
     * @param role
     */
    void update(Role role);

    /**
     * 分页查询
     * @param role
     * @param pageNum
     * @param pageSize
     * @return
     */
    EasyUiResultUtil<Role> page(Role role,int pageNum,int pageSize);

    /**
     *
     * @param role
     * @return
     */
    int count(Role role);

    /**
     * 数据回显
     * @return
     */
    List<Role> findAll();

    /**
     *
     * @param roleId
     * @param permIds
     */
    void updatePerm(Integer roleId, int[] permIds);

    /**
     *根据就是id查询所有的权限id
     * @param roleId
     * @return
     */
    List<Integer> findPermissionIdsByRoleId(int roleId);

    /**
     *
     * @return
     */
    List<TreeResultUtil> permissionList();
}
