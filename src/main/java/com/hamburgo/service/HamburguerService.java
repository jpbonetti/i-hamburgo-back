package com.hamburgo.service;

import com.hamburgo.model.Hamburguer;
import com.hamburgo.repository.HamburguerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HamburguerService {

    @Autowired
    private HamburguerRepository hamburguerRepository;

    public List<Hamburguer> findAll() {
        return hamburguerRepository.findAll();
    }

    public void save(Hamburguer hamburguer) {
        hamburguerRepository.save(hamburguer);
    }

    public void delete(Long idHamburguer) {
        hamburguerRepository.deleteById(idHamburguer);
    }
}
