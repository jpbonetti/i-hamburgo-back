package com.hamburgo.contracts;

import com.hamburgo.model.CustomHamburguer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customHamburguer")
public interface CustomHamburguerContrato {

    @GetMapping("/findAll")
    ResponseEntity<List<CustomHamburguer>> findAll();

    @PostMapping("/save")
    Long save(@RequestBody CustomHamburguer customHamburguer);

    @DeleteMapping("/delete/{idCustomHamburguer}")
    void delete(@PathVariable("idCustomHamburguer") Long idCustomHamburguer);
}
