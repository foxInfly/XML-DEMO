package com.lp.xml.controller;

import com.lp.xml.sax.Book;
import com.lp.xml.sax.XMLParserSAX;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.StringReader;
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

    //http://localhost:8080/4j/getBooks2?xml=%3C?xml%20version=%221.0%22%20encoding=%22UTF-8%22?%3E%20%3C!--%20Edited%20by%20XMLSpy%20--%3E%20%3Cbookstore%3E%20%3Cbook%20category=%22cooking%22%3E%20%3Ctitle%20lang=%22en%22%3EEveryday%20Italian%3C/title%3E%20%3Cauthor%3EGiada%20De%20Laurentiis%3C/author%3E%20%3Cyear%3E2005%3C/year%3E%20%3Cprice%3E30.00%3C/price%3E%20%3C/book%3E%20%3Cbook%20category=%22children%22%3E%20%3Ctitle%20lang=%22en%22%3EHarry%20Potter%3C/title%3E%20%3Cauthor%3EJ%20K.%20Rowling%3C/author%3E%20%3Cyear%3E2005%3C/year%3E%20%3Cprice%3E29.99%3C/price%3E%20%3C/book%3E%20%3Cbook%20category=%22web%22%3E%20%3Ctitle%20lang=%22en%22%3EXQuery%20Kick%20Start%3C/title%3E%20%3Cauthor%3EJames%20McGovern%3C/author%3E%20%3Cauthor%3EPer%20Bothner%3C/author%3E%20%3Cauthor%3EKurt%20Cagle%3C/author%3E%20%3Cauthor%3EJames%20Linn%3C/author%3E%20%3Cauthor%3EVaidyanathan%20Nagarajan%3C/author%3E%20%3Cyear%3E2003%3C/year%3E%20%3Cprice%3E49.99%3C/price%3E%20%3C/book%3E%20%3Cbook%20category=%22web%22%20cover=%22paperback%22%3E%20%3Ctitle%20lang=%22en%22%3ELearning%20XML%3C/title%3E%20%3Cauthor%3EErik%20T.%20Ray%3C/author%3E%20%3Cyear%3E2003%3C/year%3E%20%3Cprice%3E39.95%3C/price%3E%20%3C/book%3E%20%3C/bookstore%3E
    @GetMapping("getBooks2")
    public List<Book> getBooks2(String xml){
        List<Book> books = XMLParserSAX.xmlReader2(xml);
        for (Book book : books) {
            System.out.println(book.toString());
        }
        return books;
    }
}
