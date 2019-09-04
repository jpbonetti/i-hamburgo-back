package com.hamburgo.resource;

import com.hamburgo.contracts.PromotionContrato;
import com.hamburgo.model.Promotion;
import com.hamburgo.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class PromotionResource implements PromotionContrato {

    @Autowired
    private PromotionService promotionService;

    @Override
    public ResponseEntity<List<Promotion>> findAll() {
        return ResponseEntity.ok(promotionService.findAll());
    }

    @Override
    public void save(@RequestBody Promotion promotion) {
        promotionService.save(promotion);
    }

    @Override
    public void delete(@PathVariable("idPromotion") Long idPromotiont) {
        promotionService.delete(idPromotiont);
    }
}