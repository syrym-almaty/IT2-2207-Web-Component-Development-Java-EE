package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/books")
@Tag(name = "Book Controller", description = "CRUD operations for Book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Operation(summary = "Get all books", description = "Gives a list of all books")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list")
    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @Operation(summary = "Create Book", description = "Creates a new book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Book created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public Book createBook(
            @Parameter(description = "Book object to be created", required = true)
            @RequestBody Book book){
        return bookService.createBook(book);
    }

    @Operation(summary = "Get book by ID", description = "Finds a book by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found book"),
            @ApiResponse(responseCode = "404", description = "Book not found")
    })
    @GetMapping("/{id}")
    public Book getBookById(
            @Parameter(description = "UUID of the book to find", required = true)
            @PathVariable UUID id){
        return bookService.getBookById(id);
    }

    @Operation(summary = "Delete Book by ID", description = "Deletes book based on ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Book deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Book not found")
    })
    @DeleteMapping("/{id}")
    public void deleteBookById(
            @Parameter(description = "UUID of the book to delete", required = true)
            @PathVariable UUID id){
        bookService.deleteBookById(id);
    }





}
