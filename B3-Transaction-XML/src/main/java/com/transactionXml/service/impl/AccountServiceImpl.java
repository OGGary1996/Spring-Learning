package com.transactionXml.service.impl;

import com.transactionXml.entity.Account;
import com.transactionXml.mapper.AccountMapper;
import com.transactionXml.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    private AccountMapper accountMapper;
    public void setAccountMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }


    @Override
    public List<Account> list() {
        return accountMapper.selectList();
    }

    @Override
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
