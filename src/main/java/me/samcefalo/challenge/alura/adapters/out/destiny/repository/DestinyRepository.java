package me.samcefalo.challenge.alura.adapters.out.destiny.repository;

import me.samcefalo.challenge.alura.adapters.out.destiny.repository.entity.DestinyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinyRepository extends JpaRepository<DestinyEntity, String> {

    List<DestinyEntity> findAllByNameContaining(String name);

}
