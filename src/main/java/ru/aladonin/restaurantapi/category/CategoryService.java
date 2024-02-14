package ru.aladonin.restaurantapi.category;

import java.util.Optional;

public interface CategoryService {
    Category createCategory(Category category);
    Optional<Category> getCategory(String latin);
}
