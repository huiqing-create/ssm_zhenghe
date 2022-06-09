package com.itheima.controller;

import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    //保存
    @RequestMapping(value = "/save" ,produces = "text/html;charset=UTF-8")
    @ResponseBody
    /*
     * @ResponseBody注解的作用是将Controller的方法返回的对象通过适当的转换器转换为指定格式之后，
     * 写入到response对象的body区，通常用来返回json或者xml数据。在使用这个注解之后就不会再走视图
     * 处理器，而是直接将数据写入输出流中，效果等同于通过response对象输出指定格式的数据。
     * */
    public String save(Account account) {
        accountService.save(account);
        return "保存成功";
    }

    //查询
    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        List<Account> all = accountService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("accountList",all);
        modelAndView.setViewName("accountList");
        return modelAndView;
    }
}
