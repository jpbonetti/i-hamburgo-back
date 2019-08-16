package com.hamburgo.resources;

import com.hamburgo.contracts.HamburguerContrato;
import com.hamburgo.model.Hamburguer;
import com.hamburgo.service.HamburguerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class HamburguerResource implements HamburguerContrato {

    @Autowired
    private HamburguerService hamburguerService;

    @Override
    public ResponseEntity<List<Hamburguer>> findAll() {
        return ResponseEntity.ok(hamburguerService.findAll());
    }

    @Override
    public void save(@RequestBody Hamburguer hamburguer) {
        hamburguerService.save(hamburguer);
    }

    @Override
    public void delete(@PathVariable("idHamburguer") Long idHamburguer) {
        hamburguerService.delete(idHamburguer);
    }
}