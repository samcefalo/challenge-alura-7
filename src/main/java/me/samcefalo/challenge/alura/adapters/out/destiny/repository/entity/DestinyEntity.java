package me.samcefalo.challenge.alura.adapters.out.destiny.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "destinations")
public class DestinyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @ElementCollection
    private final Set<String> photos = new HashSet<>();
    @Column(name = "description")
    private String description;
    @Column(name = "goal")
    private String goal;
    @Column(name = "price")
    private BigDecimal price;

}
