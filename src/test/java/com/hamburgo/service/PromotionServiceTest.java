package com.hamburgo.service;

import com.hamburgo.environment.PromotionEnvironment;
import com.hamburgo.model.Promotion;
import com.hamburgo.repository.PromotionRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

public class PromotionServiceTest {

    @InjectMocks
    private PromotionService promotionService;

    @Mock
    private PromotionRepository promotionRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        String promotionName = "PROMOTION NAME";

        when(promotionRepository.findAll()).thenReturn(PromotionEnvironment.createListPromotions());

        List<Promotion> retorno = promotionService.findAll();

        Assert.assertNotNull(retorno);
        Assert.assertEquals(1, retorno.size());
        Assert.assertEquals(promotionName, retorno.get(0).getName());
    }

    @Test
    public void testSave() {
        String promotionName = "PROMOTION NAME";

        Promotion promotion = PromotionEnvironment.createPromotion();

        promotionService.save(promotion);

        ArgumentCaptor<Promotion> argumentCaptor = ArgumentCaptor.forClass(Promotion.class);
        verify(promotionRepository, times(1)).save(argumentCaptor.capture());

        Assert.assertNotNull(argumentCaptor.getValue());
        Assert.assertEquals(promotionName, argumentCaptor.getValue().getName());
    }

    @Test
    public void testDelete() {
        Long idPromotion = 1L;

        promotionService.delete(idPromotion);

        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(promotionRepository, times(1)).deleteById(argumentCaptor.capture());

        Assert.assertNotNull(argumentCaptor.getValue());
        Assert.assertEquals(idPromotion, argumentCaptor.getValue());
    }
}
