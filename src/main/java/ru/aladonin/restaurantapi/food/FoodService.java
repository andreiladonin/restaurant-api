package ru.aladonin.restaurantapi.food;

import java.util.List;
import java.util.Optional;

public interface FoodService {
    Food createFood(Food food);
    Optional<Food> getFoodById(Long id);
    List<Food> getFoodAll();
    List<Food> getFoodByCategory(String latin);
    void deleteFood(Long id);
}
