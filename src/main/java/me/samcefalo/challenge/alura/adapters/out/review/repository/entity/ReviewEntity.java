package me.samcefalo.challenge.alura.adapters.out.review.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "reviews")
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;
    @Column(name = "date")
    private LocalDateTime date;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "author")
    private String author;
    @Column(name = "review")
    private String review;

}
