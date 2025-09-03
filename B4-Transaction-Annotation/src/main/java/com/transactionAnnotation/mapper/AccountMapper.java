package com.transactionAnnotation.mapper;

import com.transactionAnnotation.entity.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper {
    List<Account> selectList();

    void update(@Param("id") Long id, @Param("money") Double money);

}
