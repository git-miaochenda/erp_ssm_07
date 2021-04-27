package com.erp.service.impl;

import com.erp.mapper.EmpMapper;
import com.erp.mapper.EmpRoleMapper;
import com.erp.mapper.PermissionMapper;
import com.erp.pojo.Emp;
import com.erp.service.EmpService;
import com.erp.util.EasyUiResultUtil;
import com.erp.util.TreeResultUtil;
import com.erp.vo.EmpVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpRoleMapper empRoleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public void remove(int[] ids) {
        empMapper.remove(ids);
    }

    @Override
    public void update(Emp emp, int[] roleIds) {
        //修改emp表
        empMapper.update(emp);
        //在修改emp_role--修改多对多
        //再删除
        empRoleMapper.remove(new int[]{emp.getId()});
        //在增加
        empRoleMapper.add(emp.getId(),roleIds);
    }

    @Override
    public EmpVo findById(int id) {
        return empMapper.findById(id);
    }

    @Override
    public void add(Emp emp, int[] roleIds) {
        //先设置默认密码 默认手机后后四位和身份证后四位结合
        String tel=emp.getTel();
        String idCardNo=emp.getIdCardNo();
        String password=tel.substring(tel.length()-4)+idCardNo.substring(idCardNo.length()-4);
        //在设置生日 出生年月：默认从身份证中获取
        String birthDate=idCardNo.substring(6,14);//342221202011010213
        StringBuilder stringBuilder=new StringBuilder(birthDate);//202011/01
        stringBuilder.insert(6,"/").insert(4,"/");
        //把它们设置到emp中
        emp.setPassword(password);
        emp.setBirthDate(stringBuilder.toString());
        //再来执行增加
        empMapper.add(emp);
        int empId=empMapper.getKey();
        empRoleMapper.add(empId,roleIds);
    }

    @Override
    public EasyUiResultUtil<EmpVo> page(EmpVo wheres, int pageNum, int pageSize) {
        List<EmpVo> page = empMapper.page(wheres, (pageNum - 1) * pageSize, pageSize);

        int count = empMapper.count(wheres);
        return new EasyUiResultUtil<EmpVo>(count,page);
    }

    @Override
    public Emp login(String username, String password) {
        return empMapper.login(username,password);
    }

    @Override
    public List<TreeResultUtil> getPerms(String username) {
        return permissionMapper.getPerms(username);
    }
}
