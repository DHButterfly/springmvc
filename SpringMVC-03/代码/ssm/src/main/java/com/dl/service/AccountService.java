package com.dl.service;

import com.dl.domain.Account;

import java.util.List;

/**
 * Created by Administrator on 2020/4/10.
 */
public interface AccountService {
    public List<Account> findAll();
    public void saveDao(Account account);
}
