package com.hamburgo.contracts;

import com.hamburgo.model.Hamburguer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hamburguer")
public interface HamburguerContract {

    @RequestMapping("/findAllHamburguer")
    List<Hamburguer> findAllHamburguer();
}
