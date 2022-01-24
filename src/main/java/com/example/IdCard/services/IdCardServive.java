package com.example.IdCard.services;

import com.example.IdCard.model.OneCard;

import java.util.List;

public interface IdCardServive {
    List<OneCard> getCards();

    public void saveCard(OneCard oneCard);

    public void deleteCard(long id);

    OneCard getOneCardById(long id);
}
