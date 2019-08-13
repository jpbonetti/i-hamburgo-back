package com.hamburgo.contracts;

import com.hamburgo.model.Promotion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/promotion")
public interface PromotionContrato {

    @GetMapping("/findAll")
    ResponseEntity<List<Promotion>> findAll();

    @PostMapping("/save")
    void save(@RequestBody Promotion promotion);

    @DeleteMapping("/delete/{idPromotion}")
    void delete(@PathVariable("idPromotion") Long idPromotion);
}
