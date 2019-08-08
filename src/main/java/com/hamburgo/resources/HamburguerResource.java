package com.hamburgo.resources;

import com.hamburgo.contracts.HamburguerContract;
import com.hamburgo.model.Hamburguer;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class HamburguerResource implements HamburguerContract {

    @Override
    public List<Hamburguer> findAllHamburguer() {
        return Arrays.asList(new Hamburguer().setId(1L).setName("Hamburguer 1"));
    }
}