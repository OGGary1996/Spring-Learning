package com.webSpring.service.impl;


import com.webSpring.entity.Account;
import com.webSpring.mapper.AccountMapper;
import com.webSpring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    private final AccountMapper accountMapper;
    @Autowired
    public AccountServiceImpl(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }


    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED,
            readOnly = true
    )
    public List<Account> list() {
        return accountMapper.selectList();
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = {Exception.class}
    )
    public void transfer(Long formId, Long toId, Double money) {
        // formId账户扣钱
        accountMapper.update(formId, money*(-1));
        System.out.println("【Transfer】- Account " + formId + " deducted " + money);

        // 模拟异常
//        int i = 1/0;

        // toId账户加钱
        accountMapper.update(toId,money);
        System.out.println("【Transfer】- Account " + toId + " added " + money);
    }

}
