package com.dl.controller;

import com.dl.domain.Account;
import com.dl.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.management.counter.AbstractCounter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2020/4/10.
 */
@Controller
@RequestMapping(value = "/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @RequestMapping(value = "/findAll")
    public String findAll(Model model){
        System.out.println("表现层查询所有信息！");
        List<Account>list = accountService.findAll();
        model.addAttribute("list",list);
        return "list";
    }
    @RequestMapping(value = "/save")
    public void saveAccount(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        accountService.saveDao(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return;
    }
}
