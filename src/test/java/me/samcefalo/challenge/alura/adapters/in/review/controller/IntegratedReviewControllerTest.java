package me.samcefalo.challenge.alura.adapters.in.review.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.samcefalo.challenge.alura.adapters.in.review.controller.request.ReviewRequest;
import me.samcefalo.challenge.alura.adapters.in.review.controller.request.ReviewRequestMother;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
@ActiveProfiles("test")
class IntegratedReviewControllerTest {
    // TODO fix this test

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(2)
    public void should_find_by_id() throws Exception {
        String id = "1";

        this.mockMvc.perform(get("/api/v1/review/"+ id)).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Order(3)
    public void should_find_last() throws Exception {
        this.mockMvc.perform(get("/api/v1/review/last")).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Order(1)
    public void should_insert() throws Exception {
        ReviewRequest reviewRequest = ReviewRequestMother.create();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(reviewRequest);
        this.mockMvc.perform(post("/api/v1/review")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    @Order(4)
    public void should_update() throws Exception {
        String id = "1";
        ReviewRequest reviewRequest = ReviewRequestMother.create();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(reviewRequest);
        this.mockMvc.perform(put("/api/v1/review/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    @Order(5)
    public void should_delete() throws Exception {
        String id = "1";
        this.mockMvc.perform(delete("/api/v1/review/" + id))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

}
