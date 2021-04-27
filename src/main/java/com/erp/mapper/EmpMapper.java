package com.erp.mapper;

import com.erp.pojo.Emp;
import com.erp.vo.EmpVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    /**
     *
     * @param ids
     */
    void remove(@Param("ids") int[] ids);

    /**
     *
     * @param emp
     */
    void update(@Param("emp")Emp emp);

    /**
     *
     * @param id
     * @return
     */
    EmpVo findById(@Param("id") int id);

    /**
     *
     * @param emp
     */
    void add(@Param("emp")Emp emp);

    /**
     *
     * @param wheres
     * @return
     */
    int count(@Param("wheres") EmpVo wheres);

    /**
     *
     * @param wheres 查询条件
     * @param start 分页的起始位
     * @param pageSize 每页展示条数
     * @return
     */
    List<EmpVo> page(@Param("wheres")EmpVo wheres,@Param("start")int start,
                     @Param("pageSize")int pageSize);

    /**
     * 获取自动增长的主键
     * @return
     */
    int getKey();

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    Emp login(@Param("username") String username,@Param("password") String password);
}
