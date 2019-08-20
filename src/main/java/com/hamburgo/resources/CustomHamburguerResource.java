package com.hamburgo.resources;

import com.hamburgo.contracts.CustomHamburguerContrato;
import com.hamburgo.model.CustomHamburguer;
import com.hamburgo.service.CustomHamburguerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CustomHamburguerResource implements CustomHamburguerContrato {

    @Autowired
    private CustomHamburguerService customHamburguerService;

    @Override
    public ResponseEntity<List<CustomHamburguer>> findAll() {
        return ResponseEntity.ok(customHamburguerService.findAll());
    }

    @Override
    public Long save(@RequestBody CustomHamburguer customHamburguer) {
        return customHamburguerService.save(customHamburguer).getId();
    }

    @Override
    public void delete(@PathVariable("idOrder") Long idCustomHamburguer) {
        customHamburguerService.delete(idCustomHamburguer);
    }
}