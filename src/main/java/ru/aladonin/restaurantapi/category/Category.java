package ru.aladonin.restaurantapi.category;

import jakarta.persistence.*;
import lombok.*;

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

    @PrePersist
    public void init(){
        date = LocalDate.now();
    }
}
