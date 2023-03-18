package com.api.book.restapi.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.restapi.Entities.Book;

// @Controller
@RestController
public class BookController {

    // @RequestMapping(value = "/books", method = RequestMethod.GET)
    // @ResponseBody
    @GetMapping("/books")
    public String getbooks() {

        return "This is testing book first";
    }

    @GetMapping("/book")
    public Book getbook() {

        Book book = new Book();
        book.setId(1);
        book.setName("Hello");
        book.setAuthor("Goutham");
        return book;
    }

}
