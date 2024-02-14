package ru.aladonin.restaurantapi.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aladonin.restaurantapi.utils.Transcriptor;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    private Transcriptor transcriptor;

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(Transcriptor transcriptor, CategoryRepository categoryRepository) {
        this.transcriptor = transcriptor;
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(Category category){
        String russianToLatin = transcriptor.russianToLatin(category.getTitle());
        category.setTransliteration(russianToLatin.toLowerCase());
        return categoryRepository.save(category);
    }

    public Optional<Category> getCategory(String latin) {
        if (categoryRepository.findByTransliteration(latin).isEmpty()) {
            throw new CategoryNotFoundException("Requested Category does not exist");
        }
        
        return categoryRepository.findByTransliteration(latin);
    }
}
