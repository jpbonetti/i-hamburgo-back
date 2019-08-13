package com.hamburgo.service;

import com.hamburgo.model.Promotion;
import com.hamburgo.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    public List<Promotion> findAll() {
        return promotionRepository.findAll();
    }

    public void save(Promotion promotion) {
        promotionRepository.save(promotion);
    }

    public void delete(Long idPromotion) {
        promotionRepository.deleteById(idPromotion);
    }
}
