package ru.aladonin.restaurantapi.food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {

    @Query("")
    List<Food> getFoodsByCategoryTransliteration(String latin);
}
