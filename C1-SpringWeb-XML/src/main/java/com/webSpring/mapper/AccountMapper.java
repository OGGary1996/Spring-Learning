package com.webSpring.mapper;

import com.webSpring.entity.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper {
    List<Account> selectList();

    void update(@Param("id") Long id, @Param("money") Double money);

}
