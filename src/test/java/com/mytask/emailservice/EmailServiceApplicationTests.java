package com.mytask.emailservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mytask.emailservice.model.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EmailServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void sendMessage() throws Exception {
        this.mockMvc.perform(post("/api/email/message")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(new Message("email", "test"))))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void sendMessageWithBadField() throws Exception {
        this.mockMvc.perform(post("/api/email/message")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(new Message(null, "test"))))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}
