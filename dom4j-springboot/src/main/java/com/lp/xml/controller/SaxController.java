package com.lp.xml.controller;

import com.lp.xml.sax.Book;
import com.lp.xml.sax.XMLParserSAX;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;
@RestController
public class SaxController {

    //http://localhost:8080/getBooks?path=books.xml
    @GetMapping("getBooks")
    public List<Book> getBooks(String path){
        List<Book> books = XMLParserSAX.xmlReader(new File(path));
//		List<Book> books = saxParser(new File("books.xml"));
        for (Book book : books) {
            System.out.println(book.toString());
        }
        return books;
    }
}
