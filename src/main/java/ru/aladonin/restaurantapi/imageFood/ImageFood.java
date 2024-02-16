package ru.aladonin.restaurantapi.imageFood;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.aladonin.restaurantapi.food.Food;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_image")
public class ImageFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "food_id")
    private Food food;
}
