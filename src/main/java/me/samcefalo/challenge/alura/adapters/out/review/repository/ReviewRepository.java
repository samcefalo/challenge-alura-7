package me.samcefalo.challenge.alura.adapters.out.review.repository;

import me.samcefalo.challenge.alura.adapters.out.review.repository.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, String> {

    List<ReviewEntity> findTop3ByOrderByDateDesc();

}
