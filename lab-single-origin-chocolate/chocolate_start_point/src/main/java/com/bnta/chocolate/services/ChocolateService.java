package com.bnta.chocolate.services;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChocolateService {

    @Autowired
    ChocolateRepository chocolateRepository;

    public List<Chocolate> getAllChocolates(){
      return chocolateRepository.findAll();
    }

    public Optional<Chocolate> getChocolateById(Long id){
        return chocolateRepository.findById(id);
    }

    public Chocolate addChocolate(Chocolate chocolate){
        return chocolateRepository.save(chocolate);
    }

//method to call the derived query in the chocolate repo
    public List<Chocolate> getChocolatesByCocoaPercentage(int cocoaPercentage) {
        return chocolateRepository.findByCocoaPercentageGreaterThanEqual(cocoaPercentage);
    }
}
