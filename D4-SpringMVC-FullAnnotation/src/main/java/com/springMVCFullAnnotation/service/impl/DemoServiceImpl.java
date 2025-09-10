package com.springMVCFullAnnotation.service.impl;

import com.springMVCFullAnnotation.entity.Account;
import com.springMVCFullAnnotation.mapper.DemoMapper;
import com.springMVCFullAnnotation.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {
    private final DemoMapper demoMapper;
    @Autowired
    public DemoServiceImpl(DemoMapper demoMapper) {
        this.demoMapper = demoMapper;
    }

    @Override
    @Transactional(
        isolation = Isolation.REPEATABLE_READ, // 可重复读
        readOnly = true, // 只读事务
        timeout = 5, // 超时时间3秒
        rollbackFor = Exception.class // 遇到异常回滚
    )
    public List<Account> list() {
        System.out.println("DemoServiceImpl is called");
        return demoMapper.selectList();
    }
}
