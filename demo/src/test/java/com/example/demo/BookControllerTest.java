package com.example.demo;

import com.example.demo.entity.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

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
        String bookJson = objectMapper.writeValueAsString(new Book("Effective Java", "Joshua Bloch", "9780134685991", true));

        mockMvc.perform(post("/api/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Effective Java"))
                .andExpect(jsonPath("$.author").value("Joshua Bloch"));
    }

    @Test
    public void testGetBookById() throws Exception {
        // Пример UUID книги
        String bookId = "some-uuid-id";

        mockMvc.perform(get("/api/books/" + bookId))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testUpdateBook() throws Exception {
        String bookId = "some-uuid-id";
        String updatedBookJson = objectMapper.writeValueAsString(new Book("Updated Title", "Updated Author", "9780134685991", true));

        mockMvc.perform(put("/api/books/" + bookId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedBookJson))
                .andExpect(status().isNotFound()); // В данном примере id может не существовать, поэтому тестирует 404
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
