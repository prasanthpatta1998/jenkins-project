package com.example.mathwarapp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MathControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private int getA() {
        return Integer.parseInt(System.getProperty("math.a", "5")); // default 5
    }

    private int getB() {
        return Integer.parseInt(System.getProperty("math.b", "3")); // default 3
    }

    @Test
    void testAddition() throws Exception {
        int a = getA();
        int b = getB();
        int expected = a + b;

        mockMvc.perform(get("/math/add")
                .param("a", String.valueOf(a))
                .param("b", String.valueOf(b)))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(expected))); // <-- changed here
    }

    @Test
    void testSubtraction() throws Exception {
        int a = getA();
        int b = getB();
        int expected = a - b;

        mockMvc.perform(get("/math/subtract")
                .param("a", String.valueOf(a))
                .param("b", String.valueOf(b)))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(expected))); // <-- changed here
    }

    @Test
    void testMultiplication() throws Exception {
        int a = getA();
        int b = getB();
        int expected = a * b;

        mockMvc.perform(get("/math/multiply")
                .param("a", String.valueOf(a))
                .param("b", String.valueOf(b)))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(expected))); // <-- changed here
    }
@Test
void testDivision() throws Exception {
    int a = getA();
    int b = getB();

    if (b == 0) {
        mockMvc.perform(get("/math/divide")
                .param("a", String.valueOf(a))
                .param("b", String.valueOf(b)))
                .andExpect(status().isOk())
                .andExpect(content().string("Error: Cannot divide by zero"));
    } else {
        double expected = (double) a / b;  // changed to double
        mockMvc.perform(get("/math/divide")
                .param("a", String.valueOf(a))
                .param("b", String.valueOf(b)))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(expected)));
    }
}

}
