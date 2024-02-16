package ru.aladonin.restaurantapi.food;

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
    private String title;
    private String description;
    private Double cost;
    public Double massInGrams;
    public Boolean isSet = false;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
