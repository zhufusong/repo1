package cn.itcast.service.impl;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("查询所有执行了");
        List<Account> list = accountDao.findAll();
        for (Account account : list) {
            System.out.println("account = " + account);
        }
        return null;
    }

    @Override
    @Transactional
    public void saveAccount(Account account) {
        System.out.println("保存用户执行了");
    }
}
