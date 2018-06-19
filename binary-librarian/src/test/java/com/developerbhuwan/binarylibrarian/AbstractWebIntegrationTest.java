package com.developerbhuwan.binarylibrarian;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Locale;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public abstract class AbstractWebIntegrationTest {

    protected MockMvc mvc;

    @Autowired
    WebApplicationContext context;

    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(context).
                defaultRequest(MockMvcRequestBuilders.get("/").locale(Locale.US)).
                build();
    }

    @Test
    void addNewBookInLibrary() {
    }


}
