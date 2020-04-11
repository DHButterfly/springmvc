package com.dl.test;

import com.dl.dao.AccountDao;
import com.dl.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * Created by Administrator on 2020/4/10.
 */
public class TestMybatis {
    /*
    测试查询
     */
    @Test
    public void test1() throws Exception {
        //加载配置文件
        InputStream in=Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession session=factory.openSession();
        //获取代理对象
        AccountDao dao=session.getMapper(AccountDao.class);
        List<Account> accounts = dao.findAll();
        for(Account account:accounts){
            System.out.println(account);
        }
        session.close();
        in.close();
    }
    /*
    测试保存
     */
    @Test
    public void test2()throws Exception{
        //首先加载配置文件
        InputStream in=Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //通过session对象获得代理
        AccountDao dao=session.getMapper(AccountDao.class);
        //进行保存
        /*
        *做增删改都需要提交事务,spring整合mybatis也就是需要将获得的代理对象注入到IOC容器中，
        * 而Service也在IOC容器中，因此可以调用
         */
        Account account=new Account();
        account.setName("小芳");
        account.setMoney(500.0);
        dao.saveDao(account);
        //提交事务
        session.commit();
        session.close();
        in.close();
    }
}
