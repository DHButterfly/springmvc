package com.dl.dao;

import com.dl.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2020/4/10.
 */
//利用注解Repository将AccountDao交给spring容器管理
@Repository
public interface AccountDao {
    @Select("select * from account2")
    public List<Account> findAll();
    @Insert("insert into account2 values (default,#{name},#{money})")
    public void saveDao(Account account);
}
