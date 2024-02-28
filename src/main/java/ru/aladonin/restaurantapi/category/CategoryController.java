package ru.aladonin.restaurantapi.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/category/")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public Category create(@RequestBody Category category) {
        category = categoryService.createCategory(category);
        return category;
    }

    @GetMapping("/{latin}")
    @ResponseStatus(HttpStatus.OK)
    public Category  getCategory(@PathVariable String latin){
        Optional<Category> fromDb = categoryService.getCategory(latin);
        return fromDb.get();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Category> getCategories(){
        return categoryService.getCategoryAll();
    }

    @DeleteMapping("/{latin}/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable String latin){
        categoryService.delete(latin);
    }
}
