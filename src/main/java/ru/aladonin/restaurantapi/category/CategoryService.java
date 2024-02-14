package ru.aladonin.restaurantapi.category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Category createCategory(Category category);
    Optional<Category> getCategory(String latin);
    List<Category> getCategoryAll();
    void delete(String latin);
}
