package com.example.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HelloController helloController;

    @Test
    public void hello() throws Exception {
        given(helloController.hello()).willReturn(ResponseEntity.ok("hello"));
        call("hello");
    }

    @Test
    public void hola() throws Exception {
        given(helloController.hola()).willReturn(ResponseEntity.ok("hola"));
        call("hola");
    }

    private void call(String endpoint) throws Exception {
        mockMvc.perform(get("/" + endpoint))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string(endpoint));
    }

}