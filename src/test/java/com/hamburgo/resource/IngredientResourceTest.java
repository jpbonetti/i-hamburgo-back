package com.hamburgo.resource;

import com.hamburgo.environment.IngredientEnvironment;
import com.hamburgo.model.Ingredient;
import com.hamburgo.repository.IngredientRepository;
import com.hamburgo.service.IngredientService;
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
@WebMvcTest(IngredientResource.class)
public class IngredientResourceTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private IngredientService ingredientService;

    @Mock
    private IngredientRepository ingredientRepository;

    @Test
    public void testFindAll() throws Exception {

        Ingredient ingredient = IngredientEnvironment.createIngredient();

        given(ingredientService.findAll()).willReturn(Arrays.asList(ingredient));

        mvc.perform(
            get("/ingredient/findAll").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$[0].name", is("INGREDIENT NAME")));
    }

    @Test
    public void testSave() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders
            .post("/ingredient/save")
            .accept(MediaType.APPLICATION_JSON)
            .content("{\"id\":1,\"name\":\"SIMPLE INGREDIENT\"}")
            .contentType(MediaType.APPLICATION_JSON);

        mvc.perform(request)
            .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void testDelete() throws Exception {
        Long idIngredient = 1L;

        mvc.perform(delete("/ingredient/delete/" + idIngredient))
                .andExpect(status().isOk());

        verify(ingredientService, times(1))
            .delete(idIngredient);
    }
}
