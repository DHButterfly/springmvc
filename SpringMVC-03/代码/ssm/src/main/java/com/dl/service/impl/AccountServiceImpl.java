package com.dl.service.impl;

import com.dl.dao.AccountDao;
import com.dl.domain.Account;
import com.dl.service.AccountService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2020/4/10.
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountDao accountDao;
    @Override
    public List<Account> findAll() {
        System.out.println("业务层查询Account2所有信息!!!");
        return accountDao.findAll();
    }

    @Override
    public void saveDao(Account account) {
        System.out.println("业务层保存Account信息!!!");
        accountDao.saveDao(account);
    }
}
