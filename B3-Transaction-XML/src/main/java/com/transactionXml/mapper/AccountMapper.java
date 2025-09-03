package com.transactionXml.mapper;

import com.transactionXml.entity.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper {
    List<Account> selectList();

    void update(@Param("id") Long id, @Param("money") Double money);

}
