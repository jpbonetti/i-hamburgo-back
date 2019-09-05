package com.hamburgo.resource;

import com.hamburgo.environment.PromotionEnvironment;
import com.hamburgo.model.Promotion;
import com.hamburgo.repository.PromotionRepository;
import com.hamburgo.service.PromotionService;
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
@WebMvcTest(PromotionResource.class)
public class PromotionResourceTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PromotionService promotionService;

    @Mock
    private PromotionRepository promotionRepository;

    @Test
    public void testFindAll() throws Exception {

        Promotion promotion = PromotionEnvironment.createPromotion();

        given(promotionService.findAll()).willReturn(Arrays.asList(promotion));

        mvc.perform(
            get("/promotion/findAll").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$[0].name", is("PROMOTION NAME")));
    }

    @Test
    public void testSave() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders
            .post("/promotion/save")
            .accept(MediaType.APPLICATION_JSON)
            .content("{\"id\":1,\"name\":\"SIMPLE PROMOTION\"}")
            .contentType(MediaType.APPLICATION_JSON);

        mvc.perform(request)
            .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void testDelete() throws Exception {
        Long idPromotion = 1L;

        mvc.perform(delete("/promotion/delete/" + idPromotion))
                .andExpect(status().isOk());

        verify(promotionService, times(1))
            .delete(idPromotion);
    }
}
