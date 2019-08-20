package com.hamburgo.service;

import com.hamburgo.model.CustomHamburguer;
import com.hamburgo.repository.CustomHamburguerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomHamburguerService {

    @Autowired
    private CustomHamburguerRepository customHamburguerRepository;

    public List<CustomHamburguer> findAll() {
        return customHamburguerRepository.findAll();
    }

    public CustomHamburguer save(CustomHamburguer customHamburguer) {
        return customHamburguerRepository.save(customHamburguer);
    }

    public void delete(Long idCustomHamburguer) {
        customHamburguerRepository.deleteById(idCustomHamburguer);
    }
}
