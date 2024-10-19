package com.example.demo;

import com.example.demo.entity.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class DemoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllBooks() throws Exception {
        mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testCreateBook() throws Exception {
        // Создаем объект книги для теста
        Book book = new Book("Java Book", "Author", "123456789", true);
        String bookJson = objectMapper.writeValueAsString(book);

        mockMvc.perform(post("/api/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Java Book"))
                .andExpect(jsonPath("$.author").value("Author"));
    }

    @Test
    public void testGetBookById() throws Exception {
        String bookId = "some-uuid-id";

        mockMvc.perform(get("/api/books/" + bookId))
                .andExpect(status().isNotFound()); // Предполагается, что книга не существует
    }

    @Test
    public void testUpdateBook() throws Exception {
        String bookId = "some-uuid-id";
        Book updatedBook = new Book("Updated Book", "Updated Author", "987654321", false);
        String updatedBookJson = objectMapper.writeValueAsString(updatedBook);

        mockMvc.perform(put("/api/books/" + bookId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedBookJson))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testDeleteBook() throws Exception {
        String bookId = "some-uuid-id";

        mockMvc.perform(delete("/api/books/" + bookId))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testSearchBooks() throws Exception {
        mockMvc.perform(get("/api/books/search")
                        .param("keyword", "Java"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
