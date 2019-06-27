package com.alpha.heroku.test.controller;

import com.alpha.heroku.test.bo.PageBO;
import com.alpha.heroku.test.bo.PageParamBO;
import com.alpha.heroku.test.bo.ResponseBO;
import com.alpha.heroku.test.entity.MyFirst;
import com.alpha.heroku.test.mapper.MyFirstMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author huiyan.yao
 * @Date 2019/6/26 15:08
 */
@Controller
@Slf4j
public class TestController {
    @Autowired
    private MyFirstMapper myFirstMapper;


    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return String.valueOf(System.currentTimeMillis());
    }

    @GetMapping("/list")
    @ResponseBody
    public ResponseBO<PageBO<MyFirst>> list(PageParamBO pageParamBO) {
        PageHelper.startPage(pageParamBO.getPageIndex(), pageParamBO.getPageSize());
        Page page = (Page) myFirstMapper.selectByExample(null);
        PageBO<MyFirst> pageBO = new PageBO<>(page, MyFirst.class);

        return new ResponseBO<>(pageBO);
    }

    @GetMapping("/add")
    @ResponseBody
    public ResponseBO<Void> add() {
        MyFirst book = new MyFirst();
        book.setGroupName("yao" + String.valueOf(System.currentTimeMillis()));
        book.setFirstName("query" + String.valueOf(System.currentTimeMillis()));
        myFirstMapper.insertSelective(book);

        log.info("对象插入完毕：{}", book);
        return new ResponseBO<>();
    }
}
