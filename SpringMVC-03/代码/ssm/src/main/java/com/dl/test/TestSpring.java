package com.dl.test;

import com.dl.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2020/4/10.
 */
public class TestSpring {
    @Test
    public void test1(){
        //加载配置文件
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //获取对象
        AccountService accountService=(AccountService) applicationContext.getBean("accountService");
        //执行方法
        accountService.findAll();
    }
}
