package com.example.desafiobackenditarc.integration;

import com.example.desafiobackenditarc.config.IntegrationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IntegrationTest
public class GroupControllerTest {

    private MockMvc mockMvc;

    private String controllerUrl = "/api/v1/group";

    @Test
    @Sql("/sql/successGetUserGroups.sql")
    void successGetUserGroups() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(controllerUrl.concat("?user.id=1"))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.records[0].id")
                        .value(1));
    }
}
