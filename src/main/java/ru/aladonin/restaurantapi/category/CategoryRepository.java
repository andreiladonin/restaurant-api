package ru.aladonin.restaurantapi.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByTransliteration(String latin);
    void deleteByTransliteration(String latin);
}
