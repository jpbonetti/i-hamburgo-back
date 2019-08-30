package com.hamburgo.service;

import com.hamburgo.environment.HamburguerEnvironment;
import com.hamburgo.model.Hamburguer;
import com.hamburgo.repository.HamburguerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class HamburguerServiceTest {

    @InjectMocks
    private HamburguerService hamburguerService;

    @Mock
    private HamburguerRepository hamburguerRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        String hamburguerName = "HAMBURGUER NAME";

        when(hamburguerRepository.findAll()).thenReturn(HamburguerEnvironment.createListHamburguers());

        List<Hamburguer> retorno = hamburguerService.findAll();

        Assert.assertNotNull(retorno);
        Assert.assertEquals(1, retorno.size());
        Assert.assertEquals(hamburguerName, retorno.get(0).getName());
    }

    @Test
    public void testSave() {
        String hamburguerName = "HAMBURGUER NAME";

        Hamburguer hamburguer = HamburguerEnvironment.createHamburguer();

        hamburguerService.save(hamburguer);

        ArgumentCaptor<Hamburguer> argumentCaptor = ArgumentCaptor.forClass(Hamburguer.class);
        verify(hamburguerRepository, times(1)).save(argumentCaptor.capture());

        Assert.assertNotNull(argumentCaptor.getValue());
        Assert.assertEquals(hamburguerName, argumentCaptor.getValue().getName());
    }

    @Test
    public void testDelete() {
        Long idHamburguer = 1L;

        hamburguerService.delete(idHamburguer);

        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(hamburguerRepository, times(1)).deleteById(argumentCaptor.capture());

        Assert.assertNotNull(argumentCaptor.getValue());
        Assert.assertEquals(idHamburguer, argumentCaptor.getValue());
    }
}
