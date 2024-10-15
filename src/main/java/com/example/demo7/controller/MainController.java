package com.example.demo7.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo7.model.Book;
import com.example.demo7.service.BookService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@RestController
public class MainController {
 private final BookService bookService;

         public MainController(BookService bookService) {
         this.bookService = bookService;
         }

         @PostMapping("/create-book")
 public ResponseEntity<String> createBook(@RequestBody Book newBook) {
         try {
             bookService.createBook(newBook);
             return new ResponseEntity<>("Tạo sách thành công."
                    ,HttpStatus.CREATED);
             } catch (Exception e) {
             return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
             }
         }
    @DeleteMapping("/delete-book")
    public ResponseEntity<String> deleteBook(@RequestParam(name = "isbn") String isbn) {
        try {
            bookService.deleteBook(isbn);
            return new ResponseEntity<>("Đã xóa sách thành công.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/edit-book")
    public ResponseEntity<String> updateBook(@RequestBody Book book) {
        try {
            String isbn = book.getISBN();
            bookService.updateBook(isbn, book);
            return new ResponseEntity<>("Sách được cập nhật thành công.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-book")
    public ResponseEntity<Book> getBook(@RequestParam(name = "isbn") String isbn) {
        Optional<Book> book = bookService.getBook(isbn);
        if (book.isPresent())
            return new ResponseEntity<>(book.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

}
