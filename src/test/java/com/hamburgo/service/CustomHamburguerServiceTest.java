package com.hamburgo.service;

import com.hamburgo.environment.CustomHamburguerEnvironment;
import com.hamburgo.model.CustomHamburguer;
import com.hamburgo.repository.CustomHamburguerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

public class CustomHamburguerServiceTest {

    @InjectMocks
    private CustomHamburguerService customHamburguerService;

    @Mock
    private CustomHamburguerRepository customHamburguerRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        String customHamburguerName = "CUSTOM HAMBURGUER NAME";

        when(customHamburguerRepository.findAll()).thenReturn(CustomHamburguerEnvironment
                .createListCustomHamburguers());

        List<CustomHamburguer> retorno = customHamburguerService.findAll();

        Assert.assertNotNull(retorno);
        Assert.assertEquals(1, retorno.size());
        Assert.assertEquals(customHamburguerName, retorno.get(0).getName());
    }

    @Test
    public void testSave() {
        String customHamburguerName = "CUSTOM HAMBURGUER NAME";

        CustomHamburguer customHamburguer = CustomHamburguerEnvironment.createCustomHamburguer();

        customHamburguerService.save(customHamburguer);

        ArgumentCaptor<CustomHamburguer> argumentCaptor = ArgumentCaptor.forClass(CustomHamburguer.class);
        verify(customHamburguerRepository, times(1)).save(argumentCaptor.capture());

        Assert.assertNotNull(argumentCaptor.getValue());
        Assert.assertEquals(customHamburguerName, argumentCaptor.getValue().getName());
    }

    @Test
    public void testDelete() {
        Long idHamburguer = 1L;

        customHamburguerService.delete(idHamburguer);

        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(customHamburguerRepository, times(1)).deleteById(argumentCaptor.capture());

        Assert.assertNotNull(argumentCaptor.getValue());
        Assert.assertEquals(idHamburguer, argumentCaptor.getValue());
    }
}
