package com.example.IdCard.services;

import com.example.IdCard.model.OneCard;
import com.example.IdCard.repos.IdCardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IdCardService {
    IdCardRepository idCardRepository;

    public List<OneCard> getCards(){
        return idCardRepository
                .findAll();
    }

    public void saveCard(OneCard oneCard){
        this.idCardRepository.save(oneCard);
    }
}
