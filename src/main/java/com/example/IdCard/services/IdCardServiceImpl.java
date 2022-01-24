package com.example.IdCard.services;

import com.example.IdCard.model.OneCard;
import com.example.IdCard.repos.IdCardRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class IdCardServiceImpl implements IdCardServive {
    @Autowired
    IdCardRepository idCardRepository;

    @Override
    public List<OneCard> getCards() {
        return idCardRepository
                .findAll();
    }

    @Override
    public void saveCard(OneCard oneCard) {
        this.idCardRepository.save(oneCard);
    }

    @Override
    public void deleteCard(long id) {
        this.idCardRepository.deleteById(id);
    }

    @Override
    public OneCard getOneCardById(long id) {
        Optional<OneCard> optional = idCardRepository.findById(id);
        OneCard oneCard = null;

        if(optional.isPresent()){
            oneCard = optional.get();
        }else {
            throw new RuntimeException("IdCard not found for id :: "+id);
        }
        return oneCard;
    }
}
