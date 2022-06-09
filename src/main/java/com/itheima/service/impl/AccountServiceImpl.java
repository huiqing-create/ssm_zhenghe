package com.itheima.service.impl;

import com.itheima.domain.Account;
import com.itheima.mapper.AccountMapper;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

//    @Override   之前的save方法
//    public void save(Account account) {
//        try {
//            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//            SqlSession sqlSession = sqlSessionFactory.openSession();
//            AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
//            mapper.save(account);
//            sqlSession.commit();
//            sqlSession.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    /**
     * 之前有关mybatis的相关工厂对象，mapper接口的实现等等一些东西都要通过读取配置文件，使用工厂对象创建mapper实现的对象，
     * 现在spring和mybatis相结合了，直接就可一将mybatis交给spring容器的bean管理，省去了获取对象一些繁杂的步骤
     */
    @Autowired
    private AccountMapper accountMapper;


    @Override
    public void save(Account account) {
        accountMapper.save(account);
    }

    @Override
    public List<Account> findAll() {
        return accountMapper.findAll();
    }
}

