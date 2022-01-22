package com.example.IdCard.repos;

import com.example.IdCard.model.OneCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdCardRepository extends JpaRepository<OneCard, Long> {
}
