package ru.aladonin.restaurantapi.food;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.aladonin.restaurantapi.category.Category;


@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    private String transliteration;
    private String description;
    private String fileName;
    private Double cost;
    public Double massInGrams;
    public Boolean isSet = false;
    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

}
