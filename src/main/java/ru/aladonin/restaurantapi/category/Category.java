package ru.aladonin.restaurantapi.category;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;
import ru.aladonin.restaurantapi.food.Food;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="tbl_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String transliteration;

    private LocalDate date;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Food> foodSet;
    @PrePersist
    public void init(){
        date = LocalDate.now();
    }
}
