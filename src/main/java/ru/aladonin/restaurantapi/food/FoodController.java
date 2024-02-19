package ru.aladonin.restaurantapi.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/food/")
public class FoodController {

    private FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Food create(@RequestBody Food food){
        return foodService.createFood(food);
    }

    @GetMapping
    public List<Food> getAll(){
        return foodService.getFoodAll();
    }
    
    @GetMapping("{id}")
    public Food getFood(@PathVariable Long id) {
        return foodService.getFoodById(id).get();
    }

    @GetMapping("{latin}/category")
    public List<Food> getByCategory(@PathVariable String latin) {
        return foodService.getFoodByCategory(latin);
    }

    @DeleteMapping("{id}/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFood(@PathVariable Long id) {
        foodService.deleteFood(id);
    }
}
