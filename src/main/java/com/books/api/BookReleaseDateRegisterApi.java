package com.books.api;

import com.books.service.BookReleaseDateRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class BookReleaseDateRegisterApi {

    @Autowired
    private BookReleaseDateRegisterService bookReleaseDateRegisterService;

    @RequestMapping("/books/register")
    public void register() {
        bookReleaseDateRegisterService.register();
    }
}
