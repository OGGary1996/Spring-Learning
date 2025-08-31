package com.xmlMyBatis.service.impl;

import com.xmlMyBatis.dao.DepartmentDAO;
import com.xmlMyBatis.mapper.DepartmentMapper;
import com.xmlMyBatis.pojo.Department;
import com.xmlMyBatis.service.DepartmentService;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentMapper departmentMapper;
    public void setDepartmentMapper(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    @Override
    public void getAll() {
        List<Department> departmentList = departmentMapper.getAll();
        departmentList.stream().map(department -> {
            DepartmentDAO departmentDAO = new DepartmentDAO();
            BeanUtils.copyProperties(department, departmentDAO);
            return departmentDAO;
        }).toList().forEach(System.out::println);
    }
}
