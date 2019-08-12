package com.hamburgo.contracts;

import com.hamburgo.model.Hamburguer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hamburguer")
public interface HamburguerContrato {

    @GetMapping("/findAll")
    ResponseEntity<List<Hamburguer>> findAll();

    @PostMapping("/save")
    void save(@RequestBody Hamburguer hamburguer);

    @DeleteMapping("/delete/{idHamburguer}")
    void delete(@PathVariable("idHamburguer") Long idHamburguer);
}
