package com.hamburgo.resource;

import com.hamburgo.environment.HamburguerEnvironment;
import com.hamburgo.model.Hamburguer;
import com.hamburgo.repository.HamburguerRepository;
import com.hamburgo.service.HamburguerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HamburguerResource.class)
public class HamburguerResourceTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private HamburguerService hamburguerService;

    @Mock
    private HamburguerRepository hamburguerRepository;

    @Test
    public void testFindAll() throws Exception {

        Hamburguer hamburguer = HamburguerEnvironment.createSimpleHamburguer();

        given(hamburguerService.findAll()).willReturn(Arrays.asList(hamburguer));

        mvc.perform(
            get("/hamburguer/findAll").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$[0].name", is("SIMPLE HAMBURGUER NAME")));
    }
}
