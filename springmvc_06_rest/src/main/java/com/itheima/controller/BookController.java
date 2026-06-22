package com.itheima.controller;

import com.itheima.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
//@ResponseBody // 代表这个类所有的方法都带@ReSponseBody
@RestController // @Controller 和 @ResponseBody 合二为一
@RequestMapping("/books") // 所有方法统一加个前缀/books
public class BookController {

//    @RequestMapping(method = RequestMethod.POST)
    @PostMapping  // 与上面的注解同一个意思
    public String save(@RequestBody Book book){
        System.out.println("book save..."+book);
        return "{'module':'book save}";
    }

//    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        System.out.println("book delete..."+id);
        return "{'module':'book delete'}";
    }

//    @RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public String update(@RequestBody Book book){
        System.out.println("book update..."+book);
        return "{'module':'book update'}";
    }

//    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Integer id){
        System.out.println("book getById..."+id);
        return "{'module':'book getById'}";
    }

//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String getAll(){
        System.out.println("book getAll...");
        return "{'module':'book getById'}";
    }

}
