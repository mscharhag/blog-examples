package com.mscharhag.mockmvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.mscharhag.mockmvc.TestUtil.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void requestTextBlocks() throws Exception {
        mvc.perform(put("/products/42")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                    {
                        "name": "Cool Gadget",
                        "description": "Looks cool"
                    }""".stripIndent())
                .header("Authorization", getBasicAuthHeader("John", "secr3t")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Cool Gadget"))
                .andExpect(jsonPath("$.description").value("Looks cool"));
    }

    @Test
    public void requestCustomJacksonMapping() throws Exception {
        Product product = new Product("Cool Gadget", "Looks cool");
        mvc.perform(put("/products/42")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectToJson(product))
                .header("Authorization", getBasicAuthHeader("John", "secr3t")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Cool Gadget"))
                .andExpect(jsonPath("$.description").value("Looks cool"));
    }

    @Test
    public void requestPutJson() throws Exception {
        Product product = new Product("Cool Gadget", "Looks cool");
        mvc.perform(putJson("/products/42", product)
                .header("Authorization", getBasicAuthHeader("John", "secr3t")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Cool Gadget"))
                .andExpect(jsonPath("$.description").value("Looks cool"));
    }

    @Test
    public void requestPutJsonWithAuthentication() throws Exception {
        Product product = new Product("Cool Gadget", "Looks cool");
        mvc.perform(putJson("/products/42", product).with(authentication()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Cool Gadget"))
                .andExpect(jsonPath("$.description").value("Looks cool"));
    }

    @Test
    public void response() throws Exception {
        mvc.perform(get("/products/42"))
                .andExpect(status().isOk())
                .andExpect(header().string("Cache-Control", "no-cache"))
                .andExpect(jsonPath("$.name").value("Cool Gadget"))
                .andExpect(jsonPath("$.description").value("Looks cool"));
    }

    @Test
    public void responseNoCacheHeader() throws Exception {
        mvc.perform(get("/products/42"))
                .andExpect(status().isOk())
                .andExpect(noCacheHeader())
                .andExpect(jsonPath("$.name").value("Cool Gadget"))
                .andExpect(jsonPath("$.description").value("Looks cool"));
    }

    @Test
    public void responseCustomResultMatcher() throws Exception {
        Product product = new Product("Cool Gadget", "Looks cool");
        mvc.perform(get("/products/42"))
                .andExpect(status().isOk())
                .andExpect(noCacheHeader())
                .andExpect(product("$", product));
    }
}
