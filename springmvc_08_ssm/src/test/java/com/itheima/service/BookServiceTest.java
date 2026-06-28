package com.itheima.service;

import com.itheima.config.SpringConfig;
import com.itheima.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)  // 指定用 Spring 的测试引擎运行
@ContextConfiguration(classes= SpringConfig.class)  // 告诉 Spring 加载哪个配置类
public class BookServiceTest { // Spring继承测试类，测试BookService业务层是否正常工作

    @Autowired
    private BookService bookService;

    @Test
    public void testGetById(){
        Book book=bookService.getById(1);
        System.out.println(book);
    }

    @Test
    public void testGetAll(){
        List<Book> all=bookService.getAll();
        System.out.println(all);
    }
}