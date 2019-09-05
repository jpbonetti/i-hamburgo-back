package com.hamburgo.resource;

import com.hamburgo.environment.CustomHamburguerEnvironment;
import com.hamburgo.model.CustomHamburguer;
import com.hamburgo.repository.CustomHamburguerRepository;
import com.hamburgo.service.CustomHamburguerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomHamburguerResource.class)
public class CustomHamburguerResourceTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomHamburguerService customhamburguerService;

    @Mock
    private CustomHamburguerRepository customHamburguerRepository;

    @Test
    public void testFindAll() throws Exception {

        CustomHamburguer customHamburguer = CustomHamburguerEnvironment.createCustomHamburguer();

        given(customhamburguerService.findAll()).willReturn(Arrays.asList(customHamburguer));

        mvc.perform(
            get("/customHamburguer/findAll").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$[0].name", is("CUSTOM HAMBURGUER NAME")));
    }

    @Test
    public void testSave() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders
            .post("/customHamburguer/save")
            .accept(MediaType.APPLICATION_JSON)
            .content("{\"id\":1,\"name\":\"CUSTOM HAMBURGUER NAME\"}")
            .contentType(MediaType.APPLICATION_JSON);

        mvc.perform(request)
            .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void testDelete() throws Exception {
        Long idCustomHamburguer = 1L;

        mvc.perform(delete("/customHamburguer/delete/" + idCustomHamburguer))
                .andExpect(status().isOk());

        verify(customhamburguerService, times(1))
            .delete(idCustomHamburguer);
    }
}
