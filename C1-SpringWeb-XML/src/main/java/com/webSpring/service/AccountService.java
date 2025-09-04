package com.webSpring.service;



import com.webSpring.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> list();

    // 转账
    void transfer(Long formId, Long toId, Double money);
}
