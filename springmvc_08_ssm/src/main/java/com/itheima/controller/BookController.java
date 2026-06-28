package com.itheima.controller;

import com.itheima.domain.Book;
import com.itheima.exception.BusinessException;
import com.itheima.exception.SystemException;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Result save(@RequestBody Book book) { // 从提交的JSON数据中获取

        boolean flag=bookService.save(book);
        return new Result(flag?Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean flag=bookService.update(book);
        return new Result(flag?Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag=bookService.delete(id);
        return new Result(flag?Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        // 第一关：业务校验（主动抛业务异常）
        if(id==1){
            throw new BusinessException(Code.BUSINESS_ERR,"请不要用你的技术挑战我的耐心");
        }
        // 第二关：系统级模拟（捕获底层异常并转译）
        try {
            int i=1/0;
        }catch (Exception e){
            throw new SystemException(Code.SYSTEM_TIMEOUT_ERR,"服务器访问超时，请重试",e);
        }

        Book book=bookService.getById(id);
        Integer code=book!=null?Code.GET_OK:Code.GET_ERR;
        String msg=book!=null?"":"数据查询失败，请重试！";
        return new Result(code,book,msg);
    }

    @GetMapping("")
    public Result getAll() {
        List<Book> bookList=bookService.getAll();
        Integer code=bookList!=null?Code.GET_OK:Code.GET_ERR;
        String msg=bookList!=null?"":"数据查询失败，请重试！";
        return new Result(code,bookList,msg);
    }
}
