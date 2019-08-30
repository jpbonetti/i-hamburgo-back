package com.hamburgo.service;

import com.hamburgo.environment.IngredientEnvironment;
import com.hamburgo.model.Ingredient;
import com.hamburgo.repository.IngredientRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

public class IngredientsServiceTest {

    @InjectMocks
    private IngredientService ingredientService;

    @Mock
    private IngredientRepository ingredientRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        String ingredientName = "INGREDIENT NAME";

        when(ingredientRepository.findAll()).thenReturn(IngredientEnvironment.createListIngredients());

        List<Ingredient> retorno = ingredientService.findAll();

        Assert.assertNotNull(retorno);
        Assert.assertEquals(1, retorno.size());
        Assert.assertEquals(ingredientName, retorno.get(0).getName());
    }

    @Test
    public void testSave() {
        String ingredientName = "INGREDIENT NAME";

        Ingredient promotion = IngredientEnvironment.createIngredient();

        ingredientService.save(promotion);

        ArgumentCaptor<Ingredient> argumentCaptor = ArgumentCaptor.forClass(Ingredient.class);
        verify(ingredientRepository, times(1)).save(argumentCaptor.capture());

        Assert.assertNotNull(argumentCaptor.getValue());
        Assert.assertEquals(ingredientName, argumentCaptor.getValue().getName());
    }

    @Test
    public void testDelete() {
        Long idIngredient = 1L;

        ingredientService.delete(idIngredient);

        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(ingredientRepository, times(1)).deleteById(argumentCaptor.capture());

        Assert.assertNotNull(argumentCaptor.getValue());
        Assert.assertEquals(idIngredient, argumentCaptor.getValue());
    }
}
